package leetcode.interview;

import leetcode.algorithms.MaximumsSplicedArray;

/**
 * Description: 面试题 16.17. 连续数列
 *
 * @author Baltan
 * @date 2020-04-08 21:40
 * @see leetcode.algorithms.MaxSubArray
 * @see leetcode.algorithms.MaximumCostSubstring
 * @see MaximumsSplicedArray
 */
public class MaxSubArray {
    public static void main(String[] args) {
        int[] nums1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int[] nums2 = {-1};
        System.out.println(maxSubArray(nums1));
        System.out.println(maxSubArray(nums2));
    }

    public static int maxSubArray(int[] nums) {
        int result = nums[0];
        /**
         * 当前子序列中所有数字的和
         */
        int temp = 0;

        for (int i = 0; i < nums.length; i++) {
            /**
             * 如果当前数字nums[i]加上它前面子序列中所有数字的和大于nums[i]，就继续扩展它前面的子序列，否则就
             * 从当前数字开始重新尝试扩展子序列
             */
            temp = Math.max(nums[i] + temp, nums[i]);
            result = Math.max(result, temp);
        }
        return result;
    }
}
