package leetcode.algorithms;

import leetcode.util.OutputUtils;

/**
 * Description: 2177. Find Three Consecutive Integers That Sum to a Given Number
 *
 * @author Baltan
 * @date 2022/2/22 17:48
 */
public class SumOfThree {
    public static void main(String[] args) {
        OutputUtils.print1DLongArray(sumOfThree(33));
        OutputUtils.print1DLongArray(sumOfThree(4));
    }

    public static long[] sumOfThree(long num) {
        if (num % 3 != 0) {
            return new long[0];
        }

        long mid = num / 3;
        return new long[]{mid - 1, mid, mid + 1};
    }
}
