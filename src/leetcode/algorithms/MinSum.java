package leetcode.algorithms;

/**
 * Description: 2918. Minimum Equal Sum of Two Arrays After Replacing Zeros
 *
 * @author baltan
 * @date 2023/11/2 13:56
 */
public class MinSum {
    public static void main(String[] args) {
        System.out.println(minSum(new int[]{3, 2, 0, 1, 0}, new int[]{6, 5, 0}));
        System.out.println(minSum(new int[]{2, 0, 2, 0}, new int[]{1, 4}));
    }

    public static long minSum(int[] nums1, int[] nums2) {
        long sum1 = 0L;
        long sum2 = 0L;
        int zero1 = 0;
        int zero2 = 0;

        for (int num : nums1) {
            if (num == 0) {
                zero1++;
            } else {
                sum1 += num;
            }
        }

        for (int num : nums2) {
            if (num == 0) {
                zero2++;
            } else {
                sum2 += num;
            }
        }
        /**
         * 如果数组nums1中没有0并且数组nums2中所有0都替换为最小的正整数1后，nums2中元素的和仍大于nums1中元素的和，不可能使得两数组中元素
         * 之和相等；如果数组nums2中没有0并且数组nums1中所有0都替换为最小的正整数1后，nums1中元素的和仍大于nums2中元素的和，不可能使得两
         * 数组中元素之和相等。否则，考虑将两个数组中所有0都替换为1后，其中元素之和较小的数组可以把原来的0替换为更大的正整数，使得两数组元素
         * 之和相等
         */
        return (zero1 == 0 && sum2 + zero2 > sum1) || (zero2 == 0 && sum1 + zero1 > sum2) ? -1L : Math.max(sum1 + zero1, sum2 + zero2);
    }
}
