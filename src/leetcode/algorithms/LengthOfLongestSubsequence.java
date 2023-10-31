package leetcode.algorithms;

import java.util.Arrays;
import java.util.List;

/**
 * Description: 2915. Length of the Longest Subsequence That Sums to Target
 *
 * @author baltan
 * @date 2023/10/31 09:43
 */
public class LengthOfLongestSubsequence {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubsequence(Arrays.asList(1, 2, 3, 4, 5), 9));
        System.out.println(lengthOfLongestSubsequence(Arrays.asList(4, 1, 3, 2, 1, 5), 7));
        System.out.println(lengthOfLongestSubsequence(Arrays.asList(1, 1, 5, 4, 5), 3));
        System.out.println(lengthOfLongestSubsequence(Arrays.asList(1000), 1000));
    }

    public static int lengthOfLongestSubsequence(List<Integer> nums, int target) {
        int result = -1;
        int size = nums.size();
        /**
         * dp[i][j]表示数组nums的前缀数组[nums[0],nums[1],……,nums[size-1]]中元素和为j的子序列的最大长度
         */
        int[][] dp = new int[size][target + 1];
        /**
         * 假设长度为1的前缀子数组中每个子序列的元素和都不能为[0,target]
         */
        Arrays.fill(dp[0], -1);
        dp[0][0] = 0;
        /**
         * 判断唯一的子序列[nums[0]]的元素和是否为[0,target]
         */
        if (nums.get(0) <= target) {
            dp[0][nums.get(0)] = 1;
        }
        result = Math.max(result, dp[0][target]);

        for (int i = 1; i < size; i++) {
            /**
             * 假设长度为i+1的前缀子数组中每个子序列的元素和都不能为[0,target]
             */
            Arrays.fill(dp[i], -1);
            dp[i][0] = 0;

            for (int j = 1; j <= target; j++) {
                /**
                 * 如果子序列中不包括元素nums[i]，则dp[i][j]的情况和dp[i-1][j]相同
                 */
                dp[i][j] = dp[i - 1][j];
                /**
                 * 如果子序列中包括元素nums[i]，则dp[i][j]的情况为dp[i-1][j-nums[i]]的长度加1
                 */
                if (j - nums.get(i) >= 0 && dp[i - 1][j - nums.get(i)] != -1) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - nums.get(i)] + 1);
                }
            }
            result = Math.max(result, dp[i][target]);
        }
        return result;
    }
}
