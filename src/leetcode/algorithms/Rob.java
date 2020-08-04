package leetcode.algorithms;

/**
 * Description: 198. House Robber
 *
 * @author Baltan
 * @date 2018/8/8 16:23
 * @see Rob1
 * @see Rob2
 */
public class Rob {
    public static void main(String[] args) {
        System.out.println(rob(new int[]{1, 2, 3, 1}));
        System.out.println(rob(new int[]{2, 7, 9, 3, 1}));
        System.out.println(rob(new int[]{2}));
    }

    public static int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return nums[0];
        }
        /**
         * dp[i]表示到第i（0-based）间房屋为止可以获得的最高金额
         */
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < dp.length; i++) {
            /**
             * 如果要偷第i间房屋，则前面最多偷到第i-2间房屋
             */
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[dp.length - 1];
    }
}
