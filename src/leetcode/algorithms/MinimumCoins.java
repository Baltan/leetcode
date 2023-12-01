package leetcode.algorithms;

/**
 * Description: 2944. Minimum Number of Coins for Fruits
 *
 * @author Baltan
 * @date 2023/11/26 22:15
 */
public class MinimumCoins {
    public static void main(String[] args) {
        System.out.println(minimumCoins(new int[]{3, 1, 2}));
        System.out.println(minimumCoins(new int[]{1, 10, 1, 1}));
    }

    public static int minimumCoins(int[] prices) {
        int length = prices.length;
        /**
         * dp[i][0]表示得到前i个水果，并且购买得到第i个水果时的最小费用
         * dp[i][1]表示得到前i个水果，并且免费得到第i个水果时的最小费用
         */
        int[][] dp = new int[length + 1][2];
        dp[1][0] = prices[0];
        /**
         * 第一个水果必须购买，不可能免费得到
         */
        dp[1][1] = Integer.MAX_VALUE;

        for (int i = 2; i <= length; i++) {
            /**
             * 如果第i个水果需要购买得到，则第i-1个水果可以是购买得到，也可以是免费得到，取费用较小的方案
             */
            dp[i][0] = Math.min(dp[i - 1][0], dp[i - 1][1]) + prices[i - 1];
            /**
             * 如果第i个水果需要免费得到，则第[ceil(i/2),i-1]个水果中必须有一个是购买得到的，取费用较小的方案
             */
            dp[i][1] = Integer.MAX_VALUE;

            for (int j = (i + 1) / 2; j < i; j++) {
                dp[i][1] = Math.min(dp[i][1], dp[j][0]);
            }
        }
        return Math.min(dp[length][0], dp[length][1]);
    }
}
