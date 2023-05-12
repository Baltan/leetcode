package leetcode.algorithms;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Description: 778. Swim in Rising Water
 *
 * @author Baltan
 * @date 2023/4/17 09:32
 */
public class SwimInWater {
    public static void main(String[] args) {
        System.out.println(swimInWater(new int[][]{{0, 2}, {1, 3}}));
        System.out.println(swimInWater(new int[][]{{0, 1, 2, 3, 4}, {24, 23, 22, 21, 5}, {12, 13, 14, 15, 16}, {11, 17, 18, 19, 20}, {10, 9, 8, 7, 6}}));
    }

    public static int swimInWater(int[][] grid) {
        int result = Integer.MIN_VALUE;
        int rows = grid.length;
        int cols = grid[0].length;
        /**
         * 队列中的格子按照高度升序排列
         */
        Queue<Grid> pq = new PriorityQueue<>(Comparator.comparingInt(x -> x.height));
        /**
         * isVisited[i][j]表示格子grid[i][j]已访问过
         */
        boolean[][] isVisited = new boolean[rows][cols];
        /**
         * 每一步可能向上下左右四个方向移动
         */
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        /**
         * 从左上角的格子grid[0][0]出发
         */
        pq.offer(new Grid(0, 0, grid[0][0]));
        isVisited[0][0] = true;

        while (!pq.isEmpty()) {
            Grid currGrid = pq.poll();
            result = Math.max(result, currGrid.height);
            /**
             * 已到达右下角的格子grid[rows-1][cols-1]，结束移动
             */
            if (currGrid.x == rows - 1 && currGrid.y == cols - 1) {
                break;
            }
            /**
             * 计算下一步可能到达的格子
             */
            for (int[] direction : directions) {
                int nextX = currGrid.x + direction[0];
                int nextY = currGrid.y + direction[1];

                if (nextX >= 0 && nextX < rows && nextY >= 0 && nextY < cols && !isVisited[nextX][nextY]) {
                    pq.offer(new Grid(nextX, nextY, grid[nextX][nextY]));
                    isVisited[nextX][nextY] = true;
                }
            }
        }
        return result;
    }

    public static class Grid {
        /**
         * 格子的横坐标
         */
        private int x;
        /**
         * 格子的纵坐标
         */
        private int y;
        /**
         * 格子的高度
         */
        private int height;

        public Grid(int x, int y, int height) {
            this.x = x;
            this.y = y;
            this.height = height;
        }
    }
}
