package leetcode.algorithms;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Description: 2328. Number of Increasing Paths in a Grid
 *
 * @author baltan
 * @date 2023/9/14 19:07
 */
public class CountPaths1 {
    public static void main(String[] args) {
        System.out.println(countPaths(new int[][]{{1, 1}, {3, 4}}));
        System.out.println(countPaths(new int[][]{{1}, {2}}));
    }

    public static int countPaths(int[][] grid) {
        long result = 0L;
        int mod = 1000000007;
        int rows = grid.length;
        int cols = grid[0].length;
        /**
         * counts[i][j]表示以格子grid[i][j]为终点的递增路径的数量
         */
        long[][] counts = new long[rows][cols];
        /**
         * 保存所有格子的坐标(x,y)，并且这些坐标按照grid[x][y]升序排列
         */
        Queue<int[]> pq = new PriorityQueue<>(rows * cols, Comparator.comparingInt(x -> grid[x[0]][x[1]]));
        /**
         * 可以从上下左右四个方向的格子到达当前格子
         */
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        /**
         * 将所有格子的坐标加入优先队列pq
         */
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                pq.offer(new int[]{i, j});
            }
        }

        while (!pq.isEmpty()) {
            int[] coordinate = pq.poll();
            int x = coordinate[0];
            int y = coordinate[1];
            /**
             * 当前格子grid[i][j]自身作为一条长度为1的递增路径
             */
            counts[x][y]++;

            for (int[] direction : directions) {
                int prevX = x + direction[0];
                int prevY = y + direction[1];
                /**
                 * 判断能否从上下左右四个方向的格子到达当前格子grid[i][j]，只有前一个格子中的整数小于grid[i][j]中的整数，才可以得到新的
                 * 递增路径
                 */
                if (prevX >= 0 && prevX < rows && prevY >= 0 && prevY < cols) {
                    if (grid[prevX][prevY] < grid[x][y]) {
                        counts[x][y] = (counts[x][y] + counts[prevX][prevY]) % mod;
                    }
                }
            }
        }
        /**
         * 累加以每个格子作为终点的递增路径的数量
         */
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result = (result + counts[i][j]) % mod;
            }
        }
        return (int) result;
    }
}
