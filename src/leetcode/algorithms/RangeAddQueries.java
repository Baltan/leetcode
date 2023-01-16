package leetcode.algorithms;

import leetcode.util.OutputUtils;

/**
 * Description: 2536. Increment Submatrices by One
 *
 * @author Baltan
 * @date 2023/1/16 13:48
 */
public class RangeAddQueries {
    public static void main(String[] args) {
        OutputUtils.print2DIntegerArray(rangeAddQueries(3, new int[][]{{1, 1, 2, 2}, {0, 0, 1, 1}}));
        OutputUtils.print2DIntegerArray(rangeAddQueries(2, new int[][]{{0, 0, 1, 1}}));
    }

    public static int[][] rangeAddQueries(int n, int[][] queries) {
        /**
         * diffsArray[i]为原矩阵mat第i行的差分数组
         */
        int[][] diffsArray = new int[n][n];

        for (int[] query : queries) {
            int startRow = query[0];
            int startCol = query[1];
            int endRow = query[2];
            int endCol = query[3];
            /**
             * 计算矩阵mat第startRow行到第endRow行的差分数组
             */
            for (int i = startRow; i <= endRow; i++) {
                int[] diffs = diffsArray[i];
                diffs[startCol]++;

                if (endCol + 1 < n) {
                    diffs[endCol + 1]--;
                }
            }
        }
        /**
         * 由每一行的差分数组倒推每一行的原始数组，假设差分数组为diffs，原数组为x，则：
         * x[i]=diffs[0]+diffs[1]+……+diffs[i]
         *     =x[i-1]+diffs[i]
         */
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n; j++) {
                diffsArray[i][j] = diffsArray[i][j - 1] + diffsArray[i][j];
            }
        }
        return diffsArray;
    }
}
