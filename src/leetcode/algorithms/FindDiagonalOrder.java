package leetcode.algorithms;

import leetcode.util.OutputUtils;

/**
 * Description: 498. Diagonal Traverse
 *
 * @author Baltan
 * @date 2020-02-06 14:54
 */
public class FindDiagonalOrder {
    public static void main(String[] args) {
        int[][] matrix1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        OutputUtils.print1DIntegerArray(findDiagonalOrder(matrix1));
    }

    public static int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new int[]{};
        }

        int rows = matrix.length;
        int cols = matrix[0].length;
        int[] result = new int[rows * cols];
        int index = 0;
        /**
         * 对于同一条对角线上的元素，它们的行索引和列索引的和是一样；对于不同的对角线，这个和是逐一
         * 递增的。第一条对角线的索引和为0（左上角元素行索引和列索引的和），最后一条对角线的索引和
         * 为rows+cols-2（右下角元素行索引和列索引的和）
         */
        int minIndex = 0;
        int maxIndex = rows + cols - 2;
        /**
         * 当前对角线上元素的遍历方向，true表示从左下向右上遍历，false表示从右上向左下遍历
         */
        boolean direction = true;
        /**
         * 从左上向右下处理每一条对角线上的元素
         */
        for (int indexSum = minIndex; indexSum <= maxIndex; indexSum++) {
            if (direction) {
                /**
                 * 如果从左下向右上遍历对角线上的元素，这条对角线上的第一个元素不是在第一列，就是
                 * 在最后一行，第一个元素的列索引为Math.max(0,indexSum-(rows-1))
                 */
                int startCol = Math.max(0, indexSum - (rows - 1));
                /**
                 * 第一个元素的行索引
                 */
                int startRow = indexSum - startCol;
                /**
                 * 从左下向右上遍历对角线上的元素直到超出矩阵范围
                 */
                while (true) {
                    result[index++] = matrix[startRow--][startCol++];

                    if (startRow < 0 || startCol == cols) {
                        /**
                         * 变换遍历方向为从右上向左下
                         */
                        direction = false;
                        break;
                    }
                }
            } else {
                /**
                 * 如果从右上向左下遍历对角线上的元素，这条对角线上的第一个元素不是在第一行，就是
                 * 在最后一列，第一个元素的行索引为Math.max(0,indexSum-(cols-1))
                 */
                int startRow = Math.max(0, indexSum - (cols - 1));
                /**
                 * 第一个元素的列索引
                 */
                int startCol = indexSum - startRow;
                /**
                 * 从右上向左下遍历对角线上的元素直到超出矩阵范围
                 */
                while (true) {
                    result[index++] = matrix[startRow++][startCol--];

                    if (startRow == rows || startCol < 0) {
                        /**
                         * 变换遍历方向为左下向右上
                         */
                        direction = true;
                        break;
                    }
                }
            }
        }
        return result;
    }
}
