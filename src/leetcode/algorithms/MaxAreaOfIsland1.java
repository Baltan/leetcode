package leetcode.algorithms;

/**
 * Description: 695. Max Area of Island
 *
 * @author Baltan
 * @date 2018/8/7 15:11
 */
public class MaxAreaOfIsland1 {
    /**
     * 记录当前岛屿的面积
     */
    public static int area;

    public static void main(String[] args) {
        int[][] grid1 = {{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0,},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}};
        System.out.println(maxAreaOfIsland(grid1));

        int[][] grid2 = {{0, 0, 0, 0, 0, 0, 0, 0}};
        System.out.println(maxAreaOfIsland(grid2));

        int[][] grid3 = {{1}};
        System.out.println(maxAreaOfIsland(grid3));
    }

    public static int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int result = 0;
        int rows = grid.length;
        int cols = grid[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    area = 0;
                    dfs(grid, i, j);
                    /**
                     * 更新最大岛屿的面积
                     */
                    result = Math.max(result, area);
                }
            }
        }
        return result;
    }

    /**
     * 深度优先搜索
     *
     * @param grid
     * @param x
     * @param y
     */
    public static void dfs(int[][] grid, int x, int y) {
        int rows = grid.length;
        int cols = grid[0].length;

        if (x < 0 || x >= rows || y < 0 || y >= cols || grid[x][y] == 0) {
            return;
        }
        area++;
        /**
         * 将当前位置土地改为水域，避免重复计算面积
         */
        grid[x][y] = 0;
        /**
         * 向上下左右四个方向扩张岛屿面积
         */
        dfs(grid, x + 1, y);
        dfs(grid, x - 1, y);
        dfs(grid, x, y + 1);
        dfs(grid, x, y - 1);
    }
}
