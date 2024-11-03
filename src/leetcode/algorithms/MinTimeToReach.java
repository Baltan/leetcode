package leetcode.algorithms;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Description: 3341. Find Minimum Time to Reach Last Room I
 *
 * @author Baltan
 * @date 2024/11/3 13:56
 * @see MinTimeToReach1
 */
public class MinTimeToReach {
    public static void main(String[] args) {
        System.out.println(minTimeToReach(new int[][]{{0, 4}, {4, 4}}));
        System.out.println(minTimeToReach(new int[][]{{0, 0, 0}, {0, 0, 0}}));
        System.out.println(minTimeToReach(new int[][]{{0, 1}, {1, 2}}));
    }

    public static int minTimeToReach(int[][] moveTime) {
        int rows = moveTime.length;
        int cols = moveTime[0].length;
        /**
         * minTimes[i][j]表示到达grid[i][j]的最早时间
         */
        int[][] minTimes = new int[rows][cols];
        /**
         * 可以向上下左右四个方向移动
         */
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        /**
         * 保存当前已到达的房间，并且按照到达房间的时间升序排列
         */
        Queue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(x -> x[2]));

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                minTimes[i][j] = Integer.MAX_VALUE;
            }
        }
        /**
         * 初始时，0时刻在房间grid[0][0]
         */
        queue.offer(new int[]{0, 0, 0});
        minTimes[0][0] = 0;

        while (!queue.isEmpty()) {
            int[] condition = queue.poll();
            int x = condition[0];
            int y = condition[1];
            int time = condition[2];
            /**
             * 已到达终点地牢右下角的房间
             */
            if (x == rows - 1 && y == cols - 1) {
                return time;
            }
            /**
             * 遍历从房间grid[x][y]前进一步后可以到达的其他房间
             */
            for (int[] direction : directions) {
                int nextX = x + direction[0];
                int nextY = y + direction[1];
                /**
                 * 从房间grid[x][y]到达房间grid[nextX][nextY]如果可以比之前到达房间grid[nextX][nextY]的时间更早，就更新达到房间
                 * grid[nextX][nextY]的最早到达时间
                 */
                if (nextX >= 0 && nextX < rows && nextY >= 0 && nextY < cols && Math.max(time, moveTime[nextX][nextY]) + 1 < minTimes[nextX][nextY]) {
                    minTimes[nextX][nextY] = Math.max(time, moveTime[nextX][nextY]) + 1;
                    queue.offer(new int[]{nextX, nextY, minTimes[nextX][nextY]});
                }
            }
        }
        return -1;
    }
}
