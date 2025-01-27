package leetcode.algorithms;

/**
 * Description: 3429. Paint House IV
 *
 * @author Baltan
 * @date 2025/1/27 23:09
 */
public class MinCost7 {
    public static void main(String[] args) {
        System.out.println(minCost(4, new int[][]{{3, 5, 7}, {6, 2, 9}, {4, 8, 1}, {7, 3, 5}}));
        System.out.println(minCost(6, new int[][]{{2, 4, 6}, {5, 3, 8}, {7, 1, 9}, {4, 6, 2}, {3, 5, 7}, {8, 2, 4}}));
    }

    public static long minCost(int n, int[][] cost) {
        long result = Long.MAX_VALUE;
        /**
         * dp[i][j][k]表示将房子i涂成颜色j，房子n-1-i涂成颜色k时，房子[0,i]和[n-1-i,n-1]这2(i+1)个房子粉刷的总成本的最小值
         */
        long[][][] dp = new long[n / 2][3][3];
        /**
         * 计算将房子0涂成颜色i，房子n-1涂成颜色j时的总成本
         */
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == j) {
                    dp[0][i][j] = Long.MAX_VALUE;
                } else {
                    dp[0][i][j] = cost[0][i] + cost[n - 1][j];
                }
            }
        }
        /**
         * 计算将房子i涂成颜色j，房子n-1-i涂成颜色k时，房子[0,i]和[n-1-i,n-1]这2(i+1)个房子粉刷的总成本的最小值
         */
        for (int i = 1; i < n / 2; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    /**
                     * 初始化用Long.MAX_VALUE表示不可能同时将房子i涂成颜色j，将房子n-1-i涂成颜色k
                     */
                    dp[i][j][k] = Long.MAX_VALUE;

                    if (j == k) {
                        continue;
                    }
                    /**
                     * 从房子i-1的颜色为l，并且房子n-i的颜色为m的情况递推
                     */
                    for (int l = 0; l < 3; l++) {
                        for (int m = 0; m < 3; m++) {
                            /**
                             * 第i-1个房子的颜色不能为j，且第n-1-i个房子的颜色不能为k
                             */
                            if (j != l && m != k && dp[i - 1][l][m] != Long.MAX_VALUE) {
                                dp[i][j][k] = Math.min(dp[i][j][k], dp[i - 1][l][m] + cost[i][j] + cost[n - 1 - i][k]);
                            }
                        }
                    }
                }
            }
        }
        /**
         * 所有房子都涂色完成后，取最小总成本
         */
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (dp[n / 2 - 1][i][j] != Long.MAX_VALUE) {
                    result = Math.min(result, dp[n / 2 - 1][i][j]);
                }
            }
        }
        return result;
    }
}
