package leetcode.algorithms;

import java.util.Map;
import java.util.TreeMap;

/**
 * Description: My Calendar III
 *
 * @author Baltan
 * @date 2019-05-09 09:36
 */
public class MyCalendarThree {
    private Map<Integer, Integer> map;

    public MyCalendarThree() {
        map = new TreeMap<>();
    }

    public int book(int start, int end) {
        map.put(start, map.getOrDefault(start, 0) + 1);
        map.put(end, map.getOrDefault(end, 0) - 1);
        int days = 0;
        int maxBookDays = 0;

        for (int num : map.values()) {
            days += num;
            maxBookDays = Math.max(days, maxBookDays);
        }
        return maxBookDays;
    }

    public static void main(String[] args) {
        MyCalendarThree calendar1 = new MyCalendarThree();
        System.out.println(calendar1.book(10, 20));
        System.out.println(calendar1.book(50, 60));
        System.out.println(calendar1.book(10, 40));
        System.out.println(calendar1.book(5, 15));
        System.out.println(calendar1.book(5, 10));
        System.out.println(calendar1.book(25, 55));
    }
}
