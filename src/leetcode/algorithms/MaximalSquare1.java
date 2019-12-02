package leetcode.algorithms;

/**
 * Description: 221. Maximal Square
 *
 * @author Baltan
 * @date 2019-06-10 12:09
 * <p>
 * 参考：
 * <a href="https://leetcode-cn.com/problems/maximal-square/solution/zui-da-zheng-fang-xing-by-leetcode/"></a>
 */
public class MaximalSquare1 {
    public static void main(String[] args) {
        char[][] matrix1 = {{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}};
        System.out.println(maximalSquare(matrix1));

        char[][] matrix2 = {{'0', '1'}, {'1', '1'}};
        System.out.println(maximalSquare(matrix2));
    }

    public static int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;
        /**
         * 最大正方形的边长
         */
        int max = 0;
        int[][] dp = new int[rows + 1][cols + 1];
        /**
         * dp[i][j]表示以matrix[i-1][j-1]这个格子作为右下角格子的最大正方形的边长，如果matrix[i-1][j-1]为1，
         * 则dp[i][j]=min(dp[i-1][j],dp[i][j-1],dp[i-1][j-1])+1
         */
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == '1') {
                    dp[i + 1][j + 1] = Math.min(Math.min(dp[i][j + 1], dp[i + 1][j]), dp[i][j]) + 1;
                    /**
                     * 更新最大正方形的边长
                     */
                    max = Math.max(max, dp[i + 1][j + 1]);
                }
            }
        }
        return max * max;
    }
}
