package leetcode.algorithms;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Description: 934. Shortest Bridge
 *
 * @author Baltan
 * @date 2020-02-27 11:54
 */
public class ShortestBridge {
    public static void main(String[] args) {
        int[][] A1 = {{0, 1}, {1, 0}};
        System.out.println(shortestBridge(A1));

        int[][] A2 = {{0, 1, 0}, {0, 0, 0}, {0, 0, 1}};
        System.out.println(shortestBridge(A2));

        int[][] A3 = {{1, 1, 1, 1, 1}, {1, 0, 0, 0, 1}, {1, 0, 1, 0, 1}, {1, 0, 0, 0, 1}, {1, 1, 1, 1, 1}};
        System.out.println(shortestBridge(A3));
    }

    public static int shortestBridge(int[][] A) {
        int result = 0;
        int rows = A.length;
        int cols = A[0].length;
        /**
         * 保存其中一座岛屿所有格子的坐标
         */
        Queue<int[]> queue = new LinkedList<>();
        /**
         * 岛屿可以向上下左右四个方向扩张
         */
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        outer:
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                /**
                 * 找到其中一座岛屿，将岛屿上格子的值都变为2，并将该岛屿格子的坐标都加入队列
                 * queue中
                 */
                if (A[i][j] == 1) {
                    dfs(A, i, j, queue);
                    break outer;
                }
            }
        }
        /**
         * 将上面找到的岛屿逐层向外扩张，直到扩张到另一个岛屿为止
         */
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] coordinate = queue.poll();
                int x = coordinate[0];
                int y = coordinate[1];
                /**
                 * 从当前格子向上下左右四个方向延伸，看是否能够扩张岛屿
                 */
                for (int[] direction : directions) {
                    int nextX = x + direction[0];
                    int nextY = y + direction[1];

                    if (nextX >= 0 && nextX < rows && nextY >= 0 && nextY < cols) {
                        /**
                         * 如果这个相邻的格子值为0，说明是水域，可以扩张岛屿，将格子的坐标加入
                         * 队列queue；如果这个相邻的格子值为1，说明已经和另一座岛屿相连了，直
                         * 接返回已经完成扩张的层数
                         */
                        if (A[nextX][nextY] == 0) {
                            queue.offer(new int[]{nextX, nextY});
                            A[nextX][nextY] = 2;
                        } else if (A[nextX][nextY] == 1) {
                            return result;
                        }
                    }
                }
            }
            result++;
        }
        return -1;
    }

    /**
     * 将岛屿上格子的值都变为2，并将该岛屿格子的坐标都加入队列queue中
     *
     * @param A
     * @param i
     * @param j
     * @param queue
     */
    public static void dfs(int[][] A, int i, int j, Queue<int[]> queue) {
        int rows = A.length;
        int cols = A[0].length;

        if (i < 0 || i == rows || j < 0 || j == cols || A[i][j] != 1) {
            return;
        }

        A[i][j] = 2;
        queue.offer(new int[]{i, j});
        dfs(A, i - 1, j, queue);
        dfs(A, i + 1, j, queue);
        dfs(A, i, j - 1, queue);
        dfs(A, i, j + 1, queue);
    }
}
