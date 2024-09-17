package leetcode.algorithms;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Description: 3286. Find a Safe Walk Through a Grid
 *
 * @author Baltan
 * @date 2024/9/16 14:32
 */
public class FindSafeWalk {
    public static void main(String[] args) {
        List<List<Integer>> grid1 = Arrays.asList(
                Arrays.asList(0, 1, 0, 0, 0),
                Arrays.asList(0, 1, 0, 1, 0),
                Arrays.asList(0, 0, 0, 1, 0)
        );
        System.out.println(findSafeWalk(grid1, 1));

        List<List<Integer>> grid2 = Arrays.asList(
                Arrays.asList(0, 1, 1, 0, 0, 0),
                Arrays.asList(1, 0, 1, 0, 0, 0),
                Arrays.asList(0, 1, 1, 1, 0, 1),
                Arrays.asList(0, 0, 1, 0, 1, 0)
        );
        System.out.println(findSafeWalk(grid2, 3));

        List<List<Integer>> grid3 = Arrays.asList(
                Arrays.asList(1, 1, 1),
                Arrays.asList(1, 0, 1),
                Arrays.asList(1, 1, 1)
        );
        System.out.println(findSafeWalk(grid3, 5));

        List<List<Integer>> grid4 = Arrays.asList(
                Arrays.asList(1, 1, 1, 1)
        );
        System.out.println(findSafeWalk(grid4, 4));
    }

    public static boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int row = grid.size();
        int col = grid.getFirst().size();
        /**
         * 每一步可能向上下左右四个方向移动
         */
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        /**
         * healths[i][j]表示到达网格grid[i][j]时，剩余健康值的最大值，如果没有到达过网格则为-1
         */
        int[][] healths = new int[row][col];
        /**
         * 优先队列保存到达每个网格的坐标，按照到达网格后的剩余健康值降序排列
         */
        Queue<int[]> pq = new PriorityQueue<>((x, y) -> healths[y[0]][y[1]] - healths[x[0]][x[1]]);

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                healths[i][j] = -1;
            }
        }
        /**
         * 从网格[0,0]出发时的剩余健康值
         */
        healths[0][0] = health - grid.getFirst().getFirst();
        pq.offer(new int[]{0, 0});

        while (!pq.isEmpty()) {
            int[] position = pq.poll();
            int currX = position[0];
            int currY = position[1];
            /**
             * 剩余健康值非正数，不能继续移动
             */
            if (healths[currX][currY] <= 0) {
                continue;
            }

            for (int[] direction : directions) {
                int nextX = currX + direction[0];
                int nextY = currY + direction[1];

                if (nextX >= 0 && nextX < row && nextY >= 0 && nextY < col) {
                    /**
                     * 到达下一网格[nextX,nextY]后的剩余健康值
                     */
                    int nextHealth = healths[currX][currY] - grid.get(nextX).get(nextY);
                    /**
                     * 如果已经位于右下角网格且剩余健康值为正数，则成功到达最终的格子
                     */
                    if (nextX == row - 1 && nextY == col - 1 && nextHealth > 0) {
                        return true;
                    }
                    /**
                     * 只有下一网格[nextX,nextY]还未到达过，或者从当前网格到下一网格可以剩余更多的健康值时，才考虑继续前往下一网格
                     */
                    if (healths[nextX][nextY] == -1 || nextHealth > healths[nextX][nextY]) {
                        healths[nextX][nextY] = nextHealth;
                        pq.offer(new int[]{nextX, nextY});
                    }
                }
            }
        }
        return false;
    }
}
