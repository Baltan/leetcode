package leetcode.algorithms;

import java.util.Arrays;

/**
 * Description: 2500. Delete Greatest Value in Each Row
 *
 * @author Baltan
 * @date 2023/2/6 09:48
 */
public class DeleteGreatestValue {
    public static void main(String[] args) {
        System.out.println(deleteGreatestValue(new int[][]{{1, 2, 4}, {3, 3, 1}}));
        System.out.println(deleteGreatestValue(new int[][]{{10}}));
    }

    public static int deleteGreatestValue(int[][] grid) {
        int result = 0;
        /**
         * 将每一个行数组排序
         */
        for (int[] row : grid) {
            Arrays.sort(row);
        }
        /**
         * 逐列遍历，找出每列中的最大值
         */
        for (int i = grid[0].length - 1; i >= 0; i--) {
            int max = Integer.MIN_VALUE;

            for (int[] row : grid) {
                max = Math.max(max, row[i]);
            }
            result += max;
        }
        return result;
    }
}
