package leetcode.algorithms;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Description: 3462. Maximum Sum With at Most K Elements
 *
 * @author baltan
 * @date 2025/2/25 14:27
 */
public class MaxSum3 {
    public static void main(String[] args) {
        System.out.println(maxSum(new int[][]{{1, 2}, {3, 4}}, new int[]{1, 2}, 2));
        System.out.println(maxSum(new int[][]{{5, 3, 7}, {8, 2, 6}}, new int[]{2, 2}, 3));
    }

    public static long maxSum(int[][] grid, int[] limits, int k) {
        long result = 0L;
        /**
         * 保存矩阵grid中所有数字的坐标，并且按照坐标对应的数字降序排列
         */
        Queue<int[]> pq = new PriorityQueue<>((x, y) -> grid[y[0]][y[1]] - grid[x[0]][x[1]]);

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                pq.offer(new int[]{i, j});
            }
        }

        while (k > 0) {
            /**
             * 矩阵grid中剩余数字的最大值对应的坐标
             */
            int[] coordinate = pq.poll();
            int row = coordinate[0];
            int col = coordinate[1];
            /**
             * 当前行已被选择了limits[row]个数字，不能再被选择更多数字
             */
            if (limits[row] <= 0) {
                continue;
            }
            /**
             * 矩阵grid中剩余的数字都不大于0，继续累加数字不可能使得result更大
             */
            if (grid[row][col] <= 0) {
                break;
            }
            result += grid[row][col];
            limits[row]--;
            k--;
        }
        return result;
    }
}
