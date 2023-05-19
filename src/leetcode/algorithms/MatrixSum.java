package leetcode.algorithms;

import java.util.Arrays;

/**
 * Description: 2679. Sum in a Matrix
 *
 * @author Baltan
 * @date 2023/5/17 15:40
 */
public class MatrixSum {
    public static void main(String[] args) {
        System.out.println(matrixSum(new int[][]{{7, 2, 1}, {6, 4, 2}, {6, 5, 3}, {3, 2, 1}}));
        System.out.println(matrixSum(new int[][]{{1}}));
    }

    public static int matrixSum(int[][] nums) {
        int result = 0;
        int rows = nums.length;
        int cols = nums[0].length;
        /**
         * 将每一行的数字排序
         */
        for (int[] row : nums) {
            Arrays.sort(row);
        }

        for (int i = 0; i < cols; i++) {
            int max = Integer.MIN_VALUE;
            /**
             * 查找每一列中最大的数字
             */
            for (int j = 0; j < rows; j++) {
                max = Math.max(max, nums[j][i]);
            }
            result += max;
        }
        return result;
    }
}
