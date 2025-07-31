package leetcode.algorithms;

/**
 * Description: 3603. Minimum Cost Path with Alternating Directions II
 *
 * @author baltan
 * @date 2025/7/31 16:40
 */
public class MinCost9 {
    public static void main(String[] args) {
        System.out.println(minCost(1, 2, new int[][]{{1, 2}}));
        System.out.println(minCost(2, 2, new int[][]{{3, 5}, {2, 4}}));
        System.out.println(minCost(2, 3, new int[][]{{6, 1, 4}, {3, 2, 5}}));
    }

    public static long minCost(int m, int n, int[][] waitCost) {
        /**
         * dp[i][j]表示到达单元格grid[i][j]时的最小成本。为了统一计算，假设在grid[0][0]处也停留了1秒，最后结果减去这1秒的等待成本
         * waitCost[0][0]即可
         */
        long[][] dp = new long[m][n];
        dp[0][0] = 1;

        for (int i = 1; i < m; i++) {
            /**
             * 只能从grid[i-1][0]停留1秒后到达grid[i][0]
             */
            dp[i][0] = dp[i - 1][0] + waitCost[i - 1][0] + (i + 1);
        }

        for (int i = 1; i < n; i++) {
            /**
             * 只能从grid[0][i-1]停留1秒后到达grid[0][i]
             */
            dp[0][i] = dp[0][i - 1] + waitCost[0][i - 1] + (i + 1);
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                /**
                 * 可以从grid[i-1][j]停留1秒后到达grid[i][j]，或从从grid[i][j-1]停留1秒后到达grid[i][j]，两者取成本较小的情况
                 */
                dp[i][j] = Math.min(dp[i - 1][j] + waitCost[i - 1][j], dp[i][j - 1] + waitCost[i][j - 1]) + (long) (i + 1) * (j + 1);
            }
        }
        /**
         * 减去假设在grid[0][0]处停留了1秒的等待成本
         */
        return dp[m - 1][n - 1] - waitCost[0][0];
    }
}
