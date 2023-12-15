package leetcode.algorithms;

import leetcode.util.OutputUtils;

/**
 * Description: 2956. Find Common Elements Between Two Arrays
 *
 * @author Baltan
 * @date 2023/12/10 19:43
 */
public class FindIntersectionValues {
    public static void main(String[] args) {
        OutputUtils.print1DIntegerArray(findIntersectionValues(new int[]{4, 3, 2, 3, 1}, new int[]{2, 2, 5, 2, 3, 6}));
        OutputUtils.print1DIntegerArray(findIntersectionValues(new int[]{3, 4, 2, 3}, new int[]{1, 5}));
    }

    public static int[] findIntersectionValues(int[] nums1, int[] nums2) {
        int[] result = new int[2];
        /**
         * 根据题意，数组nums1和nums2中的元素∈[1,100]
         */
        int length = 101;
        /**
         * counts1[i]表示数组nums1中元素i的个数
         */
        int[] counts1 = new int[length];
        /**
         * counts2[i]表示数组nums2中元素i的个数
         */
        int[] counts2 = new int[length];

        for (int num : nums1) {
            counts1[num]++;
        }

        for (int num : nums2) {
            counts2[num]++;
        }

        for (int i = 1; i < length; i++) {
            /**
             * 对在数组nums1和nums2中都出现过的元素进行计数
             */
            if (counts1[i] > 0 && counts2[i] > 0) {
                result[0] += counts1[i];
                result[1] += counts2[i];
            }
        }
        return result;
    }
}
