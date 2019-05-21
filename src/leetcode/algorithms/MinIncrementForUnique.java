package leetcode.algorithms;

import java.util.Arrays;

/**
 * Description: 945. Minimum Increment to Make Array Unique
 *
 * @author Baltan
 * @date 2019-05-03 00:10
 */
public class MinIncrementForUnique {
    public static void main(String[] args) {
        System.out.println(minIncrementForUnique(new int[]{1, 2, 2}));
        System.out.println(minIncrementForUnique(new int[]{3, 2, 1, 2, 1, 7}));
    }

    public static int minIncrementForUnique(int[] A) {
        int result = 0;
        int length = A.length;
        Arrays.sort(A);

        for (int i = 1; i < length; i++) {
            if (A[i] <= A[i - 1]) {
                result += A[i - 1] + 1 - A[i];
                A[i] = A[i - 1] + 1;
            }
        }
        return result;
    }
}
