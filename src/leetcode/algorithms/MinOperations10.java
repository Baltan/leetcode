package leetcode.algorithms;

/**
 * Description: 2541. Minimum Operations to Make Array Equal II
 *
 * @author Baltan
 * @date 2023/1/24 14:22
 */
public class MinOperations10 {
    public static void main(String[] args) {
        System.out.println(minOperations(new int[]{1, 2, 3, 4}, new int[]{1, 2, 3, 4}, 0));
        System.out.println(minOperations(new int[]{2, 4}, new int[]{4, 2}, 2));
        System.out.println(minOperations(new int[]{4, 3, 1, 4}, new int[]{1, 3, 7, 1}, 3));
        System.out.println(minOperations(new int[]{3, 8, 5, 2}, new int[]{2, 4, 1, 6}, 1));
    }

    public static long minOperations(int[] nums1, int[] nums2, int k) {
        int length = nums1.length;
        /**
         * nums1中元素变为nums2中的元素需要加k操作的次数
         */
        long incrementCount = 0L;
        /**
         * nums1中元素变为nums2中的元素需要减k操作的次数
         */
        long decrementCount = 0L;

        for (int i = 0; i < length; i++) {
            /**
             * 不需要进行操作
             */
            if (nums1[i] == nums2[i]) {
                continue;
            }
            /**
             * nums1[i]无法变为nums2[i]
             */
            if (k == 0 || (nums1[i] - nums2[i]) % k != 0) {
                return -1L;
            }

            if (nums1[i] < nums2[i]) {
                incrementCount += (nums2[i] - nums1[i]) / k;
            } else if (nums1[i] > nums2[i]) {
                decrementCount += (nums1[i] - nums2[i]) / k;
            }
        }
        return incrementCount == decrementCount ? incrementCount : -1;
    }
}
