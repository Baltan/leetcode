package leetcode.algorithms;

/**
 * Description: 1423. Maximum Points You Can Obtain from Cards
 *
 * @author Baltan
 * @date 2020-04-28 08:11
 */
public class MaxScore1 {
    public static void main(String[] args) {
        System.out.println(maxScore(new int[]{1, 2, 3, 4, 5, 6, 1}, 3));
        System.out.println(maxScore(new int[]{2, 2, 2}, 2));
        System.out.println(maxScore(new int[]{9, 7, 7, 9, 7, 7, 9}, 7));
        System.out.println(maxScore(new int[]{1, 1000, 1}, 1));
        System.out.println(maxScore(new int[]{1, 79, 80, 1, 1, 1, 200, 1}, 3));
    }

    public static int maxScore(int[] cardPoints, int k) {
        int result = Integer.MIN_VALUE;
        int length = cardPoints.length;
        /**
         * 数组cardPoints的前缀和
         */
        int[] prefixSum = new int[length + 1];

        for (int i = 0; i < length; i++) {
            prefixSum[i + 1] = prefixSum[i] + cardPoints[i];
        }
        /**
         * 结果总是从数组cardPoints的最前面取i张，从最后面去k-i张
         */
        for (int i = 0; i <= k; i++) {
            result = Math.max(result,
                    prefixSum[i] - prefixSum[0] + prefixSum[length] - prefixSum[length - k + i]);
        }
        return result;
    }
}
