package leetcode.algorithms;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Description: 3619. Count Islands With Total Value Divisible by K
 *
 * @author Baltan
 * @date 2025/8/17 18:02
 */
public class CountIslands {
    public static void main(String[] args) {
        System.out.println(countIslands(new int[][]{{0, 2, 1, 0, 0}, {0, 5, 0, 0, 5}, {0, 0, 1, 0, 0}, {0, 1, 4, 7, 0}, {0, 2, 0, 0, 8}}, 5));
        System.out.println(countIslands(new int[][]{{3, 0, 3, 0}, {0, 3, 0, 3}, {3, 0, 3, 0}}, 3));
    }

    public static int countIslands(int[][] grid, int k) {
        int result = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        /**
         * isVisited[i][j]表示陆地grid[i][j]是否已被计算过面积
         */
        boolean[][] isVisited = new boolean[rows][cols];
        /**
         * 可以向上下左右四个方向移动
         */
        int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                /**
                 * 如果当前位置不是陆地，或者是已被计算过面积的陆地，直接跳过
                 */
                if (isVisited[i][j] || grid[i][j] == 0) {
                    continue;
                }
                Queue<int[]> queue = new LinkedList<>();
                /**
                 * 当前岛屿的面积
                 */
                long sum = 0L;
                queue.offer(new int[]{i, j});
                isVisited[i][j] = true;
                /**
                 * 广度优先搜索计算当前岛屿的面积
                 */
                while (!queue.isEmpty()) {
                    int[] coordinate = queue.poll();
                    sum += grid[coordinate[0]][coordinate[1]];

                    for (int[] direction : directions) {
                        int nextX = coordinate[0] + direction[0];
                        int nextY = coordinate[1] + direction[1];
                        /**
                         * 如果坐标(nextX,nextY)已超出矩阵范围，或者不是陆地，或者是已被计算过面积的陆地，直接跳过
                         */
                        if (nextX < 0 || nextX >= rows || nextY < 0 || nextY >= cols || isVisited[nextX][nextY] || grid[nextX][nextY] == 0) {
                            continue;
                        }
                        queue.offer(new int[]{nextX, nextY});
                        isVisited[nextX][nextY] = true;
                    }
                }

                if (sum % k == 0) {
                    result++;
                }
            }
        }
        return result;
    }
}
