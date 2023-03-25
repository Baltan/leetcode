package leetcode.algorithms;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Description: 1368. Minimum Cost to Make at Least One Valid Path in a Grid
 *
 * @author Baltan
 * @date 2023/3/21 11:28
 */
public class MinCost2 {
    public static void main(String[] args) {
        System.out.println(minCost(new int[][]{{1, 1, 1, 1}, {2, 2, 2, 2}, {1, 1, 1, 1}, {2, 2, 2, 2}}));
        System.out.println(minCost(new int[][]{{1, 1, 3}, {3, 2, 2}, {1, 1, 4}}));
        System.out.println(minCost(new int[][]{{1, 2}, {4, 3}}));
        System.out.println(minCost(new int[][]{{2, 2, 2}, {2, 2, 2}}));
        System.out.println(minCost(new int[][]{{4}}));
    }

    /**
     * 参考：<a href="https://leetcode.cn/problems/minimum-cost-to-make-at-least-one-valid-path-in-a-grid/solutions/2138021/zui-duan-lu-tong-shi-dui-yu-mei-ge-fang-g8xd2/"></a>
     *
     * @param grid
     * @return
     */
    public static int minCost(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        /**
         * 依次对应四个移动方向：1-向右走，2-向左走，3-向下走，4-向上走
         */
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        /**
         * isVisited[i][j][k]表示已到达过grid[i][j]，并且此时grid[i][j]=k
         */
        boolean[][][] isVisited = new boolean[rows][cols][5];
        /**
         * 将所有情况按照已付出的代价升序排列
         */
        Queue<Cell> queue = new PriorityQueue<>(Comparator.comparingInt(x -> x.cost));
        queue.offer(new Cell(0, 0, 0));
        isVisited[0][0][grid[0][0]] = true;

        while (!queue.isEmpty()) {
            Cell cell = queue.poll();
            int row = cell.row;
            int col = cell.col;
            int cost = cell.cost;
            /**
             * 已到达右下角的格子，找到了一条有效路劲，直接返回结果
             */
            if (row == rows - 1 && col == cols - 1) {
                return cost;
            }
            /**
             * 可以从当前坐标(row,col)向前后左右四个方向移动
             */
            for (int i = 0; i < directions.length; i++) {
                int nextRow = row + directions[i][0];
                int nextCol = col + directions[i][1];

                if (nextRow >= 0 && nextRow < rows && nextCol >= 0 && nextCol < cols && !isVisited[nextRow][nextCol][i]) {
                    isVisited[nextRow][nextCol][i] = true;
                    /**
                     * 判断是否要修改当前坐标的格子中的数字
                     */
                    if (i + 1 != grid[row][col]) {
                        queue.offer(new Cell(nextRow, nextCol, cost + 1));
                    } else {
                        queue.offer(new Cell(nextRow, nextCol, cost));
                    }
                }
            }
        }
        return -1;
    }
    public static class Cell {
        private int row;
        private int col;
        private int cost;

        public Cell(int row, int col, int cost) {
            this.row = row;
            this.col = col;
            this.cost = cost;
        }
    }
}
