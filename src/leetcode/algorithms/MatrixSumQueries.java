package leetcode.algorithms;

/**
 * Description: 2718. Sum of Matrix After Queries
 *
 * @author Baltan
 * @date 2023/6/4 14:00
 */
public class MatrixSumQueries {
    public static void main(String[] args) {
        System.out.println(matrixSumQueries(8, new int[][]{{0, 6, 30094}, {0, 7, 99382}, {1, 2, 18599}, {1, 3, 49292}, {1, 0, 81549}, {1, 1, 38280}, {0, 0, 19405}, {0, 4, 30065}, {1, 4, 60826}, {1, 5, 9241}, {0, 5, 33729}, {0, 1, 41456}, {0, 2, 62692}, {0, 3, 30807}, {1, 7, 70613}, {1, 6, 9506}, {0, 5, 39344}, {1, 0, 44658}, {1, 1, 56485}, {1, 2, 48112}, {0, 6, 43384}}));
        System.out.println(matrixSumQueries(3, new int[][]{{0, 0, 1}, {1, 2, 2}, {0, 2, 3}, {1, 0, 4}}));
        System.out.println(matrixSumQueries(3, new int[][]{{0, 0, 4}, {0, 1, 2}, {1, 0, 1}, {0, 2, 3}, {1, 2, 1}}));
    }

    public static long matrixSumQueries(int n, int[][] queries) {
        long result = 0L;
        /**
         * 剩余可填充数字的行数
         */
        int rows = n;
        /**
         * 剩余可填充数字的列数
         */
        int cols = n;
        /**
         * isVisitedRows[i]表示第i行是否已被填充过数字
         */
        boolean[] isVisitedRows = new boolean[n];
        /**
         * isVisitedCols[i]表示第i列是否已被填充过数字
         */
        boolean[] isVisitedCols = new boolean[n];
        /**
         * 因为如果填充数字的单元格发生重叠，后面填充的数字总会覆盖前面填充的数字，所以倒序处理每一次操作
         */
        for (int i = queries.length - 1; i >= 0; i--) {
            int type = queries[i][0];
            int index = queries[i][1];
            int value = queries[i][2];
            /**
             * 当需要填充某一行或某一列数字不会被后续的操作覆盖时，才可能被保留下来，同时对于之前操作所填充的数字，最终实际可保留下来的行数或
             * 列数就会被减1
             */
            if (type == 0 && !isVisitedCols[index]) {
                result += (long) value * cols;
                isVisitedCols[index] = true;
                rows--;
            } else if (type == 1 && !isVisitedRows[index]) {
                result += (long) value * rows;
                isVisitedRows[index] = true;
                cols--;
            }
        }
        return result;
    }
}
