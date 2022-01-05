package leetcode.algorithms;

import leetcode.util.OutputUtils;

/**
 * Description: 面试题 17.23. 最大黑方阵
 *
 * @author Baltan
 * @date 2022/1/5 19:18
 */
public class FindSquare {
    public static void main(String[] args) {
        int[][] matrix1 = {{1, 0, 1}, {0, 0, 1}, {0, 0, 1}};
        OutputUtils.print1DIntegerArray(findSquare(matrix1));

        int[][] matrix2 = {{0, 1, 1}, {1, 0, 1}, {1, 1, 0}};
        OutputUtils.print1DIntegerArray(findSquare(matrix2));

        int[][] matrix3 = {{0}};
        OutputUtils.print1DIntegerArray(findSquare(matrix3));

        int[][] matrix4 = {{1}};
        OutputUtils.print1DIntegerArray(findSquare(matrix4));
    }

    public static int[] findSquare(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[]{};
        }
        /**
         * 标记矩阵中是否有黑像素
         */
        boolean flag = false;
        int rows = matrix.length;
        int cols = matrix[0].length;
        /**
         * 查找矩阵中是否有黑像素
         */
        outer:
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    flag = true;
                    break outer;
                }
            }
        }
        /**
         * 如果矩阵中没有黑像素，则不存在符合条件的子方阵，直接返回空数组
         */
        if (!flag) {
            return new int[]{};
        }

        int[] result = new int[3];
        /**
         * rightDp[i][j]表示以matrix[i][j]为起点，向右延伸最长黑色边的长度
         */
        int[][] rightDp = new int[rows][cols];
        /**
         * downDp[i][j]表示以matrix[i][j]为起点，向下延伸最长黑色边的长度
         */
        int[][] downDp = new int[rows][cols];
        /**
         * 先标记最右下角的点向右和向下延伸最长黑色边的长度
         */
        rightDp[rows - 1][cols - 1] = matrix[rows - 1][cols - 1] == 0 ? 1 : 0;
        downDp[rows - 1][cols - 1] = matrix[rows - 1][cols - 1] == 0 ? 1 : 0;
        /**
         * 计算最底下的边上的点（除最右下角的点）向右和向下延伸最长黑色边的长度
         */
        for (int i = cols - 2; i >= 0; i--) {
            if (matrix[rows - 1][i] == 0) {
                downDp[rows - 1][i] = 1;
                rightDp[rows - 1][i] = rightDp[rows - 1][i + 1] + 1;
            } else {
                downDp[rows - 1][i] = 0;
                rightDp[rows - 1][i] = 0;
            }
        }
        /**
         * 计算最右边的边上的点（除最右下角的点）向右和向下延伸最长黑色边的长度
         */
        for (int i = rows - 2; i >= 0; i--) {
            if (matrix[i][cols - 1] == 0) {
                rightDp[i][cols - 1] = 1;
                downDp[i][cols - 1] = downDp[i + 1][cols - 1] + 1;
            } else {
                rightDp[i][cols - 1] = 0;
                downDp[i][cols - 1] = 0;
            }
        }
        /**
         * 计其他点（除最底下的边和最右边的边）向右和向下延伸最长黑色边的长度
         */
        for (int i = rows - 2; i >= 0; i--) {
            for (int j = cols - 2; j >= 0; j--) {
                if (matrix[i][j] == 0) {
                    rightDp[i][j] = rightDp[i][j + 1] + 1;
                    downDp[i][j] = downDp[i + 1][j] + 1;
                }
            }
        }
        /**
         * 逐一判断以每个点作为左上角的点，可以构成的最大的符合条件的子方阵
         */
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                /**
                 * 子方阵可能的最大边长
                 */
                int maxLength = Math.min(rightDp[i][j], downDp[i][j]);

                for (int length = maxLength; length > 0; length--) {
                    /**
                     * 只有子方阵左下角的点向右延伸黑色边的长度和子方阵右上角的点向下延伸黑色边的长度都不小于length时，才可能
                     * 行程满足条件的子方阵
                     */
                    if (rightDp[i + length - 1][j] >= length && downDp[i][j + length - 1] >= length &&
                            length > result[2]) {
                        result[0] = i;
                        result[1] = j;
                        result[2] = length;
                    }
                }
            }
        }
        return result;
    }
}
