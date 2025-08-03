package leetcode.algorithms;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Description: 3604. Minimum Time to Reach Destination in Directed Graph
 *
 * @author Baltan
 * @date 2025/8/3 14:18
 */
public class MinTime3 {
    public static void main(String[] args) {
        System.out.println(minTime(5, new int[][]{{0, 3, 7, 21}, {3, 4, 13, 23}, {3, 4, 2, 8}, {4, 0, 24, 25}, {3, 2, 23, 23}, {1, 0, 13, 14}, {2, 0, 24, 24}, {3, 1, 9, 13}, {4, 1, 12, 18}, {0, 3, 23, 23}}));
        System.out.println(minTime(5, new int[][]{{0, 4, 20, 23}, {1, 2, 25, 25}, {2, 3, 4, 19}, {2, 4, 4, 24}, {0, 2, 5, 23}}));
        System.out.println(minTime(5, new int[][]{{2, 4, 18, 19}, {0, 1, 10, 18}, {0, 4, 12, 22}, {4, 3, 20, 20}, {1, 4, 19, 25}, {2, 1, 4, 18}, {2, 1, 6, 13}}));
        System.out.println(minTime(3, new int[][]{{0, 1, 0, 5}, {0, 2, 2, 6}, {1, 2, 0, 6}}));
        System.out.println(minTime(3, new int[][]{{0, 1, 0, 1}, {1, 2, 2, 5}}));
        System.out.println(minTime(4, new int[][]{{0, 1, 0, 3}, {1, 3, 7, 8}, {0, 2, 1, 5}, {2, 3, 4, 7}}));
        System.out.println(minTime(3, new int[][]{{1, 0, 1, 3}, {1, 2, 3, 5}}));
    }

    public static int minTime(int n, int[][] edges) {
        /**
         * graph[i]保存节点i的所有出边，并且同一个节点的所有出边按照可使用的起始时刻start升序排列
         */
        Queue<int[]>[] graph = new Queue[n];
        /**
         * minTimes[i]表示到达节点i的最早时刻
         */
        int[] minTimes = new int[n];
        /**
         * 按照到达各个节点的最早时刻升序保存所有可到达的节点
         */
        Queue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(x -> minTimes[x]));
        Arrays.setAll(graph, i -> new PriorityQueue<int[]>(Comparator.comparingInt(x -> x[2])));
        Arrays.fill(minTimes, Integer.MAX_VALUE);
        /**
         * 初始状态下，时刻0时位于节点0
         */
        minTimes[0] = 0;
        pq.offer(0);
        /**
         * 构建图
         */
        for (int[] edge : edges) {
            graph[edge[0]].add(edge);
        }

        while (!pq.isEmpty()) {
            int curr = pq.poll();
            /**
             * 当前位于目标节点n-1，直接返回到达节点n-1的最早时刻minTimes[n-1]
             */
            if (curr == n - 1) {
                return minTimes[curr];
            }
            /**
             * 遍历节点curr的所有出边
             */
            for (int[] edge : graph[curr]) {
                int next = edge[1];
                /**
                 * 只有出边edge在到达当前节点的最早时刻minTimes[curr]之后仍可使用，才有可能通过edge到达下一节点next
                 */
                if (minTimes[curr] <= edge[3]) {
                    /**
                     * 通过出边edge到达下一节点next的最早时刻
                     */
                    int nextTime = Math.max(minTimes[curr], edge[2]) + 1;
                    /**
                     * 如果通过出边edge到达下一节点next的最早时刻，早于通过之前已访问过的边到达下一节点next的最早时刻，则更新之，并将节点
                     * next再次入队，从而使得节点next可以排到队列中更靠前的位置
                     */
                    if (nextTime < minTimes[next]) {
                        minTimes[next] = Math.min(minTimes[next], nextTime);
                        pq.offer(next);
                    }
                }
            }
        }
        return -1;
    }
}
