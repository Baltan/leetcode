package leetcode.algorithms;

/**
 * Description: 980. Unique Paths III
 *
 * @author Baltan
 * @date 2023/2/27 11:18
 */
public class UniquePathsIII {
    public static void main(String[] args) {
        System.out.println(uniquePathsIII(new int[][]{{1, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 2, -1}}));
        System.out.println(uniquePathsIII(new int[][]{{1, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 2}}));
        System.out.println(uniquePathsIII(new int[][]{{0, 1}, {2, 0}}));
    }

    private static int result;

    public static int uniquePathsIII(int[][] grid) {
        result = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        /**
         * isVisited[i][j]表示方格grid[i][j]已访问过
         */
        boolean[][] isVisited = new boolean[rows][cols];
        /**
         * 上下左右四个方向
         */
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        /**
         * 起始方格坐标
         */
        int[] start = {0, 0};
        /**
         * 结束方格坐标
         */
        int[] end = {0, 0};
        /**
         * 空方格数量
         */
        int emptyCount = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    start[0] = i;
                    start[1] = j;
                } else if (grid[i][j] == 2) {
                    end[0] = i;
                    end[1] = j;
                } else if (grid[i][j] == 0) {
                    emptyCount++;
                }
            }
        }
        dfs(grid, isVisited, directions, end, emptyCount, rows, cols, start[0], start[1]);
        return result;
    }

    public static void dfs(int[][] grid, boolean[][] isVisited, int[][] directions, int[] end, int emptyCount, int rows, int cols, int x, int y) {
        /**
         * 如果到达结束方格的时候已经经过了所有空方格，则此时得到一条有效路径
         */
        if (x == end[0] && y == end[1] && emptyCount == 0) {
            result++;
            return;
        }
        isVisited[x][y] = true;
        /**
         * 如果当前坐标[x,y]位于一个空方格，要将剩余的空方格数量减去1
         */
        emptyCount -= grid[x][y] == 0 ? 1 : 0;
        /**
         * 在四个方向上判断是否能继续前进
         */
        for (int[] direction : directions) {
            int nextX = x + direction[0];
            int nextY = y + direction[1];

            if (nextX >= 0 && nextX < rows && nextY >= 0 && nextY < cols && !isVisited[nextX][nextY] && grid[nextX][nextY] != -1) {
                dfs(grid, isVisited, directions, end, emptyCount, rows, cols, nextX, nextY);
            }
        }
        isVisited[x][y] = false;
    }
}
