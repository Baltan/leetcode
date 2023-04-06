package leetcode.algorithms;

/**
 * Description: 53. Maximum Subarray
 *
 * @author Baltan
 * @date 2017/11/8 09:22
 * @see leetcode.interview.MaxSubArray
 * @see MaxSubArray
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
