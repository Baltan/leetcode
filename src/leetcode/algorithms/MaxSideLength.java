package leetcode.algorithms;

/**
 * Description: 1292. Maximum Side Length of a Square with Sum Less than or Equal to Threshold
 *
 * @author Baltan
 * @date 2019-12-19 09:39
 */
public class MaxSideLength {
    public static void main(String[] args) {
        int[][] mat1 = {{1, 1, 3, 2, 4, 3, 2}, {1, 1, 3, 2, 4, 3, 2}, {1, 1, 3, 2, 4, 3, 2}};
        System.out.println(maxSideLength(mat1, 4));

        int[][] mat2 = {{2, 2, 2, 2, 2}, {2, 2, 2, 2, 2}, {2, 2, 2, 2, 2}, {2, 2, 2, 2, 2}, {2, 2, 2, 2, 2}};
        System.out.println(maxSideLength(mat2, 1));

        int[][] mat3 = {{1, 1, 1, 1}, {1, 0, 0, 0}, {1, 0, 0, 0}, {1, 0, 0, 0}};
        System.out.println(maxSideLength(mat3, 6));

        int[][] mat4 = {{18, 70}, {61, 1}, {25, 85}, {14, 40}, {11, 96}, {97, 96}, {63, 45}};
        System.out.println(maxSideLength(mat4, 40184));
    }

    public static int maxSideLength(int[][] mat, int threshold) {
        int result = 0;
        int rows = mat.length;
        int cols = mat[0].length;
        /**
         * sums[i][j]表示以mat[0][0]为左上顶点，mat[i][j]为右下顶点的矩形的所有数字的和
         */
        int[][] sums = new int[rows][cols];
        sums[0][0] = mat[0][0];

        for (int i = 1; i < rows; i++) {
            sums[i][0] = sums[i - 1][0] + mat[i][0];
        }

        for (int i = 1; i < cols; i++) {
            sums[0][i] = sums[0][i - 1] + mat[0][i];
        }

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                sums[i][j] = sums[i - 1][j] + sums[i][j - 1] + mat[i][j] - sums[i - 1][j - 1];
            }
        }
        /**
         * 正方形以mat[i][j]作为左上顶点
         */
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                /**
                 * k为当前讨论正方形的边长-1
                 */
                for (int k = 0; ; k++) {
                    /**
                     * mat矩阵中的数字不够拼成以mat[i][j]作为左上顶点，k+1为边长的正方形，讨论下
                     * 一顶点
                     */
                    if (i + k == rows || j + k == cols) {
                        break;
                    }
                    /**
                     * 以mat[0][0]作为左上顶点，mat[i+k][j+k]作为右下顶点的正方形的所有数字的和
                     */
                    int rightBottomSum = sums[i + k][j + k];
                    /**
                     * 如果当前左上顶点在第一列，顶点左边没有矩形，左边矩形的所有数字的和记为0
                     */
                    int leftSum = j == 0 ? 0 : sums[i + k][j - 1];
                    /**
                     * 如果当前左上顶点在第一行，顶点上边没有矩形，上边矩形的所有数字的和记为0
                     */
                    int topSum = i == 0 ? 0 : sums[i - 1][j + k];
                    /**
                     * 如果当前顶点在第一行或第一列，顶点左上方没有矩形，左上矩形的所有数字的和记
                     * 为0
                     */
                    int leftTopSum = i == 0 || j == 0 ? 0 : sums[i - 1][j - 1];
                    /**
                     * 以mat[i][j]作为左上顶点，k+1为边长的正方形的所有数字的和，如果不大于阈值，
                     * 更新最大正方形的边长，否则讨论下一顶点
                     */
                    if (rightBottomSum - leftSum - topSum + leftTopSum <= threshold) {
                        result = Math.max(result, k + 1);
                    } else {
                        break;
                    }
                }
            }
        }
        return result;
    }
}
