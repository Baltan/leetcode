package leetcode.algorithms;

/**
 * Description: 2658. Maximum Number of Fish in a Grid
 *
 * @author Baltan
 * @date 2023/4/30 16:24
 */
public class FindMaxFish {
    public static void main(String[] args) {
        System.out.println(findMaxFish(new int[][]{{10, 5}, {8, 0}}));
        System.out.println(findMaxFish(new int[][]{{0, 10}, {3, 0}}));
        System.out.println(findMaxFish(new int[][]{{0, 2, 1, 0}, {4, 0, 0, 3}, {1, 0, 0, 4}, {0, 3, 2, 0}}));
        System.out.println(findMaxFish(new int[][]{{1, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 1}}));
    }

    private static int result;
    /**
     * 某一个水域中鱼的数量
     */
    private static int count;

    public static int findMaxFish(int[][] grid) {
        result = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        /**
         * isVisited[i][j]表示格子grid[i][j]已访问过
         */
        boolean[][] isVisited = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                /**
                 * 初始化grid[i][j]所在水域中鱼的数量
                 */
                count = 0;
                /**
                 * 计算每一片水域中鱼的数量
                 */
                dfs(grid, rows, cols, i, j, isVisited);
            }
        }
        return result;
    }

    /**
     * 深度优先搜索计算每个连通分量上单元格中数字之和
     *
     * @param grid
     * @param rows
     * @param cols
     * @param row
     * @param col
     * @param isVisited
     */
    public static void dfs(int[][] grid, int rows, int cols, int row, int col, boolean[][] isVisited) {
        if (row < 0 || row == rows || col < 0 || col == cols || grid[row][col] == 0 || isVisited[row][col]) {
            result = Math.max(result, count);
            return;
        }
        count += grid[row][col];
        isVisited[row][col] = true;
        dfs(grid, rows, cols, row - 1, col, isVisited);
        dfs(grid, rows, cols, row + 1, col, isVisited);
        dfs(grid, rows, cols, row, col - 1, isVisited);
        dfs(grid, rows, cols, row, col + 1, isVisited);
    }
}
