package leetcode.algorithms;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Description: 1162. As Far from Land as Possible
 *
 * @author Baltan
 * @date 2019-08-19 09:53
 */
public class MaxDistance {
    public static void main(String[] args) {
        int[][] grid1 = {{1, 0, 1}, {0, 0, 0}, {1, 0, 1}};
        System.out.println(maxDistance(grid1));

        int[][] grid2 = {{1, 0, 0}, {0, 0, 0}, {0, 0, 0}};
        System.out.println(maxDistance(grid2));
    }

    public static int maxDistance(int[][] grid) {
        /**
         * 保存最远水陆距离（0和最近的1的最远距离）
         */
        int result = -1;
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int distance = 0;
                /**
                 * 对于每一个0，查找距离它最近的1的距离
                 */
                if (grid[i][j] == 0) {
                    Queue<int[]> queue = new LinkedList<>();
                    /**
                     * 标记某个坐标是否已经被访问过，避免重复访问
                     */
                    boolean[][] isVisited = new boolean[rows][cols];
                    isVisited[i][j] = true;
                    /**
                     * 将距离当前坐标距离为1的坐标加入queue中
                     */
                    for (int k = 0; k < 4; k++) {
                        int[] move = directions[k];
                        int nextX = i + move[0];
                        int nextY = j + move[1];

                        if (nextX >= 0 && nextX < rows && nextY >= 0 && nextY < cols) {
                            queue.offer(new int[]{nextX, nextY});
                            isVisited[nextX][nextY] = true;
                        }
                    }

                    loop:
                    while (!queue.isEmpty()) {
                        int size = queue.size();
                        distance++;
                        /**
                         * 依次判断距离开始坐标距离为distance的坐标，如果坐标值为1，已经找到最近的1，如果当前距离
                         * distance大于result，可以将distance赋值给result，并且退出循环，不用再继续查找（后续坐
                         * 标值为1的坐标距离开始坐标的距离不小于distance）；如果坐标值为0，从该坐标开始向四周查找
                         * 距离为(distance+1)的坐标加入queue中继续下一轮判断
                         */
                        for (int k = 0; k < size; k++) {
                            int[] coordinate = queue.poll();
                            int x = coordinate[0];
                            int y = coordinate[1];

                            if (grid[x][y] == 1) {
                                result = Math.max(distance, result);
                                break loop;
                            } else {
                                for (int l = 0; l < 4; l++) {
                                    int[] move = directions[l];
                                    int nextX = x + move[0];
                                    int nextY = y + move[1];

                                    if (nextX >= 0 && nextX < rows && nextY >= 0 && nextY < cols &&
                                            !isVisited[nextX][nextY]) {
                                        queue.offer(new int[]{nextX, nextY});
                                        isVisited[nextX][nextY] = true;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return result;
    }
}
