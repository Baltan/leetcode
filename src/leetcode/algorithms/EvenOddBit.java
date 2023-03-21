package leetcode.algorithms;

import leetcode.util.OutputUtils;

/**
 * Description: 2595. Number of Even and Odd Bits
 *
 * @author Baltan
 * @date 2023/3/19 13:02
 */
public class EvenOddBit {
    public static void main(String[] args) {
        OutputUtils.print1DIntegerArray(evenOddBit(17));
        OutputUtils.print1DIntegerArray(evenOddBit(2));
    }

    public static int[] evenOddBit(int n) {
        int[] result = {0, 0};
        /**
         * 当前的二进制位是否是偶数索引的
         */
        boolean isEven = true;

        while (n > 0) {
            if ((n & 1) == 1) {
                if (isEven) {
                    result[0]++;
                } else {
                    result[1]++;
                }
            }
            isEven = !isEven;
            n >>= 1;
        }
        return result;
    }
}
