package leetcode.algorithms;

import leetcode.util.OutputUtils;

import java.util.Arrays;

/**
 * Description: 2251. Number of Flowers in Full Bloom
 *
 * @author Baltan
 * @date 2024/1/14 23:45
 */
public class FullBloomFlowers {
    public static void main(String[] args) {
        int[][] flowers1 = {{1, 6}, {3, 7}, {9, 12}, {4, 13}};
        int[] people1 = {2, 3, 7, 11};
        OutputUtils.print1DIntegerArray(fullBloomFlowers(flowers1, people1));

        int[][] flowers2 = {{1, 10}, {3, 3}};
        int[] people2 = {3, 3, 2};
        OutputUtils.print1DIntegerArray(fullBloomFlowers(flowers2, people2));
    }

    public static int[] fullBloomFlowers(int[][] flowers, int[] people) {
        int[] result = new int[people.length];
        int length = flowers.length;
        /**
         * startTimes[i]表示第i朵花花期开始时间
         */
        int[] startTimes = new int[length];
        /**
         * endTimes[i]表示第i朵花花期结束时间
         */
        int[] endTimes = new int[length];

        for (int i = 0; i < length; i++) {
            startTimes[i] = flowers[i][0];
            endTimes[i] = flowers[i][1];
        }
        Arrays.sort(startTimes);
        Arrays.sort(endTimes);

        for (int i = 0; i < people.length; i++) {
            int time = people[i];
            /**
             * 查找花期开始时间在time时刻之前（含time时刻）的花朵数
             */
            int totalStart = binarySearchStart(startTimes, time);
            /**
             * 查找花期结束时间在time时刻之前（不含time时刻）的花朵数
             */
            int totalEnd = binarySearchEnd(endTimes, time);
            result[i] = totalStart - totalEnd;
        }
        return result;
    }

    /**
     * 在有序数组startTimes中二分查找小于等于time的元素的个数
     *
     * @param startTimes
     * @param time
     * @return
     */
    public static int binarySearchStart(int[] startTimes, int time) {
        /**
         * 数组startTimes中所有元素都大于time
         */
        if (time < startTimes[0]) {
            return 0;
        }
        /**
         * 数组startTimes中所有元素都小于等于time
         */
        if (time >= startTimes[startTimes.length - 1]) {
            return startTimes.length;
        }
        int lo = 0;
        int hi = startTimes.length - 1;

        while (lo < hi) {
            int mid = (lo + hi + 1) / 2;

            if (startTimes[mid] > time) {
                hi = mid - 1;
            } else {
                lo = mid;
            }
        }
        return lo + 1;
    }

    /**
     * 在有序数组endTimes中二分查找小于time的元素的个数
     *
     * @param endTimes
     * @param time
     * @return
     */
    public static int binarySearchEnd(int[] endTimes, int time) {
        /**
         * 数组endTimes中所有元素都大于等于time
         */
        if (time <= endTimes[0]) {
            return 0;
        }
        /**
         * 数组endTimes中所有元素都小于time
         */
        if (time > endTimes[endTimes.length - 1]) {
            return endTimes.length;
        }
        int lo = 0;
        int hi = endTimes.length - 1;

        while (lo < hi) {
            int mid = (lo + hi + 1) / 2;

            if (endTimes[mid] >= time) {
                hi = mid - 1;
            } else {
                lo = mid;
            }
        }
        return lo + 1;
    }
}
