package leetcode.algorithms;

/**
 * Description: 3742. Maximum Path Score in a Grid
 *
 * @author baltan
 * @date 2026/1/20 16:34
 */
public class MaxPathScore {
    public static void main(String[] args) {
        System.out.println(maxPathScore(new int[][]{{0, 2, 2}, {1, 1, 1}, {0, 0, 2}}, 3));
        System.out.println(maxPathScore(new int[][]{{0, 1}, {2, 0}}, 1));
        System.out.println(maxPathScore(new int[][]{{0, 1}, {1, 2}}, 1));
    }

    public static int maxPathScore(int[][] grid, int k) {
        int result = -1;
        int rows = grid.length;
        int cols = grid[0].length;
        /**
         * dp[i][j][k]表示到达网格grid[i][j]且花费为k时的最大得分
         */
        int[][][] dp = new int[rows][cols][k + 1];
        /**
         * maxCosts[i][j]表示到达网格grid[i][j]时可能的最大花费
         */
        int[][] maxCosts = new int[rows][cols];
        /**
         * 初始化假设所有网格不管多少花费都不可到达
         */
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                for (int l = 0; l <= k; l++) {
                    dp[i][j][l] = -1;
                }
            }
        }
        /**
         * 出发点
         */
        dp[0][0][0] = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                /**
                 * 可以尝试从网格grid[i-1][j]向下移动一格到达grid[i][j]
                 */
                if (i > 0) {
                    /**
                     * 遍历网格grid[i-1][j]花费在[0,maxCosts[i-1][j]]范围内的情况，假设为l，到达网格grid[i][j]时的花费不能大于k
                     */
                    for (int l = 0; l <= maxCosts[i - 1][j] && l + (grid[i][j] == 0 ? 0 : 1) <= k; l++) {
                        if (dp[i - 1][j][l] != -1) {
                            /**
                             * 到达网格grid[i][j]时的花费
                             */
                            int cost = l + (grid[i][j] == 0 ? 0 : 1);
                            /**
                             * 到达网格grid[i][j]时的得分
                             */
                            int score = dp[i - 1][j][l] + grid[i][j];
                            dp[i][j][cost] = Math.max(dp[i][j][cost], score);
                            maxCosts[i][j] = Math.max(maxCosts[i][j], cost);
                        }
                    }
                }
                /**
                 * 可以尝试从网格grid[i][j-1]向右移动一格到达grid[i][j]
                 */
                if (j > 0) {
                    /**
                     * 遍历网格grid[i][j-1]花费在[0,maxCosts[i][j-1]]范围内的情况，假设为l，到达网格grid[i][j]时的花费不能大于k
                     */
                    for (int l = 0; l <= maxCosts[i][j - 1] && l + (grid[i][j] == 0 ? 0 : 1) <= k; l++) {
                        if (dp[i][j - 1][l] != -1) {
                            /**
                             * 到达网格grid[i][j]时的花费
                             */
                            int cost = l + (grid[i][j] == 0 ? 0 : 1);
                            /**
                             * 到达网格grid[i][j]时的得分
                             */
                            int score = dp[i][j - 1][l] + grid[i][j];
                            dp[i][j][cost] = Math.max(dp[i][j][cost], score);
                            maxCosts[i][j] = Math.max(maxCosts[i][j], cost);
                        }
                    }
                }
            }
        }
        /**
         * 计算到达网格grid[rows-1][cols-1]时的最大得分
         */
        for (int i = 0; i <= k; i++) {
            result = Math.max(result, dp[rows - 1][cols - 1][i]);
        }
        return result;
    }
}
