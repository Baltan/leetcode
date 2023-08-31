package leetcode.algorithms;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Description: 1970. Last Day Where You Can Still Cross
 *
 * @author Baltan
 * @date 2023/8/30 22:42
 */
public class LatestDayToCross {
    public static void main(String[] args) {
        System.out.println(latestDayToCross(2, 2, new int[][]{{1, 1}, {2, 1}, {1, 2}, {2, 2}}));
        System.out.println(latestDayToCross(2, 2, new int[][]{{1, 1}, {1, 2}, {2, 1}, {2, 2}}));
        System.out.println(latestDayToCross(3, 3, new int[][]{{1, 2}, {2, 1}, {3, 3}, {2, 2}, {1, 1}, {1, 3}, {2, 3}, {3, 2}, {3, 1}}));
    }

    /**
     * 参考：<a href="https://leetcode.cn/problems/last-day-where-you-can-still-cross/solutions/936684/ni-neng-chuan-guo-ju-zhen-de-zui-hou-yi-9j20y/"></a>
     *
     * @param row
     * @param col
     * @param cells
     * @return
     */
    public static int latestDayToCross(int row, int col, int[][] cells) {
        /**
         * 每一个格子可能有上下左右四个相邻的格子
         */
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int lo = 0;
        int hi = row * col;
        /**
         * 二分查找计算第mid天时，能否从最上面一行走到最下面一行
         */
        outer:
        while (lo < hi) {
            int mid = (lo + hi + 1) / 2;
            Queue<int[]> queue = new LinkedList<>();
            /**
             * isVisited[i][j]表示cells[i][j]已被到达过
             */
            boolean[][] isVisited = new boolean[row][col];
            /**
             * 将[1,mid]天的水域网格标记为已被到达过，则后续计算中，这部分网格不会再被访问
             */
            for (int i = 0; i < mid; i++) {
                int waterX = cells[i][0] - 1;
                int waterY = cells[i][1] - 1;
                isVisited[waterX][waterY] = true;
            }
            /**
             * 将最上面一行可以被访问的网格加入队列
             */
            for (int i = 0; i < col; i++) {
                /**
                 * 如果isVisited[0][i]为true，表示cells[0][i]在[1,mid]天中会成为水域，不能从这个网格出发
                 */
                if (!isVisited[0][i]) {
                    queue.offer(new int[]{0, i});
                    isVisited[0][i] = true;
                }
            }

            while (!queue.isEmpty()) {
                int[] coordinate = queue.poll();
                int x = coordinate[0];
                int y = coordinate[1];
                /**
                 * 已到达最下面一行，说明可以在第mid天从最上面一行走到最下面一行，继续二分查找
                 */
                if (x == row - 1) {
                    lo = mid;
                    continue outer;
                }
                /**
                 * 从cells[x][y]判断能否向四个方向到达下一个陆地网格
                 */
                for (int[] direction : directions) {
                    int nextX = x + direction[0];
                    int nextY = y + direction[1];

                    if (nextX >= 0 && nextX < row && nextY >= 0 && nextY < col && !isVisited[nextX][nextY]) {
                        queue.offer(new int[]{nextX, nextY});
                        isVisited[nextX][nextY] = true;
                    }
                }
            }
            /**
             * 未能到达最下面一行，说明不能在第mid天从最上面一行走到最下面一行，继续二分查找
             */
            hi = mid - 1;
        }
        return lo;
    }
}
