package leetcode.algorithms;

/**
 * Description: 200. Number of Islands
 *
 * @author Baltan
 * @date 2020-04-20 08:08
 * @see NumIslands
 */
public class NumIslands1 {
    private static int result;

    public static void main(String[] args) {
        char[][] grid1 =
                {{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0'
                        , '0', '0', '0', '0'}};
        System.out.println(numIslands(grid1));

        char[][] grid2 =
                {{'1', '1', '0', '0', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '1', '0', '0'}, {'0'
                        , '0', '0', '1', '1'}};
        System.out.println(numIslands(grid2));
    }

    public static int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        result = 0;
        int rows = grid.length;
        int cols = grid[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    result++;
                    dfs(grid, rows, cols, i, j);
                }
            }
        }
        return result;
    }

    public static void dfs(char[][] grid, int rows, int cols, int x, int y) {
        if (x < 0 || x == rows || y < 0 || y == cols || grid[x][y] == '0') {
            return;
        }

        grid[x][y] = '0';
        dfs(grid, rows, cols, x - 1, y);
        dfs(grid, rows, cols, x + 1, y);
        dfs(grid, rows, cols, x, y - 1);
        dfs(grid, rows, cols, x, y + 1);
    }
}
