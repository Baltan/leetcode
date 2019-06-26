package leetcode.algorithms;

import java.util.*;

/**
 * Description: 352. Data Stream as Disjoint Intervals
 *
 * @author Baltan
 * @date 2019-06-26 08:51
 */
public class SummaryRanges1 {
    private Set<int[]> set;
    private Iterator<int[]> it;

    /**
     * Initialize your data structure here.
     */
    public SummaryRanges1() {
        set = new TreeSet<>(Comparator.comparingInt(range -> range[0]));
    }

    public void addNum(int val) {
        if (set.isEmpty()) {
            set.add(new int[]{val, val});
        } else if (set.size() == 1) {
            it = set.iterator();
            int[] range = it.next();
            if (val == range[0] - 1) {
                range[0] = val;
            } else if (val == range[1] + 1) {
                range[1] = val;
            } else if (val < range[0] - 1 || val > range[1] + 1) {
                set.add(new int[]{val, val});
            }
        } else {
            it = set.iterator();
            int[] range1 = it.next();
            int[] range2 = it.next();

            while (true) {
                if (range2 == null) {
                    if (range1[0] > val + 1 || range1[1] < val - 1) {
                        set.add(new int[]{val, val});
                        return;
                    } else if (range1[0] == val + 1) {
                        range1[0] = val;
                        return;
                    } else if (range1[0] <= val && range1[1] >= val) {
                        return;
                    } else if (range1[1] == val - 1) {
                        range1[1] = val;
                        return;
                    }
                } else {
                    if (range1[0] > val + 1) {
                        set.add(new int[]{val, val});
                        return;
                    } else if (range1[0] == val + 1) {
                        range1[0] = val;
                        return;
                    } else if (range1[0] <= val && range1[1] >= val) {
                        return;
                    } else if (range1[1] == val - 1) {
                        if (range2[0] > val + 1) {
                            range1[1] = val;
                            return;
                        } else {
                            range1[1] = range2[1];
                            set.remove(range2);
                            return;
                        }
                    } else if (range1[1] < val - 1) {
                        range1 = range2;
                        range2 = it.hasNext() ? it.next() : null;
                    }
                }
            }
        }
    }

    public int[][] getIntervals() {
        int size = set.size();
        int[][] ranges = new int[size][2];
        it = set.iterator();

        for (int i = 0; i < size; i++) {
            ranges[i] = it.next();
        }
        return ranges;
    }

    public static void main(String[] args) {
        SummaryRanges1 ranges1 = new SummaryRanges1();
        ranges1.addNum(1);
        System.out.println(Arrays.deepToString(ranges1.getIntervals()));
        ranges1.addNum(3);
        System.out.println(Arrays.deepToString(ranges1.getIntervals()));
        ranges1.addNum(7);
        System.out.println(Arrays.deepToString(ranges1.getIntervals()));
        ranges1.addNum(2);
        System.out.println(Arrays.deepToString(ranges1.getIntervals()));
        ranges1.addNum(6);
        System.out.println(Arrays.deepToString(ranges1.getIntervals()));
    }
}
