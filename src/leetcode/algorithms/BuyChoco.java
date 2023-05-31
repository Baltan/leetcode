package leetcode.algorithms;

import java.util.Arrays;

/**
 * Description: 2706. Buy Two Chocolates
 *
 * @author Baltan
 * @date 2023/5/28 17:29
 */
public class BuyChoco {
    public static void main(String[] args) {
        System.out.println(buyChoco(new int[]{1, 2, 2}, 3));
        System.out.println(buyChoco(new int[]{3, 2, 3}, 3));
    }

    public static int buyChoco(int[] prices, int money) {
        Arrays.sort(prices);
        /**
         * 选择价格最便宜的两种巧克力
         */
        int cost = prices[0] + prices[1];
        return cost <= money ? money - cost : money;
    }
}
