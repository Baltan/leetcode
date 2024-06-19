package leetcode.algorithms;

import java.util.Arrays;

/**
 * Description: 3176. Find the Maximum Length of a Good Subsequence I
 *
 * @author baltan
 * @date 2024/6/13 10:53
 * @see MaximumLength4
 */
public class MaximumLength3 {
    public static void main(String[] args) {
        System.out.println(maximumLength(new int[]{29, 30, 30}, 0));
        System.out.println(maximumLength(new int[]{2}, 0));
        System.out.println(maximumLength(new int[]{1, 2, 1, 1, 3}, 2));
        System.out.println(maximumLength(new int[]{1, 2, 3, 4, 5, 1}, 0));
    }

    public static int maximumLength(int[] nums, int k) {
        int result = 1;
        /**
         * dp[i][j]表示以nums[i-1]结尾，并且存在j对不同相邻元素的好序列的最大长度
         */
        int[][] dp = new int[nums.length + 1][k + 1];
        /**
         * 初始化假设所有情况下的子序列都不存在
         */
        for (int i = 0; i <= nums.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        /**
         * 一个空序列中，有0对不同相邻元素，是一个好序列
         */
        dp[0][0] = 0;

        for (int i = 1; i <= nums.length; i++) {
            /**
             * 元素nums[i-1]自身作为一个长度为1的序列，有0对不同相邻元素，是一个好序列
             */
            dp[i][0] = 1;

            for (int j = 1; j < i; j++) {
                /**
                 * 如果nums[i-1]和nums[j-1]相等，并且存在以nums[j-1]结尾的有0对不同相邻元素的好序列，则以nums[i-1]结尾的有0对不同相
                 * 邻元素的好序列的最大长度是前者的最大长度加1
                 */
                if (nums[i - 1] == nums[j - 1] && dp[j][0] != -1) {
                    dp[i][0] = dp[j][0] + 1;
                    result = Math.max(result, dp[i][0]);
                }
                /**
                 * 计算以nums[i-1]结尾的有l对不同相邻元素的好序列的情况
                 */
                for (int l = 1; l <= k; l++) {
                    /**
                     * 如果nums[i-1]和nums[j-1]相等，并且存在以nums[j-1]结尾的有l对不同相邻元素的好序列，则以nums[i-1]结尾的有l对不
                     * 同相邻元素的好序列的最大长度是前者的最大长度加1
                     */
                    if (nums[i - 1] == nums[j - 1] && dp[j][l] != -1) {
                        dp[i][l] = Math.max(dp[i][l], dp[j][l] + 1);
                        result = Math.max(result, dp[i][l]);
                    }
                    /**
                     * 如果nums[i-1]和nums[j-1]不相等，并且存在以nums[j-1]结尾的有l-1对不同相邻元素的好序列，则以nums[i-1]结尾的有l
                     * 对不同相邻元素的好序列的最大长度是前者的最大长度加1
                     */
                    if (nums[i - 1] != nums[j - 1] && dp[j][l - 1] != -1) {
                        dp[i][l] = Math.max(dp[i][l], dp[j][l - 1] + 1);
                        result = Math.max(result, dp[i][l]);
                    }
                }
            }
        }
        return result;
    }
}
