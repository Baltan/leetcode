package leetcode.algorithms;

/**
 * Description: 1031. Maximum Sum of Two Non-Overlapping Subarrays
 *
 * @author Baltan
 * @date 2019-04-22 11:13
 */
public class MaxSumTwoNoOverlap {
    public static void main(String[] args) {
        System.out.println(maxSumTwoNoOverlap(new int[]{0, 6, 5, 2, 2, 5, 1, 9, 4}, 1, 2));
        System.out.println(maxSumTwoNoOverlap(new int[]{3, 8, 1, 3, 2, 1, 8, 9, 0}, 3, 2));
        System.out.println(maxSumTwoNoOverlap(new int[]{2, 1, 5, 6, 0, 9, 5, 0, 3, 8}, 4, 3));
        System.out.println(maxSumTwoNoOverlap(new int[]{0, 1, 0, 0, 0, 2, 5, 0, 3, 8}, 2, 4));
        System.out.println(maxSumTwoNoOverlap(new int[]{1, 0, 3}, 1, 2));
    }

    public static int maxSumTwoNoOverlap(int[] A, int L, int M) {
        int length = A.length;
        int[] prefixSum = new int[length + 1];

        for (int i = 1; i <= length; i++) {
            prefixSum[i] = A[i - 1] + prefixSum[i - 1];
        }

        if (L == M) {
            return help(prefixSum, L, M);
        } else {
            return Math.max(help(prefixSum, L, M), help(prefixSum, M, L));
        }
    }

    public static int help(int[] prefixSum, int len1, int len2) {
        int len1Sum;
        int len2Sum;
        int sum = 0;
        int length = prefixSum.length;

        for (int i = len1; i <= length - len2 - 1; i++) {
            len1Sum = prefixSum[i] - prefixSum[i - len1];

            for (int j = i + len2; j < length; j++) {
                len2Sum = prefixSum[j] - prefixSum[j - len2];
                sum = Math.max(sum, len1Sum + len2Sum);
            }
        }
        return sum;
    }
}