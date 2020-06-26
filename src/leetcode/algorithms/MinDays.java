package leetcode.algorithms;

import java.util.Arrays;

/**
 * Description: 1482. Minimum Number of Days to Make m Bouquets
 *
 * @author Baltan
 * @date 2020-06-26 11:24
 */
public class MinDays {
    public static void main(String[] args) {
        int[] bloomDay1 = {1, 10, 3, 10, 2};
        System.out.println(minDays(bloomDay1, 3, 1));

        int[] bloomDay2 = {1, 10, 3, 10, 2};
        System.out.println(minDays(bloomDay2, 3, 2));

        int[] bloomDay3 = {7, 7, 7, 7, 12, 7, 7};
        System.out.println(minDays(bloomDay3, 2, 3));

        int[] bloomDay4 = {1000000000, 1000000000};
        System.out.println(minDays(bloomDay4, 1, 1));

        int[] bloomDay5 = {1, 10, 2, 9, 3, 8, 4, 7, 5, 6};
        System.out.println(minDays(bloomDay5, 4, 2));
    }

    public static int minDays(int[] bloomDay, int m, int k) {
        if (bloomDay.length < m * k) {
            return -1;
        }
        /**
         * 最大可能天数为bloomDay中最后一朵花开花的那一天
         */
        int hi = Arrays.stream(bloomDay).max().getAsInt();
        /**
         * 最小可能天数为第一天
         */
        int lo = 1;
        /**
         * 二分查找制作m束花的最小天数
         */
        while (lo < hi) {
            int mid = (lo + hi) / 2;

            if (check(bloomDay, mid, m, k)) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    /**
     * 判断day天后能不能制作m束花
     *
     * @param bloomDay
     * @param day
     * @param m
     * @param k
     * @return
     */
    public static boolean check(int[] bloomDay, int day, int m, int k) {
        int length = bloomDay.length;
        /**
         * 连续开花的数量
         */
        int continualBloomCount = 0;

        for (int i = 0; i < length; i++) {
            if (bloomDay[i] <= day) {
                continualBloomCount++;
                /**
                 * 如果有连续k朵花开了，就可以制作一束花
                 */
                if (continualBloomCount == k) {
                    /**
                     * 还需制作m-1束花
                     */
                    m--;
                    continualBloomCount = 0;
                }
            } else {
                continualBloomCount = 0;
            }
            /**
             * 如果m束花都制作完成了，说明day天后可以制作m束花
             */
            if (m == 0) {
                return true;
            }
        }
        return false;
    }
}
