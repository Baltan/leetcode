package leetcode.algorithms;

import leetcode.util.OutputUtils;

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
        /**
         * 如果A中所有数字都不小于0，则A中的数字顺序平方后即可；如果A中所有数字都不大于0，则A中的数字倒序平
         * 方后即可；如果A中的数字有正有负，则找到A中第一个为0的位置，或者A中正负交界的位置，此时维护两个指
         * 针，分别向两端移动，将两个指针指向的值的平方较小的结果加入result即可
         */
        if (A[0] >= 0) {
            for (int i = 0; i < length; i++) {
                result[i] = A[i] * A[i];
            }
        } else if (A[length - 1] <= 0) {
            for (int i = 0; i < length; i++) {
                result[i] = A[length - 1 - i] * A[length - 1 - i];
            }
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

            while (lo >= 0 || hi < length) {
                if (lo >= 0 && hi < length) {
                    if (A[lo] * A[lo] <= A[hi] * A[hi]) {
                        result[index++] = A[lo] * A[lo];
                        lo--;
                    } else {
                        result[index++] = A[hi] * A[hi];
                        hi++;
                    }
                } else if (lo >= 0) {
                    while (lo >= 0) {
                        result[index++] = A[lo] * A[lo];
                        lo--;
                    }
                } else if (hi < length) {
                    while (hi < length) {
                        result[index++] = A[hi] * A[hi];
                        hi++;
                    }
                }
            }
        }
        return result;
    }
}
