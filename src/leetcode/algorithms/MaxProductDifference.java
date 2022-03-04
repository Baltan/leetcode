package leetcode.algorithms;

/**
 * Description: 1913. Maximum Product Difference Between Two Pairs
 *
 * @author Baltan
 * @date 2022/3/4 11:47
 */
public class MaxProductDifference {
    public static void main(String[] args) {
        System.out.println(maxProductDifference(new int[]{5, 6, 2, 7, 4}));
        System.out.println(maxProductDifference(new int[]{4, 2, 5, 9, 7, 4, 8}));
    }

    public static int maxProductDifference(int[] nums) {
        /**
         * 数组nums中最大的数
         */
        int max1 = Integer.MIN_VALUE;
        /**
         * 数组nums中第二大的数
         */
        int max2 = Integer.MIN_VALUE;
        /**
         * 数组nums中最小的数
         */
        int min1 = Integer.MAX_VALUE;
        /**
         * 数组nums中第二小的数
         */
        int min2 = Integer.MAX_VALUE;
        /**
         * 数组nums中最大的数的索引
         */
        int max1Index = -1;
        /**
         * 数组nums中最小的数的索引
         */
        int min1Index = -1;
        /**
         * 查找最大的数和最小的数
         */
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max1) {
                max1 = nums[i];
                max1Index = i;
            }

            if (nums[i] < min1) {
                min1 = nums[i];
                min1Index = i;
            }
        }
        /**
         * 查找第二大的数和第二小的数
         */
        for (int i = 0; i < nums.length; i++) {
            if (i != max1Index && i != min1Index) {
                if (nums[i] > max2) {
                    max2 = nums[i];
                }

                if (nums[i] < min2) {
                    min2 = nums[i];
                }
            }
        }
        return max1 * max2 - min1 * min2;
    }
}
