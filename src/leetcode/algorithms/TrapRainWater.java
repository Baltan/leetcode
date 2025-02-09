package leetcode.algorithms;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Description: 407. Trapping Rain Water II
 *
 * @author Baltan
 * @date 2025/2/4 19:08
 * @see Trap
 * @see leetcode.interview.Trap
 */
public class TrapRainWater {
    public static void main(String[] args) {
        System.out.println(trapRainWater(new int[][]{{12, 13, 1, 12}, {13, 4, 13, 12}, {13, 8, 10, 12}, {12, 13, 12, 12}, {13, 13, 13, 13}}));
        System.out.println(trapRainWater(new int[][]{{1, 4, 3, 1, 3, 2}, {3, 2, 1, 3, 2, 4}, {2, 3, 3, 2, 3, 1}}));
        System.out.println(trapRainWater(new int[][]{{3, 3, 3, 3, 3}, {3, 2, 2, 2, 3}, {3, 2, 1, 2, 3}, {3, 2, 2, 2, 3}, {3, 3, 3, 3, 3}}));
    }

    /**
     * 参考：<a href="https://leetcode.cn/problems/trapping-rain-water-ii/solutions/1079738/jie-yu-shui-ii-by-leetcode-solution-vlj3/"></a>
     *
     * @param heightMap
     * @return
     */
    public static int trapRainWater(int[][] heightMap) {
        int result = 0;
        int rows = heightMap.length;
        int cols = heightMap[0].length;
        /**
         * 上下左右四个相邻的格子
         */
        int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        /**
         * isVisited[i][j]表示是否已计算过格子(x,y)的最大接水量
         */
        boolean[][] isVisited = new boolean[rows][cols];
        /**
         * 保存最外围一圈格子的坐标，并且按照格子的接水后的最大高度升序排列
         */
        Queue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(x -> heightMap[x[0]][x[1]]));
        /**
         * 初始时，最外围一圈格子即矩阵的上下左右四条边上的格子，并且这些格子都无法接水
         */
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (i == 0 || i == rows - 1 || j == 0 || j == cols - 1) {
                    pq.offer(new int[]{i, j});
                    isVisited[i][j] = true;
                }
            }
        }
        /**
         * 对于最外围一圈中高度最低的格子，其相邻格子接水后的最大高度一定不超过前者的最大高度，否则雨水会从前面这个格子流走。逐个计算与最外围
         * 一圈中高度最低的格子相邻的格子的接水后的最大高度即可确定相邻格子的接水量
         */
        while (!pq.isEmpty()) {
            int[] coordination = pq.poll();

            for (int[] direction : directions) {
                int nextX = coordination[0] + direction[0];
                int nextY = coordination[1] + direction[1];

                if (nextX >= 0 && nextX < rows && nextY >= 0 && nextY < cols && !isVisited[nextX][nextY]) {
                    pq.offer(new int[]{nextX, nextY});
                    isVisited[nextX][nextY] = true;
                    /**
                     * 格子(nextX,nextY)接水后的最大高度
                     */
                    int height = Math.max(heightMap[nextX][nextY], heightMap[coordination[0]][coordination[1]]);
                    /**
                     * 格子(nextX,nextY)的最大接水量
                     */
                    result += height - heightMap[nextX][nextY];
                    /**
                     * 格子(nextX,nextY)成为新的最外围一圈中的一个格子，其高度为height
                     */
                    heightMap[nextX][nextY] = height;
                }
            }
        }
        return result;
    }
}
