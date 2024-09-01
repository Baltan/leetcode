package leetcode.algorithms;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Description: 864. Shortest Path to Get All Keys
 *
 * @author Baltan
 * @date 2024/9/1 16:19
 */
public class ShortestPathAllKeys {
    public static void main(String[] args) {
        System.out.println(shortestPathAllKeys(new String[]{"@...a", ".###A", "b.BCc"}));
        System.out.println(shortestPathAllKeys(new String[]{"@.a..", "###.#", "b.A.B"}));
        System.out.println(shortestPathAllKeys(new String[]{"@..aA", "..B#.", "....b"}));
        System.out.println(shortestPathAllKeys(new String[]{"@Aa"}));
    }

    public static int shortestPathAllKeys(String[] grid) {
        int rows = grid.length;
        int cols = grid[0].length();
        /**
         * 起点的横坐标
         */
        int startRow = 0;
        /**
         * 起点的纵坐标
         */
        int startCol = 0;
        /**
         * 钥匙的数量
         */
        int keys = 0;
        /**
         * 上下左右四个移动方向
         */
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        /**
         * 计算钥匙的总数，查找起点位置
         */
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (Character.isLowerCase(grid[i].charAt(j))) {
                    keys++;
                } else if (grid[i].charAt(j) == '@') {
                    startRow = i;
                    startCol = j;
                }
            }
        }
        /**
         * 假设得到钥匙a，则allKeyStatus的二进制值的最低位为1；得到钥匙b，则allKeyStatus的二进制值的第二低位为1，以此类推。得到所有钥匙
         * 后的状态为0b11……11（共keys个1）
         */
        int allKeyStatus = (1 << keys) - 1;
        /**
         * 保存所有可能的状态，优先按照从起点出发到达当前状态的步数升序排列，部署相等时，按照已获得的钥匙的数量降序排列
         */
        Queue<Status> pq = new PriorityQueue<>((x, y) -> x.step == y.step ? Integer.bitCount(y.keyStatus) - Integer.bitCount(x.keyStatus) : x.step - y.step);
        /**
         * isVisited[i][j][k]表示当前位于单元格(i,j)，并且已获得钥匙的情况为k，这种情况是否已出现过
         */
        boolean[][][] isVisited = new boolean[rows][cols][1 << keys];
        /**
         * 将起点入队
         */
        pq.offer(new Status(startRow, startCol, 0, 0));
        isVisited[startRow][startCol][0] = true;

        while (!pq.isEmpty()) {
            Status status = pq.poll();
            /**
             * 当前状态已获得所有钥匙，因为优先队列中的各种状态是按照从起点出发到达当前状态的步数升序排列的，所以所用步数一定是最少的
             */
            if (status.keyStatus == allKeyStatus) {
                return status.step;
            }

            for (int[] direction : directions) {
                int nextRow = status.row + direction[0];
                int nextCol = status.col + direction[1];

                if (nextRow < 0 || nextRow == rows || nextCol < 0 || nextCol == cols || grid[nextRow].charAt(nextCol) == '#') {
                    continue;
                }

                if (Character.isUpperCase(grid[nextRow].charAt(nextCol))) {
                    /**
                     * 如果单元格(nextRow,nextCol)中是锁，则只有获得对应的钥匙才能进入
                     */
                    if ((status.keyStatus >> (grid[nextRow].charAt(nextCol) - 'A') & 1) == 1 && !isVisited[nextRow][nextCol][status.keyStatus]) {
                        isVisited[nextRow][nextCol][status.keyStatus] = true;
                        pq.offer(new Status(nextRow, nextCol, status.keyStatus, status.step + 1));
                    }
                } else if (Character.isLowerCase(grid[nextRow].charAt(nextCol))) {
                    /**
                     * 得到单元格(nextRow,nextCol)中的钥匙后，已有钥匙的情况
                     */
                    int nextKeyStatus = status.keyStatus | (1 << (grid[nextRow].charAt(nextCol) - 'a'));

                    if (!isVisited[nextRow][nextCol][nextKeyStatus]) {
                        isVisited[nextRow][nextCol][nextKeyStatus] = true;
                        pq.offer(new Status(nextRow, nextCol, nextKeyStatus, status.step + 1));
                    }
                } else {
                    if (!isVisited[nextRow][nextCol][status.keyStatus]) {
                        isVisited[nextRow][nextCol][status.keyStatus] = true;
                        pq.offer(new Status(nextRow, nextCol, status.keyStatus, status.step + 1));
                    }
                }
            }
        }
        return -1;
    }

    /**
     * 当前的状态
     */
    public static class Status {
        /**
         * 当前所在位置的横坐标
         */
        private int row;
        /**
         * 当前所在位置的纵坐标
         */
        private int col;
        /**
         * 当前已获得的钥匙的情况
         */
        private int keyStatus;
        /**
         * 从起点出发到达当前状态的步数
         */
        private int step;

        public Status(int row, int col, int keyStatus, int step) {
            this.row = row;
            this.col = col;
            this.keyStatus = keyStatus;
            this.step = step;
        }
    }
}
