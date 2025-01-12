package leetcode.algorithms;

import java.util.Arrays;

/**
 * Description: 3409. Longest Subsequence With Decreasing Adjacent Difference
 *
 * @author Baltan
 * @date 2025/1/10 23:15
 */
public class LongestSubsequence3 {
    public static void main(String[] args) {
        System.out.println(longestSubsequence(new int[]{2, 8, 8, 8, 1}));
        System.out.println(longestSubsequence(new int[]{16, 6, 3}));
        System.out.println(longestSubsequence(new int[]{6, 5, 3, 4, 2, 1}));
        System.out.println(longestSubsequence(new int[]{10, 20, 10, 19, 10, 20}));
    }

    /**
     * 参考：<a href="https://leetcode.cn/problems/longest-subsequence-with-decreasing-adjacent-difference/solutions/3038930/zhuang-tai-she-ji-you-hua-pythonjavacgo-qy2bu/"></a>
     *
     * @param nums
     * @return
     */
    public static int longestSubsequence(int[] nums) {
        int result = 0;
        int max = Arrays.stream(nums).max().getAsInt();
        int min = Arrays.stream(nums).min().getAsInt();
        /**
         * 子序列中相邻两数之差的绝对值的最大值
         */
        int maxDiff = max - min;
        /**
         * dp[i][j]表示以nums[i]结尾，并且最后两个数字之差的绝对值大于等于j的子序列的最大长度
         */
        int[][] dp = new int[nums.length][maxDiff + 2];
        /**
         * lastIndexes[i]表示遍历到某个元素前，最后一次出现数字i的索引值
         */
        int[] lastIndexes = new int[max + 1];
        Arrays.fill(lastIndexes, -1);

        for (int i = 0; i < nums.length; i++) {
            for (int j = maxDiff; j >= 0; j--) {
                /**
                 * 1、元素nums[i]可以单独作为一个长度为1的子序列
                 * 2、如果元素nums[i]和子序列的前一个元素之差的绝对值大于j，则dp[i][j]=dp[i][j+1]
                 */
                dp[i][j] = Math.max(dp[i][j + 1], 1);
                /**
                 * 3、如果元素nums[i]和子序列的前一个元素之差的绝对值等于j，则前一个元素可以为nums[i]-j，如果此前nums[i]-j出现过，就可
                 * 以得到新的子序列，并且dp[i][j]=dp[lastIndexes[nums[i]-j]][j]+1。前一个元素也可以为nums[i]+j，如果此前nums[i]+j
                 * 出现过，也可以得到新的子序列，并且dp[i][j]=dp[lastIndexes[nums[i]+j]][j]+1
                 */
                if (nums[i] - j >= 0 && lastIndexes[nums[i] - j] >= 0) {
                    dp[i][j] = Math.max(dp[i][j], dp[lastIndexes[nums[i] - j]][j] + 1);
                }

                if (nums[i] + j <= max && lastIndexes[nums[i] + j] >= 0) {
                    dp[i][j] = Math.max(dp[i][j], dp[lastIndexes[nums[i] + j]][j] + 1);
                }
                /**
                 * 以上dp[i][j]的三种情况取最大值更新结果result
                 */
                result = Math.max(result, dp[i][j]);
            }
            /**
             * 更新到nums[i]为止，数字nums[i]最后一次出现的索引值为i
             */
            lastIndexes[nums[i]] = i;
        }
        return result;
    }
}
