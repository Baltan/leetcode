package leetcode.algorithms;

import java.util.Arrays;

/**
 * Description: 3627. Maximum Median Sum of Subsequences of Size 3
 *
 * @author Baltan
 * @date 2025/8/24 19:57
 */
public class MaximumMedianSum {
    public static void main(String[] args) {
        System.out.println(maximumMedianSum(new int[]{2, 1, 3, 2, 1, 3}));
        System.out.println(maximumMedianSum(new int[]{1, 1, 10, 10, 10, 10}));
    }

    public static long maximumMedianSum(int[] nums) {
        long result = 0L;
        /**
         * 升序排列数组nums中，中位数的索引
         */
        int mid = nums.length - 2;
        Arrays.sort(nums);
        /**
         * 对于数组nums中剩余所有数字而言，最大值和最小值是不可能成为中位数的，根据贪心思想，选择除这两个数字外的最大值作为中位数，和最大值、
         * 最小值构成一个三元组即可。以此类推直到所有数字都被使用
         */
        for (int i = 0; i < nums.length / 3; i++) {
            result += nums[mid];
            mid -= 2;
        }
        return result;
    }
}
