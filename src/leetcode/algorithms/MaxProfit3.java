package leetcode.algorithms;

/**
 * Description: 309. Best Time to Buy and Sell Stock with Cooldown
 *
 * @author Baltan
 * @date 2020-02-14 14:43
 * @see MaxProfit
 * @see MaxProfit1
 * @see MaxProfit2
 * @see MaxProfit4
 * @see MaxProfit5
 */
public class MaxProfit3 {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{1, 2, 3, 0, 2}));
        System.out.println(maxProfit(new int[]{}));
    }

    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int length = prices.length;
        /**
         * 当天如果买新股票可以获得的最大收益
         */
        int buy = -prices[0];
        /**
         * 当天如果卖出股票可以获得的最大收益
         */
        int sell = 0;
        /**
         * 当天如果是冻结状态可以获得的最大收益
         */
        int frozen = 0;
        /**
         * 当天如果什么都不做并且持有股票可以获得的最大收益
         */
        int undoAndKeep = -prices[0];
        /**
         * 当天如果什么都不做并且不持有股票可以获得的最大收益
         */
        int undoAndNotKeep = 0;

        for (int i = 1; i < length; i++) {
            int buyYesterday = buy;
            int sellYesterday = sell;
            int frozenYesterday = frozen;
            int undoAndKeepYesterday = undoAndKeep;
            int undoAndNotKeepYesterday = undoAndNotKeep;
            /**
             * 当天如果要买进股票，只能是昨天是冻结状态或者昨天什么都没做并且不持有股票
             */
            buy = Math.max(frozenYesterday - prices[i], undoAndNotKeepYesterday - prices[i]);
            /**
             * 当天如果要卖出股票，只能是昨天买进了股票或者昨天什么都没做并且持有股票
             */
            sell = Math.max(buyYesterday + prices[i], undoAndKeepYesterday + prices[i]);
            /**
             * 当天如果是冻结状态，只能是昨天卖出了股票
             */
            frozen = sellYesterday;
            /**
             * 当天如果什么都没做并且持有股票，只能是昨天买进了股票或者昨天也是什么都没做并且持
             * 有股票
             */
            undoAndKeep = Math.max(buyYesterday, undoAndKeepYesterday);
            /**
             * 当天如果什么都没做并且不持有股票，只能是昨天是冻结状态或者昨天也是什么都没做并且
             * 不持有股票
             */
            undoAndNotKeep = Math.max(frozenYesterday, undoAndNotKeepYesterday);
        }
        /**
         * 最终不持有股票的收益一定大于持有股票的收益，从当天不持有股票的三种情况中选取最大值
         */
        return Math.max(Math.max(sell, frozen), undoAndNotKeep);
    }
}
