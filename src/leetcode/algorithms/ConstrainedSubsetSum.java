package leetcode.algorithms;

/**
 * Description: 1425. Constrained Subsequence Sum
 *
 * @author Baltan
 * @date 2020-05-04 10:19
 */
public class ConstrainedSubsetSum {
    public static void main(String[] args) {
        System.out.println(constrainedSubsetSum(new int[]{10, 2, -10, 5, 20}, 2));
        System.out.println(constrainedSubsetSum(new int[]{-1, -2, -3}, 1));
        System.out.println(constrainedSubsetSum(new int[]{10, -2, -10, -5, 20}, 2));
    }

    public static int constrainedSubsetSum(int[] nums, int k) {
        int result = nums[0];
        int length = nums.length;
        int[] dp = new int[length];
        dp[0] = nums[0];

        for (int i = 1; i < length; i++) {
            dp[i] = nums[i];

            for (int j = i - 1; j >= Math.max(0, i - k); j--) {
                dp[i] = Math.max(dp[i], dp[j] + nums[i]);
            }
            result = Math.max(result, dp[i]);
        }
        return result;
    }
}
