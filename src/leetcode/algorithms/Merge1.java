package leetcode.algorithms;

import leetcode.entity.Interval;

import java.util.*;

/**
 * Description: 56. Merge Intervals
 *
 * @author Baltan
 * @date 2018/9/18 09:42
 */
public class Merge1 {
    public static void main(String[] args) {
        Interval interval1 = new Interval(1, 3);
        Interval interval2 = new Interval(2, 6);
        Interval interval3 = new Interval(8, 10);
        Interval interval4 = new Interval(15, 18);
        List<Interval> intervals1 =
                new ArrayList<>(Arrays.asList(interval1, interval2, interval3, interval4));
        System.out.println(merge(intervals1));

        Interval interval5 = new Interval(1, 4);
        Interval interval6 = new Interval(4, 5);
        List<Interval> intervals2 =
                new ArrayList<>(Arrays.asList(interval5, interval6));
        System.out.println(merge(intervals2));
    }

    public static List<Interval> merge(List<Interval> intervals) {
        List<Interval> res = new ArrayList<>();
        if (intervals == null || intervals.size() == 0) {
            return res;
        }
        if (intervals.size() == 1) {
            return intervals;
        }

        Collections
                .sort(intervals, Comparator.comparingInt((Interval interval) -> interval.start));
        res.add(intervals.get(0));
        for (int i = 1; i < intervals.size(); i++) {
            Interval interval1 = res.get(res.size() - 1);
            Interval interval2 = intervals.get(i);
            if (interval2.start <= interval1.end) {
                interval1.end = Math.max(interval1.end, interval2.end);
            } else {
                res.add(intervals.get(i));
            }
        }
        return res;
    }
}
