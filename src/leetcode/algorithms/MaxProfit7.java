package leetcode.algorithms;

/**
 * Description: 3652. Best Time to Buy and Sell Stock using Strategy
 *
 * @author baltan
 * @date 2025/9/16 13:50
 */
public class MaxProfit7 {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{4, 2, 8}, new int[]{-1, 0, 1}, 2));
        System.out.println(maxProfit(new int[]{5, 4, 3}, new int[]{1, 1, 0}, 2));
    }

    public static long maxProfit(int[] prices, int[] strategy, int k) {
        int length = prices.length;
        /**
         * 修改前所有天数的利润和
         */
        long sum;
        /**
         * 修改前连续k天的利润和
         */
        long sum1 = 0L;
        /**
         * 修改后连续k天的利润和
         */
        long sum2 = 0L;
        /**
         * 修改后连续k天的利润和相比于初始状态时这k天的利润和的增量，当不做修改时，利润增量为0
         */
        long maxIncrement = 0L;
        /**
         * 修改前[0,k-1]天的利润和
         */
        for (int i = 0; i < k; i++) {
            sum1 += prices[i] * strategy[i];
        }
        /**
         * 修改[0,k-1]天的策略，则[k/2,k]天的价格之和为修改后连续k天的利润和
         */
        for (int i = k / 2; i < k; i++) {
            sum2 += prices[i];
        }
        sum = sum1;
        maxIncrement = Math.max(maxIncrement, sum2 - sum1);
        /**
         * 向右移动窗口
         */
        for (int i = k; i < length; i++) {
            sum += prices[i] * strategy[i];
            /**
             * 修改前连续k天的利润和新增prices[i]*strategy[i]，扣除prices[i-k]*strategy[i-k]
             */
            sum1 = sum1 + prices[i] * strategy[i] - prices[i - k] * strategy[i - k];
            /**
             * 修改后连续k天的利润和新增prices[i]，扣除prices[i-k/2]
             */
            sum2 = sum2 + prices[i] - prices[i - k / 2];
            maxIncrement = Math.max(maxIncrement, sum2 - sum1);
        }
        return sum + maxIncrement;
    }
}
