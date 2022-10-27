package leetcode.algorithms;

/**
 * Description: 1559. Detect Cycles in 2D Grid
 *
 * @author Baltan
 * @date 2022/10/25 11:31
 */
public class ContainsCycle {
    public static void main(String[] args) {
        char[][] grid1 =
                {{'a', 'a', 'a', 'a'}, {'a', 'b', 'b', 'a'}, {'a', 'b', 'b', 'a'}, {'a', 'a', 'a', 'a'}};
        System.out.println(containsCycle(grid1));

        char[][] grid2 =
                {{'c', 'c', 'c', 'a'}, {'c', 'd', 'c', 'c'}, {'c', 'c', 'e', 'c'}, {'f', 'c', 'c', 'c'}};
        System.out.println(containsCycle(grid2));

        char[][] grid3 = {{'a', 'b', 'b'}, {'b', 'z', 'b'}, {'b', 'b', 'a'}};
        System.out.println(containsCycle(grid3));

        char[][] grid4 = {{'a', 'a'}, {'a', 'a'}};
        System.out.println(containsCycle(grid4));
    }

    /**
     * 参考：
     * <a href="https://leetcode.cn/problems/detect-cycles-in-2d-grid/solutions/1798758/-by-fei-xiao-r-m9j9/"></a>
     *
     * @param grid
     * @return
     */
    public static boolean containsCycle(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        /**
         * 标记所有已经访问过的格子的坐标
         */
        boolean[][] isVisited = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                /**
                 * 假设初始时是从左边进入grid[i][j]这个格子的
                 */
                if (!isVisited[i][j] && dfs(grid, isVisited, rows, cols, grid[i][j], i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * @param grid
     * @param isVisited
     * @param rows
     * @param cols
     * @param value     当前查找的环上的字符
     * @param x
     * @param y
     * @param from      进入格子grid[x][y]的方向：0-左，1-上，2-右，3-下
     * @return
     */
    public static boolean dfs(char[][] grid, boolean[][] isVisited, int rows, int cols, char value, int x,
                              int y, int from) {
        /**
         * 超出二维网格图的范围，不能构成环
         */
        if (x < 0 || y < 0 || x >= rows || y >= cols) {
            return false;
        }
        /**
         * grid[x][y]和之前路径上的字符不同，不能构成环
         */
        if (grid[x][y] != value) {
            return false;
        }
        /**
         * 和之前已经访问过的网格构成了环
         */
        if (isVisited[x][y]) {
            return true;
        }
        isVisited[x][y] = true;
        /**
         * from：0-左，1-上，2-右，3-下
         *
         * 1、如果不是从右进入格子grid[x][y]的，下一步就可以向右走进入格子grid[x][y+1]，对于格子grid[x][y+1]来说即是从左边
         * 进入格子
         * 2、如果不是从下进入格子grid[x][y]的，下一步就可以向下走进入格子grid[x+1][y]，对于格子grid[x+1][y]来说即是从上边
         * 进入格子
         * 3、如果不是从左进入格子grid[x][y]的，下一步就可以向左走进入格子grid[x][y-1]，对于格子grid[x][y-1]来说即是从右边
         * 进入格子
         * 4、如果不是从上进入格子grid[x][y]的，下一步就可以向上走进入格子grid[x-1][y]，对于格子grid[x-1][y]来说即是从下边
         * 进入格子
         */
        return (from != 2 && dfs(grid, isVisited, rows, cols, value, x, y + 1, 0)) ||
                (from != 3 && dfs(grid, isVisited, rows, cols, value, x + 1, y, 1)) ||
                (from != 0 && dfs(grid, isVisited, rows, cols, value, x, y - 1, 2)) ||
                (from != 1 && dfs(grid, isVisited, rows, cols, value, x - 1, y, 3));
    }
}
