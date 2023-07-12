package leetcode.algorithms;

/**
 * Description: 2771. Longest Non-decreasing Subarray From Two Arrays
 *
 * @author Baltan
 * @date 2023/7/11 15:15
 */
public class MaxNonDecreasingLength {
    public static void main(String[] args) {
        System.out.println(maxNonDecreasingLength(new int[]{2, 3, 1}, new int[]{1, 2, 1}));
        System.out.println(maxNonDecreasingLength(new int[]{1, 3, 2, 1}, new int[]{2, 2, 3, 4}));
        System.out.println(maxNonDecreasingLength(new int[]{1, 1}, new int[]{2, 2}));
        System.out.println(maxNonDecreasingLength(new int[]{1, 3, 5, 1, 2, 3, 4, 5, 6}, new int[]{1, 3, 5, 6, 2, 3, 4, 5, 6}));
    }

    public static int maxNonDecreasingLength(int[] nums1, int[] nums2) {
        int result = 1;
        int length = nums1.length;
        /**
         * dp[i][0]表示以nums1[i]结尾的非递减子数组的最大长度，dp[i][1]表示以nums2[i]结尾的非递减子数组的最大长度
         */
        int[][] dp = new int[length][2];
        /**
         * 第一个数字不管选nums1[0]还是nums2[0]都会得到长度为1的非递减子数组
         */
        dp[0][0] = 1;
        dp[0][1] = 1;

        for (int i = 1; i < length; i++) {
            /**
             * 如果以nums1[i]结尾，判断能否将nums1[i]接在nums1[i-1]或nums2[i-1]后面，如果可以的话选择此前更长的非递减子数组，在此基础
             * 上得到长度加1的非递减子数组，否则就得到一个以nums1[i]开头的长度为1的非递减子数组
             */
            dp[i][0] = Math.max(nums1[i] >= nums1[i - 1] ? dp[i - 1][0] + 1 : 1, nums1[i] >= nums2[i - 1] ? dp[i - 1][1] + 1 : 1);
            /**
             * 如果以nums2[i]结尾，判断能否将nums2[i]接在nums1[i-1]或nums2[i-1]后面，如果可以的话选择此前更长的非递减子数组，在此基础
             * 上得到长度加1的非递减子数组，否则就得到一个以nums2[i]开头的长度为1的非递减子数组
             */
            dp[i][1] = Math.max(nums2[i] >= nums1[i - 1] ? dp[i - 1][0] + 1 : 1, nums2[i] >= nums2[i - 1] ? dp[i - 1][1] + 1 : 1);
            /**
             * 更新此时已得到的非递减子数组的最大长度
             */
            result = Math.max(result, dp[i][0]);
            result = Math.max(result, dp[i][1]);
        }
        return result;
    }
}
