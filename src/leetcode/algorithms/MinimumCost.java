package leetcode.algorithms;

import java.util.Arrays;

/**
 * Description: 2144. Minimum Cost of Buying Candies With Discount
 *
 * @author Baltan
 * @date 2022/1/26 09:52
 */
public class MinimumCost {
    public static void main(String[] args) {
        System.out.println(minimumCost(new int[]{1, 2, 3}));
        System.out.println(minimumCost(new int[]{6, 5, 7, 9, 2, 2}));
        System.out.println(minimumCost(new int[]{5, 5}));
    }

    public static int minimumCost(int[] cost) {
        int result = 0;
        Arrays.sort(cost);
        /**
         * 剩余糖果中最贵的两个一定是要付费购买的，然后我们要求赠送除这两个糖果之外的最贵的糖果
         */
        for (int i = cost.length - 1; i >= 0; i--) {
            /**
             * 最贵的糖果
             */
            if (i >= 0) {
                result += cost[i--];
            }
            /**
             * 第二贵的的糖果
             */
            if (i >= 0) {
                result += cost[i--];
            }
        }
        return result;
    }
}
