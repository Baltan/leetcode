package leetcode.algorithms;

import java.time.LocalDate;

/**
 * Description: 1185. Day of the Week
 *
 * @author Baltan
 * @date 2019-09-09 10:04
 */
public class DayOfTheWeek {
    public static void main(String[] args) {
        System.out.println(dayOfTheWeek(31, 8, 2019));
        System.out.println(dayOfTheWeek(18, 7, 1999));
        System.out.println(dayOfTheWeek(15, 8, 1993));
        System.out.println(dayOfTheWeek(9, 9, 2019));
        System.out.println(dayOfTheWeek(1, 1, 1971));
        System.out.println(dayOfTheWeek(31, 12, 2100));
    }

    public static String dayOfTheWeek(int day, int month, int year) {
        String[] values = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        LocalDate date = LocalDate.of(year, month, day);
        return values[date.getDayOfWeek().getValue() % 7];
    }
}
