package leetcode.algorithms;

/**
 * Description: 1594. Maximum Non Negative Product in a Matrix
 *
 * @author Baltan
 * @date 2020-09-21 22:40
 */
public class MaxProductPath {
    public static void main(String[] args) {
        int[][] grid1 = {{-1, -2, -3}, {-2, -3, -3}, {-3, -3, -2}};
        System.out.println(maxProductPath(grid1));

        int[][] grid2 = {{1, -2, 1}, {1, -2, 1}, {3, -4, 1}};
        System.out.println(maxProductPath(grid2));

        int[][] grid3 = {{1, 3}, {0, -4}};
        System.out.println(maxProductPath(grid3));

        int[][] grid4 = {{1, 4, 4, 0}, {-2, 0, 0, 1}, {1, -1, 1, 1}};
        System.out.println(maxProductPath(grid4));
    }

    public static int maxProductPath(int[][] grid) {
        int mod = 1000000007;
        int rows = grid.length;
        int cols = grid[0].length;
        /**
         * dp[i][j][0]表示从grid[0][0]到grid[i][j]的路径可以得到的最大正数积，dp[i][j][1]表示从
         * grid[0][0]到grid[i][j]的路径可以得到的最小负数积
         */
        long[][][] dp = new long[rows][cols][2];
        /**
         * 矩阵中是否包含0
         */
        boolean hasZero = false;
        /**
         * 计算矩阵中是否包含0
         */
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 0) {
                    hasZero = true;
                }
            }
        }

        if (grid[0][0] > 0) {
            dp[0][0][0] = grid[0][0];
        } else if (grid[0][0] < 0) {
            dp[0][0][1] = grid[0][0];
        }
        /**
         * 沿着第一列走
         */
        for (int i = 1; i < rows; i++) {
            /**
             * 从上方最大正数积的路径向下走
             */
            long topPositive = grid[i][0] * dp[i - 1][0][0];
            /**
             * 从上方最小负数积的路径向下走
             */
            long topNegative = grid[i][0] * dp[i - 1][0][1];

            if (topPositive > 0) {
                dp[i][0][0] = Math.max(dp[i][0][0], topPositive);
            } else if (topPositive < 0) {
                dp[i][0][1] = Math.min(dp[i][0][1], topPositive);
            }

            if (topNegative > 0) {
                dp[i][0][0] = Math.max(dp[i][0][0], topNegative);
            } else if (topNegative < 0) {
                dp[i][0][1] = Math.min(dp[i][0][1], topNegative);
            }
        }
        /**
         * 沿着第一排走
         */
        for (int i = 1; i < cols; i++) {
            /**
             * 从左方最大正数积的路径向右走
             */
            long leftPositive = grid[0][i] * dp[0][i - 1][0];
            /**
             * 从左方最小负数积的路径向右走
             */
            long leftNegative = grid[0][i] * dp[0][i - 1][1];

            if (leftPositive > 0) {
                dp[0][i][0] = Math.max(dp[0][i][0], leftPositive);
            } else if (leftPositive < 0) {
                dp[0][i][1] = Math.min(dp[0][i][1], leftPositive);
            }

            if (leftNegative > 0) {
                dp[0][i][0] = Math.max(dp[0][i][0], leftNegative);
            } else if (leftNegative < 0) {
                dp[0][i][1] = Math.min(dp[0][i][1], leftNegative);
            }
        }

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                /**
                 * 从上方最大正数积的路径向下走
                 */
                long topPositive = grid[i][j] * dp[i - 1][j][0];
                /**
                 * 从上方最小负数积的路径向下走
                 */
                long topNegative = grid[i][j] * dp[i - 1][j][1];
                /**
                 * 从左方最大正数积的路径向右走
                 */
                long leftPositive = grid[i][j] * dp[i][j - 1][0];
                /**
                 * 从左方最小负数积的路径向右走
                 */
                long leftNegative = grid[i][j] * dp[i][j - 1][1];

                if (topPositive > 0) {
                    dp[i][j][0] = Math.max(dp[i][j][0], topPositive);
                } else if (topPositive < 0) {
                    dp[i][j][1] = Math.min(dp[i][j][1], topPositive);
                }

                if (topNegative > 0) {
                    dp[i][j][0] = Math.max(dp[i][j][0], topNegative);
                } else if (topNegative < 0) {
                    dp[i][j][1] = Math.min(dp[i][j][1], topNegative);
                }

                if (leftPositive > 0) {
                    dp[i][j][0] = Math.max(dp[i][j][0], leftPositive);
                } else if (leftPositive < 0) {
                    dp[i][j][1] = Math.min(dp[i][j][1], leftPositive);
                }

                if (leftNegative > 0) {
                    dp[i][j][0] = Math.max(dp[i][j][0], leftNegative);
                } else if (leftNegative < 0) {
                    dp[i][j][1] = Math.min(dp[i][j][1], leftNegative);
                }
            }
        }
        /**
         * 如果走到grid[rows-1][cols-1]后的路径最大正数积为正，返回该值；如果最大正数积为0，需要通过判断
         * 矩阵中是否存在0来确定是否存在积为0的路径，如果存在0，就返回0，否则说明没有非负积路径，返回-1
         */
        if (dp[rows - 1][cols - 1][0] > 0) {
            return (int) (dp[rows - 1][cols - 1][0] % mod);
        } else if (dp[rows - 1][cols - 1][0] == 0 && hasZero) {
            return 0;
        } else {
            return -1;
        }
    }
}
