package leetcode.algorithms;

/**
 * Description:Maximum Subarray
 * @author Baltan
 *
 * @date 2017/11/8 09:22
 */
public class MaxSubArray {
    public static void main(String[] args) {
        int[] nums1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int[] nums2 = {-1};
        System.out.println(maxSubArray(nums1));
        System.out.println(maxSubArray(nums2));
    }

    public static int maxSubArray(int[] nums) {
        int max = nums[0];
        int temp = 0;
        for (int i = 0; i < nums.length; i++) {
            temp = nums[i] + temp >= nums[i] ? nums[i] + temp : nums[i];
            max = max > temp ? max : temp;
        }
        return max;
    }
}
