package leetcode.algorithms;

/**
 * Description: 304. Range Sum Query 2D - Immutable
 *
 * @author Baltan
 * @date 2019-06-19 09:41
 */
public class NumMatrix {
    private int[][] matrix;
    private int[][] dp;

    public NumMatrix(int[][] matrix) {
        this.matrix = matrix;
        help();
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (dp != null) {
            if (row1 == 0 && col1 == 0) {
                return dp[row2][col2];
            } else if (row1 == 0) {
                return dp[row2][col2] - dp[row2][col1 - 1];
            } else if (col1 == 0) {
                return dp[row2][col2] - dp[row1 - 1][col2];
            } else {
                return dp[row2][col2] + dp[row1 - 1][col1 - 1] - dp[row1 - 1][col2] - dp[row2][col1 - 1];
            }
        }
        return 0;
    }

    public void help() {
        if (matrix != null && matrix.length > 0 && matrix[0].length > 0) {
            int rows = matrix.length;
            int cols = matrix[0].length;

            dp = new int[rows][cols];
            dp[0][0] = matrix[0][0];

            for (int i = 1; i < rows; i++) {
                dp[i][0] = dp[i - 1][0] + matrix[i][0];
            }

            for (int i = 1; i < cols; i++) {
                dp[0][i] = dp[0][i - 1] + matrix[0][i];
            }

            for (int i = 1; i < rows; i++) {
                for (int j = 1; j < cols; j++) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + matrix[i][j];
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix =
                {{3, 0, 1, 4, 2}, {5, 6, 3, 2, 1}, {1, 2, 0, 1, 5}, {4, 1, 0, 1, 7}, {1, 0, 3, 0, 5}};
        NumMatrix numMatrix = new NumMatrix(matrix);
        System.out.println(numMatrix.sumRegion(2, 1, 4, 3));
        System.out.println(numMatrix.sumRegion(1, 1, 2, 2));
        System.out.println(numMatrix.sumRegion(1, 2, 2, 4));
    }
}