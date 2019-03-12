package leetcode.algorithms;

import leetcode.util.OutputUtils;

/**
 * Description: Sort Array By Parity
 *
 * @author Baltan
 * @date 2019-03-12 10:37
 */
public class SortArrayByParity {
    public static void main(String[] args) {
        OutputUtils.print1DIntegerArray(sortArrayByParity(new int[]{3, 1, 2, 4}));
    }

    public static int[] sortArrayByParity(int[] A) {
        int length = A.length;
        int lo = 0;
        int hi = length - 1;
        int[] result = new int[length];

        for (int i = 0; i < length; i++) {
            if ((A[i] & 1) == 1) {
                result[hi] = A[i];
                hi--;
            } else {
                result[lo] = A[i];
                lo++;
            }
        }
        return result;
    }
}
