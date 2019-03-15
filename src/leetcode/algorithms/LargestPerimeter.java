package leetcode.algorithms;

import java.util.Arrays;

/**
 * Description: Largest Perimeter Triangle
 *
 * @author Baltan
 * @date 2019-03-15 09:39
 */
public class LargestPerimeter {
    public static void main(String[] args) {
        System.out.println(largestPerimeter(new int[]{2, 1, 2}));
        System.out.println(largestPerimeter(new int[]{1, 2, 1}));
        System.out.println(largestPerimeter(new int[]{3, 2, 3, 4}));
        System.out.println(largestPerimeter(new int[]{3, 6, 2, 3}));
    }

    public static int largestPerimeter(int[] A) {
        Arrays.sort(A);

        int length = A.length;

        for (int i = length - 1; i >= 2; i--) {
            if (A[i - 1] + A[i - 2] > A[i]) {
                return A[i] + A[i - 1] + A[i - 2];
            }
        }
        return 0;
    }
}
