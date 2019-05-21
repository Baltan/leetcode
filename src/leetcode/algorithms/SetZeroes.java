package leetcode.algorithms;

import leetcode.util.OutputUtils;

/**
 * Description: 73. Set Matrix Zeroes
 *
 * @author Baltan
 * @date 2018/9/24 11:58
 */
public class SetZeroes {
    public static void main(String[] args) {
        int[][] matrix1 = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        setZeroes(matrix1);
        int[][] matrix2 = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        setZeroes(matrix2);
        int[][] matrix3 = {{0, 1}, {2, 3}};
        setZeroes(matrix3);
        int[][] matrix4 = {{1, 1, 1}, {0, 1, 1}};
        setZeroes(matrix4);
    }

    public static void setZeroes(int[][] matrix) {
        if (matrix.length == 0) {
            return;
        }
        int length = matrix.length;
        int width = matrix[0].length;
        int mark = -1; // 标记matrix[0][0]为0时的情况，若mark=0，则第一行全为0；若mark=1，则第一列全为0；若mark=2，则第一行第一列全为0；
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                    if (i == 0 && j == 0) {
                        mark = 2;
                    } else if (i == 0 && j != 0 && mark != 2) {
                        mark = 0;
                    } else if (j == 0 && i != 0 && mark != 2) {
                        if (mark == 0) {
                            mark = 2;
                        } else {
                            mark = 1;
                        }
                    }
                }
            }
        }
        for (int i = 1; i < length; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 0; j < width; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        for (int i = 1; i < width; i++) {
            if (matrix[0][i] == 0) {
                for (int j = 0; j < length; j++) {
                    matrix[j][i] = 0;
                }
            }
        }
        if (matrix[0][0] == 0) {
            if (mark == 0) {
                for (int i = 0; i < width; i++) {
                    matrix[0][i] = 0;
                }
            } else if (mark == 1) {
                for (int i = 0; i < length; i++) {
                    matrix[i][0] = 0;
                }
            } else {
                for (int i = 0; i < length; i++) {
                    matrix[i][0] = 0;
                }
                for (int i = 0; i < width; i++) {
                    matrix[0][i] = 0;
                }
            }
        }
        OutputUtils.print2DIntegerArray(matrix);
    }
}
