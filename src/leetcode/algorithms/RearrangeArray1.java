package leetcode.algorithms;

import leetcode.util.OutputUtils;

import java.util.Arrays;

/**
 * Description: 1968. Array With Elements Not Equal to Average of Neighbors
 *
 * @author Baltan
 * @date 2022/1/29 13:10
 */
public class RearrangeArray1 {
    public static void main(String[] args) {
        OutputUtils.print1DIntegerArray(rearrangeArray(new int[]{1, 2, 3, 4, 5}));
        OutputUtils.print1DIntegerArray(rearrangeArray(new int[]{6, 2, 0, 9, 7}));
    }

    public static int[] rearrangeArray(int[] nums) {
        int length = nums.length;
        int[] result = new int[length];
        Arrays.sort(nums);
        int index = 0;
        /**
         * 将排序后的nums中的元素先逐一放入result中索引为偶数的位置，到最后再从头开始将nums中剩余的元素放入result中索引为奇数
         * 的位置
         */
        for (int i = 0; i < length; i++) {
            result[index] = nums[i];
            index += 2;
            /**
             * 此时result中偶数索引位置都已填满，从头开始填充奇数索引位置
             */
            if (index >= length) {
                index = 1;
            }
        }
        return result;
    }
}
