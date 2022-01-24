package leetcode.algorithms;

import leetcode.util.OutputUtils;

/**
 * Description: 2149. Rearrange Array Elements by Sign
 *
 * @author Baltan
 * @date 2022/1/24 10:08
 */
public class RearrangeArray {
    public static void main(String[] args) {
        OutputUtils.print1DIntegerArray(rearrangeArray(new int[]{3, 1, -2, -5, 2, -4}));
        OutputUtils.print1DIntegerArray(rearrangeArray(new int[]{-1, 1}));
        OutputUtils.print1DIntegerArray(rearrangeArray(new int[]{}));
    }

    public static int[] rearrangeArray(int[] nums) {
        int length = nums.length;
        int[] result = new int[length];
        /**
         * 查找正数的指针
         */
        int positivePointer = 0;
        /**
         * 查找负数的指针
         */
        int negativePointer = 0;
        int index = 0;

        while (index < length) {
            /**
             * 查找下一个正数
             */
            while (nums[positivePointer] < 0) {
                positivePointer++;
            }
            /**
             * 查找下一个负数
             */
            while (nums[negativePointer] > 0) {
                negativePointer++;
            }
            result[index++] = nums[positivePointer++];
            result[index++] = nums[negativePointer++];
        }
        return result;
    }
}
