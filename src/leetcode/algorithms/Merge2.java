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
        List<int[]> list = new ArrayList<>();

        if (intervals == null || intervals.length == 0) {
            return new int[][]{};
        }
        if (intervals.length == 1) {
            return intervals;
        }

        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));
        list.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] interval1 = list.get(list.size() - 1);
            int[] interval2 = intervals[i];
            if (interval2[0] <= interval1[1]) {
                interval1[1] = Math.max(interval1[1], interval2[1]);
            } else {
                list.add(intervals[i]);
            }
        }

        int[][] result = new int[list.size()][2];

        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}
