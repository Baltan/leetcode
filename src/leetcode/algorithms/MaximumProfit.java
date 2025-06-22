package leetcode.algorithms;

/**
 * Description: 3573. Best Time to Buy and Sell Stock V
 *
 * @author baltan
 * @date 2025/6/18 18:02
 * @see MaxProfit
 * @see MaxProfit1
 * @see MaxProfit2
 * @see MaxProfit3
 * @see MaxProfit4
 * @see MaxProfit5
 */
public class MaximumProfit {
    public static void main(String[] args) {
        System.out.println(maximumProfit(new int[]{6, 11, 1, 5, 3, 15, 8}, 3));
        System.out.println(maximumProfit(new int[]{1, 7, 9, 8, 2}, 2));
        System.out.println(maximumProfit(new int[]{12, 16, 19, 19, 8, 1, 19, 13, 9}, 3));
    }

    public static long maximumProfit(int[] prices, int k) {
        /**
         * 当不进行任何操作时，总利润为0美元
         */
        long result = 0L;
        /**
         * dp[i][j][l]表示第i天时，状态为0-做多、1-做空、2-空仓，并且已进行l次买入或卖出操作的情况下，总利润的最大值。因为最多可以进行k笔
         * 交易，相当与最多可以进行2k次买入或卖出操作
         */
        long[][][] dp = new long[prices.length][3][2 * k + 1];

        for (int i = 0; i < prices.length; i++) {
            for (int j = 0; j < 3; j++) {
                for (int l = 0; l <= 2 * k; l++) {
                    dp[i][j][l] = Long.MIN_VALUE;
                }
            }
        }
        /**
         * 第0天如果保持做多状态，则需要进行一次买入操作，支出prices[0]美元买入股票，此时总利润为-prices[0]元
         */
        dp[0][0][1] = -prices[0];
        /**
         * 第0天如果保持做空状态，则需要进行一次卖出操作，可以卖出股票收入prices[0]美元，此时总利润为prices[0]元
         */
        dp[0][1][1] = prices[0];
        /**
         * 第0天如果保持空仓状态，则不进行买入或卖出操作，此时总利润仍为0美元
         */
        dp[0][2][0] = 0L;

        for (int i = 1; i < prices.length; i++) {
            for (int j = 0; j < 3; j++) {
                /**
                 * 到第i天为止如果已进行买入或卖出操作仍为0次，则只可能是保持空仓状态，并且前一天也是空仓状态，操作次数为0次，此时总利润仍为
                 * 0美元
                 */
                dp[i][2][0] = dp[i - 1][2][0];

                for (int l = 1; l <= 2 * k; l++) {
                    /**
                     * 第i天如果保持做多状态，并且已进行买入或卖出操作为l次，则前一天可以是做多状态，并且已进行买入或卖出操作为l次，而第i天
                     * 不进行任何操作，此时总利润为dp[i-1][0][l]元
                     */
                    dp[i][0][l] = dp[i - 1][0][l] == Long.MIN_VALUE ? dp[i][0][l] : Math.max(dp[i][0][l], dp[i - 1][0][l]);
                    /**
                     * 第i天如果保持做多状态，并且已进行买入或卖出操作为l次，则前一天可以是空仓状态，并且已进行买入或卖出操作为l-1次，而第
                     * i天支出prices[i]美元买入股票，此时总利润为dp[i-1][2][l-1]-prices[i]元
                     */
                    dp[i][0][l] = dp[i - 1][2][l - 1] == Long.MIN_VALUE ? dp[i][0][l] : Math.max(dp[i][0][l], dp[i - 1][2][l - 1] - prices[i]);
                    /**
                     * 第i天如果保持做空状态，并且已进行买入或卖出操作为l次，则前一天可以是做空状态，并且已进行买入或卖出操作为l次，而第i天
                     * 不进行任何操作，此时总利润为dp[i-1][1][l]元
                     */
                    dp[i][1][l] = dp[i - 1][1][l] == Long.MIN_VALUE ? dp[i][1][l] : Math.max(dp[i][1][l], dp[i - 1][1][l]);
                    /**
                     * 第i天如果保持做空状态，并且已进行买入或卖出操作为l次，则前一天可以是空仓状态，并且已进行买入或卖出操作为l-1次，而第
                     * i天卖出股票收入prices[i]美元，此时总利润为dp[i-1][2][l-1]+prices[i]元
                     */
                    dp[i][1][l] = dp[i - 1][2][l - 1] == Long.MIN_VALUE ? dp[i][1][l] : Math.max(dp[i][1][l], dp[i - 1][2][l - 1] + prices[i]);
                    /**
                     * 第i天如果保持空仓状态，并且已进行买入或卖出操作为l次，则前一天可以是空仓状态，并且已进行买入或卖出操作为l次，而第i天
                     * 不进行任何操作，此时总利润为dp[i-1][2][l]元
                     */
                    dp[i][2][l] = dp[i - 1][2][l] == Long.MIN_VALUE ? dp[i][2][l] : Math.max(dp[i][2][l], dp[i - 1][2][l]);
                    /**
                     * 第i天如果保持空仓状态，并且已进行买入或卖出操作为l次，则前一天可以是做多状态，并且已进行买入或卖出操作为l-1次，而第
                     * i天卖出股票收入prices[i]美元，此时总利润为dp[i-1][0][l-1]+prices[i]元
                     */
                    dp[i][2][l] = dp[i - 1][0][l - 1] == Long.MIN_VALUE ? dp[i][2][l] : Math.max(dp[i][2][l], dp[i - 1][0][l - 1] + prices[i]);
                    /**
                     * 第i天如果保持空仓状态，并且已进行买入或卖出操作为l次，则前一天可以是做空状态，并且已进行买入或卖出操作为l-1次，而第
                     * i天支出prices[i]美元买入股票，此时总利润为dp[i-1][1][l-1]-prices[i]元
                     */
                    dp[i][2][l] = dp[i - 1][1][l - 1] == Long.MIN_VALUE ? dp[i][2][l] : Math.max(dp[i][2][l], dp[i - 1][1][l - 1] - prices[i]);
                }
            }
        }
        /**
         * 最后一天结束后并且空仓状态下，选择买入或卖出操作次数为[0,2k]中的最大值即可
         */
        for (int i = 0; i <= 2 * k; i++) {
            result = Math.max(result, dp[prices.length - 1][2][i]);
        }
        return result;
    }
}
