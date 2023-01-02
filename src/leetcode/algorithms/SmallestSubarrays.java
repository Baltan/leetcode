package leetcode.algorithms;

import leetcode.util.OutputUtils;

import java.util.Arrays;

/**
 * Description: 2411. Smallest Subarrays With Maximum Bitwise OR
 *
 * @author Baltan
 * @date 2022/12/20 11:30
 */
public class SmallestSubarrays {
    public static void main(String[] args) {
        OutputUtils.print1DIntegerArray(smallestSubarrays(new int[]{1, 0, 2, 1, 3}));
        OutputUtils.print1DIntegerArray(smallestSubarrays(new int[]{1, 2}));
    }

    /**
     * 参考：<a href="https://leetcode.cn/problems/smallest-subarrays-with-maximum-bitwise-or/solutions/1830669/by-hong-tou-fa-nolei-ou-jstk/"></a>
     *
     * @param nums
     * @return
     */
    public static int[] smallestSubarrays(int[] nums) {
        int length = nums.length;
        int[] result = new int[length];
        /**
         * dp[x]表示nums[i]……nums[length-1]这部分数字的二进制值从低到高第x位为1的第一个数字的索引位置
         */
        int[] dp = new int[32];
        /**
         * dp[x]为-1表示nums[i]……nums[length-1]这部分数字的二进制值从低到高第x位都为0
         */
        Arrays.fill(dp, -1);

        for (int i = length - 1; i >= 0; i--) {
            int max = 1;

            for (int x = 0; x < 32; x++) {
                /**
                 * 从低位向高位判断nums[i]的二进制值的每一位是否为1
                 */
                if (((nums[i] >> x) & 1) == 1) {
                    dp[x] = i;
                }

                if (dp[x] != -1) {
                    max = Math.max(max, dp[x] - i + 1);
                }
            }
            result[i] = max;
        }
        return result;
    }
}
