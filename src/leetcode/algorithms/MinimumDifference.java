package leetcode.algorithms;

import java.util.Arrays;

/**
 * Description: 1984. Minimum Difference Between Highest and Lowest of K Scores
 *
 * @author Baltan
 * @date 2022/1/20 16:38
 */
public class MinimumDifference {
    public static void main(String[] args) {
        System.out.println(minimumDifference(new int[]{90}, 1));
        System.out.println(minimumDifference(new int[]{9, 4, 1, 7}, 2));
    }

    public static int minimumDifference(int[] nums, int k) {
        int result = Integer.MAX_VALUE;
        Arrays.sort(nums);
        /**
         * 遍历所有可能的间隔为k-1的两个数的差，取最小值
         */
        for (int i = k - 1; i < nums.length; i++) {
            result = Math.min(result, nums[i] - nums[i - k + 1]);
        }
        return result;
    }
}
