package leetcode.algorithms;

import leetcode.util.OutputUtils;

/**
 * Description: 3669. Balanced K-Factor Decomposition
 *
 * @author Baltan
 * @date 2025/10/1 23:08
 */
public class MinDifference2 {
    public static void main(String[] args) {
        OutputUtils.print1DIntegerArray(minDifference(18, 5));
        OutputUtils.print1DIntegerArray(minDifference(100, 2));
        OutputUtils.print1DIntegerArray(minDifference(44, 3));
    }

    public static int[] minDifference(int n, int k) {
        int[] result = new int[k];
        int count = k;
        /**
         * dp[i][j]表示将i分割成j个正整数之积时的最佳分割方案
         */
        Plan[][] dp = new Plan[n + 1][k + 1];
        /**
         * 将1分割成[1,k]个因数之积时，分割方案中的所有因数都为1
         */
        for (int i = 1; i <= k; i++) {
            dp[1][i] = new Plan(1, 1, 0);
        }
        /**
         * 将i分割成j个正整数之积
         */
        for (int i = 2; i <= n; i++) {
            /**
             * 如果i不是n的因数，则所求分割方案dp[n][k]中一定不包含i，直接跳过计算
             */
            if (n % i == 0) {
                dp[i][1] = new Plan(i, i, 0);

                for (int j = 2; j <= k; j++) {
                    /**
                     * 将i分割成j个正整数之积的最差分割方案为j-1个1和1和i之积
                     */
                    dp[i][j] = new Plan(1, i, i - 1);
                    /**
                     * 计算分割方案中包含因数l的情况
                     */
                    for (int l = 1; l * l <= i; l++) {
                        /**
                         * 除去因数l后，剩余j-1个因数之积为i/l，即当前得到的分割方案为在方案dp[i/l][j-1]中加入因数l
                         */
                        if (i % l == 0) {
                            int min = Math.min(dp[i / l][j - 1].min, l);
                            int max = Math.max(dp[i / l][j - 1].max, l);
                            int difference = max - min;
                            /**
                             * 判断当前得到的分割方案是否更优
                             */
                            if (difference < dp[i][j].difference) {
                                dp[i][j] = new Plan(min, max, difference);
                            }
                        }
                    }
                }
            }
        }
        /**
         * 从最优分割方案dp[n][k]中倒推得到分割方案中的个个因数
         */
        for (int i = 0; i < count; i++) {
            result[i] = dp[n][k].max;
            n /= result[i];
            k--;
        }
        return result;
    }

    /**
     * 因数分解分割方案
     */
    private static class Plan {
        /**
         * 分割方案中的最小因数
         */
        private int min;
        /**
         * 分割方案中的最大因数
         */
        private int max;
        /**
         * 分割方案中的最大因数和最小因数之差
         */
        private int difference;

        public Plan(int min, int max, int difference) {
            this.min = min;
            this.max = max;
            this.difference = difference;
        }
    }
}