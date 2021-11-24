package leetcode.algorithms;

import java.util.Arrays;

/**
 * Description: 2033. Minimum Operations to Make a Uni-Value Grid
 *
 * @author Baltan
 * @date 2021/11/24 09:13
 */
public class MinOperations2 {
    public static void main(String[] args) {
        int[][] grid1 = {{2, 4}, {6, 8}};
        int x1 = 2;
        System.out.println(minOperations(grid1, x1));

        int[][] grid2 = {{1, 5}, {2, 3}};
        int x2 = 1;
        System.out.println(minOperations(grid2, x2));

        int[][] grid3 = {{1, 2}, {3, 4}};
        int x3 = 2;
        System.out.println(minOperations(grid3, x3));
    }

    public static int minOperations(int[][] grid, int x) {
        int rows = grid.length;
        int cols = grid[0].length;
        int total = rows * cols;
        /**
         * 保存网格中的所有数字
         */
        int[] list = new int[total];
        int index = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                list[index++] = grid[i][j];
            }
        }

        Arrays.sort(list);
        /**
         * 逐一判断相邻两个数字的较小值能否通过若干次加x得到较大值，如果某一对数字不能，说明所有数字最终无法通过操作相等
         */
        for (int i = 1; i < total; i++) {
            if ((list[i] - list[i - 1]) % x != 0) {
                return -1;
            }
        }
        /**
         * 最终相等的值越位于list的靠中间的位置，总操作数越小
         */
        if (total % 2 == 1) {
            int mid = list[total / 2];
            int result = 0;

            for (int num : list) {
                result += Math.abs(num - mid) / x;
            }
            return result;
        } else {
            int midLeft = list[(total - 1) / 2];
            int midRight = list[total / 2];
            int resultLeft = 0;
            int resultRight = 0;

            for (int num : list) {
                resultLeft += Math.abs(num - midLeft) / x;
                resultRight += Math.abs(num - midRight) / x;
            }
            return Math.min(resultLeft, resultRight);
        }
    }
}
