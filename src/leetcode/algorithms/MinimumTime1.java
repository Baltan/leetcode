package leetcode.algorithms;

/**
 * Description: 2187. Minimum Time to Complete Trips
 *
 * @author Baltan
 * @date 2022/2/28 09:15
 */
public class MinimumTime1 {
    public static void main(String[] args) {
        System.out.println(minimumTime(new int[]{1, 2, 3}, 5));
        System.out.println(minimumTime(new int[]{2}, 1));
    }

    public static long minimumTime(int[] time, int totalTrips) {
        int min = Integer.MAX_VALUE;

        for (int value : time) {
            min = Math.min(min, value);
        }

        long lo = 1L;
        /**
         * 最大可能的用时不会超过完成一趟旅途的最小时间和总旅途数目的乘积
         */
        long hi = 1L * min * totalTrips;
        /**
         * 二分查找最小用时
         */
        while (lo < hi) {
            long mid = (lo + hi) / 2;
            /**
             * 当总用时为mid时可以完成的总旅途数目
             */
            long total = 0L;

            for (int value : time) {
                total += mid / value;
            }

            if (total >= totalTrips) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }
}
