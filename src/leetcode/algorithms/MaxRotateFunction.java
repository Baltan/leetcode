package leetcode.algorithms;

import java.util.Arrays;

/**
 * Description: Rotate Function
 *
 * @author Baltan
 * @date 2019-04-12 10:43
 */
public class MaxRotateFunction {
    public static void main(String[] args) {
        System.out.println(maxRotateFunction(new int[]{4, 3, 2, 6}));
    }

    public static int maxRotateFunction(int[] A) {
        int sum = Arrays.stream(A).sum();
        int max = Integer.MIN_VALUE;
        int length = A.length;
        int value = 0;

        for (int i = 0; i < length; i++) {
            value += (i * A[i]);
        }

        max = Math.max(value, max);

        for (int i = 1; i < length; i++) {
            value = value + sum - length * A[length - i];
            max = Math.max(value, max);
        }
        return max;
    }
}
