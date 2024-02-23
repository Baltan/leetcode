package leetcode.algorithms;

import leetcode.util.OutputUtils;

/**
 * Description: 3033. Modify the Matrix
 *
 * @author Baltan
 * @date 2024/2/23 22:15
 */
public class ModifiedMatrix {
    public static void main(String[] args) {
        OutputUtils.print2DIntegerArray(modifiedMatrix(new int[][]{{1, 2, -1}, {4, -1, 6}, {7, 8, 9}}));
        OutputUtils.print2DIntegerArray(modifiedMatrix(new int[][]{{3, -1}, {5, 2}}));
    }

    public static int[][] modifiedMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        /**
         * 逐列遍历
         */
        for (int i = 0; i < cols; i++) {
            /**
             * 当前列所有元素的最大值
             */
            int max = Integer.MIN_VALUE;

            for (int j = 0; j < rows; j++) {
                max = Math.max(max, matrix[j][i]);
            }

            for (int j = 0; j < rows; j++) {
                if (matrix[j][i] == -1) {
                    matrix[j][i] = max;
                }
            }
        }
        return matrix;
    }
}
