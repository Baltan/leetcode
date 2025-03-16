package leetcode.algorithms;

import java.util.Arrays;

/**
 * Description: 3469. Find Minimum Cost to Remove Array Elements
 *
 * @author Baltan
 * @date 2025/3/8 23:28
 */
public class MinCost8 {
    public static void main(String[] args) {
        System.out.println(minCost(new int[]{6, 2, 8, 4}));
        System.out.println(minCost(new int[]{2, 1, 3, 3}));
    }

    /**
     * 参考：<a href="https://leetcode.cn/problems/find-minimum-cost-to-remove-array-elements/solutions/3591270/jie-fa-dp-by-tsreaper-h1tn/"></a>
     *
     * @param nums
     * @return
     */
    public static int minCost(int[] nums) {
        /**
         * 因为每次都是从数组中移除两个元素，为了统一处理，可以在数组最后再增加若干个0，这样也不会影响最终移除所有数字的最小成本。如果数组
         * nums的长度为偶数，则在最后增加两个0，否则最后增加三个0。此时，当数组中只剩下最后两个0时，就表示原有数组中的数字都已被移除了
         */
        nums = Arrays.copyOf(nums, nums.length % 2 == 0 ? nums.length + 2 : nums.length + 3);
        int length = nums.length;
        /**
         * 因为每次都是从数组剩余元素的前三个中任选两个移除，所以剩余数组中，除了第一个元素外，剩余元素的索引是连续的，也就是剩余元素的索引依
         * 次为i、j、j+1、j+2……dp[i][j]表示数组中剩余元素为nums[i]、nums[j]、nums[j+1]、nums[j+2]……时，已移除数字的最小总成本
         */
        int[][] dp = new int[length + 1][length + 1];

        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        /**
         * 初始时，数组nums中所有元素都未移除，已移除数字的最小总成本为0
         */
        dp[0][1] = 0;

        for (int i = 0; i < length - 2; i++) {
            for (int j = i + 1; j < length - 2; j++) {
                /**
                 * 说明数组nums中剩余元素为nums[i]、nums[j]、nums[j+1]、nums[j+2]……的情况不存在
                 */
                if (dp[i][j] == Integer.MAX_VALUE) {
                    continue;
                }
                /**
                 * 如果移除元素nums[i]和nums[j]，当前操作总成本为dp[i][j]+Math.max(nums[i],nums[j])，则剩余元素为nums[j+1]、
                 * nums[j+2]、nums[j+3]、nums[j+4]……
                 */
                dp[j + 1][j + 2] = Math.min(dp[j + 1][j + 2], dp[i][j] + Math.max(nums[i], nums[j]));
                /**
                 * 如果移除元素nums[i]和nums[j+1]，当前操作总成本为dp[i][j]+Math.max(nums[i],nums[j+1])，则剩余元素为nums[j]、
                 * nums[j+2]、nums[j+3]、nums[j+4]……
                 */
                dp[j][j + 2] = Math.min(dp[j][j + 2], dp[i][j] + Math.max(nums[i], nums[j + 1]));
                /**
                 * 如果移除元素nums[j]和nums[j+2]，当前操作总成本为dp[i][j]+Math.max(nums[j],nums[j+1])，则剩余元素为nums[j+1]、
                 * nums[j+2]、nums[j+3]、nums[j+4]……
                 */
                dp[i][j + 2] = Math.min(dp[i][j + 2], dp[i][j] + Math.max(nums[j], nums[j + 1]));
            }
        }
        return dp[length - 2][length - 1];
    }
}
