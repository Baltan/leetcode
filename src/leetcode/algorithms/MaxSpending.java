package leetcode.algorithms;

/**
 * Description: 2931. Maximum Spending After Buying Items
 *
 * @author Baltan
 * @date 2023/12/24 22:13
 */
public class MaxSpending {
    public static void main(String[] args) {
        System.out.println(maxSpending(new int[][]{{8, 5, 2}, {6, 4, 1}, {9, 7, 3}}));
        System.out.println(maxSpending(new int[][]{{10, 8, 6, 4, 2}, {9, 7, 5, 3, 2}}));
    }

    public static long maxSpending(int[][] values) {
        long result = 0L;
        int rows = values.length;
        int cols = values[0].length;
        /**
         * indexes[i]表示第i行values[i]中，当前可以选择的数字索引
         */
        int[] indexes = new int[rows];
        /**
         * 总是选择rows行中当前可以选择的最大数字
         */
        for (int i = rows * cols; i > 0; i--) {
            int row = maxRow(values, indexes, rows, cols);
            result += (long) i * values[row][indexes[row]];
            indexes[row]++;
        }
        return result;
    }

    /**
     * 选出矩阵values的rows行中可选的最大数字的行数
     *
     * @param values
     * @param indexes
     * @param rows
     * @param cols
     * @return
     */
    public static int maxRow(int[][] values, int[] indexes, int rows, int cols) {
        int row = -1;
        int value = -1;

        for (int i = 0; i < rows; i++) {
            if (indexes[i] < cols && values[i][indexes[i]] > value) {
                row = i;
                value = values[i][indexes[i]];
            }
        }
        return row;
    }
}
