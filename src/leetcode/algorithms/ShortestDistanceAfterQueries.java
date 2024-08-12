package leetcode.algorithms;

import leetcode.util.OutputUtils;

/**
 * Description: 3243. Shortest Distance After Road Addition Queries I
 *
 * @author baltan
 * @date 2024/8/8 16:52
 * @see ShortestDistanceAfterQueries1
 */
public class ShortestDistanceAfterQueries {
    public static void main(String[] args) {
        OutputUtils.print1DIntegerArray(shortestDistanceAfterQueries(6, new int[][]{{2, 4}, {0, 2}}));
        OutputUtils.print1DIntegerArray(shortestDistanceAfterQueries(6, new int[][]{{1, 3}, {3, 5}}));
        OutputUtils.print1DIntegerArray(shortestDistanceAfterQueries(5, new int[][]{{2, 4}, {0, 2}, {0, 4}}));
        OutputUtils.print1DIntegerArray(shortestDistanceAfterQueries(4, new int[][]{{0, 3}, {0, 2}}));
    }

    public static int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        int[] result = new int[queries.length];
        /**
         * dp[i][j]表示节点i到节点j的最短距离
         */
        int[][] dp = new int[n][n];
        /**
         * 初始时，节点i到节点j的距离为j-i
         */
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                dp[i][j] = j - i;
            }
        }

        for (int i = 0; i < queries.length; i++) {
            int from = queries[i][0];
            int to = queries[i][1];
            dp[from][to] = 1;

            for (int j = 0; j <= from; j++) {
                for (int k = to; k < n; k++) {
                    /**
                     * 判断节点j到节点from，再到节点to，再到节点k的距离是否比之前节点j到节点k的距离更近
                     */
                    dp[j][k] = Math.min(dp[j][k], dp[j][from] + dp[from][to] + dp[to][k]);
                }
            }
            result[i] = dp[0][n - 1];
        }
        return result;
    }
}
