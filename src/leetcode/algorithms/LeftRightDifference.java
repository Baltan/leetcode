package leetcode.algorithms;

import leetcode.util.OutputUtils;

/**
 * Description: 2574. Left and Right Sum Differences
 *
 * @author Baltan
 * @date 2023/2/26 13:44
 */
public class LeftRightDifference {
    public static void main(String[] args) {
        OutputUtils.print1DIntegerArray(leftRightDifference(new int[]{10, 4, 8, 3}));
        OutputUtils.print1DIntegerArray(leftRightDifference(new int[]{1}));
    }

    public static int[] leftRightDifference(int[] nums) {
        int length = nums.length;
        int[] result = new int[length];
        /**
         * 数组nums中所有元素的和
         */
        int sum = 0;
        /**
         * 数组nums的前缀和
         */
        int[] prefixSums = new int[length + 1];

        for (int i = 0; i < length; i++) {
            sum += nums[i];
            prefixSums[i + 1] = prefixSums[i] + nums[i];
        }

        for (int i = 0; i < length; i++) {
            /**
             * leftSum[i]为nums[i]左边所有数字的和，即prefixSums[i]；rightSum[i]为nums[i]右边所有数字的和，即sum-prefixSums[i+1]
             */
            result[i] = Math.abs(prefixSums[i] - (sum - prefixSums[i + 1]));
        }
        return result;
    }
}
