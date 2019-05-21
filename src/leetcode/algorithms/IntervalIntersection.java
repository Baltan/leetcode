package leetcode.algorithms;

import leetcode.entity.Interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description: 986. Interval List Intersections
 *
 * @author Baltan
 * @date 2019-03-22 19:47
 */
public class IntervalIntersection {
    public static void main(String[] args) {
        Interval[] A1 = {new Interval(0, 2), new Interval(5, 10), new Interval(13, 23), new Interval(24, 25)};
        Interval[] B1 = {new Interval(1, 5), new Interval(8, 12), new Interval(15, 24), new Interval(25, 26)};
        System.out.println(Arrays.toString(intervalIntersection(A1, B1)));
    }

    public static Interval[] intervalIntersection(Interval[] A, Interval[] B) {
        List<Interval> list = new ArrayList<>();
        int aLength = A.length;
        int bLength = B.length;
        int aIndex = 0;
        int bIndex = 0;

        while (aIndex < aLength && bIndex < bLength) {
            Interval intersection = getIntersection(A[aIndex], B[bIndex]);
            if (intersection != null) {
                list.add(intersection);
            }
            if (A[aIndex].end < B[bIndex].end) {
                aIndex++;
            } else if (A[aIndex].end == B[bIndex].end) {
                aIndex++;
                bIndex++;
            } else {
                bIndex++;
            }
        }
        return list.toArray(new Interval[0]);
    }

    public static Interval getIntersection(Interval A, Interval B) {
        if (A.end < B.start || B.end < A.start) {
            return null;
        }
        int start = Math.max(A.start, B.start);
        int end = Math.min(A.end, B.end);
        return new Interval(start, end);
    }
}
