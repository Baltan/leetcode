package leetcode.algorithms;

import leetcode.util.OutputUtils;

import java.util.Arrays;

/**
 * Description: 3685. Subsequence Sum After Capping Elements
 *
 * @author Baltan
 * @date 2025/11/2 17:46
 */
public class SubsequenceSumAfterCapping {
    public static void main(String[] args) {
        OutputUtils.print1DBooleanArray(subsequenceSumAfterCapping(new int[]{11, 14, 2, 5, 10, 8, 11, 4, 2, 7, 8, 4, 10, 5, 11}, 3));
        OutputUtils.print1DBooleanArray(subsequenceSumAfterCapping(new int[]{3, 3, 5, 6, 2, 5}, 23));
        OutputUtils.print1DBooleanArray(subsequenceSumAfterCapping(new int[]{1, 1}, 1));
        OutputUtils.print1DBooleanArray(subsequenceSumAfterCapping(new int[]{11, 12, 2, 8, 4, 19, 10, 10, 14, 20, 17, 10, 2, 13, 20, 15, 20, 9, 13, 16}, 6));
        OutputUtils.print1DBooleanArray(subsequenceSumAfterCapping(new int[]{1}, 1));
        OutputUtils.print1DBooleanArray(subsequenceSumAfterCapping(new int[]{4, 3, 2, 4}, 5));
        OutputUtils.print1DBooleanArray(subsequenceSumAfterCapping(new int[]{1, 2, 3, 4, 5}, 3));
    }

    public static boolean[] subsequenceSumAfterCapping(int[] nums, int k) {
        Arrays.sort(nums);
        int length = nums.length;
        boolean[] result = new boolean[length];
        /**
         * 当前要加入背包数字为nums[j]
         */
        int j = 0;
        /**
         * 数组nums中的最大数字
         */
        int max = nums[length - 1];
        /**
         * dp[i]表示能否从背包中选择若干个已有数字，使得和为i，元素之和最大只需要计算到k即可
         */
        boolean[] dp = new boolean[k + 1];
        /**
         * 当背包为空时，可以使得若干个已有数字之和为0
         */
        dp[0] = true;
        /**
         * 当前限制值为i
         */
        for (int i = 1; i <= length; i++) {
            /**
             * 当限制值大于max时，背包中的数字始终和初始时一样，不需要重复计算
             */
            if (i > max) {
                result[i - 1] = result[i - 2];
                continue;
            }
            /**
             * 如果元素nums[j]不大于i，就将其加入背包中
             */
            for (; j < length && nums[j] <= i; j++) {
                /**
                 * 遍历加入元素nums[j]之前背包中选择若干个已有数字之和的情况。注意必须降序遍历，否则可能出现nums[j]被重复累加的情况
                 */
                for (int sum = k; sum >= 0; sum--) {
                    if (!dp[sum]) {
                        continue;
                    }
                    /**
                     * 背包中选择若干个已有数字，可以使得和为newSum
                     */
                    int newSum = sum + nums[j];

                    if (newSum <= k) {
                        dp[newSum] = true;
                    }
                }
            }
            /**
             * 出去背包中的已有元素，剩下的length-j个元素都为被限制值更新为i
             */
            for (int l = 0; l <= length - j; l++) {
                /**
                 * 如果选择l个被限制值更新后的元素i，则还需要从背包中选择若干个元素，使得他们的的和为k-i*l，此时包含所有这些被选元素的子序
                 * 列之和才能为k
                 */
                int otherSum = k - l * i;

                if (otherSum >= 0 && dp[otherSum]) {
                    result[i - 1] = true;
                    break;
                }
            }
        }
        return result;
    }
}
