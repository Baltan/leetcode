package leetcode.algorithms;

/**
 * Description: 1043. Partition Array for Maximum Sum
 *
 * @author Baltan
 * @date 2020-05-30 13:43
 */
public class MaxSumAfterPartitioning {
    public static void main(String[] args) {
        System.out.println(maxSumAfterPartitioning(new int[]{1, 15, 7, 9, 2, 5, 10}, 3));
    }

    public static int maxSumAfterPartitioning(int[] A, int K) {
        int result = 0;
        int length = A.length;
        /**
         * dp[i][j]表示A.subarray(0,i+1)进行分隔，并且最后j个数分隔为一个子数组时得到的最大和
         */
        int[][] dp = new int[length][K + 1];
        /**
         * 当数组A只包含一个数字时，不管怎么分隔得到的最大和都是A[0]
         */
        for (int i = 1; i <= K; i++) {
            dp[0][i] = A[0];
        }

        for (int i = 1; i < length; i++) {
            /**
             * 最后一个子数组中的元素个数不仅不大于K，而且不能大于当前用于分隔的元素的总个数i+1
             */
            for (int j = 1; j <= K && j <= i + 1; j++) {
                /**
                 * 如果最后一个子数组只有1个元素，则只需要找到A.subarray(0,i)的所有分隔方法的得到的最大和再
                 * 加上A[i]即可
                 */
                if (j == 1) {
                    for (int k = 1; k <= K; k++) {
                        dp[i][j] = Math.max(dp[i][j], dp[i - 1][k] + A[i]);
                    }
                } else {
                    int max = 0;
                    /**
                     * dp[i-1][j-1]这种分隔方法的最后一个子数组中的j-1个数的最大值
                     */
                    for (int k = 0; k < j - 1 && k <= i - 1; k++) {
                        max = Math.max(max, A[i - 1 - k]);
                    }
                    /**
                     * 先减去最后一个子数组的j-1个数的和
                     */
                    dp[i][j] = dp[i - 1][j - 1] - max * (j - 1);
                    /**
                     * 最后一个子数组中的j个数的最大值
                     */
                    max = Math.max(max, A[i]);
                    /**
                     * 再加上最后一个子数组的j个数的和
                     */
                    dp[i][j] += max * j;
                }
            }
            /**
             * 当分隔的数字不足j个，即无法保证最后一个子数组有j个数字时
             */
            for (int j = i + 2; j <= K; j++) {
                dp[i][j] = dp[i][j - 1];
            }
        }
        /**
         * 获取数组A的所有分隔方法的可以得到的最大和
         */
        for (int i = 1; i <= K; i++) {
            result = Math.max(result, dp[length - 1][i]);
        }
        return result;
    }
}
