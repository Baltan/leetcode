package leetcode.algorithms;

/**
 * Description: 121. Best Time to Buy and Sell Stock
 *
 * @author Baltan
 * @date 2017/11/7 20:03
 * @see MaxProfit1
 * @see MaxProfit2
 * @see MaxProfit3
 * @see MaxProfit4
 * @see MaxProfit5
 */
public class MaxProfit {
    public static void main(String[] args) {
        int[] prices1 = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices1));

        int[] prices2 = {7, 6, 4, 3, 1};
        System.out.println(maxProfit(prices2));

        int[] prices3 = {3, 2, 6, 5, 0, 3};
        System.out.println(maxProfit(prices3));
    }

    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int profit = 0;
        /**
         * 至今为止买入股票的最小价格
         */
        int min = Integer.MAX_VALUE;

        for (int price : prices) {
            min = Math.min(min, price);
            /**
             * 至今为止卖出股票的最大收益
             */
            profit = Math.max(profit, price - min);
        }
        return profit;
    }
}
