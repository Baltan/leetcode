package leetcode.algorithms;

/**
 * Description: 3131. Find the Integer Added to Array I
 *
 * @author Baltan
 * @date 2024/5/4 15:23
 * @see MinimumAddedInteger
 */
public class AddedInteger {
    public static void main(String[] args) {
        System.out.println(addedInteger(new int[]{2, 6, 4}, new int[]{9, 7, 5}));
        System.out.println(addedInteger(new int[]{10}, new int[]{5}));
        System.out.println(addedInteger(new int[]{1, 1, 1, 1}, new int[]{1, 1, 1, 1}));
    }

    public static int addedInteger(int[] nums1, int[] nums2) {
        /**
         * 数组nums1中的最小值
         */
        int min1 = Integer.MAX_VALUE;
        /**
         * 数组nums2中的最小值
         */
        int min2 = Integer.MAX_VALUE;

        for (int i = 0; i < nums1.length; i++) {
            min1 = Math.min(min1, nums1[i]);
            min2 = Math.min(min2, nums2[i]);
        }
        return min2 - min1;
    }
}
