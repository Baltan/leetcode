package leetcode.algorithms;

import leetcode.util.OutputUtils;

/**
 * Description: 1605. Find Valid Matrix Given Row and Column Sums
 *
 * @author Baltan
 * @date 2022/10/7 12:57
 */
public class RestoreMatrix {
    public static void main(String[] args) {
        int[] rowSum1 = {3, 8};
        int[] colSum1 = {4, 7};
        OutputUtils.print2DIntegerArray(restoreMatrix(rowSum1, colSum1));

        System.out.println("--------------------------------------------------------");

        int[] rowSum2 = {5, 7, 10};
        int[] colSum2 = {8, 6, 8};
        OutputUtils.print2DIntegerArray(restoreMatrix(rowSum2, colSum2));
    }

    /**
     * 参考：
     * <a href="https://leetcode.cn/problems/find-valid-matrix-given-row-and-column-sums/solution/tan-xin-fa-fu-tu-jie-bao-zheng-neng-dong-by-durant/"></a>
     *
     * @param rowSum
     * @param colSum
     * @return
     */
    public static int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int rows = rowSum.length;
        int cols = colSum.length;
        int[][] result = new int[rows][cols];
        /**
         * 逐一遍历填充每个单元格，填入单元格的数字为符合题意的当前可以填入的最大数字，即该行剩余元素之和和该列剩余元素之和的较小
         * 值，对于后面的单元格，可以都填0
         */
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int min = Math.min(rowSum[i], colSum[j]);
                result[i][j] = min;
                rowSum[i] -= min;
                colSum[j] -= min;
            }
        }
        return result;
    }
}
