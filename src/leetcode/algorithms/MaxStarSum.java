package leetcode.algorithms;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Description: 2497. Maximum Star Sum of a Graph
 *
 * @author Baltan
 * @date 2022/12/17 14:11
 */
public class MaxStarSum {
    public static void main(String[] args) {
        int[] vals1 = {1, 2, 3, 4, 10, -10, -20};
        int[][] edges1 = {{0, 1}, {1, 2}, {1, 3}, {3, 4}, {3, 5}, {3, 6}};
        int k1 = 2;
        System.out.println(maxStarSum(vals1, edges1, k1));

        int[] vals2 = {-5};
        int[][] edges2 = {};
        int k2 = 0;
        System.out.println(maxStarSum(vals2, edges2, k2));
    }

    public static int maxStarSum(int[] vals, int[][] edges, int k) {
        int result = Integer.MIN_VALUE;
        int n = vals.length;
        /**
         * valQueues[i]保存以编号为i的节点作为中心节点时，与其相邻的所有节点的值，并且按照降序排列
         */
        Queue<Integer>[] valQueues = new Queue[n];

        for (int i = 0; i < n; i++) {
            valQueues[i] = new PriorityQueue<>((x, y) -> y - x);
        }

        for (int[] edge : edges) {
            int x = edge[0];
            int y = edge[1];
            valQueues[x].offer(vals[y]);
            valQueues[y].offer(vals[x]);
        }

        for (int i = 0; i < n; i++) {
            int sum = vals[i];
            int nodes = k;
            Queue<Integer> valQueue = valQueues[i];
            /**
             * 从与编号为i的节点相邻的节点中选择至多nodes个节点值大于0的节点
             */
            while (nodes > 0 && !valQueue.isEmpty() && valQueue.peek() > 0) {
                sum += valQueue.poll();
                nodes--;
            }
            result = Math.max(result, sum);
        }
        return result;
    }
}
