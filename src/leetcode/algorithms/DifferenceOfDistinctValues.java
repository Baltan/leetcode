package leetcode.algorithms;

import leetcode.util.OutputUtils;

/**
 * Description: 2711. Difference of Number of Distinct Values on Diagonals
 *
 * @author Baltan
 * @date 2023/5/28 18:30
 */
public class DifferenceOfDistinctValues {
    public static void main(String[] args) {
        OutputUtils.print2DIntegerArray(differenceOfDistinctValues(new int[][]{{1, 2, 3}, {3, 1, 5}, {3, 2, 1}}));
        System.out.println("---------------------------------");
        OutputUtils.print2DIntegerArray(differenceOfDistinctValues(new int[][]{{1}}));
    }

    public static int[][] differenceOfDistinctValues(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] result = new int[rows][cols];
        /**
         * topLeftCounts[i][j]表示单元格grid[i][j]左上角对角线上不同元素的个数
         */
        int[][] topLeftCounts = new int[rows][cols];
        /**
         * bottomRightCounts[i][j]表示单元格grid[i][j]右下角对角线上不同元素的个数
         */
        int[][] bottomRightCounts = new int[rows][cols];
        /**
         * 以第一行的单元格作为起点
         */
        for (int i = 0; i < cols; i++) {
            topLeft(topLeftCounts, grid, rows, cols, 0, i);
        }
        /**
         * 以第一列的单元格作为起点（除grid[0][0]）
         */
        for (int i = 1; i < rows; i++) {
            topLeft(topLeftCounts, grid, rows, cols, i, 0);
        }
        /**
         * 以最后一行的单元格作为起点
         */
        for (int i = 0; i < cols; i++) {
            bottomRight(bottomRightCounts, grid, rows - 1, i);
        }
        /**
         * 以最后一列的单元格作为起点（除grid[rows-1][cols-1]）
         */
        for (int i = rows - 2; i >= 0; i--) {
            bottomRight(bottomRightCounts, grid, i, cols - 1);
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = Math.abs(topLeftCounts[i][j] - bottomRightCounts[i][j]);
            }
        }
        return result;
    }

    /**
     * 计算每个单元格的左上角对角线上存在的不同元素的个数
     *
     * @param topLeftCounts
     * @param grid
     * @param rows
     * @param cols
     * @param row
     * @param col
     */
    public static void topLeft(int[][] topLeftCounts, int[][] grid, int rows, int cols, int row, int col) {
        /**
         * counts[i]表示从左上向右下遍历的过程中，对角线上元素i的个数，根据题意，grid[i][j]∈[1,50]
         */
        int[] counts = new int[51];
        /**
         * 累计对角线最左上角的数字
         */
        counts[grid[row][col]]++;
        row++;
        col++;
        /**
         * 向右下方向遍历
         */
        while (row < rows && col < cols) {
            /**
             * 如果grid[row-1][col-1]在左上角对角线上只出现过1次，说明grid[row][col]比grid[row-1][col-1]的左上角对角线中不同元素的
             * 个数多1个，即元素grid[row-1][col-1]；否则说明grid[row-1][col-1]之前就已出现过，没有增加新的不同元素
             */
            topLeftCounts[row][col] = topLeftCounts[row - 1][col - 1] + (counts[grid[row - 1][col - 1]] == 1 ? 1 : 0);
            counts[grid[row][col]]++;
            row++;
            col++;
        }
    }

    /**
     * 计算每个单元格的右下角对角线上存在的不同元素的个数
     *
     * @param bottomRightCounts
     * @param grid
     * @param row
     * @param col
     */
    public static void bottomRight(int[][] bottomRightCounts, int[][] grid, int row, int col) {
        /**
         * counts[i]表示从右下向左上遍历的过程中，对角线上元素i的个数，根据题意，grid[i][j]∈[1,50]
         */
        int[] counts = new int[51];
        /**
         * 累计对角线最右下角的数字
         */
        counts[grid[row][col]]++;
        row--;
        col--;
        /**
         * 向左上方向遍历
         */
        while (row >= 0 && col >= 0) {
            /**
             * 如果grid[row+1][col+1]在右下角对角线上只出现过1次，说明grid[row][col]比grid[row+1][col+1]的右下角对角线中不同元素的
             * 个数多1个，即元素grid[row+1][col+1]；否则说明grid[row+1][col+1]之前就已出现过，没有增加新的不同元素。
             */
            bottomRightCounts[row][col] = bottomRightCounts[row + 1][col + 1] + (counts[grid[row + 1][col + 1]] == 1 ? 1 : 0);
            counts[grid[row][col]]++;
            row--;
            col--;
        }
    }
}
