package leetcode.algorithms;

/**
 * Description: 410. Split Array Largest Sum
 *
 * @author Baltan
 * @date 2020-07-25 11:23
 * @see SplitArray1
 */
public class SplitArray {
    public static void main(String[] args) {
        System.out.println(splitArray(new int[]{7, 2, 5, 10, 8}, 2));
        System.out.println(
                splitArray(new int[]{7, 4, 3, 22, 5, 7, 8, 24, 2, 18, 5, 13, 43, 76, 13, 46, 68, 24, 10}, 4));
    }

    public static int splitArray(int[] nums, int m) {
        int length = nums.length;
        /**
         * dp[i][j]表示把nums的前i个数字分成j个连续子数组，这j个子数组各自和的最大值中的最小值，题目所求即为
         * dp[length][m]
         */
        int[][] dp = new int[length + 1][m + 1];
        /**
         * 计算把nums的前i个数字很分成1段，这段子数组的和。dp[i][1]也就是数组nums的前缀和prefixSum[i]
         */
        for (int i = 1; i <= length; i++) {
            dp[i][1] = nums[i - 1] + dp[i - 1][1];
        }
        /**
         * 把nums分成i个连续子数组
         */
        for (int i = 2; i <= m; i++) {
            /**
             * 把数组前j个数字分成i个连续子数组，则至少有i个数字，至多有length个数字
             */
            for (int j = i; j <= length; j++) {
                /**
                 * 把nums的前j个数字分成i个连续子数组，这i个子数组各自和的最大值中的最小值
                 */
                dp[j][i] = Integer.MAX_VALUE;
                /**
                 * 把数组前k个数字分成i-1个连续子数组，k至少为i-1，至多为j-1，因为第i个子数组至少要包括一个数字，
                 * 所以不能把前j个数字都分配到前i-1个子数组中
                 */
                for (int k = i - 1; k < j; k++) {
                    /**
                     * Math.max(dp[k][i-1], dp[j][1]-dp[k][1])表示i个连续子数组的和的最大值，我们要求所有分
                     * 割中使得这个最大值最小的情况
                     */
                    dp[j][i] = Math.min(dp[j][i], Math.max(dp[k][i - 1], dp[j][1] - dp[k][1]));
                }
            }
        }
        return dp[length][m];
    }
}
