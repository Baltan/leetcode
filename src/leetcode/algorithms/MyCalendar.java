package leetcode.algorithms;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Description: 729. My Calendar I
 *
 * @author Baltan
 * @date 2019-08-23 13:10
 */
public class MyCalendar {
    private Queue<int[]> queue;

    public MyCalendar() {
        queue = new PriorityQueue<>(Comparator.comparingInt(x -> x[0]));
    }

    public boolean book(int start, int end) {
        /**
         * 如果要安排的日程第一天在某个已安排的日程范围内，返回false
         */
        for (int[] arrangement : queue) {
            if (start >= arrangement[0] && start < arrangement[1]) {
                return false;
            }
        }
        /**
         * 如果要安排的日程最后一天在某个已安排的日程范围内，返回false
         */
        for (int[] arrangement : queue) {
            if (end - 1 >= arrangement[0] && end - 1 < arrangement[1]) {
                return false;
            }
        }
        /**
         * 如果要安排的日程范围包含了某个已安排的日程范围，返回false
         */
        for (int[] arrangement : queue) {
            if (start < arrangement[0] && end >= arrangement[1]) {
                return false;
            }
        }
        queue.offer(new int[]{start, end});
        return true;
    }

    public static void main(String[] args) {
        MyCalendar myCalendar1 = new MyCalendar();
        System.out.println(myCalendar1.book(10, 20));
        System.out.println(myCalendar1.book(15, 25));
        System.out.println(myCalendar1.book(20, 30));

        System.out.println("------------");

        MyCalendar myCalendar2 = new MyCalendar();
        System.out.println(myCalendar2.book(1, 10));
        System.out.println(myCalendar2.book(20, 30));
        System.out.println(myCalendar2.book(40, 50));
        System.out.println(myCalendar2.book(15, 35));
    }
}
