package leetcode.algorithms;

import leetcode.util.OutputUtils;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Description: 1034. Coloring A Border
 *
 * @author Baltan
 * @date 2019-08-17 09:51
 */
public class ColorBorder {
    public static void main(String[] args) {
        int[][] grid1 = {{1, 1}, {1, 2}};
        OutputUtils.print2DIntegerArray(colorBorder(grid1, 0, 0, 3));

        System.out.println("----------------------------------------------------------");

        int[][] grid2 = {{1, 2, 2}, {2, 3, 2}};
        OutputUtils.print2DIntegerArray(colorBorder(grid2, 0, 1, 3));

        System.out.println("----------------------------------------------------------");

        int[][] grid3 = {{1, 1, 1}, {1, 1, 1}, {1, 1, 1}};
        OutputUtils.print2DIntegerArray(colorBorder(grid3, 1, 1, 2));

        System.out.println("----------------------------------------------------------");

        int[][] grid4 = {{1}};
        OutputUtils.print2DIntegerArray(colorBorder(grid4, 0, 0, 2));
    }

    public static int[][] colorBorder(int[][] grid, int r0, int c0, int color) {
        int rows = grid.length;
        int cols = grid[0].length;
        /**
         * 记录当前格子的操作结果，还未访问到状态为-1，访问过是边界需要着色状态为1，访问过不是边界不用着色状态为0
         */
        int[][] book = new int[rows][cols];
        Queue<int[]> queue = new LinkedList<>();
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int initColor = grid[r0][c0];
        /**
         * 将所有格子的状态标记为-1
         */
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                book[i][j] = -1;
            }
        }

        queue.offer(new int[]{r0, c0});
        /**
         * 从开始的格子开始依次向四周查找连通分量
         */
        while (!queue.isEmpty()) {
            int[] coordinate = queue.poll();
            int r = coordinate[0];
            int c = coordinate[1];
            /**
             * 如果当前查找到的格子是连通分量的边界，将该格子的状态标记为1，否则标记为0，从而避免后续重复查找
             */
            if (isBorder(grid, r, c)) {
                book[r][c] = 1;
            } else {
                book[r][c] = 0;
            }
            /**
             * 查找当前格子四个方向上是否有格子，如果有的话是不是在连通分量中，如果在连通分量中就加入queue
             */
            for (int i = 0; i < 4; i++) {
                int nextR = r + directions[i][0];
                int nextC = c + directions[i][1];

                if (nextR >= 0 && nextR < rows && nextC >= 0 && nextC < cols && book[nextR][nextC] == -1 &&
                        grid[nextR][nextC] == initColor) {
                    queue.offer(new int[]{nextR, nextC});
                }
            }
        }
        /**
         * 将状态为1的所有格子进行着色
         */
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (book[i][j] == 1) {
                    grid[i][j] = color;
                }
            }
        }
        return grid;
    }

    /**
     * 判断grid[r][c]处的格子是不是连通分量边界上的格子
     *
     * @param grid
     * @param r
     * @param c
     * @return
     */
    public static boolean isBorder(int[][] grid, int r, int c) {
        int rows = grid.length;
        int cols = grid[0].length;
        int color = grid[r][c];
        /**
         * 如果grid[r][c]处的格子是在grid四条边界上的，则grid[r][c]是连通分量边界上的格子
         */
        if (r == 0 || r == rows - 1 || c == 0 || c == cols - 1) {
            return true;
        }
        /**
         * 如果grid[r][c]处的格子上下左右的格子都和其同色，则该格子不是连通分量边界上的格子，否则就是连通分量边界上的格子
         */
        return !(grid[r - 1][c] == color && grid[r + 1][c] == color && grid[r][c - 1] == color &&
                grid[r][c + 1] == color);
    }
}
