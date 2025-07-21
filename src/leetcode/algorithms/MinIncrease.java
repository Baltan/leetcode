package leetcode.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description: 3593. Minimum Increments to Equalize Leaf Paths
 *
 * @author baltan
 * @date 2025/7/21 17:00
 */
public class MinIncrease {
    public static void main(String[] args) {
        System.out.println(minIncrease(4, new int[][]{{0, 1}, {1, 2}, {1, 3}}, new int[]{13, 7, 9, 4}));
        System.out.println(minIncrease(3, new int[][]{{0, 1}, {0, 2}}, new int[]{2, 1, 3}));
        System.out.println(minIncrease(3, new int[][]{{0, 1}, {1, 2}}, new int[]{5, 1, 4}));
        System.out.println(minIncrease(5, new int[][]{{0, 4}, {0, 1}, {1, 2}, {1, 3}}, new int[]{3, 4, 1, 1, 7}));
    }

    private static int result;

    public static int minIncrease(int n, int[][] edges, int[] cost) {
        result = 0;
        /**
         * graph[i]表示与节点i相邻的所有节点
         */
        List<Integer>[] graph = new List[n];
        /**
         * sums[i]表示以节点i作为根节点的子树中，从节点i出发到某个叶子节点的成本总和
         */
        int[] sums = new int[n];
        Arrays.setAll(graph, i -> new ArrayList<>());
        /**
         * 构建图
         */
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        dfs(graph, cost, sums, 0, -1);
        return result;
    }

    /**
     * 递归计算以节点curr作为根节点时，从节点curr出发到某个叶子节点的成本总和sums[curr]，以及增加成本的节点数的最小值
     *
     * @param graph
     * @param cost
     * @param sums
     * @param curr
     * @param prev
     */
    public static void dfs(List<Integer>[] graph, int[] cost, int[] sums, int curr, int prev) {
        /**
         * 节点curr为叶子节点，不用继续递归
         */
        if (graph[curr].size() == 1 && graph[curr].getFirst() == prev) {
            sums[curr] = cost[curr];
            return;
        }
        /**
         * 节点curr的所有相邻子节点分别作为子树的根节点时，从该子节点出发到某个叶子节点的成本总和的最大值
         */
        int max = Integer.MIN_VALUE;

        for (int next : graph[curr]) {
            if (next != prev) {
                /**
                 * 递归计算节点curr的相邻子节点next作为根节点时的情况
                 */
                dfs(graph, cost, sums, next, curr);
                max = Math.max(max, sums[next]);
            }
        }
        /**
         * 为了保证节点curr的所有相邻子节点分别作为子树的根节点时，到叶子节点的成本总和相等，必须令该子节点增加成本max-sums[next]，如果增
         * 加成本不为0，则将增加成本的节点数加1
         */
        for (int next : graph[curr]) {
            if (next != prev && max != sums[next]) {
                result++;
            }
        }
        /**
         * 更新节点curr到叶子节点的成本总和
         */
        sums[curr] = cost[curr] + max;
    }
}
