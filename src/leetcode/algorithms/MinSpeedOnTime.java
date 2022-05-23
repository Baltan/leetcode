package leetcode.algorithms;

/**
 * Description: 1870. Minimum Speed to Arrive on Time
 *
 * @author Baltan
 * @date 2022/5/22 15:09
 */
public class MinSpeedOnTime {
    public static void main(String[] args) {
        System.out.println(minSpeedOnTime(new int[]{1, 1}, 1.0));
        System.out.println(minSpeedOnTime(new int[]{1, 1, 100000}, 2.01));
        System.out.println(minSpeedOnTime(new int[]{1, 3, 2}, 6));
        System.out.println(minSpeedOnTime(new int[]{1, 3, 2}, 2.7));
        System.out.println(minSpeedOnTime(new int[]{1, 3, 2}, 1.9));
    }

    public static int minSpeedOnTime(int[] dist, double hour) {
        /**
         * 前dist.length-1趟列车至少用时dist.length-1小时，如果此时用时已经不小于hour，则一定无法准时到达
         */
        if (dist.length - 1 >= hour) {
            return -1;
        }
        /**
         * 列车的最小时速
         */
        int lo = 0;
        /**
         * 列车的最大时速
         */
        int hi = Integer.MAX_VALUE;
        /**
         * 二分搜索符合条件的列车的最小时速
         */
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            /**
             * 当列车时速为mid时的总用时
             */
            double totalTime = 0d;
            /**
             * 前dist.length-1趟列车用时向上取整
             */
            for (int i = 0; i < dist.length - 1; i++) {
                totalTime += Math.ceil(1.0 * dist[i] / mid);
            }
            /**
             * 最后一趟列车用时
             */
            totalTime += 1.0 * dist[dist.length - 1] / mid;

            if (totalTime > hour) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }
}
