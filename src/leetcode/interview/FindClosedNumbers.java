package leetcode.interview;

import leetcode.util.OutputUtils;

/**
 * Description: 面试题 05.04. 下一个数
 *
 * @author Baltan
 * @date 2020-03-15 12:33
 */
public class FindClosedNumbers {
    public static void main(String[] args) {
        OutputUtils.print1DIntegerArray(findClosedNumbers(0b10));
        OutputUtils.print1DIntegerArray(findClosedNumbers(0b1));
        OutputUtils.print1DIntegerArray(findClosedNumbers(0b111));
        OutputUtils.print1DIntegerArray(findClosedNumbers(0b1100011));
        OutputUtils.print1DIntegerArray(findClosedNumbers(0b111000101));
        OutputUtils.print1DIntegerArray(findClosedNumbers(0b1010011010011110));
        OutputUtils.print1DIntegerArray(findClosedNumbers(0b1111111111111111111111111111111));
    }

    public static int[] findClosedNumbers(int num) {
        int[] result = {-1, -1};
        /**
         * 将num的二进制表示放入一个长度为32的数组
         */
        int[] bits = new int[32];
        int index = 31;
        int value = num;

        while (value > 0) {
            bits[index--] = value & 1;
            value >>= 1;
        }
        /**
         * 对于比num略大的数，从低位向高位遍历，找到第一次出现bits[i]=1并且bits[i-1]=0的地方，将bits[i-1]
         * 改为0，bits[i]改为0，并将bits[i+1]-bits[31]中的1尽可能向低位靠拢。
         * 例如：0b101111000改为0b110000111
         */
        for (int i = 31; i > 1; i--) {
            if (bits[i] == 1 && bits[i - 1] == 0) {
                value = num;
                /**
                 * 将bits[i-1]改为0，bits[i]改为0
                 */
                value = value - (1 << (31 - i)) + (1 << (32 - i));
                /**
                 * bits[i+1]-bits[31]中1的个数
                 */
                int count = 0;

                for (int j = 31; j > i; j--) {
                    if (bits[j] == 1) {
                        count++;
                        /**
                         * 先将bits[i+1]-bits[31]中的1改为0
                         */
                        value -= 1 << (31 - j);
                    }
                }
                /**
                 * 从最低位开始向高位方向增加count个1
                 */
                for (int j = 0; j < count; j++) {
                    value += 1 << j;
                }
                result[0] = value;
                break;
            }
        }
        /**
         * 对于比num略小的数，从低位向高位遍历，找到第一次出现bits[i]=1并且bits[i+1]=0的地方，将bits[i]-
         * bits[31]中的1尽可能向bit[i+1]靠拢。
         * 例如：0b101000111改为0b100111100
         */
        for (int i = 30; i > 0; i--) {
            if (bits[i] == 1 && bits[i + 1] == 0) {
                value = num;
                /**
                 * bits[i]-bits[31]中1的个数
                 */
                int count = 0;

                for (int j = 31; j >= i; j--) {
                    if (bits[j] == 1) {
                        count++;
                        /**
                         * 先将bits[i]-bits[31]中的1改为0
                         */
                        value -= 1 << (31 - j);
                    }
                }
                /**
                 * 从bits[i+1]开始向低位方向增加count个1
                 */
                for (int j = 0; j < count; j++) {
                    value += 1 << (30 - i++);
                }
                result[1] = value;
                break;
            }
        }
        return result;
    }
}
