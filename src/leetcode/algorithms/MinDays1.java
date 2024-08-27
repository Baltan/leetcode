package leetcode.algorithms;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Description: 1568. Minimum Number of Days to Disconnect Island
 *
 * @author baltan
 * @date 2024/8/25 14:36
 */
public class MinDays1 {
    public static void main(String[] args) {
        System.out.println(minDays(new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}}));
        System.out.println(minDays(new int[][]{{1, 0, 1, 0}}));
        System.out.println(minDays(new int[][]{{0, 1, 1, 0}, {0, 1, 1, 0}, {0, 0, 0, 0}}));
        System.out.println(minDays(new int[][]{{1, 1}}));
    }

    /**
     * 参考：<a href="https://leetcode.cn/problems/minimum-number-of-days-to-disconnect-island/solutions/441162/shi-lu-di-fen-chi-de-zui-shao-tian-shu-by-leetcode/"></a>
     *
     * @param grid
     * @return
     */
    public static int minDays(int[][] grid) {
        if (isDisconnected(grid)) {
            /**
             * 所有岛屿本身就是分离的，不需要将某个陆地单元格修改为水单元格
             */
            return 0;
        } else {
            int rows = grid.length;
            int cols = grid[0].length;

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (grid[i][j] == 1) {
                        grid[i][j] = 0;
                        /**
                         * 将陆地grid[i][j]修改为水单元格后，所有岛屿成为分离的，所以只需要修改1个陆地单元格
                         */
                        if (isDisconnected(grid)) {
                            return 1;
                        }
                        grid[i][j] = 1;
                    }
                }
            }
        }
        /**
         * 将岛屿某个角上的陆地单元格相邻的两个陆地单元格修改为水单元格后，一定可以使这个角上的陆地单元格单独分离为一座岛屿，所以至多需要修改
         * 2个陆地单元格
         */
        return 2;
    }

    /**
     * 判断图中的所有岛屿是否是分离的
     *
     * @param grid
     * @return
     */
    public static boolean isDisconnected(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        /**
         * 所有岛屿的总面积
         */
        int totalArea = 0;
        /**
         * 当前岛屿的面积
         */
        int currentArea = 0;
        Queue<int[]> queue = new LinkedList<>();
        /**
         * isVisited[i][j]表示陆地grid[i][j]是否已被计算过面积
         */
        boolean[][] isVisited = new boolean[rows][cols];
        int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                totalArea += grid[i][j];
            }
        }
        /**
         * 如果不存在岛屿，则也认为图中岛屿是分离的
         */
        if (totalArea == 0) {
            return true;
        }
        outer:
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    queue.offer(new int[]{i, j});
                    isVisited[i][j] = true;
                    currentArea++;
                    /**
                     * 广度优先搜索计算陆地grid[i][j]所在的岛屿的总面积
                     */
                    while (!queue.isEmpty()) {
                        int[] coordinates = queue.poll();

                        for (int[] direction : directions) {
                            int nextX = coordinates[0] + direction[0];
                            int nextY = coordinates[1] + direction[1];

                            if (nextX >= 0 && nextX < rows && nextY >= 0 && nextY < cols && !isVisited[nextX][nextY] && grid[nextX][nextY] == 1) {
                                queue.offer(new int[]{nextX, nextY});
                                isVisited[nextX][nextY] = true;
                                currentArea++;
                            }
                        }
                    }
                    break outer;
                }
            }
        }
        return currentArea < totalArea;
    }
}
