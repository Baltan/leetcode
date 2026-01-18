package leetcode.algorithms;

/**
 * Description: 3733. Minimum Time to Complete All Deliveries
 *
 * @author baltan
 * @date 2026/1/14 13:54
 */
public class MinimumTime4 {
    public static void main(String[] args) {
        System.out.println(minimumTime(new int[]{3, 1}, new int[]{2, 3}));
        System.out.println(minimumTime(new int[]{1, 3}, new int[]{2, 2}));
        System.out.println(minimumTime(new int[]{2, 1}, new int[]{3, 4}));
    }

    /**
     * 参考：<a href="https://leetcode.cn/problems/minimum-time-to-complete-all-deliveries/solutions/3821359/er-fen-tan-xin-by-tsreaper-i6dq/"></a>
     *
     * @param d
     * @param r
     * @return
     */
    public static long minimumTime(int[] d, int[] r) {
        long result = -1;
        /**
         * 两架无人机同时充电的天数间隔
         */
        long lcm = lcm(r[0], r[1]);
        long lo = 0;
        long hi = Long.MAX_VALUE;

        while (lo < hi) {
            long mid = (lo + hi) / 2;

            if (binarySearch(mid, lcm, d, r)) {
                result = mid;
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return result;
    }

    /**
     * 二分计算在totalDays天内能否完成所有送货任务
     *
     * @param totalDays
     * @param lcm
     * @param d
     * @param r
     * @return
     */
    public static boolean binarySearch(long totalDays, long lcm, int[] d, int[] r) {
        /**
         * 第一架无人机充电的天数
         */
        long rechargeDays1 = totalDays / r[0];
        /**
         * 第二架无人机充电的天数
         */
        long rechargeDays2 = totalDays / r[1];
        /**
         * 两架无人机同时充电的天数
         */
        long bothRechargeDays = totalDays / lcm;
        /**
         * 只有第一架无人机送货的天数
         */
        long taskDays1 = rechargeDays2 - bothRechargeDays;
        /**
         * 只有第二架无人机送货的天数
         */
        long taskDays2 = rechargeDays1 - bothRechargeDays;
        /**
         * 两架无人机同时送货的天数
         */
        long bothTaskDays = totalDays - (rechargeDays1 + rechargeDays2 - bothRechargeDays);
        /**
         * 第一架无人机至少还需要Math.max(0,d[0]-taskDays1)天可以送完所有货，第二架无人机至少还需要Math.max(0,d[1]-taskDays2)天可以
         * 送完所有货，判断两架无人机同时送货的天数可以让两架无人机都送完所有货
         */
        return bothTaskDays >= Math.max(0, d[0] - taskDays1) + Math.max(0, d[1] - taskDays2);
    }

    /**
     * 求x和y的最大公约数
     *
     * @param x
     * @param y
     * @return
     */
    public static long gcd(long x, long y) {
        long min = Math.min(x, y);
        long max = Math.max(x, y);

        while (max % min != 0) {
            long remainder = max % min;
            max = min;
            min = remainder;
        }
        return min;
    }

    /**
     * 求x和y的最小公倍数
     *
     * @param x
     * @param y
     * @return
     */
    public static long lcm(long x, long y) {
        return x * y / gcd(x, y);
    }
}
