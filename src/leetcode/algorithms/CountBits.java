package leetcode.algorithms;

import leetcode.util.OutputUtils;

/**
 * Description: Counting Bits
 *
 * @author Baltan
 * @date 2018/1/11 10:45
 */
public class CountBits {
    public static void main(String[] args) {
        OutputUtils.print1DIntegerArray(countBits(5));
        OutputUtils.print1DIntegerArray(countBits(0));
    }

    public static int[] countBits(int num) {
        int[] arr = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            int bitCount = 0;
            int currentNum = i;
            while (currentNum > 0) {
                if ((currentNum & 1) == 1) {
                    bitCount++;
                }
                currentNum >>= 1;
            }
            arr[i] = bitCount;
        }
        return arr;
    }
}
