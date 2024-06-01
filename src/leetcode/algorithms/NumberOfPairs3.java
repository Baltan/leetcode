package leetcode.algorithms;

/**
 * Description: 3162. Find the Number of Good Pairs I
 *
 * @author Baltan
 * @date 2024/5/30 22:22
 * @see NumberOfPairs4
 */
public class NumberOfPairs3 {
    public static void main(String[] args) {
        System.out.println(numberOfPairs(new int[]{2, 18, 2, 14}, new int[]{3, 4, 1, 11}, 2));
        System.out.println(numberOfPairs(new int[]{1, 3, 4}, new int[]{1, 3, 4}, 1));
        System.out.println(numberOfPairs(new int[]{1, 2, 4, 12}, new int[]{2, 4}, 3));
    }

    public static int numberOfPairs(int[] nums1, int[] nums2, int k) {
        int result = 0;
        /**
         * 两两组合判断是否是好数对
         */
        for (int i : nums1) {
            for (int j : nums2) {
                if (i % (j * k) == 0) {
                    result++;
                }
            }
        }
        return result;
    }
}
