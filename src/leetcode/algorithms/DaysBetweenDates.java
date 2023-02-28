package leetcode.algorithms;

import java.util.Objects;

/**
 * Description: 1360. Number of Days Between Two Dates
 *
 * @author Baltan
 * @date 2023/2/21 09:38
 */
public class DaysBetweenDates {
    public static void main(String[] args) {
        System.out.println(daysBetweenDates("2019-06-29", "2019-06-30"));
        System.out.println(daysBetweenDates("2020-01-15", "2019-12-31"));
    }

    public static int daysBetweenDates(String date1, String date2) {
        if (Objects.equals(date1, date2)) {
            return 0;
        }
        /**
         * 平年每月的天数
         */
        int[] commonYearMonthlyDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        /**
         * 闰年每月的天数
         */
        int[] leapYearMonthlyDays = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int days1 = daysFrom19700101(date1, commonYearMonthlyDays, leapYearMonthlyDays);
        int days2 = daysFrom19700101(date2, commonYearMonthlyDays, leapYearMonthlyDays);
        /**
         * 较晚日期减去较早日期
         */
        return days1 <= days2 ? days2 - days1 : days1 - days2;
    }

    /**
     * 从1970-01-01到日期date经过的天数
     *
     * @param date
     * @param commonYearMonthlyDays
     * @param leapYearMonthlyDays
     * @return
     */
    public static int daysFrom19700101(String date, int[] commonYearMonthlyDays, int[] leapYearMonthlyDays) {
        int days = 0;
        int year = (date.charAt(0) - '0') * 1000 + (date.charAt(1) - '0') * 100 + (date.charAt(2) - '0') * 10 + (date.charAt(3) - '0');
        int month = (date.charAt(5) - '0') * 10 + (date.charAt(6) - '0');
        int day = (date.charAt(8) - '0') * 10 + (date.charAt(9) - '0');
        int[] monthlyDays = isLeapYear(year) ? leapYearMonthlyDays : commonYearMonthlyDays;
        /**
         * 从1970-01-01到year-01-01经过的天数
         */
        for (int i = 1970; i < year; i++) {
            days += isLeapYear(i) ? 366 : 365;
        }
        /**
         * 从year-01-01到year-month-01经过的天数
         */
        for (int i = 1; i < month; i++) {
            days += monthlyDays[i - 1];
        }
        /**
         * 从year-month-01到year-month-day经过的天数
         */
        days += day;
        return days;
    }

    /**
     * 判断年份year是否是闰年
     *
     * @param year
     * @return
     */
    public static boolean isLeapYear(int year) {
        return year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
    }
}
