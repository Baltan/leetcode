package leetcode.algorithms;

/**
 * Description: 1277. Count Square Submatrices with All Ones
 *
 * @author Baltan
 * @date 2019-12-02 15:02
 * @see MaximalSquare1
 */
public class CountSquares {
    public static void main(String[] args) {
        int[][] matrix1 = {{0, 1, 1, 1}, {1, 1, 1, 1}, {0, 1, 1, 1}};
        System.out.println(countSquares(matrix1));

        int[][] matrix2 = {{1, 0, 1}, {1, 1, 0}, {1, 1, 0}};
        System.out.println(countSquares(matrix2));
    }

    public static int countSquares(int[][] matrix) {
        int result = 0;
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] dp = new int[rows + 1][cols + 1];
        /**
         * dp[i][j]表示以matrix[i-1][j-1]这个格子作为右下角格子的最大正方形的边长，如果matrix[i-1][j-1]为1，
         * 则dp[i][j]=min(dp[i-1][j],dp[i][j-1],dp[i-1][j-1])+1
         */
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 1) {
                    dp[i + 1][j + 1] = Math.min(Math.min(dp[i][j + 1], dp[i + 1][j]), dp[i][j]) + 1;
                    /**
                     * 以matrix[i-1][j-1]这个格子作为右下角格子可能形成边长为1，2，……，dp[i][j]，共有dp[i][j]
                     * 个正方形
                     */
                    result += dp[i + 1][j + 1];
                }
            }
        }
        return result;
    }
}
