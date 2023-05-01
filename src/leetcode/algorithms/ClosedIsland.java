package leetcode.algorithms;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Description: 1254. Number of Closed Islands
 *
 * @author Baltan
 * @date 2019-11-12 09:11
 */
public class ClosedIsland {
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
         * 下一步可以走的方向
         */
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        /**
         * 标记陆地是否被访问过
         */
        boolean[][] isVisited = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 0 && !isVisited[i][j]) {
                    /**
                     * 保存当前岛屿的每一块陆地坐标
                     */
                    Queue<int[]> landQueue = new LinkedList<>();
                    landQueue.offer(new int[]{i, j});
                    /**
                     * 当前岛屿最上面的位置
                     */
                    int upmost = rows - 1;
                    /**
                     * 当前岛屿最下面的位置
                     */
                    int downmost = 0;
                    /**
                     * 当前岛屿最左面的位置
                     */
                    int leftmost = cols - 1;
                    /**
                     * 当前岛屿最右面的位置
                     */
                    int rightmost = 0;

                    while (!landQueue.isEmpty()) {
                        int[] coordinate = landQueue.poll();
                        int row = coordinate[0];
                        int col = coordinate[1];
                        /**
                         * 将当前陆地标记为已访问过
                         */
                        isVisited[row][col] = true;
                        /**
                         * 更新当前岛屿最上面、最下面、最左面、最右面的位置
                         */
                        upmost = Math.min(upmost, row);
                        downmost = Math.max(downmost, row);
                        leftmost = Math.min(leftmost, col);
                        rightmost = Math.max(rightmost, col);
                        /**
                         * 查找当前陆地的上下左右是否还有相邻未访问的陆地，如果有的话加入队列landQueue
                         */
                        for (int k = 0; k < directions.length; k++) {
                            int[] direction = directions[k];
                            int adjacentRow = row + direction[0];
                            int adjacentCol = col + direction[1];

                            if (adjacentRow >= 0 && adjacentRow < rows && adjacentCol >= 0 &&
                                    adjacentCol < cols && grid[adjacentRow][adjacentCol] == 0 &&
                                    !isVisited[adjacentRow][adjacentCol]) {
                                landQueue.offer(new int[]{adjacentRow, adjacentCol});
                            }
                        }
                    }
                    /**
                     * 如果当前岛屿最上面、最下面、最左面、最右面的位置都不在grid的边界上，则岛屿一定完全被水域包围
                     */
                    if (upmost > 0 && downmost < rows - 1 && leftmost > 0 && rightmost < cols - 1) {
                        result++;
                    }
                }
            }
        }
        return result;
    }
}
