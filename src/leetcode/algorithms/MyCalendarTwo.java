package leetcode.algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: 731. My Calendar II
 *
 * @author Baltan
 * @date 2022/11/16 09:25
 */
public class MyCalendarTwo {
    private List<int[]> oneList;
    private List<int[]> twoList;

    public MyCalendarTwo() {
        /**
         * 保存所有时间段
         */
        oneList = new ArrayList<>();
        /**
         * 保存所有已有重叠的时间段
         */
        twoList = new ArrayList<>();
    }

    public boolean book(int start, int end) {
        /**
         * 两段时间有重叠的情况有以下两种：
         * 1、start2>=start1并且start2<end1
         * start1--------------end1
         *     start2--------------end2
         *
         * 2、start1>=start2并且start1<end2
         * start2--------------end2
         *     start1--------------end1
         */
        for (int[] interval : twoList) {
            if (isOverlapped(start, end, interval[0], interval[1])) {
                return false;
            }
        }

        for (int[] interval : oneList) {
            if (isOverlapped(start, end, interval[0], interval[1])) {
                twoList.add(new int[]{Math.max(start, interval[0]), Math.min(end, interval[1])});
            }
        }
        oneList.add(new int[]{start, end});
        return true;
    }

    /**
     * 判断两段时间是否有重叠
     *
     * @param start1
     * @param end1
     * @param start2
     * @param end2
     * @return
     */
    private boolean isOverlapped(int start1, int end1, int start2, int end2) {
        return (start1 >= start2 && start1 < end2) || (start2 >= start1 && start2 < end1);
    }

    public static void main(String[] args) {
        MyCalendarTwo myCalendarTwo = new MyCalendarTwo();
        System.out.println(myCalendarTwo.book(10, 20));
        System.out.println(myCalendarTwo.book(50, 60));
        System.out.println(myCalendarTwo.book(10, 40));
        System.out.println(myCalendarTwo.book(5, 15));
        System.out.println(myCalendarTwo.book(5, 10));
        System.out.println(myCalendarTwo.book(25, 55));
    }
}
