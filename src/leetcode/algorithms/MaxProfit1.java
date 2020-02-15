package leetcode.algorithms;

/**
 * Description: 122. Best Time to Buy and Sell Stock II
 *
 * @author Baltan
 * @date 2017/11/17 14:04
 * @see MaxProfit
 * @see MaxProfit2
 * @see MaxProfit3
 * @see MaxProfit4
 * @see MaxProfit5
 */
public class MaxProfit1 {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(maxProfit(new int[]{1, 2, 3, 4, 5}));
        System.out.println(maxProfit(new int[]{7, 6, 4, 3, 1}));
    }

    public static int maxProfit(int[] prices) {
        int profit = 0;

        for (int i = 0; i < prices.length - 1; i++) {
            /**
             * 相邻的两天中，如果后一天的股票价格高于前一天，就应该在这两天完成一次交易获得更多的
             * 收益
             */
            if (prices[i] < prices[i + 1]) {
                profit += (prices[i + 1] - prices[i]);
            }
        }
        return profit;
    }
}
