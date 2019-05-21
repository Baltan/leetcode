package leetcode.algorithms;

/**
 * Description: 122. Best Time to Buy and Sell Stock II
 *
 * @author Baltan
 * @date 2017/11/17 14:04
 */
public class MaxProfit1 {
    public static void main(String[] args) {

    }

    public static int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i] < prices[i + 1]) {
                profit += (prices[i + 1] - prices[i]);
            }
        }
        return profit;
    }
}
