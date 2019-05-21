package leetcode.algorithms;

import leetcode.util.OutputUtils;

import java.util.Arrays;

/**
 * Description: 977. Squares of a Sorted Array
 *
 * @author Baltan
 * @date 2019-03-12 09:54
 */
public class SortedSquares {
    public static void main(String[] args) {
        OutputUtils.print1DIntegerArray(sortedSquares(new int[]{-4, -1, 0, 3, 10}));
        OutputUtils.print1DIntegerArray(sortedSquares(new int[]{-7, -3, 2, 3, 11}));
        OutputUtils.print1DIntegerArray(sortedSquares(new int[]{-5, -4, -3, -2, -1}));
        OutputUtils.print1DIntegerArray(sortedSquares(new int[]{0, 1, 2, 3, 4}));
    }

    public static int[] sortedSquares(int[] A) {
        int length = A.length;
        int[] result = new int[length];

        if (A[0] >= 0) {
            int[] array = Arrays.stream(A).map(v -> v * v).toArray();
            for (int i = 0; i < length; i++) {
                result[i] = array[i];
            }
            return result;
        } else if (A[length - 1] <= 0) {
            int[] array = Arrays.stream(A).map(v -> v * v).toArray();
            for (int i = 0; i < length; i++) {
                result[i] = array[length - 1 - i];
            }
            return result;
        } else {
            int lo = 0;
            int hi = length - 1;
            int index = 0;

            for (int i = 0; i < length; i++) {
                if (A[i] == 0 || (A[i] < 0 && A[i + 1] > 0)) {
                    lo = i;
                    hi = i + 1;
                    break;
                }
            }
            while (lo >= 0 && hi < length) {
                int num1 = A[lo];
                int num2 = A[hi];

                if (num1 * num1 <= num2 * num2) {
                    result[index] = num1 * num1;
                    lo--;
                } else {
                    result[index] = num2 * num2;
                    hi++;
                }
                index++;
            }
            if (lo < 0) {
                for (int i = hi; i < length; i++) {
                    result[index] = A[i] * A[i];
                    index++;
                }
            } else {
                for (int i = lo; i >= 0; i--) {
                    result[index] = A[i] * A[i];
                    index++;
                }
            }
        }
        return result;
    }
}
