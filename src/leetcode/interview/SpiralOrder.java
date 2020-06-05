package leetcode.interview;

import leetcode.util.OutputUtils;

/**
 * Description: 面试题29. 顺时针打印矩阵
 *
 * @author Baltan
 * @date 2020-06-05 08:54
 * @see leetcode.algorithms.SpiralOrder
 */
public class SpiralOrder {
    public static void main(String[] args) {
        int[][] matrix1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        OutputUtils.print1DIntegerArray(spiralOrder(matrix1));

        int[][] matrix2 = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        OutputUtils.print1DIntegerArray(spiralOrder(matrix2));

        int[][] matrix3 = {};
        OutputUtils.print1DIntegerArray(spiralOrder(matrix3));

        int[][] matrix4 = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        OutputUtils.print1DIntegerArray(spiralOrder(matrix4));
    }

    public static int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new int[0];
        }

        int rows = matrix.length;
        int cols = matrix[0].length;
        int total = rows * cols;
        int index = 0;
        /**
         * isVisited[i][j]标记matrix[i][j]是否到达过
         */
        boolean[][] isVisited = new boolean[rows][cols];
        int[] result = new int[rows * cols];
        /**
         * 四种方向依次为向右、向下、向左、向上，构成顺时针方向
         */
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int directionIndex = 0;
        /**
         * 因为开始时方向是向右，第一个到达的位置是(0,0)，所以假设初始位置为(0,-1)
         */
        int currRow = 0;
        int currCol = -1;

        while (index < total) {
            if (!isUnavailable(rows, cols, currRow, currCol, directions[directionIndex], isVisited)) {
                currRow += directions[directionIndex][0];
                currCol += directions[directionIndex][1];
                result[index++] = matrix[currRow][currCol];
                /**
                 * 标记位置(currRow,currCol)已被到达过
                 */
                isVisited[currRow][currCol] = true;
            } else {
                /**
                 * 顺时针方向变换方向
                 */
                directionIndex = (directionIndex + 1) % directions.length;
            }
        }
        return result;
    }

    /**
     * 判断从当前位置(currRow,currCol)沿着方向direction走一步到达的位置是否是可达的
     *
     * @param rows
     * @param cols
     * @param currRow
     * @param currCol
     * @param direction
     * @param isVisited
     * @return
     */
    public static boolean isUnavailable(int rows, int cols, int currRow, int currCol, int[] direction,
                                        boolean[][] isVisited) {
        /**
         * 新到达的位置必须在matrix范围内并且该位置没有被到达过
         */
        return currRow + direction[0] < 0 || currRow + direction[0] == rows || currCol + direction[1] < 0 ||
                currCol + direction[1] == cols || isVisited[currRow + direction[0]][currCol + direction[1]];
    }
}
