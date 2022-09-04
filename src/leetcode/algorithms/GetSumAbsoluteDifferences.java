package leetcode.algorithms;

import leetcode.util.OutputUtils;

/**
 * Description: 1685. Sum of Absolute Differences in a Sorted Array
 *
 * @author Baltan
 * @date 2022/8/28 14:46
 */
public class GetSumAbsoluteDifferences {
    public static void main(String[] args) {
        OutputUtils.print1DIntegerArray(getSumAbsoluteDifferences(new int[]{2, 3, 5}));
        OutputUtils.print1DIntegerArray(getSumAbsoluteDifferences(new int[]{1, 4, 6, 8, 10}));
    }

    public static int[] getSumAbsoluteDifferences(int[] nums) {
        int[] result = new int[nums.length];
        int length = nums.length;
        /**
         * 数组nums的前缀和，即prefixSum[i]表示nums[0]+nums[1]+……+nums[i-1]的和
         */
        int[] prefixSum = new int[length + 1];
        /**
         * 计算数组nums的前缀和
         */
        for (int i = 0; i < length; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }

        for (int i = 0; i < length; i++) {
            /**
             * nums[i]前面的子数组的长度
             */
            int prevLength = i;
            /**
             * nums[i]后面的子数组的长度
             */
            int nextLength = length - (i + 1);
            /**
             * nums[i]前面的子数组中所有元素的和
             */
            int prevSum = prefixSum[prevLength];
            /**
             * nums[i]后面的子数组中所有元素的和
             */
            int nextSum = prefixSum[length] - prefixSum[i + 1];
            result[i] = (nums[i] * prevLength - prevSum) + (nextSum - nums[i] * nextLength);
        }
        return result;
    }
}
