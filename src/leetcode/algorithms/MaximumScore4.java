package leetcode.algorithms;

/**
 * Description: 3788. Maximum Score of a Split
 *
 * @author baltan
 * @date 2026/2/10 11:07
 */
public class MaximumScore4 {
    public static void main(String[] args) {
        System.out.println(maximumScore(new int[]{10, -1, 3, -4, -5}));
        System.out.println(maximumScore(new int[]{-7, -5, 3}));
        System.out.println(maximumScore(new int[]{1, 1}));
    }

    public static long maximumScore(int[] nums) {
        long result = Long.MIN_VALUE;
        /**
         * 数组nums的前缀和数组
         */
        long[] prefixSums = new long[nums.length + 1];
        /**
         * 数组nums后缀子数组的最小值
         */
        int suffixMin = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            prefixSums[i + 1] = prefixSums[i] + nums[i];
        }

        for (int i = nums.length - 2; i >= 0; i--) {
            suffixMin = Math.min(suffixMin, nums[i + 1]);
            result = Math.max(result, prefixSums[i + 1] - suffixMin);
        }
        return result;
    }
}
