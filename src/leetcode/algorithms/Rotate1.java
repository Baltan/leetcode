package leetcode.algorithms;

import leetcode.util.OutputUtils;

/**
 * Description: 48. Rotate Image
 *
 * @author Baltan
 * @date 2018/9/14 10:15
 */
public class Rotate1 {
    public static void main(String[] args) {
        int[][] matrix1 = {{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}};
        rotate(matrix1);

        int[][] matrix2 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        rotate(matrix2);

        int[][] matrix3 = {{1, 2}, {3, 4}};
        rotate(matrix3);

        int[][] matrix4 = {{1}};
        rotate(matrix4);
    }

    public static void rotate(int[][] matrix) {
        int length = matrix.length;

        for (int i = 0; i < length / 2; i++) {
            for (int j = i; j < length - i - 1; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[length - 1 - j][i];
                matrix[length - 1 - j][i] = matrix[length - 1 - i][length - 1 - j];
                matrix[length - 1 - i][length - 1 - j] = matrix[j][length - 1 - i];
                matrix[j][length - 1 - i] = temp;
            }
        }
        OutputUtils.print2DIntegerArray(matrix);
    }
}
