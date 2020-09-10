package leetcode.algorithms;

/**
 * Description: 377. Combination Sum IV
 *
 * @author Baltan
 * @date 2019-06-29 10:40
 * @see CombinationSum1
 * @see CombinationSum2
 * @see CombinationSum3
 * @see Combine
 */
public class CombinationSum4 {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3};
        System.out.println(combinationSum4(nums1, 4));
    }

    public static int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;

        for (int i = 1; i <= target; i++) {
            int count = 0;

            for (int num : nums) {
                if (i - num >= 0) {
                    count += dp[i - num];
                }
            }
            dp[i] = count;
        }
        return dp[target];
    }
}
