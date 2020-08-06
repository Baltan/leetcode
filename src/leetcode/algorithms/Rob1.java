package leetcode.algorithms;

/**
 * Description: 213. House Robber II
 *
 * @author Baltan
 * @date 2019-06-08 09:23
 * @see Rob
 * @see Rob2
 */
public class Rob1 {
    public static void main(String[] args) {
        System.out.println(rob(new int[]{2, 3, 2}));
        System.out.println(rob(new int[]{1, 2, 3, 1}));
        System.out.println(rob(new int[]{0, 0}));
        System.out.println(rob(new int[]{1, 3, 1, 3, 100}));
    }

    public static int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return nums[0];
        }

        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        /**
         * 因为所有房子排成一个环状，所以第一间房屋和最后一件房屋不可能同时选中，考虑不包含第一件房屋和最后一间房
         * 屋的两种情况
         */
        int length = nums.length - 1;
        /**
         * dp1[i]为到nums[i]为止可以获得的最高金额（不包括最后一间房屋）
         */
        int[] dp1 = new int[length];
        /**
         * dp2[i]为到nums[i+1]为止可以获得的最高金额（不包括第一间房屋）
         */
        int[] dp2 = new int[length];
        dp1[0] = nums[0];
        dp1[1] = Math.max(nums[0], nums[1]);
        dp2[0] = nums[1];
        dp2[1] = Math.max(nums[1], nums[2]);

        for (int i = 2; i < length; i++) {
            dp1[i] = Math.max(dp1[i - 2] + nums[i], dp1[i - 1]);
            dp2[i] = Math.max(dp2[i - 2] + nums[i + 1], dp2[i - 1]);
        }
        return Math.max(dp1[length - 1], dp2[length - 1]);
    }
}
