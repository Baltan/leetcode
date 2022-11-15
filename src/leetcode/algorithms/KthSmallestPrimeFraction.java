package leetcode.algorithms;

import leetcode.util.OutputUtils;

import java.util.Arrays;

/**
 * Description: 786. K-th Smallest Prime Fraction
 *
 * @author Baltan
 * @date 2022/11/14 18:34
 * @see KthSmallestPrimeFraction1
 */
public class KthSmallestPrimeFraction {
    public static void main(String[] args) {
        OutputUtils.print1DIntegerArray(kthSmallestPrimeFraction(new int[]{1, 2, 3, 5}, 3));
        OutputUtils.print1DIntegerArray(kthSmallestPrimeFraction(new int[]{1, 7}, 1));
    }

    public static int[] kthSmallestPrimeFraction(int[] arr, int k) {
        int length = arr.length;
        /**
         * 总共可以构成的分数个数
         */
        int total = length * (length - 1) / 2;
        /**
         * fractions[i]表示第i个分数
         */
        int[][] fractions = new int[total][2];
        int index = 0;

        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                fractions[index++] = new int[]{arr[i], arr[j]};
            }
        }
        /**
         * 将所有分数升序排列
         */
        Arrays.sort(fractions, (x, y) -> x[0] * y[1] - y[0] * x[1]);
        return fractions[k - 1];
    }
}
