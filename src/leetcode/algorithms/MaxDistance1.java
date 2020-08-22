package leetcode.algorithms;

import java.util.Arrays;

/**
 * Description: 1552. Magnetic Force Between Two Balls
 *
 * @author Baltan
 * @date 2020-08-22 09:08
 */
public class MaxDistance1 {
    public static void main(String[] args) {
        System.out.println(maxDistance(new int[]{1, 2, 3, 4, 7}, 3));
        System.out.println(maxDistance(new int[]{5, 4, 3, 2, 1, 1000000000}, 2));
    }

    public static int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int length = position.length;
        int hi = position[length - 1] - position[0];
        int lo = Integer.MAX_VALUE;

        for (int i = 1; i < length; i++) {
            lo = Math.min(lo, position[i] - position[i - 1]);
        }
        /**
         * 二分查找最大距离
         */
        while (lo <= hi) {
            int mid = (lo + hi) / 2;

            if (help(position, m, mid)) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return hi;
    }

    /**
     * 当两球之间的最小距离不小于distance时，判断是否可以满足要求
     *
     * @param position
     * @param m
     * @param distance
     * @return
     */
    public static boolean help(int[] position, int m, int distance) {
        int length = position.length;
        /**
         * 前一个球的位置，第一个球放在首个位置
         */
        int prev = position[0];
        m--;

        for (int i = 1; i < length; i++) {
            /**
             * 如果当前位置距离前一个球的位置已经不小于distance了，就在当前位置放下一个球
             */
            if (position[i] - prev >= distance) {
                prev = position[i];
                m--;
            }
        }
        /**
         * 如果放下的球的个数不少于m个，说明可以满足要求
         */
        return m <= 0;
    }
}
