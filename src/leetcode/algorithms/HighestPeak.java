package leetcode.algorithms;

import leetcode.util.OutputUtils;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Description: 1765. Map of Highest Peak
 *
 * @author Baltan
 * @date 2022/7/17 14:00
 * @see HighestPeak1
 */
public class HighestPeak {
    public static void main(String[] args) {
        int[][] isWater1 = {{0, 1}, {0, 0}};
        OutputUtils.print2DIntegerArray(highestPeak(isWater1));

        System.out.println("------------------------------------------");

        int[][] isWater2 = {{0, 0, 1}, {1, 0, 0}, {0, 0, 0}};
        OutputUtils.print2DIntegerArray(highestPeak(isWater2));
    }

    public static int[][] highestPeak(int[][] isWater) {
        int rows = isWater.length;
        int cols = isWater[0].length;
        int[][] result = new int[rows][cols];
        /**
         * isVisited[i][j]表示格子isWater[i][j]是否已被安排过高度
         */
        boolean[][] isVisited = new boolean[rows][cols];
        Queue<int[]> queue = new LinkedList<>();
        /**
         * 每一个格子可能有上下左右四个相邻的格子
         */
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        /**
         * 查找所有水域格子
         */
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (isWater[i][j] == 1) {
                    queue.offer(new int[]{i, j});
                    isVisited[i][j] = true;
                    /**
                     * 所有水域格子的高度必须为0
                     */
                    result[i][j] = 0;
                }
            }
        }
        /**
         * 从每一个已安排过高度的格子逐层向外扩张，直到所有的格子都被安排高度
         */
        while (!queue.isEmpty()) {
            int[] coordinate = queue.poll();

            for (int[] direction : directions) {
                int x = coordinate[0] + direction[0];
                int y = coordinate[1] + direction[1];

                if (x >= 0 && x < rows && y >= 0 && y < cols && !isVisited[x][y]) {
                    queue.offer(new int[]{x, y});
                    isVisited[x][y] = true;
                    /**
                     * isWater[x][y]的高度应当比isWater坐标为coordinate的格子高度多1
                     */
                    result[x][y] = result[coordinate[0]][coordinate[1]] + 1;
                }
            }
        }
        return result;
    }
}
