package leetcode.algorithms;

import java.util.Arrays;

/**
 * Description:
 *
 * @author Baltan
 * @date 2020-02-15 12:55
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

    public static int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length == 0 || k == 0) {
            return 0;
        }

        int[] buyMin = new int[k];
        int[] sellMax = new int[k];
        Arrays.fill(buyMin, Integer.MAX_VALUE);

        for (int price : prices) {
            buyMin[0] = Math.min(buyMin[0], price);
            sellMax[0] = Math.max(sellMax[0], price - buyMin[0]);

            for (int i = 1; i < k; i++) {
                buyMin[i] = Math.min(buyMin[i], price - sellMax[i - 1]);
                sellMax[i] = Math.max(sellMax[i], price - buyMin[i]);
            }
        }
        return sellMax[k - 1];
    }
}
