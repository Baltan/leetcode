package leetcode.algorithms;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Description: 1559. Detect Cycles in 2D Grid
 *
 * @author Baltan
 * @date 2022/10/25 11:31
 */
public class ContainsCycle {
    public static void main(String[] args) {
        char[][] grid1 =
                {{'a', 'a', 'a', 'a'}, {'a', 'b', 'b', 'a'}, {'a', 'b', 'b', 'a'}, {'a', 'a', 'a', 'a'}};
        System.out.println(containsCycle(grid1));

        char[][] grid2 =
                {{'c', 'c', 'c', 'a'}, {'c', 'd', 'c', 'c'}, {'c', 'c', 'e', 'c'}, {'f', 'c', 'c', 'c'}};
        System.out.println(containsCycle(grid2));

        char[][] grid3 = {{'a', 'b', 'b'}, {'b', 'z', 'b'}, {'b', 'b', 'a'}};
        System.out.println(containsCycle(grid3));

        char[][] grid4 = {{'a', 'a'}, {'a', 'a'}};
        System.out.println(containsCycle(grid4));
    }

    public static boolean containsCycle(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        /**
         * 每一个格子可能有上下左右四个相邻的格子
         */
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                /**
                 * 路径的起点格子的坐标为(startX,startY)
                 */
                int startX = i;
                int startY = j;
                char value = grid[startX][startY];
                /**
                 * 保存路径上所有格子的坐标
                 */
                Queue<int[]> queue = new LinkedList<>();
                /**
                 * 标记所有已经访问过的格子的坐标
                 */
                boolean[][] isVisited = new boolean[rows][cols];
                queue.offer(new int[]{startX, startY});
                isVisited[startX][startY] = true;

                while (!queue.isEmpty()) {
                    int size = queue.size();
                    /**
                     * 保存与起点格子的坐标(startX,startY)相同距离的所有格子的坐标
                     */
                    boolean[][] willVisit = new boolean[rows][cols];

                    for (int k = 0; k < size; k++) {
                        int[] coordinate = queue.poll();

                        for (int[] direction : directions) {
                            int nextX = coordinate[0] + direction[0];
                            int nextY = coordinate[1] + direction[1];
                            boolean inRange = nextX >= 0 && nextX < rows && nextY >= 0 && nextY < cols;
                            /**
                             * 如果从队列queue中的两个格子都能到达坐标为(nextX,nextY)的格子，说明已经找到了一个还，且环的
                             * 长度一定是大于等于4的
                             */
                            if (inRange && willVisit[nextX][nextY]) {
                                return true;
                            }

                            if (inRange && !isVisited[nextX][nextY] && grid[nextX][nextY] == value) {
                                queue.offer(new int[]{nextX, nextY});
                                isVisited[nextX][nextY] = true;
                                willVisit[nextX][nextY] = true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
}
