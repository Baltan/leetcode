package leetcode.algorithms;

import java.util.*;

/**
 * Description: 2065. Maximum Path Quality of a Graph
 *
 * @author Baltan
 * @date 2023/11/12 19:41
 */
public class MaximalPathQuality {
    public static void main(String[] args) {
        int[] values1 = {5, 10, 15, 20};
        int[][] edges1 = {{0, 1, 10}, {1, 2, 10}, {0, 3, 10}};
        int maxTime1 = 30;
        System.out.println(maximalPathQuality(values1, edges1, maxTime1));

        int[] values2 = {1, 2, 3, 4};
        int[][] edges2 = {{0, 1, 10}, {1, 2, 11}, {2, 3, 12}, {1, 3, 13}};
        int maxTime2 = 50;
        System.out.println(maximalPathQuality(values2, edges2, maxTime2));

        int[] values3 = {0, 1, 2};
        int[][] edges3 = {{1, 2, 10}};
        int maxTime3 = 10;
        System.out.println(maximalPathQuality(values3, edges3, maxTime3));

        int[] values4 = {0, 32, 10, 43};
        int[][] edges4 = {{0, 1, 10}, {1, 2, 15}, {0, 3, 10}};
        int maxTime4 = 49;
        System.out.println(maximalPathQuality(values4, edges4, maxTime4));
    }

    private static int result;

    /**
     * 参考：<a href="https://leetcode.cn/problems/maximum-path-quality-of-a-graph/solutions/1088414/bao-sou-jian-zhi-by-endlesscheng-iv6z/"></a>
     *
     * @param values
     * @param edges
     * @param maxTime
     * @return
     */
    public static int maximalPathQuality(int[] values, int[][] edges, int maxTime) {
        result = 0;
        int n = values.length;
        /**
         * toTimesList[i]表示从节点i直接可以到达的下一节点j的用时情况，其中每个元素都为一个长度为2的数组[j,time]
         */
        List<int[]>[] toTimesList = new List[n];
        /**
         * 堆优化Dijkstra，minTimes[i]表示节点0到节点i的最小花费时间
         * @see CountRestrictedPaths
         */
        int[] minTimes = new int[n + 1];
        /**
         * isVisited[i]表示节点0到节点i的最小花费时间是否已计算过
         */
        boolean[] isVisited = new boolean[n + 1];
        /**
         * 队列保存的所有节点，并且按照节点0到该节点的最小花费时间升序排列
         */
        Queue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(x -> minTimes[1]));
        queue.offer(0);
        Arrays.setAll(toTimesList, x -> new ArrayList<>());
        Arrays.fill(minTimes, Integer.MAX_VALUE);
        /**
         * 出发时就在节点0，不需要花费任何时间
         */
        minTimes[0] = 0;

        for (int[] edge : edges) {
            toTimesList[edge[0]].add(new int[]{edge[1], edge[2]});
            toTimesList[edge[1]].add(new int[]{edge[0], edge[2]});
        }
        /**
         * 广度优先搜索计算节点0到每个节点的最小花费时间
         */
        while (!queue.isEmpty()) {
            int i = queue.poll();

            if (isVisited[i]) {
                continue;
            }
            isVisited[i] = true;
            /**
             * 从节点i直接可以到达的下一节点的用时情况
             */
            List<int[]> toTimes = toTimesList[i];

            for (int[] toTime : toTimes) {
                int j = toTime[0];
                int time = toTime[1];
                /**
                 * 从节点0经过节点i再到达节点j可能比不经过节点i的路径用时更少
                 */
                minTimes[j] = Math.min(minTimes[j], minTimes[i] + time);
                queue.offer(j);
            }
        }
        dfs(0, toTimesList, minTimes, maxTime, values, 0);
        return result;
    }

    /**
     * 回溯计算所有可能的路径
     * 根据题意，我们最多可能经过10条边，而每个节点至多有四条边，所以情况总数至多为4^10，可以通过暴力枚举进行计算
     *
     * @param i             当前所在节点
     * @param toTimes
     * @param minTimes
     * @param remainingTime 剩余可用时间
     * @param values
     * @param quality       已累计的价值
     */
    public static void dfs(int i, List<int[]>[] toTimes, int[] minTimes, int remainingTime, int[] values, int quality) {
        int value = values[i];
        quality += value;
        /**
         * 节点i处的价值已被计算过，不能再被累计
         */
        values[i] = 0;
        /**
         * 每次到达节点0都得到一条符合题意的路径
         */
        if (i == 0) {
            result = Math.max(result, quality);
        }

        for (int[] toTime : toTimes[i]) {
            int j = toTime[0];
            int time = toTime[1];
            /**
             * 如果剩余时间能够从节点i到达节点j，并且还能从节点j回到节点0，才可以继续向节点j前进
             */
            if (time <= remainingTime && remainingTime - time >= minTimes[j]) {
                dfs(j, toTimes, minTimes, remainingTime - time, values, quality);
            }
        }
        /**
         * 还原到达节点i之前的情况
         */
        values[i] = value;
    }
}
