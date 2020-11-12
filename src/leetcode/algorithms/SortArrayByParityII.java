package leetcode.algorithms;

import leetcode.util.OutputUtils;

/**
 * Description: 922. Sort Array By Parity II
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

        for (int i = 0; i < length; ) {
            /**
             * 如果i为偶数但是A[i]为奇数，就把A[i]和A[oddIndex]交换位置，从而使得奇数A[i]放到了奇数
             * 索引位置oddIndex上；如果i为奇数但是A[i]为偶数，就把A[i]和A[evenIndex]交换位置，从而
             * 使得偶数A[i]放到了偶数索引位置evenIndex上；如果i和A[i]奇偶性相同，则已经符合题意，继
             * 续判断下一个数即可
             */
            if ((i & 1) == 0 && (A[i] & 1) == 1) {
                int temp = A[oddIndex];
                A[oddIndex] = A[i];
                A[i] = temp;
                oddIndex -= 2;
            } else if ((i & 1) == 1 && (A[i] & 1) == 0) {
                int temp = A[evenIndex];
                A[evenIndex] = A[i];
                A[i] = temp;
                evenIndex += 2;
            } else {
                i++;
            }
        }
        return A;
    }
}
