package leetcode.algorithms;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Description: 994. Rotting Oranges
 *
 * @author Baltan
 * @date 2019-03-15 15:49
 */
public class OrangesRotting {
    public static void main(String[] args) {
        int[][] grid1 = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        System.out.println(orangesRotting(grid1));

        int[][] grid2 = {{2, 1, 1}, {0, 1, 1}, {1, 0, 1}};
        System.out.println(orangesRotting(grid2));

        int[][] grid3 = {{0, 2}};
        System.out.println(orangesRotting(grid3));
    }

    public static int orangesRotting(int[][] grid) {
        int result = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        /**
         * 新鲜橘子的数量
         */
        int freshCount = 0;
        /**
         * 保存腐烂橘子的坐标
         */
        Queue<int[]> queue = new LinkedList<>();
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    freshCount++;
                }
            }
        }
        /**
         * 每一次循环将队列中的所有腐烂橘子相邻的橘子全部变成腐烂的，并加入队列
         */
        while (!queue.isEmpty()) {
            int size = queue.size();
            /**
             * 这轮循环是否导致新鲜的橘子腐烂
             */
            boolean becomeRotten = false;

            for (int i = 0; i < size; i++) {
                int[] coordinate = queue.poll();

                for (int[] direction : directions) {
                    int x = coordinate[0] + direction[0];
                    int y = coordinate[1] + direction[1];

                    if (x >= 0 && x < rows && y >= 0 && y < cols && grid[x][y] == 1) {
                        grid[x][y] = 2;
                        freshCount--;
                        queue.offer(new int[]{x, y});
                        becomeRotten = true;
                    }
                }
            }
            /**
             * 如果这轮循环导致了新鲜橘子的腐烂，才将分钟数加1
             */
            if (becomeRotten == true) {
                result++;
            }
        }
        /**
         * 如果最后还剩新鲜的橘子，说明这些橘子不能被腐烂，返回-1
         */
        return freshCount == 0 ? result : -1;
    }
}
