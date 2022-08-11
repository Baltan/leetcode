package leetcode.algorithms;

import java.util.Arrays;

/**
 * Description: 1727. Largest Submatrix With Rearrangements
 *
 * @author Baltan
 * @date 2022/8/7 12:52
 */
public class LargestSubmatrix {
    public static void main(String[] args) {
        int[][] matrix1 = {{0, 0, 1}, {1, 1, 1}, {1, 0, 1}};
        System.out.println(largestSubmatrix(matrix1));

        int[][] matrix2 = {{1, 0, 1, 0, 1}};
        System.out.println(largestSubmatrix(matrix2));

        int[][] matrix3 = {{1, 1, 0}, {1, 0, 1}};
        System.out.println(largestSubmatrix(matrix3));
    }

    /**
     * 参考：
     * <a href="https://leetcode.cn/problems/largest-submatrix-with-rearrangements/solution/java-yu-chu-li-shu-zu-bian-li-mei-xing-p-qpqu/"></a>
     *
     * @param matrix
     * @return
     */
    public static int largestSubmatrix(int[][] matrix) {
        int result = 0;
        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int i = 0; i < cols; i++) {
            for (int j = 1; j < rows; j++) {
                if (matrix[j][i] == 1) {
                    /**
                     * matrix[j][i]修改后的值表示，从原有的matrix[j][i]开始往上数最多有几个连续的"1"，例如：
                     * 0   0   1        0   0   1
                     * 1   1   1   =>   1   1   2
                     * 1   0   1        2   0   3
                     */
                    matrix[j][i] = matrix[j - 1][i] + 1;
                }
            }
        }

        for (int i = 0; i < rows; i++) {
            Arrays.sort(matrix[i]);

            for (int j = cols - 1; j >= 0; j--) {
                if (matrix[i][j] == 0) {
                    break;
                }
                /**
                 * 以matrix[i]作为子矩阵的底边，matrix的最右列作为子矩阵的最右列，可以构成的子矩阵的最大高度
                 */
                int height = matrix[i][j];
                /**
                 * 子矩阵的面积为height*(cols-j)
                 */
                result = Math.max(result, height * (cols - j));
            }
        }
        return result;
    }
}
