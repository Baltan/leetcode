package leetcode.algorithms;

import leetcode.entity.Interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description: Insert Interval
 *
 * @author Baltan
 * @date 2018/9/18 10:18
 */
public class Insert {
    public static void main(String[] args) {
        Interval interval1 = new Interval(1, 3);
        Interval interval2 = new Interval(6, 9);
        Interval newInterval1 = new Interval(2, 5);
        List<Interval> intervals1 =
                new ArrayList<>(Arrays.asList(interval1, interval2));
        System.out.println(insert(intervals1, newInterval1));

        Interval interval3 = new Interval(1, 2);
        Interval interval4 = new Interval(3, 5);
        Interval interval5 = new Interval(6, 7);
        Interval interval6 = new Interval(8, 10);
        Interval interval7 = new Interval(12, 16);
        Interval newInterval2 = new Interval(4, 8);
        List<Interval> intervals2 =
                new ArrayList<>(Arrays.asList(interval3, interval4, interval5, interval6, interval7));
        System.out.println(insert(intervals2, newInterval2));

        Interval interval8 = new Interval(1, 5);
        Interval newInterval3 = new Interval(2, 3);
        List<Interval> intervals3 =
                new ArrayList<>(Arrays.asList(interval8));
        System.out.println(insert(intervals3, newInterval3));

        Interval interval9 = new Interval(0, 5);
        Interval interval10 = new Interval(9, 12);
        Interval newInterval4 = new Interval(7, 16);
        List<Interval> intervals4 =
                new ArrayList<>(Arrays.asList(interval9, interval10));
        System.out.println(insert(intervals4, newInterval4));
    }

    public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> res = new ArrayList<>();
        if (newInterval == null) {
            return intervals;
        }
        if (intervals.size() == 0) {
            res.add(newInterval);
            return res;
        }
        if (newInterval.start < intervals.get(0).start) {
            res.add(newInterval);
            for (int i = 0; i < intervals.size(); i++) {
                Interval interval1 = res.get(res.size() - 1);
                Interval interval2 = intervals.get(i);
                if (interval2.start <= interval1.end) {
                    interval1.end = Math.max(interval1.end, interval2.end);
                } else {
                    res.add(intervals.get(i));
                }
            }
        } else {
            boolean flag = true;
            res.add(intervals.get(0));
            for (int i = 1; i < intervals.size(); i++) {
                Interval interval1 = res.get(res.size() - 1);
                Interval interval2;
                if (newInterval.start <= intervals.get(i).start && flag) {
                    interval2 = newInterval;
                    flag = false;
                    i--;
                } else {
                    interval2 = intervals.get(i);
                }
                if (interval2.start <= interval1.end) {
                    interval1.end = Math.max(interval1.end, interval2.end);
                } else {
                    res.add(interval2);
                }
            }
            if (flag) {
                if (newInterval.start <= res.get(res.size() - 1).end) {
                    res.get(res.size() - 1).end = Math.max(res.get(res.size() - 1).end, newInterval.end);
                } else {
                    res.add(newInterval);
                }
            }
        }
        return res;
    }
}
