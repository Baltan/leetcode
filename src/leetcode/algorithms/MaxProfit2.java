package leetcode.algorithms;

/**
 * Description: 714. Best Time to Buy and Sell Stock with Transaction Fee
 *
 * @author Baltan
 * @date 2020-02-14 12:23
 */
public class MaxProfit2 {
    public static void main(String[] args) {
        int[] prices1 = {1, 3, 2, 8, 4, 9};
        System.out.println(maxProfit(prices1, 2));
    }

    public static int maxProfit(int[] prices, int fee) {
        int length = prices.length;
        /**
         * 当天如果持有股票，可以获得的最大收益，初始化为第0天持有股票的最大收益
         */
        int keepMax = -prices[0];
        /**
         * 当天如果不持有股票，可以获得的最大收益，初始化为第0天不持有股票的最大收益
         */
        int notKeepMax = 0;

        for (int i = 1; i < length; i++) {
            /**
             * 前一天持有股票的最大收益
             */
            int keepMaxYesterday = keepMax;
            /**
             * 当天持有股票，可以是在前一天不持有股票的基础上当天买进，也可以将前一天持有的股票
             * 继续持有不进行任何操作
             */
            keepMax = Math.max(keepMax, notKeepMax - prices[i]);
            /**
             * 当天不持有股票，可以是在前一天持有股票的基础上当天卖出，也可以将前一天不持有股票
             * 的状态维持不进行任何操作
             */
            notKeepMax = Math.max(notKeepMax, keepMaxYesterday + prices[i] - fee);
        }
        /**
         * 最终不持有股票的收益一定大于持有股票的收益，所以返回最后一天不持有股票的最大收益
         */
        return notKeepMax;
    }
}
