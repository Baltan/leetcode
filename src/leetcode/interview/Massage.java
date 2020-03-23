package leetcode.interview;

/**
 * Description: 面试题 17.16. 按摩师
 *
 * @author Baltan
 * @date 2020-03-24 00:34
 */
public class Massage {
    public static void main(String[] args) {
        System.out.println(massage(new int[]{1, 2, 3, 1}));
        System.out.println(massage(new int[]{2, 7, 9, 3, 1}));
        System.out.println(massage(new int[]{2, 1, 4, 5, 3, 1, 1, 3}));
    }

    public static int massage(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return nums[0];
        }

        int length = nums.length;
        int[] dp = new int[length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[length - 1];
    }
}
