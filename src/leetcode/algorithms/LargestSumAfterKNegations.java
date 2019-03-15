package leetcode.algorithms;

import java.util.Arrays;

/**
 * Description: Maximize Sum Of Array After K Negations
 *
 * @author Baltan
 * @date 2019-03-15 14:51
 */
public class LargestSumAfterKNegations {
    public static void main(String[] args) {
        System.out.println(largestSumAfterKNegations(new int[]{4, 2, 3}, 1));
        System.out.println(largestSumAfterKNegations(new int[]{3, -1, 0, 2}, 3));
        System.out.println(largestSumAfterKNegations(new int[]{2, -3, -1, 5, -4}, 2));
    }

    public static int largestSumAfterKNegations(int[] A, int K) {
        for (int i = 0; i < K; i++) {
            Arrays.sort(A);
            A[0] = -A[0];
        }
        return Arrays.stream(A).sum();
    }
}
