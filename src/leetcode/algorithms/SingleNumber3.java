package leetcode.algorithms;

import leetcode.util.OutputUtils;

/**
 * Description: 260. Single Number III
 *
 * @author Baltan
 * @date 2018/8/13 09:59
 */
public class SingleNumber3 {
    public static void main(String[] args) {
        OutputUtils.print1DIntegerArray(singleNumber(new int[]{1, 2, 1, 3, 2, 5}));
        OutputUtils.print1DIntegerArray(singleNumber(new int[]{2, 1}));
        OutputUtils.print1DIntegerArray(singleNumber(new int[]{2, 1, 2, 3, 6, 3, 7, 7}));
        OutputUtils.print1DIntegerArray(singleNumber(new int[]{2, 1, 2, 3, 6, 3, 7, 6}));
    }

    public static int[] singleNumber(int[] nums) {
        if (nums == null) {
            return null;
        }
        int[] result = new int[2];
        int value = 0;

        for (int num : nums) {
            value ^= num;
        }

        /**
         * 保留value二进制表示的最右边的1，其他变为0
         */
        value &= -value;

        for (int num : nums) {
            if ((value & num) == 0) {
                result[0] ^= num;
            } else {
                result[1] ^= num;
            }
        }
        return result;
    }
}
