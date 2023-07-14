package leetcode.algorithms;

import java.util.Arrays;

/**
 * Description: 2770. Maximum Number of Jumps to Reach the Last Index
 *
 * @author Baltan
 * @date 2023/7/10 22:47
 */
public class MaximumJumps {
    public static void main(String[] args) {
        System.out.println(maximumJumps(new int[]{1, 3, 6, 4, 1, 2}, 2));
        System.out.println(maximumJumps(new int[]{1, 3, 6, 4, 1, 2}, 3));
        System.out.println(maximumJumps(new int[]{1, 3, 6, 4, 1, 2}, 0));
    }

    public static int maximumJumps(int[] nums, int target) {
        int length = nums.length;
        /**
         * dp[i]表示到达nums[i]最多可以跳跃的次数
         */
        int[] dp = new int[length];
        Arrays.fill(dp, -1);
        dp[0] = 0;

        for (int i = 1; i < length; i++) {
            for (int j = 0; j < i; j++) {
                /**
                 * 判断能否从nums[j]跳跃到nums[i]
                 */
                if (dp[j] != -1 && Math.abs(nums[i] - nums[j]) <= target) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        return dp[length - 1];
    }
}
