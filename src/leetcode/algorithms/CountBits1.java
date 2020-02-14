package leetcode.algorithms;

import leetcode.util.OutputUtils;

/**
 * Description: 338. Counting Bits
 *
 * @author Baltan
 * @date 2020-02-14 19:58
 */
public class CountBits1 {
    public static void main(String[] args) {
        OutputUtils.print1DIntegerArray(countBits(5));
        OutputUtils.print1DIntegerArray(countBits(0));
    }

    public static int[] countBits(int num) {
        int[] result = new int[num + 1];
        /**
         * n的二进制表示总是比n&(n-1)的二进制表示多一个"1"，例如：n=216，则n的二进制表示为
         * 11011000，共4个"1"。n&(n-1)的二进制表示为11011000&(1101100-1)=11011000&1101011
         * =1101000，共3个"1"
         */
        for (int i = 1; i <= num; i++) {
            result[i] = result[i & (i - 1)] + 1;
        }
        return result;
    }
}
