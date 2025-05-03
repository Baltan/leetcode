package leetcode.algorithms;

import leetcode.util.OutputUtils;

/**
 * Description: 3524. Find X Value of Array I
 *
 * @author baltan
 * @date 2025/5/3 22:48
 */
public class ResultArray1 {
    public static void main(String[] args) {
        OutputUtils.print1DLongArray(resultArray(new int[]{1, 2, 3, 4, 5}, 3));
        OutputUtils.print1DLongArray(resultArray(new int[]{1, 2, 4, 8, 16, 32}, 4));
        OutputUtils.print1DLongArray(resultArray(new int[]{1, 1, 2, 1, 1}, 2));
    }

    public static long[] resultArray(int[] nums, int k) {
        long[] result = new long[k];
        int length = nums.length;
        /**
         * dp[i][j]表示以元素nums[i]作为开头的所有子数组中元素之积除以k的余数为j的子数组的个数
         */
        long[][] dp = new long[length][k];
        /**
         * 初始状态，子数组以元素nums[length-1]开头，即子数组中只包含唯一元素nums[length-1]
         */
        dp[length - 1][nums[length - 1] % k] = 1;
        /**
         * 对于以元素nums[i]开头的子数组，相当于是在以元素nums[i+1]开头的子数组中加入了元素nums[i]。假设某个以nums[i+1]开头的子数组中元
         * 素之积除以k的余数为x，则加入元素nums[i]后，子数组中元素之积除以k的余数为x*nums[i]%k，也就是x*(nums[i]%k)%k
         */
        for (int i = length - 2; i >= 0; i--) {
            int remainder = nums[i] % k;
            /**
             * 子数组中只包含唯一元素nums[i]的情况
             */
            dp[i][remainder] = 1;
            /**
             * 遍历以nums[i+1]开头的子数组中元素之积除以k的余数为j的情况
             */
            for (int j = 0; j < k; j++) {
                if (dp[i + 1][j] != 0) {
                    int currRemainder = remainder * j % k;
                    dp[i][currRemainder] += dp[i + 1][j];
                }
            }
        }
        /**
         * 统计不同子数组中元素之积除以k的余数为j的子数组总个数
         */
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < k; j++) {
                result[j] += dp[i][j];
            }
        }
        return result;
    }
}
