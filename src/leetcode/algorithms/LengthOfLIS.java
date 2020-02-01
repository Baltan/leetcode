package leetcode.algorithms;

/**
 * Description: 300. Longest Increasing Subsequence
 *
 * @author Baltan
 * @date 2020-02-01 13:10
 */
public class LengthOfLIS {
    public static void main(String[] args) {
        int[] nums1 = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(lengthOfLIS(nums1));

        int[] nums2 = {1, 3, 6, 7, 9, 4, 10, 5, 6};
        System.out.println(lengthOfLIS(nums2));
    }

    public static int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int length = nums.length;
        /**
         * dp[i]表示子数组nums.subarray(0,i+1)的最长上升子序列的长度
         */
        int[] dp = new int[length];
        dp[0] = 1;
        int result = 1;

        for (int i = 1; i < length; i++) {
            /**
             * 子数组nums.subarray(0,i+1)的最长上升子序列的长度至少为1，即nums[i]小于前面所有值
             */
            dp[i] = 1;

            for (int j = i - 1; j >= 0; j--) {
                /**
                 * 如果nums[i]大于前面的某个值nums[j]，则nums[i]可以跟在以nums[j]结尾的最长上升子
                 * 序列的后面，构成一个长度为dp[j]+1的最长上升子序列，如果这个最长上升子序列的长度大
                 * 于当前的dp[i]，就更新dp[i]
                 */
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    result = Math.max(result, dp[i]);
                }
            }
        }
        return result;
    }
}
