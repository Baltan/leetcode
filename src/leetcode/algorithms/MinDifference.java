package leetcode.algorithms;

import java.util.Arrays;

/**
 * Description: 1509. Minimum Difference Between Largest and Smallest Value in Three Moves
 *
 * @author Baltan
 * @date 2020-07-15 21:45
 */
public class MinDifference {
    public static void main(String[] args) {
        System.out.println(minDifference(new int[]{5, 3, 2, 4}));
        System.out.println(minDifference(new int[]{1, 5, 0, 10, 14}));
        System.out.println(minDifference(new int[]{6, 6, 0, 1, 1, 4, 6}));
        System.out.println(minDifference(new int[]{1, 5, 6, 14, 15}));
    }

    public static int minDifference(int[] nums) {
        int length = nums.length;
        /**
         * 如果数组中的数字不超过四个，则一定可以使得数组中的所有数字变为同一个值，返回0
         */
        if (length <= 4) {
            return 0;
        }

        int result = Integer.MAX_VALUE;
        Arrays.sort(nums);
        /**
         * 我们总是将排序后数组两端的数字修改掉向中间的数字靠拢才能减小数组中最大值和最小值的差，相当于删除掉三个数字
         * 后使得数组中剩余数字的最大值和最小值的差尽可能小，有四种情况：删除掉最小的三个数、删除掉最小的两个数和最大
         * 的一个数、删除掉最小的一个数和最大的两个数、删除掉最大的三个数，在这四种情况中取最小的差值即可
         */
        result = Math.min(result, nums[length - 1] - nums[3]);
        result = Math.min(result, nums[length - 2] - nums[2]);
        result = Math.min(result, nums[length - 3] - nums[1]);
        result = Math.min(result, nums[length - 4] - nums[0]);
        return result;
    }
}
