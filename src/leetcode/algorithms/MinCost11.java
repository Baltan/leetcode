package leetcode.algorithms;

import java.util.*;

/**
 * Description: 3650. Minimum Cost Path with Edge Reversals
 *
 * @author baltan
 * @date 2025/9/15 15:12
 */
public class MinCost11 {
    public static void main(String[] args) {
        System.out.println(minCost(4, new int[][]{{0, 1, 3}, {3, 1, 1}, {2, 3, 4}, {0, 2, 2}}));
        System.out.println(minCost(4, new int[][]{{0, 2, 1}, {2, 1, 1}, {1, 3, 1}, {2, 3, 3}}));
    }

    public static int minCost(int n, int[][] edges) {
        /**
         * costs[i]表示到达节点i的最小总成本
         */
        int[] costs = new int[n];
        /**
         * graph[i]保存节点i的入边和出边集合
         */
        List<int[]>[] graph = new List[n];
        /**
         * 按照到达节点的最小总成本升序保存当前可到达的所有节点
         */
        Queue<Integer> pq = new PriorityQueue<>();
        Arrays.setAll(graph, i -> new ArrayList<>());
        pq.offer(0);
        /**
         * 构建图
         */
        for (int[] edge : edges) {
            graph[edge[0]].add(edge);
            graph[edge[1]].add(edge);
        }

        for (int i = 1; i < n; i++) {
            costs[i] = Integer.MAX_VALUE;
        }

        while (!pq.isEmpty()) {
            int curr = pq.poll();
            /**
             * 当前已到达节点n-1，直接返回
             */
            if (curr == n - 1) {
                return costs[curr];
            }

            for (int[] edge : graph[curr]) {
                /**
                 * edge为一条从节点curr（edge[0]）到达节点edge[1]的出边，可以缩小到达节点edge[1]的最小总成本为costs[curr]+edge[2]
                 */
                if (edge[0] == curr && costs[curr] + edge[2] < costs[edge[1]]) {
                    costs[edge[1]] = costs[curr] + edge[2];
                    pq.offer(edge[1]);
                    /**
                     * edge为一条从节点edge[0]到达节点curr（edge[1]）的入边，反转该条边后，可以缩小到达节点edge[0]的最小总成本为
                     * costs[curr]+edge[2]*2
                     */
                } else if (edge[1] == curr && costs[curr] + 2 * edge[2] < costs[edge[0]]) {
                    costs[edge[0]] = costs[curr] + 2 * edge[2];
                    pq.offer(edge[0]);
                }
            }
        }
        return -1;
    }
}