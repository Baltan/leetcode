package leetcode.algorithms;

/**
 * Description: 3381. Maximum Subarray Sum With Length Divisible by K
 *
 * @author Baltan
 * @date 2024/12/16 23:13
 */
public class MaxSubarraySum9 {
    public static void main(String[] args) {
        System.out.println(maxSubarraySum(new int[]{1, 2}, 1));
        System.out.println(maxSubarraySum(new int[]{-1, -2, -3, -4, -5}, 4));
        System.out.println(maxSubarraySum(new int[]{-5, 1, 2, -3, 4}, 2));
    }

    public static long maxSubarraySum(int[] nums, int k) {
        long result = Long.MIN_VALUE;
        /**
         * 数组nums遍历过程中的前缀子数组中所有元素的和
         */
        long sum = 0L;
        /**
         * minSums[i]表示已遍历到的前缀子数组中，所有元素个数为nk+i的子数组，这nk+i个元素之和的最小值（n为自然数）
         */
        long[] minSums = new long[k + 1];
        /**
         * 当前缀子数组中元素个数小于k时，其中必不存在长度为k的整数倍的子数组，只需要计算长度为nk+i的子数组中元素之和的最小值（n为自然数）
         */
        for (int i = 1; i < k; i++) {
            sum += nums[i - 1];
            minSums[i] = sum;
        }

        for (int i = k; i <= nums.length; i++) {
            sum += nums[i - 1];
            int remainder = i % k;
            /**
             * 当前前缀子数组中元素个数为nk+remainder个，只需要截去此前已有的长度为mk+remainder的前缀子数组，就可以得到长度为k的整数倍的
             * 子数组。当前前缀子数组中元素之和为sum，此前所有长度为mk+remainder的前缀子数组中，元素之和的最小值为minSums[remainder]，
             * sum-minSums[remainder]即为新得到的长度为k的整数倍的子数组中所有元素的和（n、m为自然数）
             */
            result = Math.max(result, sum - minSums[remainder]);
            minSums[remainder] = Math.min(minSums[remainder], sum);
        }
        return result;
    }
}
