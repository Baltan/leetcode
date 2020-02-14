package leetcode.algorithms;

import java.util.*;

/**
 * Description: 743. Network Delay Time
 *
 * @author Baltan
 * @date 2020-02-14 13:14
 */
public class NetworkDelayTime {
    public static void main(String[] args) {
        int[][] times1 = {{2, 1, 1}, {2, 3, 1}, {3, 4, 1}};
        System.out.println(networkDelayTime(times1, 4, 2));
    }

    public static int networkDelayTime(int[][] times, int N, int K) {
        int result = 0;
        /**
         * costs[i]表示信号到达节点i需要的最少时间
         */
        int[] costs = new int[N + 1];
        /**
         * 初始化信号到所有节点的时间都为Integer.MAX_VALUE，即假设所有节点都收不到信号
         */
        Arrays.fill(costs, Integer.MAX_VALUE);
        /**
         * key为源节点，value为一个队列，队列中每个元素是一个数组，数组的第一个元素是从key节点
         * 发出的信号可以直接到达的目标节点，第二个元素是信号到达目标节点需要的时间
         */
        Map<Integer, Queue<int[]>> map = new HashMap<>();

        for (int[] time : times) {
            /**
             * 源节点
             */
            int from = time[0];
            /**
             * 目标节点
             */
            int to = time[1];
            /**
             * 信号传输时间
             */
            int cost = time[2];
            map.putIfAbsent(from, new LinkedList<>());
            map.get(from).offer(new int[]{to, cost});
        }
        /**
         * 现将K节点加入队列
         */
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(K);
        /**
         * 因为信号是从K节点发出的，所以costs[K]为0
         */
        costs[K] = 0;
        /**
         * 广度优先搜索
         */
        while (!queue.isEmpty()) {
            int size = queue.size();
            /**
             * 当前队列中的所有节点作为源节点，可以直接到达的所有目标节点，为了避免目标节点重复
             * 入队，现将所有目标节点存入set中去重
             */
            Set<Integer> toSet = new HashSet<>();

            for (int i = 0; i < size; i++) {
                int from = queue.poll();
                /**
                 * 从from节点可以直接到达的所有节点
                 */
                Queue<int[]> toQueue = map.get(from);
                /**
                 * from节点不能到达任何节点，直接处理下一个源节点
                 */
                if (toQueue == null) {
                    continue;
                }

                for (int[] arr : toQueue) {
                    /**
                     * 目标节点
                     */
                    int to = arr[0];
                    /**
                     * 信号传输时间
                     */
                    int cost = arr[1];
                    /**
                     * 如果信号到达目标节点to节点的消耗的时间比之前的路径少，更新costs[to]，
                     * 并将to节点加入队列中，考虑to节点作为源节点时的情况
                     */
                    if (costs[from] + cost < costs[to]) {
                        toSet.add(to);
                        costs[to] = costs[from] + cost;
                    }
                }
            }

            for (int to : toSet) {
                queue.offer(to);
            }
        }
        /**
         * 取所有节点收到信号时间的最大值，如果还存在接收时间为Integer.MAX_VALUE的节点，说明
         * 该节点无法收到信号，就要返回-1
         */
        for (int i = 1; i <= N; i++) {
            result = Math.max(result, costs[i]);
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }
}
