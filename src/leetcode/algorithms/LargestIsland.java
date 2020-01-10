package leetcode.algorithms;

/**
 * Description: 827. Making A Large Island
 *
 * @author Baltan
 * @date 2020-01-09 12:13
 */
public class LargestIsland {
    public static void main(String[] args) {
        int[][] grid1 = {{1, 0}, {0, 1}};
        System.out.println(largestIsland(grid1));

        int[][] grid2 = {{1, 1}, {0, 1}};
        System.out.println(largestIsland(grid2));

        int[][] grid3 = {{1, 1}, {1, 1}};
        System.out.println(largestIsland(grid3));
    }

    /**
     * 当前岛屿的面积
     */
    public static int area;

    public static int largestIsland(int[][] grid) {
        int result = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        /**
         * 对于每一个格子，如果当前格子是海洋，假设把这个格子变成陆地后，计算包含当前格子的岛屿的面积，
         * 获得所有新产生的岛屿的最大面积
         */
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 0) {
                    grid[i][j] = 1;
                    /**
                     * isVisited[i][j]标记格子grid[i][j]是否已经被计算过面积
                     */
                    boolean[][] isVisited = new boolean[rows][cols];
                    area = 0;
                    dfs(grid, isVisited, i, j);
                    result = Math.max(result, area);
                    /**
                     * 计算完成后，需要将当前假设变成陆地的格子还原成海洋
                     */
                    grid[i][j] = 0;
                }
            }
        }
        /**
         * 如果result仍旧是初始化的值0，说明地图上没有海洋，只有陆地
         */
        return result == 0 ? rows * cols : result;
    }

    /**
     * 计算包含grid[i][j]格子的岛屿的面积
     *
     * @param grid
     * @param isVisited
     * @param i
     * @param j
     */
    public static void dfs(int[][] grid, boolean[][] isVisited, int i, int j) {
        int rows = grid.length;
        int cols = grid[0].length;

        if (i < 0 || i >= rows || j < 0 || j >= cols || isVisited[i][j] || grid[i][j] == 0) {
            return;
        }

        area++;
        isVisited[i][j] = true;
        dfs(grid, isVisited, i + 1, j);
        dfs(grid, isVisited, i - 1, j);
        dfs(grid, isVisited, i, j + 1);
        dfs(grid, isVisited, i, j - 1);
    }
}
