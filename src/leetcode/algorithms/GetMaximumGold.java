package leetcode.algorithms;

/**
 * Description: 1219. Path with Maximum Gold
 *
 * @author Baltan
 * @date 2019-10-08 09:04
 */
public class GetMaximumGold {
    public static void main(String[] args) {
        int[][] grid1 = {{0, 6, 0}, {5, 8, 7}, {0, 9, 0}};
        System.out.println(getMaximumGold(grid1));

        int[][] grid2 = {{1, 0, 7}, {2, 0, 6}, {3, 4, 5}, {0, 3, 0}, {9, 0, 20}};
        System.out.println(getMaximumGold(grid2));
    }

    private static int result;
    private static int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static int getMaximumGold(int[][] grid) {
        result = 0;
        int rows = grid.length;
        int cols = grid[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 0) {
                    continue;
                }

                int gold = 0;
                boolean[][] isVisited = new boolean[rows][cols];
                dfs(grid, isVisited, gold, i, j);
            }
        }
        return result;
    }

    public static void dfs(int[][] grid, boolean[][] isVisited, int gold, int x, int y) {
        if (end(grid, isVisited, x, y)) {
            result = Math.max(result, gold);
            return;
        }

        gold += grid[x][y];
        isVisited[x][y] = true;

        for (int[] direction : directions) {
            int nextX = x + direction[0];
            int nextY = y + direction[1];
            dfs(grid, isVisited, gold, nextX, nextY);
        }

        isVisited[x][y] = false;
    }

    public static boolean end(int[][] grid, boolean[][] isVisited, int x, int y) {
        int rows = grid.length;
        int cols = grid[0].length;
        return x < 0 || x >= rows || y < 0 || y >= cols || isVisited[x][y] || grid[x][y] == 0;
    }
}
