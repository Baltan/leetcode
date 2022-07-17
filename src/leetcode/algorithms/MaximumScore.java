package leetcode.algorithms;

/**
 * Description: 1770. Maximum Score from Performing Multiplication Operations
 *
 * @author Baltan
 * @date 2022/7/15 09:49
 */
public class MaximumScore {
    public static void main(String[] args) {
        System.out.println(maximumScore(new int[]{1, 2, 3}, new int[]{3, 2, 1}));
        System.out.println(maximumScore(new int[]{-5, -3, -3, -2, 7, 1}, new int[]{-10, -5, 3, 4, 6}));
    }

    /**
     * 参考：
     * <a href="https://leetcode.cn/problems/maximum-score-from-performing-multiplication-operations/solution/dong-tai-gui-hua-er-wei-zhuang-tai-ding-slg21/"></a>
     *
     * @param nums
     * @param multipliers
     * @return
     */
    public static int maximumScore(int[] nums, int[] multipliers) {
        int result = Integer.MIN_VALUE;
        int n = nums.length;
        int m = multipliers.length;
        /**
         * dp[i][j]表示数组nums中前i个数和后j个数可以得到的最大分数
         */
        int[][] dp = new int[m + 1][m + 1];
        dp[0][0] = 0;
        /**
         * 对于dp[i][0]，只能是nums[0]*multipliers[0]+nums[1]*multipliers[1]+……+nums[i]*multipliers[i]
         */
        for (int i = 1; i <= m; i++) {
            dp[i][0] = dp[i - 1][0] + nums[i - 1] * multipliers[i - 1];
        }
        /**
         * 对于dp[0][j]，只能是nums[n-1]*multipliers[0]+nums[n-2]*multipliers[1]+……+nums[n-1-j]*multipliers[j]
         */
        for (int j = 1; j <= m; j++) {
            dp[0][j] = dp[0][j - 1] + nums[n - j] * multipliers[j - 1];
        }
        /**
         * 对于dp[i][j]，可以是dp[i-1][j]+nums[i+1]*multipliers[i+j-1]，或者是
         * dp[i][j-1]+nums[n-j]*multipliers[i+j-1]，两者取较大值
         */
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; i + j <= m; ++j) {
                dp[i][j] = Math.max(dp[i - 1][j] + nums[i - 1] * multipliers[i + j - 1],
                        dp[i][j - 1] + nums[n - j] * multipliers[i + j - 1]);
            }
        }
        /**
         * 执行m步操作后，可能的情况为dp[0][m]、dp[1][m-1]、dp[2][m-2]、……、dp[m][0]，取最大值
         */
        for (int i = 0; i <= m; ++i) {
            result = Math.max(result, dp[i][m - i]);
        }
        return result;
    }
}
