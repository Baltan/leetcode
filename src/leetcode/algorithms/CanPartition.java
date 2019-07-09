package leetcode.algorithms;

/**
 * Description: 416. Partition Equal Subset Sum
 *
 * @author Baltan
 * @date 2019-07-09 19:47
 */
public class CanPartition {
    public static void main(String[] args) {
        int[] nums1 = {1, 5, 11, 5};
        System.out.println(canPartition(nums1));

        int[] nums2 = {1, 2, 3, 5};
        System.out.println(canPartition(nums2));

        int[] nums3 = {1, 2, 5};
        System.out.println(canPartition(nums3));
    }

    public static boolean canPartition(int[] nums) {
        int sum = 0;

        for (int num : nums) {
            sum += num;
        }

        if ((sum & 1) == 1) {
            return false;
        }

        int target = sum >> 1;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;

        for (int num : nums) {
            for (int i = target; i >= num; i--) {
                if (dp[i - num]) {
                    dp[i] = true;
                }
            }
        }
        return dp[target];
    }
}
