package leetcode.algorithms;

import leetcode.util.OutputUtils;

/**
 * Description: 1480. Running Sum of 1d Array
 *
 * @author Baltan
 * @date 2020-06-19 20:33
 */
public class RunningSum {
    public static void main(String[] args) {
        OutputUtils.print1DIntegerArray(runningSum(new int[]{1, 2, 3, 4}));
        OutputUtils.print1DIntegerArray(runningSum(new int[]{1, 1, 1, 1, 1}));
        OutputUtils.print1DIntegerArray(runningSum(new int[]{3, 1, 2, 10, 1}));
        OutputUtils.print1DIntegerArray(runningSum(new int[]{1}));
    }

    public static int[] runningSum(int[] nums) {
        int length = nums.length;
        int[] result = new int[length];
        result[0] = nums[0];
        /**
         * 前缀和
         */
        for (int i = 1; i < length; i++) {
            result[i] = nums[i] + result[i - 1];
        }
        return result;
    }
}
