package leetcode.algorithms;

/**
 * Description: 3473. Sum of K Subarrays With Length at Least M
 *
 * @author Baltan
 * @date 2025/3/19 21:37
 */
public class MaxSum4 {
    public static void main(String[] args) {
        System.out.println(maxSum(new int[]{1, 2, -1, 3, 3, 4}, 2, 2));
        System.out.println(maxSum(new int[]{-10, 3, -1, -2}, 4, 1));
    }

    public static int maxSum(int[] nums, int k, int m) {
        int length = nums.length;
        int[] prefixSums = new int[length + 1];
        int[][] dp = new int[length + 1][k + 1];

        for (int i = 0; i <= length; i++) {
            for (int j = 1; j <= k; j++) {
                dp[i][j] = Integer.MIN_VALUE;
            }
        }

        for (int i = 0; i < length; i++) {
            prefixSums[i + 1] = prefixSums[i] + nums[i];
        }

        for (int i = 1; i <= k; i++) {
            for (int j = i * m; j <= length; j++) {
                dp[j][i] = dp[j - 1][i];

                for (int l = m; l <= j - (i - 1) * m; l++) {
                    if (dp[j - l][i - 1] != Integer.MIN_VALUE) {
                        dp[j][i] = Math.max(dp[j][i], dp[j - l][i - 1] + prefixSums[j] - prefixSums[j - l]);
                    }
                }
            }
        }
        return dp[length][k];
    }
}
