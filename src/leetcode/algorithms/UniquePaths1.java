package leetcode.algorithms;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Description: 3665. Twisted Mirror Path Count
 *
 * @author Baltan
 * @date 2025/9/30 22:41
 */
public class UniquePaths1 {
    public static void main(String[] args) {
        System.out.println(uniquePaths(new int[][]{{0, 1, 0}, {0, 0, 1}, {1, 0, 0}}));
        System.out.println(uniquePaths(new int[][]{{0, 0}, {0, 0}}));
        System.out.println(uniquePaths(new int[][]{{0, 1, 1}, {1, 1, 0}}));
    }

    public static int uniquePaths(int[][] grid) {
        int mod = 1000000007;
        int rows = grid.length;
        int cols = grid[0].length;
        /**
         * 优先按照横坐标递增，再按照纵坐标递增的顺序保存所有可被到达的网格坐标
         */
        Queue<int[]> pq = new PriorityQueue<>((x, y) -> x[0] == y[0] ? x[1] - y[1] : x[0] - y[0]);
        /**
         * dp[i][j]表示到达网格grid[i][j]的路径数量
         */
        long[][] dp = new long[rows][cols];
        /**
         * 可以向下或者向右移动
         */
        int[][] directions = {{0, 1}, {1, 0}};
        /**
         * isEnqueued[i][j]表示网格grid[i][j]是否已在队列pq中
         */
        boolean[][] isEnqueued = new boolean[rows][cols];
        /**
         * 初始时位于网格(0,0)
         */
        dp[0][0] = 1;
        pq.offer(new int[]{0, 0});

        while (!pq.isEmpty()) {
            int[] coordinate = pq.poll();
            isEnqueued[coordinate[0]][coordinate[1]] = false;

            for (int[] direction : directions) {
                /**
                 * 当前所在网格坐标为(currRow,currCol)
                 */
                int currRow = coordinate[0];
                int currCol = coordinate[1];
                /**
                 * 向direction表示的方向前进后到达网格(nextRow,nextCol)
                 */
                int nextRow = currRow + direction[0];
                int nextCol = currCol + direction[1];
                /**
                 * 如果接下去到达的网格(nextRow,nextCol)中是镜子，则需要从之前的网格(currRow,currCol)向斜下方移动进入新的网格，直到到
                 * 达空格子或者边界外
                 */
                while (nextRow >= 0 && nextRow < rows && nextCol >= 0 && nextCol < cols && grid[nextRow][nextCol] == 1) {
                    /**
                     * 从之前的网格(currRow,currCol)向斜下方移动进入新的网格(nextRow,nextCol)，当前表示镜子的网格(nextRow,nextCol)
                     * 成为“前一网格”(currRow,currCol)
                     */
                    int tempRow = nextRow;
                    int tempCol = nextCol;
                    nextRow = currRow + 1;
                    nextCol = currCol + 1;
                    currRow = tempRow;
                    currCol = tempCol;
                }

                if (nextRow >= 0 && nextRow < rows && nextCol >= 0 && nextCol < cols) {
                    /**
                     * 从网格(coordinate[0],coordinate[1])到达(nextRow,nextCol)的路径数量为dp[coordinate[0]][coordinate[1]]
                     */
                    dp[nextRow][nextCol] = (dp[nextRow][nextCol] + dp[coordinate[0]][coordinate[1]]) % mod;
                    /**
                     * 避免网格(nextRow,nextCol)重复入队
                     */
                    if (!isEnqueued[nextRow][nextCol]) {
                        pq.offer(new int[]{nextRow, nextCol});
                        isEnqueued[nextRow][nextCol] = true;
                    }
                }
            }
        }
        return (int) dp[rows - 1][cols - 1];
    }
}
