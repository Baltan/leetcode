package leetcode.algorithms;

import leetcode.util.OutputUtils;

/**
 * Description: 3446. Sort Matrix by Diagonals
 *
 * @author baltan
 * @date 2025/2/10 10:17
 */
public class SortMatrix {
    public static void main(String[] args) {
        OutputUtils.print2DIntegerArray(sortMatrix(new int[][]{{1, 7, 3}, {9, 8, 2}, {4, 5, 6}}));
        System.out.println("---------------------------------");
        OutputUtils.print2DIntegerArray(sortMatrix(new int[][]{{0, 1}, {1, 2}}));
        System.out.println("---------------------------------");
        OutputUtils.print2DIntegerArray(sortMatrix(new int[][]{{1}}));
    }

    public static int[][] sortMatrix(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        /**
         * 矩阵主对角线左下方中的格子（包含主对角线上的格子）
         */
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j <= i; j++) {
                /**
                 * 选择排序，选择grid[r][c]、grid[r+1][c+1]、grid[r+2][c+2]中的最大值，和grid[i][j]交换位置
                 */
                int r = i;
                int c = j;
                int maxRow = i;
                int maxCol = j;

                while (r < rows && c < cols) {
                    if (grid[r][c] > grid[maxRow][maxCol]) {
                        maxRow = r;
                        maxCol = c;
                    }
                    r++;
                    c++;
                }
                int temp = grid[i][j];
                grid[i][j] = grid[maxRow][maxCol];
                grid[maxRow][maxCol] = temp;
            }
        }
        /**
         * 矩阵主对角线右上方中的格子（不包含主对角线上的格子）
         */
        for (int i = 0; i < rows; i++) {
            for (int j = i + 1; j < cols; j++) {
                /**
                 * 选择排序，选择grid[r][c]、grid[r+1][c+1]、grid[r+2][c+2]中的最小值，和grid[i][j]交换位置
                 */
                int r = i;
                int c = j;
                int minRow = i;
                int minCol = j;

                while (r < rows && c < cols) {
                    if (grid[r][c] < grid[minRow][minCol]) {
                        minRow = r;
                        minCol = c;
                    }
                    r++;
                    c++;
                }
                int temp = grid[i][j];
                grid[i][j] = grid[minRow][minCol];
                grid[minRow][minCol] = temp;
            }
        }
        return grid;
    }
}
