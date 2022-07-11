package leetcode.algorithms;

import java.util.Arrays;

/**
 * Description: 1775. Equal Sum Arrays With Minimum Number of Operations
 *
 * @author Baltan
 * @date 2022/7/10 12:37
 */
public class MinOperations5 {
    public static void main(String[] args) {
        System.out.println(minOperations(new int[]{1, 2, 3, 4, 5, 6}, new int[]{1, 1, 2, 2, 2, 2}));
        System.out.println(minOperations(new int[]{1, 1, 1, 1, 1, 1, 1}, new int[]{6}));
        System.out.println(minOperations(new int[]{6, 6}, new int[]{1}));
    }

    public static int minOperations(int[] nums1, int[] nums2) {
        /**
         * 如果较短数组的所有元素都变为6，较长数组的所有元素都变为1，较短数组元素之和仍小于较长数组元素之和，直接返回-1
         */
        if (nums1.length * 6 < nums2.length || nums2.length * 6 < nums1.length) {
            return -1;
        }
        int result = 0;
        int sum1 = Arrays.stream(nums1).sum();
        int sum2 = Arrays.stream(nums2).sum();
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        if (sum1 > sum2) {
            int diff = sum1 - sum2;
            /**
             * 指向nums1中的最大元素
             */
            int index1 = nums1.length - 1;
            /**
             * 指向nums2中的最小元素
             */
            int index2 = 0;
            /**
             * 每次操作将num1中的最大值变为1或者将nums2中的最小值变为6，取两者变化量较大的操作
             */
            while (diff > 0) {
                if (index2 < nums2.length && index1 > 0) {
                    if (6 - nums2[index2] >= nums1[index1] - 1) {
                        diff -= (6 - nums2[index2++]);
                    } else {
                        diff -= (nums1[index1--] - 1);
                    }
                } else if (index2 < nums2.length) {
                    diff -= (6 - nums2[index2++]);
                } else {
                    diff -= (nums1[index1--] - 1);
                }
                result++;
            }
        } else if (sum2 > sum1) {
            int diff = sum2 - sum1;
            /**
             * 指向nums1中的最小元素
             */
            int index1 = 0;
            /**
             * 指向nums2中的最大元素
             */
            int index2 = nums2.length - 1;
            /**
             * 每次操作将num2中的最大值变为1或者将nums1中的最小值变为6，取两者变化量较大的操作
             */
            while (diff > 0) {
                if (index1 < nums1.length && index2 > 0) {
                    if (6 - nums1[index1] >= nums2[index2] - 1) {
                        diff -= (6 - nums1[index1++]);
                    } else {
                        diff -= (nums2[index2--] - 1);
                    }
                } else if (index1 < nums1.length) {
                    diff -= (6 - nums1[index1++]);
                } else {
                    diff -= (nums2[index2--] - 1);
                }
                result++;
            }
        }
        return result;
    }
}
