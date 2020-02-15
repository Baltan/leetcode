package leetcode.algorithms;

import java.util.Arrays;

/**
 * Description: 188. Best Time to Buy and Sell Stock IV
 *
 * @author Baltan
 * @date 2020-02-15 12:55
 * @see MaxProfit
 * @see MaxProfit1
 * @see MaxProfit2
 * @see MaxProfit3
 * @see MaxProfit4
 */
public class MaxProfit5 {
    public static void main(String[] args) {
        int[] prices1 = {2, 4, 1};
        System.out.println(maxProfit(2, prices1));

        int[] prices2 = {3, 2, 6, 5, 0, 3};
        System.out.println(maxProfit(2, prices2));

        int[] prices3 = {2, 1, 4, 5, 2, 9, 7};
        System.out.println(maxProfit(2, prices3));

        int[] prices4 = {1, 3};
        System.out.println(maxProfit(0, prices4));
    }

    /**
     * 参考：
     * <a href="https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii/solution/java-1ms-100dong-tai-gui-hua-li-yong-si-ge-bian-li/"></a>
     *
     * @param k
     * @param prices
     * @return
     */
    public static int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length == 0 || k == 0) {
            return 0;
        }
        /**
         * 交易次数不会超过prices.length
         */
        k = Math.min(k, prices.length);
        /**
         * buyMin[i]表示第i（0-based）次买入股票的最低成本
         */
        int[] buyMin = new int[k];
        /**
         * sellMax[i]表示第i（0-based）次卖出股票的最大收益
         */
        int[] sellMax = new int[k];
        Arrays.fill(buyMin, Integer.MAX_VALUE);

        for (int price : prices) {
            /**
             * 第0次买入股票的最低成本就是至今为止股票的最低价格
             */
            buyMin[0] = Math.min(buyMin[0], price);
            /**
             * 第0次卖出股票的最大收益就是当天股票价格减去第0次买入股票的最低成本
             */
            sellMax[0] = Math.max(sellMax[0], price - buyMin[0]);

            for (int i = 1; i < k; i++) {
                /**
                 * 第i次买入股票的成本需要减去第i-1次卖出股票后的最大收益
                 */
                buyMin[i] = Math.min(buyMin[i], price - sellMax[i - 1]);
                /**
                 * 第i次卖出股票的最大收益就是当天股票价格减去第i-1次买入股票的最低成本
                 */
                sellMax[i] = Math.max(sellMax[i], price - buyMin[i]);
            }
        }
        return sellMax[k - 1];
    }
}
