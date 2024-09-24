package leetcode.algorithms;

import java.util.Arrays;

/**
 * Description: 3296. Minimum Number of Seconds to Make Mountain Height Zero
 *
 * @author baltan
 * @date 2024/9/24 19:36
 */
public class MinNumberOfSeconds {
    public static void main(String[] args) {
        System.out.println(minNumberOfSeconds(4, new int[]{2, 1, 1}));
        System.out.println(minNumberOfSeconds(10, new int[]{3, 2, 2, 4}));
        System.out.println(minNumberOfSeconds(5, new int[]{1}));
    }

    public static long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        /**
         * 工作时间最长的工人的工时
         */
        int max = Arrays.stream(workerTimes).max().getAsInt();
        long lo = 0;
        /**
         * 假设只有工作时间最长的工人一个人移山，总耗时为hi
         */
        long hi = (long) (1 + mountainHeight) * mountainHeight / 2 * max;
        /**
         * 二分计算移山的总时间
         */
        while (lo < hi) {
            long mid = (lo + hi) / 2;
            /**
             * mid秒内，所有工人降低山的总高度
             */
            long height = 0L;
            /**
             * mid秒内，假设工人最多可以将山的高度降低x，则(1+2+3+……+x)*workerTime<=mid，根据求根公式可以求得x的最大整数值
             */
            for (int workerTime : workerTimes) {
                height += (long) ((Math.sqrt(1 + (double) (8 * mid) / workerTime) - 1) / 2);
            }

            if (height >= mountainHeight) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }
}
