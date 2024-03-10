package leetcode.algorithms;

import leetcode.util.OutputUtils;

import java.util.*;

/**
 * Description: 3067. Count Pairs of Connectable Servers in a Weighted Tree Network
 *
 * @author Baltan
 * @date 2024/3/10 21:45
 */
public class CountPairsOfConnectableServers {
    public static void main(String[] args) {
        OutputUtils.print1DIntegerArray(countPairsOfConnectableServers(new int[][]{{0, 1, 1}, {1, 2, 5}, {2, 3, 13}, {3, 4, 9}, {4, 5, 2}}, 1));
        OutputUtils.print1DIntegerArray(countPairsOfConnectableServers(new int[][]{{0, 6, 3}, {6, 5, 3}, {0, 3, 1}, {3, 2, 7}, {3, 1, 6}, {3, 4, 2}}, 3));
    }

    public static int[] countPairsOfConnectableServers(int[][] edges, int signalSpeed) {
        /**
         * 所有服务器的最大索引
         */
        int max = 0;
        /**
         * 服务器i -> {相邻服务器j -> 两台服务器之间的距离}
         */
        Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();

        for (int[] edge : edges) {
            max = Math.max(max, edge[0]);
            max = Math.max(max, edge[1]);
            graph.computeIfAbsent(edge[0], x -> new HashMap<>()).put(edge[1], edge[2]);
            graph.computeIfAbsent(edge[1], x -> new HashMap<>()).put(edge[0], edge[2]);
        }
        int[] result = new int[max + 1];
        /**
         * 假设根节点服务器为i，通过i连接其他的两台服务器
         */
        for (int i = 0; i <= max; i++) {
            Map<Integer, Integer> neighbors = graph.get(i);
            /**
             * 与服务器i相邻的其他服务器只有一台，无法实现通过i连接其他两台服务器
             */
            if (neighbors.size() == 1) {
                continue;
            }
            /**
             * 通过服务器i的各条出边，分别可以到达的总距离为signalSpeed的正整数倍的服务器的数量
             */
            List<Integer> available = new ArrayList<>(neighbors.size());
            /**
             * 遍历服务器i的各条出边
             */
            for (Map.Entry<Integer, Integer> entry : neighbors.entrySet()) {
                /**
                 * 可以到达的总距离为signalSpeed的正整数倍的服务器的数量
                 */
                int num = 0;
                Queue<Server> queue = new LinkedList<>();
                queue.offer(new Server(entry.getKey(), entry.getValue(), i));
                /**
                 * 广度优先搜索从服务器i出发，通过服务器entry.key可以到达的所有服务器
                 */
                while (!queue.isEmpty()) {
                    Server x = queue.poll();
                    /**
                     * 服务器x.index到达根节点服务器i的总距离为signalSpeed的正整数倍
                     */
                    if (x.distance % signalSpeed == 0) {
                        num++;
                    }

                    for (Map.Entry<Integer, Integer> next : graph.get(x.index).entrySet()) {
                        /**
                         * 之前从服务器x.from到达next.key，所以不能从next.key又返回x.from
                         */
                        if (next.getKey() != x.from) {
                            queue.offer(new Server(next.getKey(), x.distance + next.getValue(), x.index));
                        }
                    }
                }
                available.add(num);
            }
            /**
             * 通过服务器i的各条出边，分别可以到达的总距离为signalSpeed的正整数倍的服务器两两配对
             */
            for (int j = 0; j < available.size(); j++) {
                for (int k = j + 1; k < available.size(); k++) {
                    if (j != k) {
                        result[i] += available.get(j) * available.get(k);
                    }
                }
            }
        }
        return result;
    }

    /**
     * 服务器对象
     */
    public static class Server {
        /**
         * 服务器索引
         */
        private int index;
        /**
         * 服务器到根节点的距离
         */
        private int distance;
        /**
         * 前一台服务器的索引
         */
        private int from;

        public Server(int index, int distance, int from) {
            this.index = index;
            this.distance = distance;
            this.from = from;
        }
    }
}
