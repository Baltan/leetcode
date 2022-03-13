package leetcode.algorithms;

import java.awt.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Description: 1905. Count Sub Islands
 *
 * @author Baltan
 * @date 2022/3/13 12:43
 */
public class CountSubIslands {
    public static void main(String[] args) {
        int[][] grid11 =
                {{1, 1, 1, 0, 0}, {0, 1, 1, 1, 1}, {0, 0, 0, 0, 0}, {1, 0, 0, 0, 0}, {1, 1, 0, 1, 1}};
        int[][] grid21 =
                {{1, 1, 1, 0, 0}, {0, 0, 1, 1, 1}, {0, 1, 0, 0, 0}, {1, 0, 1, 1, 0}, {0, 1, 0, 1, 0}};
        System.out.println(countSubIslands(grid11, grid21));

        int[][] grid12 =
                {{1, 0, 1, 0, 1}, {1, 1, 1, 1, 1}, {0, 0, 0, 0, 0}, {1, 1, 1, 1, 1}, {1, 0, 1, 0, 1}};
        int[][] grid22 =
                {{0, 0, 0, 0, 0}, {1, 1, 1, 1, 1}, {0, 1, 0, 1, 0}, {0, 1, 0, 1, 0}, {1, 0, 0, 0, 1}};
        System.out.println(countSubIslands(grid12, grid22));
    }

    public static int countSubIslands(int[][] grid1, int[][] grid2) {
        int result = 0;
        int rows = grid1.length;
        int cols = grid1[0].length;
        /**
         * isVisited[i][j]标记grid2中坐标为(i,j)的格点是否被访问过
         */
        boolean[][] isVisited = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            inner:
            for (int j = 0; j < cols; j++) {
                /**
                 * 记录grid2中当前这座岛屿包含的所有个点坐标
                 */
                List<Point> grids = new LinkedList<>();
                dfs(grid2, isVisited, grids, rows, cols, i, j);
                /**
                 * 不存在岛屿，不用往下继续判断
                 */
                if (grids.isEmpty()) {
                    continue inner;
                }
                /**
                 * 判断grid2中当前这座岛屿的每个格点是否在grid1中也是岛屿的格点，即是否是grid1中的子岛屿
                 */
                for (Point grid : grids) {
                    if (grid1[grid.x][grid.y] == 0) {
                        continue inner;
                    }
                }
                result++;
            }
        }
        return result;
    }

    /**
     * 递归查找grid2中某座岛屿的所有格点坐标
     *
     * @param grid2
     * @param isVisited
     * @param grids
     * @param rows
     * @param cols
     * @param i
     * @param j
     */
    public static void dfs(int[][] grid2, boolean[][] isVisited, List<Point> grids, int rows, int cols, int i,
                           int j) {
        if (i < 0 || i >= rows || j < 0 || j >= cols || grid2[i][j] == 0 || isVisited[i][j]) {
            return;
        }
        isVisited[i][j] = true;
        grids.add(new Point(i, j));
        dfs(grid2, isVisited, grids, rows, cols, i - 1, j);
        dfs(grid2, isVisited, grids, rows, cols, i + 1, j);
        dfs(grid2, isVisited, grids, rows, cols, i, j - 1);
        dfs(grid2, isVisited, grids, rows, cols, i, j + 1);
    }
}
