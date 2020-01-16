package leetcode.algorithms;

/**
 * Description: 862. Shortest Subarray with Sum at Least K
 *
 * @author Baltan
 * @date 2020-01-15 11:53
 */
public class ShortestSubarray {
    public static void main(String[] args) {
        int[] A1 = {1};
        System.out.println(shortestSubarray(A1, 1));

        int[] A2 = {1, 2};
        System.out.println(shortestSubarray(A2, 4));

        int[] A3 = {2, -1, 2};
        System.out.println(shortestSubarray(A3, 3));
    }

    public static int shortestSubarray(int[] A, int K) {
        int result = 50001;
        int length = A.length;
        long[] prefixSum = new long[length + 1];

        for (int i = 0; i < length; i++) {
            prefixSum[i + 1] = prefixSum[i] + A[i];
        }

        for (int firstIndex = 0; firstIndex < length; firstIndex++) {
            for (int subarrayLength = 1; subarrayLength < result; subarrayLength++) {
                int lastIndex = firstIndex + subarrayLength - 1;

                if (lastIndex >= length) {
                    break;
                }

                long subarraySum = prefixSum[lastIndex + 1] - prefixSum[firstIndex];

                if (subarraySum >= K) {
                    result = Math.min(result, subarrayLength);
                    break;
                }
            }
        }
        return result == 50001 ? -1 : result;
    }
}
