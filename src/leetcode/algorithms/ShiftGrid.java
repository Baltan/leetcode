package leetcode.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description: 1260. Shift 2D Grid
 *
 * @author Baltan
 * @date 2019-11-19 09:19
 */
public class ShiftGrid {
    public static void main(String[] args) {
        int[][] grid1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(shiftGrid(grid1, 1));

        int[][] grid2 = {{3, 8, 1, 9}, {19, 7, 2, 5}, {4, 6, 11, 10}, {12, 0, 21, 13}};
        System.out.println(shiftGrid(grid2, 4));

        int[][] grid3 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(shiftGrid(grid3, 9));
    }

    public static List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int rows = grid.length;
        int cols = grid[0].length;
        Integer[][] newGrid = new Integer[rows][cols];
        List<List<Integer>> result = new ArrayList<>(rows);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                /**
                 * 元素移动k次后，跨越的行数
                 */
                int rowspan = (j + k) / cols;
                /**
                 * 元素移动k次后，跨越的列数
                 */
                int colspan = k % cols;
                /**
                 * 元素移动k次后所在的行数
                 */
                int nextRow = (i + rowspan) % rows;
                /**
                 * 元素移动k次后所在的列数
                 */
                int nextCol = (j + colspan) % cols;
                newGrid[nextRow][nextCol] = grid[i][j];
            }
        }

        for (int i = 0; i < rows; i++) {
            result.add(Arrays.asList(newGrid[i]));
        }
        return result;
    }
}
