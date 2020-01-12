package leetcode.algorithms;

import leetcode.util.OutputUtils;

/**
 * Description: 1314. Matrix Block Sum
 *
 * @author Baltan
 * @date 2020-01-12 11:51
 */
public class MatrixBlockSum {
    public static void main(String[] args) {
        int[][] mat1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        OutputUtils.print2DIntegerArray(matrixBlockSum(mat1, 1));

        System.out.println("--------------------------");

        int[][] mat2 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        OutputUtils.print2DIntegerArray(matrixBlockSum(mat2, 2));
    }

    public static int[][] matrixBlockSum(int[][] mat, int K) {
        int rows = mat.length;
        int cols = mat[0].length;
        /**
         * prefixSum[i][j]表示mat[0][0]-mat[i-1][j-1]的所有元素的和，例如：mat为
         *
         * 1   2   3
         * 4   5   6
         * 7   8   9
         *
         * 求得的prefixSum为
         *
         * 0   0   0   0
         * 0   1   3   6
         * 0   5   12  21
         * 0   12  27  45
         *
         * 对于位置靠后的prefixSum[i][j]=prefixSum[i-1][j]+prefixSum[i][j-1]+mat[i-1][j-1]-
         * prefixSum[i-1][j-1]
         */
        int[][] prefixSum = new int[rows + 1][cols + 1];
        int[][] result = new int[rows][cols];

        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                prefixSum[i][j] = prefixSum[i - 1][j] + prefixSum[i][j - 1] + mat[i - 1][j - 1] -
                        prefixSum[i - 1][j - 1];
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                /**
                 * 符合条件的元素为mat[rowStart][rowEnd]-mat[colStart][colEnd]这些元素
                 */
                int rowStart = Math.max(0, i - K);
                int rowEnd = Math.min(rows - 1, i + K);
                int colStart = Math.max(0, j - K);
                int colEnd = Math.min(cols - 1, j + K);
                result[i][j] = prefixSum[rowEnd + 1][colEnd + 1] - prefixSum[rowStart][colEnd + 1] -
                        prefixSum[rowEnd + 1][colStart] + prefixSum[rowStart][colStart];
            }
        }
        return result;
    }
}
