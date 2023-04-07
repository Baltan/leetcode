package leetcode.algorithms;

import java.util.Arrays;

/**
 * Description: 2605. Form Smallest Number From Two Digit Arrays
 *
 * @author Baltan
 * @date 2023/4/2 21:30
 */
public class MinNumber {
    public static void main(String[] args) {
        System.out.println(minNumber(new int[]{4, 1, 3}, new int[]{5, 7}));
        System.out.println(minNumber(new int[]{3, 5, 2, 6}, new int[]{3, 1, 7}));
    }

    public static int minNumber(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        int index1 = 0;
        int index2 = 0;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        /**
         * 双指针从小到大查找数组nums1和nums2中是否有相同的数字，如果有，则第一个找到的数字就是所求最小数字
         */
        while (index1 < length1 && index2 < length2) {
            if (nums1[index1] == nums2[index2]) {
                return nums1[index1];
            } else if (nums1[index1] > nums2[index2]) {
                index2++;
            } else {
                index1++;
            }
        }
        /**
         * 从数组nums1和nums2中各取一个最小的数字，组成所求最小数字
         */
        return Math.min(nums1[0], nums2[0]) * 10 + Math.max(nums1[0], nums2[0]);
    }
}
