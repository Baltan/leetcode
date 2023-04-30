package leetcode.algorithms;

import leetcode.util.OutputUtils;

/**
 * Description: 2657. Find the Prefix Common Array of Two Arrays
 *
 * @author Baltan
 * @date 2023/4/30 15:59
 */
public class FindThePrefixCommonArray {
    public static void main(String[] args) {
        int[] A1 = {1, 3, 2, 4};
        int[] B1 = {3, 1, 2, 4};
        OutputUtils.print1DIntegerArray(findThePrefixCommonArray(A1, B1));

        int[] A2 = {2, 3, 1};
        int[] B2 = {3, 1, 2};
        OutputUtils.print1DIntegerArray(findThePrefixCommonArray(A2, B2));
    }

    public static int[] findThePrefixCommonArray(int[] A, int[] B) {
        int length = A.length;
        int[] result = new int[length];
        /**
         * maskA从最低位到高位每个比特位为1依次表示数组A中数字[1,50]已出现过
         */
        long maskA = 0L;
        /**
         * maskB从最低位到高位每个比特位为1依次表示数组B中数字[1,50]已出现过
         */
        long maskB = 0L;

        for (int i = 0; i < length; i++) {
            /**
             * 标记数组A中出现过数字A[i]
             */
            maskA |= (1L << (A[i] - 1));
            /**
             * 标记数组B中出现过数字B[i]
             */
            maskB |= (1L << (B[i] - 1));
            /**
             * maskA&maskB的某一比特位为1表示数组A和B中都已出现过该位表示的数字
             */
            result[i] = Long.bitCount(maskA & maskB);
        }
        return result;
    }
}
