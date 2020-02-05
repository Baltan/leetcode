package leetcode.algorithms;

import leetcode.util.OutputUtils;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Description: 436. Find Right Interval
 *
 * @author Baltan
 * @date 2020-02-05 10:53
 */
public class FindRightInterval {
    public static void main(String[] args) {
        int[][] intervals1 = {{1, 2}};
        OutputUtils.print1DIntegerArray(findRightInterval(intervals1));

        int[][] intervals2 = {{3, 4}, {2, 3}, {1, 2}};
        OutputUtils.print1DIntegerArray(findRightInterval(intervals2));

        int[][] intervals3 = {{1, 4}, {2, 3}, {3, 4}};
        OutputUtils.print1DIntegerArray(findRightInterval(intervals3));
    }

    public static int[] findRightInterval(int[][] intervals) {
        int length = intervals.length;
        int[] result = new int[length];
        /**
         * myIntervals[i]为[intervals[i][0],intervals[i][1],i]，即[区间起点,区间终点,区间索引]
         */
        int[][] myIntervals = new int[length][3];

        for (int i = 0; i < length; i++) {
            int[] interval = intervals[i];
            myIntervals[i] = new int[]{interval[0], interval[1], i};
        }
        /**
         * 将myIntervals中的元素按照区间起点升序排列
         */
        Arrays.sort(myIntervals, Comparator.comparingInt(x -> x[0]));
        /**
         * 对于intervals中的每一个区间在myIntervals中二分查找在其右侧的起点最小的区间
         */
        for (int i = 0; i < length; i++) {
            int end = intervals[i][1];
            int lo = 0;
            int hi = length - 1;
            /**
             * 二分查找不小于end的最小的区间起点
             */
            while (lo < hi) {
                int mid = (lo + hi) / 2;

                if (myIntervals[mid][0] < end) {
                    lo = mid + 1;
                } else {
                    hi = mid;
                }
            }
            /**
             * 如果end>myIntervals[hi][0]，说明不存在在interval[i]右侧的区间，result[i]填-1
             */
            result[i] = end > myIntervals[hi][0] ? -1 : myIntervals[hi][2];
        }
        return result;
    }
}
