package leetcode.algorithms;

import java.util.Arrays;

/**
 * Description: 3654. Minimum Sum After Divisible Sum Deletions
 *
 * @author baltan
 * @date 2025/9/17 17:24
 */
public class MinArraySum1 {
    public static void main(String[] args) {
        System.out.println(minArraySum(new int[]{34, 28, 67}, 62));
        System.out.println(minArraySum(new int[]{1, 1, 1}, 2));
        System.out.println(minArraySum(new int[]{3, 1, 4, 1, 5}, 3));
    }

    public static long minArraySum(int[] nums, int k) {
        int length = nums.length;
        /**
         * 数组nums的前缀和
         */
        long prefixSum = 0L;
        /**
         * remainders[i]表示数组nums中，前缀和除以k余数为i的最长前缀的长度
         */
        int[] remainders = new int[k];
        /**
         * 对于数组nums的前缀子数组nums[0……i]，dp[i+1][0]表示不删除nums[i]时的最小可能和，dp[i+1][1]表示删除nums[i]时的最小可能和，
         * 如果nums[i]不可能被删除，则dp[i+1][1]用Long.MAX_VALUE标记。所求即为dp[length][0]和dp[length][1]中的较小值
         */
        long[][] dp = new long[length + 1][2];
        Arrays.fill(remainders, -1);
        /**
         * 假设数组nums前存在元素0作为哨兵
         */
        remainders[0] = 0;

        for (int i = 0; i < length; i++) {
            /**
             * 如果不删除nums[i]，则可由不删除nums[i-1]和删除nums[i-1]中更小的最小可能和转移而来
             */
            dp[i + 1][0] = Math.min(dp[i][0], dp[i][1]) + nums[i];
            /**
             * 先假设nums[i]不可能被删除
             */
            dp[i + 1][1] = Long.MAX_VALUE;
            prefixSum += nums[i];
            int remainder = (int) (prefixSum % k);
            int prefixLength = remainders[remainder];
            /**
             * 因为数组nums长度为prefixLength的前缀子数组元素之和除以k的余数也为remainder，所以这部分子数组之后到nums[i]为止的元素之和
             * 除以k余数为0，从而可以将这部分子数组一起删除，则可由不删除nums[prefixLength-1]和删除nums[prefixLength-1]中更小的最小可
             * 能和转移而来
             */
            if (prefixLength != -1) {
                dp[i + 1][1] = Math.min(dp[i + 1][1], Math.min(dp[prefixLength][0], dp[prefixLength][1]));
            }
            remainders[remainder] = i + 1;
        }
        return Math.min(dp[length][0], dp[length][1]);
    }
}
