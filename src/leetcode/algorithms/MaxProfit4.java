package leetcode.algorithms;

/**
 * Description: 123. Best Time to Buy and Sell Stock III
 *
 * @author Baltan
 * @date 2020-02-15 11:40
 */
public class MaxProfit4 {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{3, 3, 5, 0, 0, 3, 1, 4}));
        System.out.println(maxProfit(new int[]{1, 2, 3, 4, 5}));
        System.out.println(maxProfit(new int[]{7, 6, 4, 3, 1}));
    }

    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int length = prices.length;
        /**
         * dp[i][j][0]表示第i天后卖出过j次并且不持有股票，dp[i][j][1]表示第i天后卖出过j次并且
         * 持有股票，因为最多可以交易2次，所以j∈[0,2]
         */
        int[][][] dp = new int[length][3][2];
        dp[0][0][0] = 0;
        /**
         * 第0天后卖出过0次并且持有股票，即在第0天买入
         */
        dp[0][0][1] = -prices[0];
        /**
         * 第0天后不可能会卖出股票，因为当天买入卖出没有收益，还会浪费一次交易机会，将这种情况的
         * 收益初始化为Integer.MIN_VALUE
         */
        dp[0][1][0] = Integer.MIN_VALUE;
        dp[0][1][1] = Integer.MIN_VALUE;
        dp[0][2][0] = Integer.MIN_VALUE;
        dp[0][2][1] = Integer.MIN_VALUE;

        for (int i = 1; i < length; i++) {
            /**
             * 第i天后卖出过0次股票并且不持有股票，只能是在第i-1天也卖出过0次股票并且不持有股票
             * 并且第i天什么都不做的情况下得到
             */
            dp[i][0][0] = dp[i - 1][0][0];
            /**
             * 第i天后卖出过0次股票并且持有股票，可能是在第i-1天后卖出过0次股票并且持有股票并且
             * 第i天什么都不做的情况下得到，也可能是在第i-1天卖出过0次股票并且不持有股票并且第i
             * 天买入股票的情况下得到，两者取较大值
             */
            dp[i][0][1] = Math.max(dp[i - 1][0][1], dp[i - 1][0][0] - prices[i]);
            /**
             * 第i天后卖出过1次股票并且不持有股票，可能是在第i-1天后卖出过1次股票并且不持有股票
             * 并且第i天什么都不做的情况下得到，也可能是在第i-1天后卖出过0次股票并且持有股票并且
             * 第i天卖出股票的情况下得到，两者取较大值
             */
            dp[i][1][0] = Math.max(dp[i - 1][1][0], dp[i - 1][0][1] + prices[i]);
            /**
             * 第i天后卖出过1次股票并且持有股票，可能是在第i-1天后卖出过1次股票并且持有股票并且
             * 第i天什么都不做的情况下得到，也可能是在第i-1天后卖出过1次股票并且不持有股票并且
             * 第i天后买入股票的情况下得到，两者取较大值。但是对于后一种情况，有可能根本不存在，
             * 例如dp[0][1][0]这种情况不可能出现，此时要舍弃这种情况
             */
            dp[i][1][1] = dp[i - 1][1][0] == Integer.MIN_VALUE ? dp[i - 1][1][1] : Math.max(dp[i - 1][1][1],
                    dp[i - 1][1][0] - prices[i]);
            /**
             * 第i天后卖出过2次股票并且不持有股票，可能是在第i-1天后卖出过2次股票并且不持有股票
             * 并且第i天什么都不做的情况下得到，也可能是在第i-1天后卖出过1次股票并且持有股票并且
             * 第i天卖出股票的情况下得到，两者取较大值
             */
            dp[i][2][0] = Math.max(dp[i - 1][2][0], dp[i - 1][1][1] + prices[i]);
            /**
             * 第i天后卖出过2次股票并且持有股票的情况不存在，因为最多可以交易2次，此时手中不可能
             * 继续持有股票
             */
            dp[i][2][1] = Integer.MIN_VALUE;
        }
        /**
         * 最终不持有股票的收益一定大于持有股票的收益，从当天不持有股票的三种情况中选取最大值
         */
        return Math.max(Math.max(dp[length - 1][0][0], dp[length - 1][1][0]), dp[length - 1][2][0]);
    }
}
