package leetcode.algorithms;

import leetcode.util.OutputUtils;

import java.util.*;

/**
 * Description: 3112. Minimum Time to Visit Disappearing Nodes
 *
 * @author Baltan
 * @date 2024/4/14 16:49
 */
public class MinimumTime3 {
    public static void main(String[] args) {
        OutputUtils.print1DIntegerArray(minimumTime(3, new int[][]{{2, 0, 9}, {1, 0, 5}, {2, 2, 4}, {0, 1, 10}, {1, 1, 10}, {1, 1, 10}, {2, 2, 10}, {1, 1, 10}}, new int[]{4, 13, 19}));
        OutputUtils.print1DIntegerArray(minimumTime(3, new int[][]{{0, 1, 2}, {1, 2, 1}, {0, 2, 4}}, new int[]{1, 1, 5}));
        OutputUtils.print1DIntegerArray(minimumTime(3, new int[][]{{0, 1, 2}, {1, 2, 1}, {0, 2, 4}}, new int[]{1, 3, 5}));
        OutputUtils.print1DIntegerArray(minimumTime(2, new int[][]{{0, 1, 1}}, new int[]{1, 1}));
    }

    public static int[] minimumTime(int n, int[][] edges, int[] disappear) {
        int[] result = new int[n];
        /**
         * graph[i]表示从节点i到达相邻节点j的最短用时
         */
        Map<Integer, Integer>[] graph = new Map[n];
        /**
         * 保存所有从节点0出发可以到达的节点，并且按照到达这些节点的时间升序排列
         */
        Queue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(x -> x[1]));
        Arrays.setAll(graph, x -> new HashMap<>());
        Arrays.fill(result, -1);
        /**
         * 将节点0先加入队列中
         */
        pq.offer(new int[]{0, 0});
        /**
         * 计算每个节点到达其相邻节点的最短用时
         */
        for (int[] edge : edges) {
            graph[edge[0]].put(edge[1], Optional.ofNullable(graph[edge[0]].get(edge[1]))
                    .map(x -> Math.min(x, edge[2]))
                    .orElse(edge[2]));
            graph[edge[1]].put(edge[0], Optional.ofNullable(graph[edge[1]].get(edge[0]))
                    .map(x -> Math.min(x, edge[2]))
                    .orElse(edge[2]));
        }

        while (!pq.isEmpty()) {
            int[] node = pq.poll();
            int index = node[0];
            int time = node[1];

            if (result[index] == -1) {
                /**
                 * 在time时刻到达节点index
                 */
                result[index] = time;
                /**
                 * 依次判断节点index的相邻节点neighbor能否被到达
                 */
                for (Map.Entry<Integer, Integer> entry : graph[index].entrySet()) {
                    int neighbor = entry.getKey();
                    /**
                     * 从节点index到达节点neighbor的时刻
                     */
                    int cost = time + entry.getValue();
                    /**
                     * 如果从节点index可以到达节点neighbor，则将节点neighbor加入队列
                     */
                    if (cost < disappear[neighbor]) {
                        pq.offer(new int[]{neighbor, cost});
                    }
                }
            }
        }
        return result;
    }
}
