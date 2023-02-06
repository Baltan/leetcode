package leetcode.algorithms;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Description: 2556. Disconnect Path in a Binary Matrix by at Most One Flip
 *
 * @author Baltan
 * @date 2023/2/5 13:54
 */
public class IsPossibleToCutPath {
    public static void main(String[] args) {
        System.out.println(isPossibleToCutPath(new int[][]{{1, 1, 1}, {0, 0, 0}, {1, 1, 1}}));
        System.out.println(isPossibleToCutPath(new int[][]{{1, 1, 1}, {1, 0, 0}, {1, 1, 1}}));
        System.out.println(isPossibleToCutPath(new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}}));
    }

    /**
     * 参考：<a href="https://leetcode.cn/problems/disconnect-path-in-a-binary-matrix-by-at-most-one-flip/solutions/2093555/liang-ci-bfsxian-pan-ding-jie-dian-shi-f-5222/"></a>
     *
     * @param grid
     * @return
     */
    public static boolean isPossibleToCutPath(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[] end = {rows - 1, cols - 1};
        /**
         * isConnected[i][j]表示从坐标(i,j)出发能否到达终点坐标end
         */
        boolean[][] isConnected = new boolean[rows][cols];
        /**
         * isVisited[i][j]表示在搜索过程中坐标(i,j)已到达过
         */
        boolean[][] isVisited = new boolean[rows][cols];
        /**
         * 从终点坐标向起点坐标搜索的过程中可以移动的方向
         */
        int[][] backDirections = {{-1, 0}, {0, -1}};
        /**
         * 从起点坐标向终点坐标搜索的过程中可以移动的方向
         */
        int[][] forwardDirections = {{1, 0}, {0, 1}};
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{rows - 1, cols - 1});
        isConnected[rows - 1][cols - 1] = true;
        isVisited[rows - 1][cols - 1] = true;
        /**
         * 从终点坐标向起点坐标搜索，判断从每个坐标出发能否到达终点坐标end
         */
        while (!queue.isEmpty()) {
            int[] coordinate = queue.poll();

            for (int[] direction : backDirections) {
                int prevX = coordinate[0] + direction[0];
                int prevY = coordinate[1] + direction[1];

                if (prevX >= 0 && prevY >= 0 && !isVisited[prevX][prevY] && grid[prevX][prevY] == 1) {
                    queue.offer(new int[]{prevX, prevY});
                    isConnected[prevX][prevY] = true;
                    isVisited[prevX][prevY] = true;
                }
            }
        }
        isVisited = new boolean[rows][cols];
        queue.offer(new int[]{0, 0});
        /**
         * 从起点坐标向终点坐标搜索
         */
        while (!queue.isEmpty()) {
            int size = queue.size();
            /**
             * 查找从当前队列中的坐标出发下一步可以到达的所有坐标，查找到的这些坐标和起点坐标的曼哈顿距离都是一样的
             */
            for (int i = 0; i < size; i++) {
                int[] coordinate = queue.poll();

                for (int[] direction : forwardDirections) {
                    int nextX = coordinate[0] + direction[0];
                    int nextY = coordinate[1] + direction[1];

                    if (nextX < rows && nextY < cols && !isVisited[nextX][nextY] && isConnected[nextX][nextY]) {
                        queue.offer(new int[]{nextX, nextY});
                        isVisited[nextX][nextY] = true;
                    }
                }
            }
            /**
             * 当和起点坐标曼哈顿距离相等且能到达终点坐标end的坐标有且不足两个时，通过翻转这个唯一的坐标或者不作任何操作就能使得矩阵不连通
             */
            if (queue.size() <= 1 && !Arrays.equals(queue.poll(), end)) {
                return true;
            }
        }
        return false;
    }
}
