package leetcode.algorithms;

import leetcode.util.OutputUtils;

/**
 * Description: 2639. Find the Width of Columns of a Grid
 *
 * @author Baltan
 * @date 2023/4/16 12:57
 */
public class FindColumnWidth {
    public static void main(String[] args) {
        OutputUtils.print1DIntegerArray(findColumnWidth(new int[][]{{1}, {22}, {333}}));
        OutputUtils.print1DIntegerArray(findColumnWidth(new int[][]{{-15, 1, 3}, {15, 7, 12}, {5, 6, -2}}));
    }

    public static int[] findColumnWidth(int[][] grid) {
        int cols = grid[0].length;
        int[] result = new int[cols];

        for (int i = 0; i < cols; i++) {
            /**
             * 遍历每一行第i列的字符串的长度
             */
            for (int[] row : grid) {
                result[i] = Math.max(result[i], String.valueOf(row[i]).length());
            }
        }
        return result;
    }
}
