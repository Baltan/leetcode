package leetcode.algorithms;

/**
 * Description: 713. Subarray Product Less Than K
 *
 * @author Baltan
 * @date 2019-08-14 08:57
 */
public class NumSubarrayProductLessThanK {
    public static void main(String[] args) {
        int[] nums1 = {10, 5, 2, 6};
        System.out.println(numSubarrayProductLessThanK(nums1, 100));

        int[] nums2 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        System.out.println(numSubarrayProductLessThanK(nums2, 1000));

        int[] nums3 = {1, 2, 3};
        System.out.println(numSubarrayProductLessThanK(nums3, 0));
    }

    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        int result = 0;
        int maxProduct = 1;
        int length = nums.length;
        int left = 0;

        for (int right = 0; right < length; right++) {
            /**
             * 向右移动右指针一位后，总乘积乘以乘入当前右指针指向的的数字nums[right]
             */
            maxProduct *= nums[right];
            /**
             * 对于当前固定的右指针，查找可能的最左边的左指针，该区间内数字的乘积小于k，
             * 如果当前乘积不小于k，将左指针向右移动一位从而减小乘积
             */
            while (maxProduct >= k && left <= right) {
                maxProduct /= nums[left];
                left++;
            }
            /**
             * 查找到的左指针和右指针间，包含右指针指向的数字的所有子区间的数字的乘积都小于k
             */
            result += (right - left + 1);
        }
        return result;
    }
}
