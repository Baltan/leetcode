package leetcode.algorithms;

import java.util.Arrays;

/**
 * Description: 2740. Find the Value of the Partition
 *
 * @author Baltan
 * @date 2023/6/18 12:49
 */
public class FindValueOfPartition {
    public static void main(String[] args) {
        System.out.println(findValueOfPartition(new int[]{1, 3, 2, 4}));
        System.out.println(findValueOfPartition(new int[]{100, 1, 10}));
    }

    public static int findValueOfPartition(int[] nums) {
        int result = Integer.MAX_VALUE;
        int length = nums.length;
        Arrays.sort(nums);
        /**
         * 在排序后的数组nums中，找到相邻两数之差最小的两个数字nums[i-1]和nums[i]，数字nums[0]、nums[1]、……、nums[i-1]放到数组nums1
         * 中，数字nums[i]、nums[i+1]、……、nums[length-1]放到数组nums2中
         */
        for (int i = 1; i < length; i++) {
            result = Math.min(result, nums[i] - nums[i - 1]);
        }
        return result;
    }
}
