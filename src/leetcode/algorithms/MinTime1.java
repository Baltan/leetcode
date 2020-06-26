package leetcode.algorithms;

import java.util.Arrays;

/**
 * Description: LCP 12. 小张刷题计划
 *
 * @author Baltan
 * @date 2020-05-22 10:22
 */
public class MinTime1 {
    public static void main(String[] args) {
        System.out.println(minTime(new int[]{1, 2, 3, 3}, 2));
        System.out.println(minTime(new int[]{999, 999, 999}, 4));
    }

    public static int minTime(int[] time, int m) {
        int hi = Arrays.stream(time).sum();
        int lo = 0;
        /**
         * 二分查找每天最小耗时
         */
        while (lo < hi) {
            int mid = (lo + hi) / 2;

            if (verify(time, m, mid)) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    /**
     * 如果每天最多耗时为t，能否在m天内完成所有题目
     *
     * @param time
     * @param m
     * @param t
     * @return
     */
    public static boolean verify(int[] time, int m, int t) {
        /**
         * 同一天中耗时最长的题目花费的时间
         */
        int maxCost = 0;
        /**
         * 同一天中完成的所有题目的总耗时（不求助的情况下）
         */
        int sumCost = 0;
        int length = time.length;
        /**
         * 累计花费的天数
         */
        int costDays = 0;

        for (int i = 0; i < length; ) {
            maxCost = Math.max(maxCost, time[i]);
            sumCost += time[i];
            /**
             * 如果求助了最耗时的题目花费的总时间还是超过了t，则第i题必须另起一天才能完成
             */
            if (sumCost - maxCost > t) {
                costDays++;
                /**
                 * 将maxCost和sumCost清零，下一轮循环仍旧从第i题开始计算判断
                 */
                maxCost = 0;
                sumCost = 0;
            } else {
                i++;
            }
            /**
             * 如果累计花费的天数已经超过了m，则当前安排无法完成刷题计划
             */
            if (costDays > m) {
                return false;
            }
        }
        /**
         * 最后那部分题目也需要一天时间完成，所以costDays要加1
         */
        costDays++;
        return costDays <= m;
    }
}
