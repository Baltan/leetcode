package leetcode.algorithms;

import leetcode.util.OutputUtils;

/**
 * Description: 2670. Find the Distinct Difference Array
 *
 * @author Baltan
 * @date 2023/5/7 19:19
 */
public class DistinctDifferenceArray {
    public static void main(String[] args) {
        OutputUtils.print1DIntegerArray(distinctDifferenceArray(new int[]{1, 2, 3, 4, 5}));
        OutputUtils.print1DIntegerArray(distinctDifferenceArray(new int[]{3, 2, 3, 4, 2}));
    }

    public static int[] distinctDifferenceArray(int[] nums) {
        int[] result = new int[nums.length];
        int length = nums.length;

        for (int i = 0; i < length; i++) {
            /**
             * 根据题意，nums[x]∈[1,50]，所以可以用64位长整形表示前缀和后缀数组中是否存在某个数字，prefix和suffix二进制值从低到高第m位的
             * 值为1就说明对应数组中存在数字m
             */
            long prefix = 0L;
            long suffix = 0L;
            /**
             * 记录前缀数组中的数字
             */
            for (int j = 0; j <= i; j++) {
                prefix |= (1L << nums[j]);
            }
            /**
             * 记录后缀数组中的数字
             */
            for (int j = i + 1; j < length; j++) {
                suffix |= (1L << nums[j]);
            }
            result[i] = Long.bitCount(prefix) - Long.bitCount(suffix);
        }
        return result;
    }
}
