package leetcode.algorithms;

import java.util.*;
import java.util.stream.IntStream;

/**
 * Description: 1786. Number of Restricted Paths From First to Last Node
 *
 * @author Baltan
 * @date 2023/1/29 16:11
 */
public class CountRestrictedPaths {
    public static void main(String[] args) {
        System.out.println(countRestrictedPaths(5, new int[][]{{1, 2, 3}, {1, 3, 3}, {2, 3, 1}, {1, 4, 2}, {5, 2, 2}, {3, 5, 1}, {5, 4, 10}}));
        System.out.println(countRestrictedPaths(7, new int[][]{{1, 3, 1}, {4, 1, 2}, {7, 3, 4}, {2, 5, 3}, {5, 6, 1}, {6, 7, 2}, {7, 5, 3}, {2, 6, 4}}));
    }

    /**
     * 参考：<a href="https://leetcode.cn/problems/number-of-restricted-paths-from-first-to-last-node/solutions/646430/xiang-jie-dui-you-hua-dijkstra-dong-tai-i6j0d/?languageTags=java"></a>
     *
     * @param n
     * @param edges
     * @return
     */
    public static int countRestrictedPaths(int n, int[][] edges) {
        int mod = 1000000007;
        /**
         * 节点i -> {节点j -> ij边的权重}
         */
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();

        for (int[] edge : edges) {
            int x = edge[0];
            int y = edge[1];
            int weight = edge[2];
            Map<Integer, Integer> xMap = map.computeIfAbsent(x, i -> new HashMap<>());
            xMap.put(y, weight);
            Map<Integer, Integer> yMap = map.computeIfAbsent(y, i -> new HashMap<>());
            yMap.put(x, weight);
        }
        /**
         * 堆优化Dijkstra，distances[i]表示节点i到节点n的最短路径距离
         */
        int[] distances = new int[n + 1];
        /**
         * isVisited[i]表示节点i到节点n的最短路径距离是否已计算过
         */
        boolean[] isVisited = new boolean[n + 1];
        /**
         * 队列保存的每个元素为[节点i,节点i到节点n的最短路径距离]，并且按照节点i到节点n的最短路径距离升序排列
         */
        Queue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        queue.offer(new int[]{n, 0});
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[n] = 0;
        /**
         * 广度优先搜索计算每个节点到节点n的最短路径距离
         */
        while (!queue.isEmpty()) {
            int[] arr = queue.poll();
            int i = arr[0];

            if (isVisited[i]) {
                continue;
            }
            isVisited[i] = true;
            /**
             * 从节点i可以到达的下一节点j -> ij边的权重
             */
            Map<Integer, Integer> weightMap = map.get(i);

            for (Map.Entry<Integer, Integer> entry : weightMap.entrySet()) {
                int j = entry.getKey();
                int weight = entry.getValue();
                distances[j] = Math.min(distances[j], distances[i] + weight);
                queue.offer(new int[]{j, distances[j]});
            }
        }
        /**
         * 将所有节点的编号按照每个节点到节点n的最短路径距离升序排列
         */
        Integer[] nodes = IntStream.rangeClosed(1, n).boxed().toArray(Integer[]::new);
        Arrays.sort(nodes, Comparator.comparingInt(x -> distances[x]));
        /**
         * dp[i]表示从节点i到节点n的受限路径的数量，从dp[n]倒推回dp[1]
         */
        long[] dp = new long[n + 1];
        dp[n] = 1;
        /**
         * 从距离节点n最短路径距离最小的节点开始遍历
         */
        for (int i : nodes) {
            /**
             * 从节点i可以到达的下一节点j -> ij边的权重
             */
            Map<Integer, Integer> weightMap = map.get(i);

            for (int j : weightMap.keySet()) {
                if (distances[i] > distances[j]) {
                    dp[i] = (dp[i] + dp[j]) % mod;
                }
            }
            /**
             * 计算完节点1后停止计算
             */
            if (i == 1) {
                break;
            }
        }
        return (int) dp[1];
    }
}
