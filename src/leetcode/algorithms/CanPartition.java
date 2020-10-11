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
        /**
         * 如果所有元素的和为奇数，则无法完成分组
         */
        if ((sum & 1) == 1) {
            return false;
        }
        /**
         * 每个分组中所有元素的和
         */
        int target = sum >> 1;
        /**
         * dp[i]表示能否得到一个分组，使得所有元素的和为i
         */
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;

        for (int num : nums) {
            /**
             * 如果已经存在和为target-num的分组，则这个分组加上num后就能使得所有元素的和为target，完成分组
             */
            if (target - num >= 0 && dp[target - num]) {
                return true;
            }
            /**
             * 依次判断加上num后能否得到和为[num,target-1]的分组
             */
            for (int i = target - 1; i >= num; i--) {
                if (dp[i - num]) {
                    dp[i] = true;
                }
            }
        }
        return dp[target];
    }
}
