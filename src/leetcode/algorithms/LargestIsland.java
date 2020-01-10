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

    public static int area;

    public static int largestIsland(int[][] grid) {
        int result = 0;
        int rows = grid.length;
        int cols = grid[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 0) {
                    grid[i][j] = 1;
                    boolean[][] isVisited = new boolean[rows][cols];
                    area = 0;
                    dfs(grid, isVisited, i, j);
                    result = Math.max(result, area);
                    grid[i][j] = 0;
                }
            }
        }
        return result == 0 ? rows * cols : result;
    }

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
