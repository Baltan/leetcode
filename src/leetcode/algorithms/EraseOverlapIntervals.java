package leetcode.algorithms;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Description: 435. Non-overlapping Intervals
 *
 * @author Baltan
 * @date 2023/1/31 15:34
 */
public class EraseOverlapIntervals {
    public static void main(String[] args) {
        int[][] intervals1 = {{1, 2}, {2, 3}, {3, 4}, {1, 3}};
        System.out.println(eraseOverlapIntervals(intervals1));

        int[][] intervals2 = {{1, 2}, {1, 2}, {1, 2}};
        System.out.println(eraseOverlapIntervals(intervals2));

        int[][] intervals3 = {{1, 2}, {2, 3}};
        System.out.println(eraseOverlapIntervals(intervals3));
    }

    /**
     * 参考：<a href="https://leetcode.cn/problems/non-overlapping-intervals/solutions/541543/wu-zhong-die-qu-jian-by-leetcode-solutio-cpsb/"></a>
     *
     * @param intervals
     * @return
     */
    public static int eraseOverlapIntervals(int[][] intervals) {
        /**
         * 题目可转化为"在保证区间不重叠的情况下，选择尽可能多的区间"，count为选择的区间数
         */
        int count = 1;
        int length = intervals.length;
        /**
         * 按照每个区间的右端点坐标升序排列
         */
        Arrays.sort(intervals, Comparator.comparingInt(x -> x[1]));
        /**
         * 从左到右选择区间，原则上选择的区间interval不会和之前已选区间的右端点发生重叠，并且interval的右端点应该尽可能小，从而使得后面有更多
         * 的区间可以被选择，于是第一个区间就选择右端点最小的区间
         */
        int right = intervals[0][1];

        for (int i = 1; i < length; i++) {
            int[] interval = intervals[i];
            /**
             * 只要当前区间interval的右端点不会和之前已选区间的右端点发生重叠，就选择该区间
             */
            if (interval[0] >= right) {
                count++;
                right = interval[1];
            }
        }
        /**
         * 剩余区间就是应该被移除的
         */
        return length - count;
    }
}
