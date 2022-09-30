package leetcode.algorithms;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Description: 1631. Path With Minimum Effort
 *
 * @author Baltan
 * @date 2022/9/25 12:32
 */
public class MinimumEffortPath {
    public static void main(String[] args) {
        int[][] heights1 = {{1, 2, 2}, {3, 8, 2}, {5, 3, 5}};
        System.out.println(minimumEffortPath(heights1));

        int[][] heights2 = {{1, 2, 3}, {3, 8, 4}, {5, 3, 5}};
        System.out.println(minimumEffortPath(heights2));

        int[][] heights3 =
                {{1, 2, 1, 1, 1}, {1, 2, 1, 2, 1}, {1, 2, 1, 2, 1}, {1, 2, 1, 2, 1}, {1, 1, 1, 2, 1}};
        System.out.println(minimumEffortPath(heights3));
    }

    public static int minimumEffortPath(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;
        /**
         * 相邻两个格子高度差绝对值的最大值
         */
        int maxDiff = 0;
        /**
         * 每次移动可以向上、下、左、右四个方向
         */
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        /**
         * 计算相邻两个格子高度差绝对值的最大值，体力消耗值最大不会超过maxDiff
         */
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (j > 0) {
                    maxDiff = Math.max(maxDiff, Math.abs(heights[i][j] - heights[i][j - 1]));
                }

                if (i > 0) {
                    maxDiff = Math.max(maxDiff, Math.abs(heights[i][j] - heights[i - 1][j]));
                }
            }
        }
        int lo = 0;
        int hi = maxDiff;
        /**
         * 二分查找最小体力消耗值
         */
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            Queue<int[]> queue = new LinkedList<>();
            /**
             * 标记已访问过的格子
             */
            boolean[][] isVisited = new boolean[rows][cols];
            queue.offer(new int[]{0, 0});
            isVisited[0][0] = true;
            /**
             * 是否到达右下角的格子
             */
            boolean reach = false;
            /**
             * 广度优先搜索是否存在体力消耗值不超过mid的路径
             */
            while (!queue.isEmpty()) {
                int[] coordinate = queue.poll();
                int row = coordinate[0];
                int col = coordinate[1];
                /**
                 * 到达了右下角的格子，退出路径查找
                 */
                if (row == rows - 1 && col == cols - 1) {
                    reach = true;
                    break;
                }

                for (int[] direction : directions) {
                    int nextRow = row + direction[0];
                    int nextCol = col + direction[1];

                    if (nextRow >= 0 && nextRow < rows && nextCol >= 0 && nextCol < cols &&
                            !isVisited[nextRow][nextCol] &&
                            Math.abs(heights[nextRow][nextCol] - heights[row][col]) <= mid) {
                        queue.offer(new int[]{nextRow, nextCol});
                        isVisited[nextRow][nextCol] = true;
                    }
                }
            }

            if (reach) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }
}
