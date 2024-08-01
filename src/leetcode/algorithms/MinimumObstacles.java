package leetcode.algorithms;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Description: 2290. Minimum Obstacle Removal to Reach Corner
 *
 * @author baltan
 * @date 2024/7/31 10:25
 */
public class MinimumObstacles {
    public static void main(String[] args) {
        System.out.println(minimumObstacles(new int[][]{{0, 0, 0}, {0, 0, 0}, {0, 0, 0}}));
        System.out.println(minimumObstacles(new int[][]{{0, 1, 1}, {1, 1, 0}, {1, 1, 0}}));
        System.out.println(minimumObstacles(new int[][]{{0, 1, 0, 0, 0}, {0, 1, 0, 1, 0}, {0, 0, 0, 1, 0}}));
    }

    public static int minimumObstacles(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        /**
         * dp[i][j]表示到达单元格dp[i][j]需要移除障碍物的最小数量
         */
        int[][] dp = new int[rows][cols];
        /**
         * 上下左右四个移动方向
         */
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        /**
         * 保存已经到达过的所有单元格坐标，按照到达每个单元格需要移除障碍物的最小数量升序排列
         */
        Queue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(x -> dp[x[0]][x[1]]));
        pq.offer(new int[]{0, 0});
        /**
         * 初始化假设除了起点[0,0]到达其他单元格需要移除障碍物的数量都为100000，因为根据题意，至多有100000个单元格
         */
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                dp[i][j] = 100000;
            }
        }
        dp[0][0] = 0;

        while (!pq.isEmpty()) {
            /**
             * 当前所在单元格
             */
            int[] curr = pq.poll();
            int currX = curr[0];
            int currY = curr[1];
            /**
             * 依次判断从[currX,currY]出发向上下左右四个方向可以到达的下一个单元格
             */
            for (int[] direction : directions) {
                int nextX = currX + direction[0];
                int nextY = currY + direction[1];

                if (nextX >= 0 && nextX < rows && nextY >= 0 && nextY < cols) {
                    /**
                     * 从[currX,currY]到达[nextX,nextY]不需要移除障碍物，并且可以减少到达[nextX,nextY]需要移除障碍物的数量
                     */
                    if (grid[nextX][nextY] == 0 && dp[currX][currY] < dp[nextX][nextY]) {
                        dp[nextX][nextY] = dp[currX][currY];
                        pq.offer(new int[]{nextX, nextY});
                        /**
                         * 从[currX,currY]到达[nextX,nextY]需要移除一个障碍物，并且可以减少到达[nextX,nextY]需要移除障碍物的数量
                         */
                    } else if (grid[nextX][nextY] == 1 && dp[currX][currY] + 1 < dp[nextX][nextY]) {
                        dp[nextX][nextY] = dp[currX][currY] + 1;
                        pq.offer(new int[]{nextX, nextY});
                    }
                }
            }
        }
        return dp[rows - 1][cols - 1];
    }
}
