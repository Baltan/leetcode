package leetcode.algorithms;

/**
 * Description: 3393. Count Paths With the Given XOR Value
 *
 * @author Baltan
 * @date 2024/12/26 20:13
 */
public class CountPathsWithXorValue {
    public static void main(String[] args) {
        System.out.println(countPathsWithXorValue(new int[][]{{2, 1, 5}, {7, 10, 0}, {12, 6, 4}}, 11));
        System.out.println(countPathsWithXorValue(new int[][]{{1, 3, 3, 3}, {0, 3, 3, 2}, {3, 0, 1, 1}}, 2));
        System.out.println(countPathsWithXorValue(new int[][]{{1, 1, 1, 2}, {3, 0, 3, 2}, {3, 0, 2, 2}}, 10));
    }

    public static int countPathsWithXorValue(int[][] grid, int k) {
        int mod = 1000000007;
        int rows = grid.length;
        int cols = grid[0].length;
        /**
         * dp[i][j][l]表示到达网格grid[i][j]后，使得路径上所有数字按位异或的值为l的路径条数
         */
        long[][][] dp = new long[rows][cols][16];
        /**
         * 出发时在左上角网格，路径上只有一个数字grid[0][0]
         */
        dp[0][0][grid[0][0]] = 1L;
        /**
         * 最左一列只能从上向下移动
         */
        for (int i = 1; i < rows; i++) {
            for (int j = 0; j < 16; j++) {
                if (dp[i - 1][0][j] > 0) {
                    /**
                     * 如果到达网格grid[i-1][0]时，路径上所有数字按位异或的值为j，则到达grid[i][0]时，值为j^grid[i][0]，此时的路径条
                     * 数为dp[i-1][0][j]
                     */
                    dp[i][0][j ^ grid[i][0]] = dp[i - 1][0][j];
                }
            }
        }
        /**
         * 最上一行只能从左向右移动
         */
        for (int i = 1; i < cols; i++) {
            for (int j = 0; j < 16; j++) {
                if (dp[0][i - 1][j] > 0) {
                    /**
                     * 如果到达网格grid[0][i-1]时，路径上所有数字按位异或的值为j，则到达grid[0][i]时，值为j^grid[0][i]，此时的路径条
                     * 数为dp[0][i-1][j]
                     */
                    dp[0][i][j ^ grid[0][i]] = dp[0][i - 1][j];
                }
            }
        }

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                for (int l = 0; l < 16; l++) {
                    int xor = l ^ grid[i][j];

                    if (dp[i - 1][j][l] > 0) {
                        /**
                         * 如果到达网格grid[i-1][j]时，路径上所有数字按位异或的值为l，则到达grid[i][j]时，值为l^grid[i][j]，此时的
                         * 路径条数为dp[i-1][j][l]
                         */
                        dp[i][j][xor] = dp[i - 1][j][l];
                    }

                    if (dp[i][j - 1][l] > 0) {
                        /**
                         * 如果到达网格grid[i][j-1]时，路径上所有数字按位异或的值为l，则到达grid[i][l]时，值为l^grid[i][l]，此时的
                         * 路径条数为dp[i][j-1][l]
                         */
                        dp[i][j][xor] = (dp[i][j][xor] + dp[i][j - 1][l]) % mod;
                    }
                }
            }
        }
        return (int) dp[rows - 1][cols - 1][k];
    }
}
