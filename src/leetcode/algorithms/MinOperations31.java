package leetcode.algorithms;

/**
 * Description: 3724. Minimum Operations to Transform Array
 *
 * @author baltan
 * @date 2026/1/13 16:54
 */
public class MinOperations31 {
    public static void main(String[] args) {
        System.out.println(minOperations(new int[]{753, 357}, new int[]{271, 520, 413}));
        System.out.println(minOperations(new int[]{2, 8}, new int[]{1, 7, 3}));
        System.out.println(minOperations(new int[]{1, 3, 6}, new int[]{2, 4, 5, 3}));
        System.out.println(minOperations(new int[]{2}, new int[]{3, 4}));
    }

    public static long minOperations(int[] nums1, int[] nums2) {
        long result = 0L;
        int length = nums1.length;
        int end = nums2[length];
        /**
         * 将nums1[i]转换为nums2[i]过程中得到的数字转换为end的最小操作数
         */
        int minDiff = Integer.MAX_VALUE;

        for (int i = 0; i < length; i++) {
            if (nums1[i] < end && nums2[i] < end) {
                /**
                 * 因为nums1[i]转换为nums2[i]的过程中的所有数字都小于end，所以过程中的最大值转换为end的操作数最小
                 */
                minDiff = Math.min(minDiff, end - Math.max(nums1[i], nums2[i]));
            } else if (nums1[i] > end && nums2[i] > end) {
                /**
                 * 因为nums1[i]转换为nums2[i]的过程中的所有数字都大于end，所以过程中的最小值转换为end的操作数最小
                 */
                minDiff = Math.min(minDiff, Math.min(nums1[i], nums2[i]) - end);
            } else {
                /**
                 * 因为nums1[i]转换为nums2[i]的过程中能够得到数字end，此时直接将该数字追加到数组nums1的末尾即可
                 */
                minDiff = 0;
            }
            /**
             * 将nums1[i]转换为nums2[i]的最小操作数
             */
            result += Math.abs(nums1[i] - nums2[i]);
        }
        return result + minDiff + 1;
    }
}
