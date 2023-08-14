package leetcode.algorithms;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Description: 2812. Find the Safest Path in a Grid
 *
 * @author Baltan
 * @date 2023/8/13 13:17
 */
public class MaximumSafenessFactor {
    public static void main(String[] args) {
        System.out.println(maximumSafenessFactor(Arrays.asList(Arrays.asList(1, 0, 0), Arrays.asList(0, 0, 0), Arrays.asList(0, 0, 1))));
        System.out.println(maximumSafenessFactor(Arrays.asList(Arrays.asList(0, 0, 1), Arrays.asList(0, 0, 0), Arrays.asList(0, 0, 0))));
        System.out.println(maximumSafenessFactor(Arrays.asList(Arrays.asList(0, 0, 0, 1), Arrays.asList(0, 0, 0, 0), Arrays.asList(0, 0, 0, 0), Arrays.asList(1, 0, 0, 0))));
    }

    public static int maximumSafenessFactor(List<List<Integer>> grid) {
        int n = grid.size();
        /**
         * 起点和终点位置存在小偷，则所有路径的安全系数都为0，直接返回0
         */
        if (grid.get(0).get(0) == 1 || grid.get(n - 1).get(n - 1) == 1) {
            return 0;
        }
        /**
         * factorMatrix[i][j]表示grid[i][j]到矩阵中任一小偷所在单元格的最小曼哈顿距离
         */
        int[][] factorMatrix = new int[n][n];
        Queue<int[]> factorQueue = new LinkedList<>();
        /**
         * 每一步可以往当前单元格的上下左右四个方向移动
         */
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        /**
         * 初始化每个单元格矩阵中任一小偷所在单元格的最小曼哈顿距离，有小偷的单元格为0，无小偷的单元格为Integer.MAX_VALUE
         */
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid.get(i).get(j) == 1) {
                    factorMatrix[i][j] = 0;
                    factorQueue.offer(new int[]{i, j});
                } else {
                    factorMatrix[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        /**
         * 从每个有小偷的单元格向四个方向辐射，计算出每个单元格矩阵中任一小偷所在单元格的最小曼哈顿距离
         */
        while (!factorQueue.isEmpty()) {
            for (int i = 0; i < factorQueue.size(); i++) {
                int[] coordinate = factorQueue.poll();
                int currX = coordinate[0];
                int currY = coordinate[1];

                for (int[] direction : directions) {
                    int nextX = currX + direction[0];
                    int nextY = currY + direction[1];

                    if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < n && factorMatrix[currX][currY] + 1 < factorMatrix[nextX][nextY]) {
                        factorMatrix[nextX][nextY] = factorMatrix[currX][currY] + 1;
                        factorQueue.offer(new int[]{nextX, nextY});
                    }
                }
            }
        }
        /**
         * 因为从grid[0][0]出发，所有路径的安全系数最大可能为factorMatrix[0][0]
         */
        for (int safeness = factorMatrix[0][0]; safeness >= 0; safeness--) {
            Queue<int[]> queue = new LinkedList<>();
            /**
             * isVisited[i][j]表示grid[i][j]是否可能出现在安全系数为safeness的路径上
             */
            boolean[][] isVisited = new boolean[n][n];
            queue.offer(new int[]{0, 0});
            isVisited[0][0] = true;

            while (!queue.isEmpty()) {
                int[] coordinate = queue.poll();
                int currX = coordinate[0];
                int currY = coordinate[1];

                for (int[] direction : directions) {
                    int nextX = currX + direction[0];
                    int nextY = currY + direction[1];
                    /**
                     * 将与grid[currX][currY]相邻的任一小偷所在单元格的最小曼哈顿距离不小于safeness的单元格加入队列中
                     */
                    if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < n && factorMatrix[nextX][nextY] >= safeness && !isVisited[nextX][nextY]) {
                        /**
                         * 已找到一条从grid[0][0]到grid[n-1][n-1]的路径，当前路径的安全系数即为所有路径中的最大安全系数
                         */
                        if (nextX == n - 1 && nextY == n - 1) {
                            return safeness;
                        }
                        queue.offer(new int[]{nextX, nextY});
                        isVisited[nextX][nextY] = true;
                    }
                }
            }
        }
        return 0;
    }
}
