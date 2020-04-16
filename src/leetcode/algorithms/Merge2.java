package leetcode.algorithms;

import leetcode.util.OutputUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Description: 56. Merge Intervals
 *
 * @author Baltan
 * @date 2018/9/18 09:42
 * @see Merge1
 */
public class Merge2 {
    public static void main(String[] args) {
        int[][] intervals1 = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        OutputUtils.print2DIntegerArray(merge(intervals1));

        int[][] intervals2 = {{1, 4}, {4, 5}};
        OutputUtils.print2DIntegerArray(merge(intervals2));
    }

    public static int[][] merge(int[][] intervals) {
        List<int[]> intervalList = new ArrayList<>();

        if (intervals == null || intervals.length == 0) {
            return new int[][]{};
        }
        /**
         * 如果只有一个区间，则不需要合并，直接返回该区间即可
         */
        if (intervals.length == 1) {
            return intervals;
        }
        /**
         * 将所有区间按照区间起点升序排雷
         */
        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));
        intervalList.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            int[] interval1 = intervalList.get(intervalList.size() - 1);
            int[] interval2 = intervals[i];
            /**
             * 如果当前区间的起点和intervalList中的最后一个区间重合，说明这两个区间可以继续合并，
             * 合并后区间的终点即为两个区间终点的较大值；否则将当前区间加入到intervalList中
             */
            if (interval2[0] <= interval1[1]) {
                interval1[1] = Math.max(interval1[1], interval2[1]);
            } else {
                intervalList.add(intervals[i]);
            }
        }
        /**
         * 将intervalList转化为数组形式返回
         */
        int[][] result = new int[intervalList.size()][2];

        for (int i = 0; i < intervalList.size(); i++) {
            result[i] = intervalList.get(i);
        }
        return result;
    }
}
