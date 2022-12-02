package leetcode.algorithms;

import leetcode.util.OutputUtils;

/**
 * Description: 2482. Difference Between Ones and Zeros in Row and Column
 *
 * @author Baltan
 * @date 2022/11/29 18:19
 */
public class OnesMinusZeros {
    public static void main(String[] args) {
        int[][] grid1 = {{0, 1, 1}, {1, 0, 1}, {0, 0, 1}};
        OutputUtils.print2DIntegerArray(onesMinusZeros(grid1));

        System.out.println("---------------------------------------------");

        int[][] grid2 = {{1, 1, 1}, {1, 1, 1}};
        OutputUtils.print2DIntegerArray(onesMinusZeros(grid2));
    }

    public static int[][] onesMinusZeros(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] result = new int[rows][cols];
        /**
         * oneCountInRow[i]表示第i行中1的个数
         */
        int[] oneCountInRow = new int[rows];
        /**
         * oneCountInRow[i]表示第i行中1的个数
         */
        int[] oneCountInCol = new int[cols];
        /**
         * 统计每一行和每一列中1的个数
         */
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                oneCountInRow[i] += (grid[i][j] == 1 ? 1 : 0);
                oneCountInCol[j] += (grid[i][j] == 1 ? 1 : 0);
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = oneCountInRow[i] + oneCountInCol[j] - (cols - oneCountInRow[i]) - (rows - oneCountInCol[j]);
            }
        }
        return result;
    }
}
