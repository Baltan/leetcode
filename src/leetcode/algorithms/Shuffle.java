package leetcode.algorithms;

import leetcode.util.OutputUtils;

/**
 * Description: 1470. Shuffle the Array
 *
 * @author Baltan
 * @date 2022/11/1 14:09
 */
public class Shuffle {
    public static void main(String[] args) {
        OutputUtils.print1DIntegerArray(shuffle(new int[]{2, 5, 1, 3, 4, 7}, 3));
        OutputUtils.print1DIntegerArray(shuffle(new int[]{1, 2, 3, 4, 4, 3, 2, 1}, 4));
        OutputUtils.print1DIntegerArray(shuffle(new int[]{1, 1, 2, 2}, 2));
    }

    public static int[] shuffle(int[] nums, int n) {
        int length = 2 * n;
        int[] result = new int[length];
        /**
         * 原数组nums的前半部分元素在新数组的偶数索引位置上
         */
        for (int i = 0; i < n; i++) {
            result[i * 2] = nums[i];
        }
        /**
         * 原数组nums的后半部分元素在新数组的奇数索引位置上
         */
        for (int i = n; i < length; i++) {
            result[(i - n) * 2 + 1] = nums[i];
        }
        return result;
    }
}
