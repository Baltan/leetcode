package leetcode.interview;

import leetcode.util.OutputUtils;

/**
 * Description: 面试题56 - I. 数组中数字出现的次数
 *
 * @author Baltan
 * @date 2020-04-28 08:03
 * @see leetcode.algorithms.SingleNumber1
 * @see leetcode.algorithms.SingleNumber
 * @see leetcode.algorithms.SingleNumber2
 * @see leetcode.algorithms.SingleNumber3
 * @see leetcode.algorithms.SingleNumber4
 */
public class SingleNumbers {
    public static void main(String[] args) {
        OutputUtils.print1DIntegerArray(singleNumber(new int[]{1, 2, 1, 3, 2, 5}));
        OutputUtils.print1DIntegerArray(singleNumber(new int[]{2, 1}));
        OutputUtils.print1DIntegerArray(singleNumber(new int[]{2, 1, 2, 3, 6, 3, 7, 7}));
        OutputUtils.print1DIntegerArray(singleNumber(new int[]{2, 1, 2, 3, 6, 3, 7, 6}));
        OutputUtils.print1DIntegerArray(singleNumber(new int[]{4, 1, 4, 6}));
        OutputUtils.print1DIntegerArray(singleNumber(new int[]{1, 2, 10, 4, 1, 4, 3, 3}));
    }

    /**
     * 参考：
     * <a href="https://leetcode-cn.com/problems/single-number-iii/solution/lowbitpan-duan-dang-qian-shu-zi-shu-yu-na-yi-ge-zu/"></a>
     *
     * @param nums
     * @return
     */
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
         * 保留value二进制表示的最右边的1，其他变为0，只出现1次的两个数在这位上肯定不同，否则在这位上会
         * 有偶数个1，偶数个1相互异或后的值应该为0
         */
        value &= -value;
        /**
         * 将这位为0的所有数相互异或，将这位为1的所有数相互异或，可以得到两个只出现1次的数
         */
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
