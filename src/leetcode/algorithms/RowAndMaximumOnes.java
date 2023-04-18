package leetcode.algorithms;

import leetcode.util.OutputUtils;

import java.util.Arrays;

/**
 * Description: 2643. Row With Maximum Ones
 *
 * @author Baltan
 * @date 2023/4/16 13:10
 */
public class RowAndMaximumOnes {
    public static void main(String[] args) {
        OutputUtils.print1DIntegerArray(rowAndMaximumOnes(new int[][]{{0, 1}, {1, 0}}));
        OutputUtils.print1DIntegerArray(rowAndMaximumOnes(new int[][]{{0, 0, 0}, {0, 1, 1}}));
        OutputUtils.print1DIntegerArray(rowAndMaximumOnes(new int[][]{{0, 0}, {1, 1}, {0, 0}}));
    }

    public static int[] rowAndMaximumOnes(int[][] mat) {
        int[] result = {0, 0};

        for (int i = 0; i < mat.length; i++) {
            /**
             * 因为每个数字不是1就是0，所以第i行中数字1的个数等于第i行中所有数字之和
             */
            int count = Arrays.stream(mat[i]).sum();

            if (count > result[1]) {
                result[0] = i;
                result[1] = count;
            }
        }
        return result;
    }
}
