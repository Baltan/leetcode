package leetcode.algorithms;

/**
 * Description: 121. Best Time to Buy and Sell Stock
 * @author Baltan
 *
 * @date 2017/11/7 20:03
 */
public class MaxProfit {
    public static void main(String[] args) {
        int[] prices1 = {7, 1, 5, 3, 6, 4};
        int[] prices2 = {7, 6, 4, 3, 1};
        int[] prices3 = {3, 2, 6, 5, 0, 3};
        System.out.println(maxProfit(prices1));
        System.out.println(maxProfit(prices2));
        System.out.println(maxProfit(prices3));
    }

    public static int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        } else {
            int profit = 0;
            int min = prices[0];
            for (int i = 1; i < prices.length; i++) {
                if (prices[i] > prices[i - 1]) {
                    profit = prices[i] - min > profit ? prices[i] - min : profit;
                } else {
                    min = prices[i] > min ? min : prices[i];
                }
            }
            return profit;
        }
    }
}
