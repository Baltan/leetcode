package leetcode.algorithms;

import leetcode.util.OutputUtils;

/**
 * Description: 73. Set Matrix Zeroes
 *
 * @author Baltan
 * @date 2018/9/24 11:58
 * @see leetcode.interview.SetZeroes
 */
public class SetZeroes {
    public static void main(String[] args) {
        int[][] matrix1 = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        setZeroes(matrix1);

        System.out.println("----------------------------");

        int[][] matrix2 = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        setZeroes(matrix2);

        System.out.println("----------------------------");

        int[][] matrix3 = {{0, 1}, {2, 3}};
        setZeroes(matrix3);

        System.out.println("----------------------------");

        int[][] matrix4 = {{1, 1, 1}, {0, 1, 1}};
        setZeroes(matrix4);
    }

    public static void setZeroes(int[][] matrix) {
        if (matrix.length == 0) {
            return;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;
        /**
         * 记录第一行是否需要清零
         */
        boolean firstRowAllZero = false;
        /**
         * 记录第一列是否需要清零
         */
        boolean firstColumnAllZero = false;
        /**
         * 如果matrix[0][0]为0，说明第一行和第一列最终都需要清零
         */
        if (matrix[0][0] == 0) {
            firstRowAllZero = true;
            firstColumnAllZero = true;
        }

        if (!firstRowAllZero) {
            for (int i = 1; i < cols; i++) {
                /**
                 * 如果第一行有0，说明第一行最终要清零
                 */
                if (matrix[0][i] == 0) {
                    firstRowAllZero = true;
                    break;
                }
            }
        }

        if (!firstColumnAllZero) {
            for (int i = 1; i < rows; i++) {
                /**
                 * 如果第一列有0，说明第一列最终要清零
                 */
                if (matrix[i][0] == 0) {
                    firstColumnAllZero = true;
                    break;
                }
            }
        }

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                /**
                 * 如果矩阵中某个元素为0，将同一行和同一列的第一个元素记为0
                 */
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i = 1; i < rows; i++) {
            /**
             * 如果第一列的某个元素为0，将该元素所在行的所有元素清零
             */
            if (matrix[i][0] == 0) {
                for (int j = 1; j < cols; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        for (int i = 1; i < cols; i++) {
            /**
             * 如果第一行的某个元素为0，将该元素所在列的所有元素清零
             */
            if (matrix[0][i] == 0) {
                for (int j = 1; j < rows; j++) {
                    matrix[j][i] = 0;
                }
            }
        }
        /**
         * 根据需要将第一行所有元素清零
         */
        if (firstRowAllZero) {
            for (int i = 0; i < cols; i++) {
                matrix[0][i] = 0;
            }
        }
        /**
         * 根据需要将第一列所有元素清零
         */
        if (firstColumnAllZero) {
            for (int i = 0; i < rows; i++) {
                matrix[i][0] = 0;
            }
        }
        OutputUtils.print2DIntegerArray(matrix);
    }
}
