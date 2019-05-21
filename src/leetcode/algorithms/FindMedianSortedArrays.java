package leetcode.algorithms;

import java.util.Arrays;

/**
 * Description: 4. Median of Two Sorted Arrays
 *
 * @author Baltan
 * @date 2018/1/12 09:53
 */
public class FindMedianSortedArrays {
    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[]{1, 3}, new int[]{2}));
        System.out.println(findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1 == null) {
            return nums2.length % 2 == 0 ? (nums2[nums2.length / 2 - 1] + nums2[nums2.length / 2]) / 2.0 :
                    nums2[nums2.length / 2] / 1.0;
        }
        if (nums2 == null) {
            return nums1.length % 2 == 0 ? (nums1[nums1.length / 2 - 1] + nums1[nums1.length / 2]) / 2.0 :
                    nums1[nums1.length / 2] / 1.0;
        }
        int nums1Length = nums1.length;
        int nums2Length = nums2.length;
        int numsLength = nums1Length + nums2Length;
        int[] nums = new int[nums1Length + nums2Length];
        for (int i = 0; i < numsLength; i++) {
            if (i < nums1Length) {
                nums[i] = nums1[i];
            } else {
                nums[i] = nums2[i - nums1Length];
            }
        }
        Arrays.sort(nums);
        double median =
                numsLength % 2 == 0 ? (nums[numsLength / 2 - 1] + nums[numsLength / 2]) / 2.0 : nums[numsLength / 2] / 1.0;
        return median;
    }
}
