package leetcode.algorithms;

import java.util.*;

/**
 * Description: 3419. Minimize the Maximum Edge Weight of Graph
 *
 * @author Baltan
 * @date 2025/1/19 14:30
 */
public class MinMaxWeight {
    public static void main(String[] args) {
        System.out.println(minMaxWeight(5, new int[][]{{1, 0, 1}, {2, 0, 2}, {3, 0, 1}, {4, 3, 1}, {2, 1, 1}}, 2));
        System.out.println(minMaxWeight(5, new int[][]{{0, 1, 1}, {0, 2, 2}, {0, 3, 1}, {0, 4, 1}, {1, 2, 1}, {1, 4, 1}}, 1));
        System.out.println(minMaxWeight(5, new int[][]{{1, 2, 1}, {1, 3, 3}, {1, 4, 5}, {2, 3, 2}, {3, 4, 2}, {4, 0, 1}}, 1));
        System.out.println(minMaxWeight(5, new int[][]{{1, 2, 1}, {1, 3, 3}, {1, 4, 5}, {2, 3, 2}, {4, 0, 1}}, 1));
    }

    public static int minMaxWeight(int n, int[][] edges, int threshold) {
        /**
         * 所有有向边的最大边权
         */
        int minWeight = Integer.MAX_VALUE;
        /**
         * 所有有向边的最大边权
         */
        int maxWeight = Integer.MIN_VALUE;
        /**
         * graph[i]表示能够直接到达节点i的其他节点的集合，已经对应有向边的边权
         */
        List<int[]>[] graph = new List[n];
        Arrays.setAll(graph, x -> new ArrayList<>());

        for (int[] edge : edges) {
            minWeight = Math.min(minWeight, edge[2]);
            maxWeight = Math.max(maxWeight, edge[2]);
            graph[edge[1]].add(new int[]{edge[0], edge[2]});
        }
        /**
         * 如果操作后的图能够满足题意要求，则最大边权的最小值∈[minWeight,maxWeight]
         */
        int lo = minWeight;
        int hi = maxWeight + 1;
        /**
         * 二分计算最大边权的最小值
         */
        while (lo < hi) {
            /**
             * 假设操作后的图的最大边权为mid
             */
            int mid = (lo + hi) / 2;
            /**
             * outgoings[i]表示节点i出边的数量
             */
            int[] outgoings = new int[n];
            /**
             * 可以到达节点0的节点总数
             */
            int count = 0;
            /**
             * reachable[i]表示节点i是否可以到达节点0，避免重复计算
             */
            boolean[] reachable = new boolean[n];
            /**
             * 保存所有可以到达节点0的节点
             */
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(0);
            reachable[0] = true;
            count++;
            /**
             * 广度优先搜索判断假设条件下，是否所有节点都可以到达节点0
             */
            bfs:
            while (!queue.isEmpty()) {
                int to = queue.poll();

                for (int[] node : graph[to]) {
                    int from = node[0];
                    int weight = node[1];
                    /**
                     * 如果此前节点from还不可以到达节点0，并且节点from当前出边的条数不足threshold，并且节点from到节点to的有向边的边权不
                     * 大于mid，则可以将节点from入队
                     */
                    if (!reachable[from] && outgoings[from] < threshold && weight <= mid) {
                        queue.offer(from);
                        reachable[from] = true;
                        count++;
                        outgoings[from]++;
                        /**
                         * 已经使得所有节点都可以到达节点0，直接结束计算
                         */
                        if (count == n) {
                            break bfs;
                        }
                    }
                }
            }

            if (count == n) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        /**
         * 如果最大边权为maxWeight的情况下，仍不能使得所有节点都可以到达节点0，说明满足提议要求的图不存在，返回-1
         */
        return lo > maxWeight ? -1 : lo;
    }
}
