package leetcode.algorithms;

/**
 * Description: 1254. Number of Closed Islands
 *
 * @author Baltan
 * @date 2019-11-12 09:11
 */
public class ClosedIsland1 {
    public static void main(String[] args) {
        int[][] grid1 = {{1, 1, 1, 1, 1, 1, 1, 0}, {1, 0, 0, 0, 0, 1, 1, 0}, {1, 0, 1, 0, 1, 1, 1, 0},
                {1, 0, 0, 0, 0, 1, 0, 1}, {1, 1, 1, 1, 1, 1, 1, 0}};
        System.out.println(closedIsland(grid1));

        int[][] grid2 = {{0, 0, 1, 0, 0}, {0, 1, 0, 1, 0}, {0, 1, 1, 1, 0}};
        System.out.println(closedIsland(grid2));

        int[][] grid3 =
                {{1, 1, 1, 1, 1, 1, 1}, {1, 0, 0, 0, 0, 0, 1}, {1, 0, 1, 1, 1, 0, 1}, {1, 0, 1, 0, 1, 0, 1},
                        {1, 0, 1, 1, 1, 0, 1}, {1, 0, 0, 0, 0, 0, 1}, {1, 1, 1, 1, 1, 1, 1}};
        System.out.println(closedIsland(grid3));
    }

    public static int closedIsland(int[][] grid) {
        int result = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        /**
         * 将与grid左边界和右边界相连的岛屿都改为水域
         */
        for (int i = 0; i < rows; i++) {
            dfs(grid, i, 0);
            dfs(grid, i, cols - 1);
        }
        /**
         * 将与grid上边界和下边界相连的岛屿都改为水域
         */
        for (int i = 0; i < cols; i++) {
            dfs(grid, 0, i);
            dfs(grid, rows - 1, i);
        }
        /**
         * 查找不与grid边界相连的岛屿，查找到后将该岛屿都改为水域
         */
        for (int i = 1; i < rows - 1; i++) {
            for (int j = 1; j < cols - 1; j++) {
                if (grid[i][j] == 0) {
                    result++;
                    dfs(grid, i, j);
                }
            }
        }
        return result;
    }

    /**
     * 将一个岛屿的陆地都改为水域
     *
     * @param grid
     * @param row
     * @param col
     */
    public static void dfs(int[][] grid, int row, int col) {
        int rows = grid.length;
        int cols = grid[0].length;

        if (row < 0 || row >= rows || col < 0 || col >= cols || grid[row][col] == 1) {
            return;
        }

        grid[row][col] = 1;
        dfs(grid, row - 1, col);
        dfs(grid, row + 1, col);
        dfs(grid, row, col - 1);
        dfs(grid, row, col + 1);
    }
}
