package leetcode.algorithms;

import leetcode.util.OutputUtils;

/**
 * Description: 542. 01 Matrix
 *
 * @author Baltan
 * @date 2019-12-20 14:52
 */
public class UpdateMatrix {
    public static void main(String[] args) {
        int[][] matrix1 = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        OutputUtils.print2DIntegerArray(updateMatrix(matrix1));

        int[][] matrix2 = {{0, 0, 0}, {0, 1, 0}, {1, 1, 1}};
        OutputUtils.print2DIntegerArray(updateMatrix(matrix2));
    }

    public static int[][] updateMatrix(int[][] matrix) {
        if (matrix == null) {
            return null;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] result = new int[rows][cols];
        /**
         * 剩余的没有计算距离的元素个数
         */
        int leftCount = rows * cols;
        int distance = 1;
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        /**
         * 初始化距离，将所有为0的元素的距离初始化为0，其余元素距离初始化为Integer.MAX_VALUE
         */
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    result[i][j] = 0;
                    leftCount--;
                } else {
                    result[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        while (leftCount != 0) {
            /**
             * 每一次循环将距离为distance-1的元素上下左右的元素距离设为distance（如果元素当前距离是
             * Integer.MAX_VALUE），直到所有元素的距离都被计算完为止
             */
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (result[i][j] == distance - 1) {
                        for (int[] direction : directions) {
                            int x = i + direction[0];
                            int y = j + direction[1];

                            if (x >= 0 && x < rows && y >= 0 && y < cols &&
                                    result[x][y] == Integer.MAX_VALUE) {
                                result[x][y] = distance;
                                leftCount--;
                            }
                        }
                    }
                }
            }
            distance++;
        }
        return result;
    }
}
