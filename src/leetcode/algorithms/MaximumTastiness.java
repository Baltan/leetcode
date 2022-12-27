package leetcode.algorithms;

import java.util.Arrays;

/**
 * Description: 2517. Maximum Tastiness of Candy Basket
 *
 * @author Baltan
 * @date 2022/12/26 11:53
 */
public class MaximumTastiness {
    public static void main(String[] args) {
        System.out.println(maximumTastiness(new int[]{144, 69, 103, 148, 184, 50, 129, 154, 2}, 4));
        System.out.println(maximumTastiness(new int[]{13, 5, 1, 8, 21, 2}, 3));
        System.out.println(maximumTastiness(new int[]{1, 3, 1}, 2));
        System.out.println(maximumTastiness(new int[]{7, 7, 7, 7}, 2));
    }

    /**
     * 参考：<a href="https://leetcode.cn/problems/maximum-tastiness-of-candy-basket/solutions/2032001/by-tsreaper-am42/"></a>
     *
     * @param price
     * @param k
     * @return
     */
    public static int maximumTastiness(int[] price, int k) {
        Arrays.sort(price);
        int length = price.length;
        /**
         * 数组price排序后相邻元素差值的最小值
         */
        int lo = Integer.MAX_VALUE;
        /**
         * 数组price元素差值的最大值
         */
        int hi = price[length - 1] - price[0];

        for (int i = 1; i < length; i++) {
            lo = Math.min(lo, price[i] - price[i - 1]);
        }
        /**
         * 二分查找。假设从排序后的数组price中可以找到k个元素，使得相邻元素的差值不小于mid，为了可以选到尽可能多的元素，总是从最小的元素
         * price[0]开始选择。如果可以选出这样的k个元素，则尝试将相邻元素的差值mid放大再选择
         */
        while (lo < hi) {
            int mid = (lo + hi + 1) / 2;
            int prev = price[0];
            /**
             * 接下去要选择的元素的最小值
             */
            int min = prev + mid;
            /**
             * 已选择的元素数量
             */
            int count = 1;

            for (int i = 1; i < length && count < k; i++) {
                if (price[i] >= min) {
                    prev = price[i];
                    min = prev + mid;
                    count++;
                }
            }

            if (count == k) {
                lo = mid;
            } else {
                hi = mid - 1;
            }
        }
        return lo;
    }
}
