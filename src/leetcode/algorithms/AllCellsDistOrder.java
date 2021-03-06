package leetcode.algorithms;

import leetcode.util.OutputUtils;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Description: 1030. Matrix Cells in Distance Order
 *
 * @author Baltan
 * @date 2019-04-22 09:44
 */
public class AllCellsDistOrder {
    public static void main(String[] args) {
        OutputUtils.print2DIntegerArray(allCellsDistOrder(1, 2, 0, 0));
        System.out.println("---------------------");
        OutputUtils.print2DIntegerArray(allCellsDistOrder(2, 2, 0, 1));
        System.out.println("---------------------");
        OutputUtils.print2DIntegerArray(allCellsDistOrder(2, 3, 1, 2));
    }

    public static int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        int[][] result = new int[R * C][2];
        /**
         * isVisited[i][j]标记原矩阵中的数matrix[i][j]是否已经被处理过
         */
        boolean[][] isVisited = new boolean[R][C];
        /**
         * 当前已经被处理过的数的个数
         */
        int count = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{r0, c0});

        while (count < R * C) {
            int[] coordinate = queue.poll();
            int x = coordinate[0];
            int y = coordinate[1];

            if (coordinate[0] < R && coordinate[0] >= 0 && coordinate[1] < C && coordinate[1] >= 0 &&
                    !isVisited[x][y]) {
                result[count++] = coordinate;
                isVisited[x][y] = true;

                if (coordinate[0] - 1 >= 0) {
                    queue.offer(new int[]{coordinate[0] - 1, coordinate[1]});
                }

                if (coordinate[0] + 1 < R) {
                    queue.offer(new int[]{coordinate[0] + 1, coordinate[1]});
                }

                if (coordinate[1] - 1 >= 0) {
                    queue.offer(new int[]{coordinate[0], coordinate[1] - 1});
                }

                if (coordinate[1] + 1 < C) {
                    queue.offer(new int[]{coordinate[0], coordinate[1] + 1});
                }
            }
        }
        return result;
    }
}
