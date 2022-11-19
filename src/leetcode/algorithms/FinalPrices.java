package leetcode.algorithms;

import leetcode.util.OutputUtils;

/**
 * Description: 1475. Final Prices With a Special Discount in a Shop
 *
 * @author Baltan
 * @date 2022/11/1 14:00
 */
public class FinalPrices {
    public static void main(String[] args) {
        OutputUtils.print1DIntegerArray(finalPrices(new int[]{8, 4, 6, 2, 3}));
        OutputUtils.print1DIntegerArray(finalPrices(new int[]{1, 2, 3, 4, 5}));
        OutputUtils.print1DIntegerArray(finalPrices(new int[]{10, 1, 1, 6}));
    }

    public static int[] finalPrices(int[] prices) {
        int length = prices.length;

        for (int i = 0; i < length; i++) {
            /**
             * 在数组prices中找到索引值大于i且元素值小于等于prices[i]的第一个元素
             */
            for (int j = i + 1; j < length; j++) {
                if (prices[j] <= prices[i]) {
                    prices[i] -= prices[j];
                    break;
                }
            }
        }
        return prices;
    }
}
