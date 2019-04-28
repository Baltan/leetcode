package leetcode.algorithms;

/**
 * Description: Best Sightseeing Pair
 *
 * @author Baltan
 * @date 2019-04-28 10:41
 */
public class MaxScoreSightseeingPair {
    public static void main(String[] args) {
        System.out.println(maxScoreSightseeingPair(new int[]{8, 1, 5, 2, 6}));
    }

    public static int maxScoreSightseeingPair(int[] A) {
        int length = A.length;
        int maxI = 0 + A[0];
        int result = Integer.MIN_VALUE;

        for (int i = 1; i < length; i++) {
            result = Math.max(A[i] - i + maxI, result);
            maxI = Math.max(maxI, i + A[i]);
        }
        return result;
    }
}
