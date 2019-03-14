package leetcode.algorithms;

import leetcode.util.OutputUtils;

/**
 * Description: Sort Array By Parity II
 *
 * @author Baltan
 * @date 2019-03-14 14:11
 */
public class SortArrayByParityII {
    public static void main(String[] args) {
        int[] A1 = {4, 2, 5, 7};
        OutputUtils.print1DIntegerArray(sortArrayByParityII(A1));

        int[] A2 = {19, 18, 17, 16, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2};
        OutputUtils.print1DIntegerArray(sortArrayByParityII(A2));
    }

    public static int[] sortArrayByParityII(int[] A) {
        int length = A.length;
        int evenIndex = 0;
        int oddIndex = length - 1;

        for (int i = 0; i < length; i++) {
            if ((i & 1) == 0 && (A[i] & 1) == 1) {
                int temp = A[oddIndex];
                A[oddIndex] = A[i];
                A[i] = temp;
                i--;
                oddIndex -= 2;
            } else if ((i & 1) == 1 && (A[i] & 1) == 0) {
                int temp = A[evenIndex];
                A[evenIndex] = A[i];
                A[i] = temp;
                i--;
                evenIndex += 2;
            }
        }
        return A;
    }
}
