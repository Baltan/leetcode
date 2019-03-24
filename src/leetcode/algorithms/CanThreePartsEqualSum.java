package leetcode.algorithms;

import java.util.Arrays;

/**
 * Description: Partition Array Into Three Parts With Equal Sum
 *
 * @author Baltan
 * @date 2019-03-24 12:09
 */
public class CanThreePartsEqualSum {
    public static void main(String[] args) {
        System.out.println(canThreePartsEqualSum(new int[]{0, 2, 1, -6, 6, -7, 9, 1, 2, 0, 1}));
        System.out.println(canThreePartsEqualSum(new int[]{0, 2, 1, -6, 6, 7, 9, -1, 2, 0, 1}));
        System.out.println(canThreePartsEqualSum(new int[]{3, 3, 6, 5, -2, 2, 5, 1, -9, 4}));
        System.out.println(canThreePartsEqualSum(new int[]{1, 1, 1}));
    }

    public static boolean canThreePartsEqualSum(int[] A) {
        if (A == null || A.length < 3) {
            return false;
        }

        int sum = Arrays.stream(A).sum();

        if (sum % 3 != 0) {
            return false;
        }

        int length = A.length;
        int partitionSum = sum / 3;
        int index = 0;
        int sum1 = A[index++];

        while (sum1 != partitionSum) {
            if (index == length) {
                return false;
            }
            sum1 += A[index++];
        }

        if (index == length) {
            return false;
        }

        int sum2 = A[index++];

        while (sum2 != partitionSum) {
            if (index == length) {
                return false;
            }
            sum2 += A[index++];
        }

        if (index == length) {
            return false;
        }

        int sum3 = 0;

        for (int i = index; i < length; i++) {
            sum3 += A[i];
        }
        return sum3 == partitionSum;
    }
}
