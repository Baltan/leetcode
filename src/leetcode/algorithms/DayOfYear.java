package leetcode.algorithms;

/**
 * Description: 1154. Day of the Year
 *
 * @author Baltan
 * @date 2019-08-12 08:56
 */
public class DayOfYear {
    public static void main(String[] args) {
        System.out.println(dayOfYear("2019-01-09"));
        System.out.println(dayOfYear("2019-02-10"));
        System.out.println(dayOfYear("2003-03-01"));
        System.out.println(dayOfYear("2004-03-01"));
        System.out.println(dayOfYear("1900-10-10"));
        System.out.println(dayOfYear("1990-11-11"));
        System.out.println(dayOfYear("1991-11-14"));
    }

    public static int dayOfYear(String date) {
        int result = 0;
        /**
         * 闰年每月天数
         */
        int[] leapYear = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        /**
         * 平年每月天数
         */
        int[] commonYear = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] array = date.split("-");
        int year = Integer.valueOf(array[0]);
        int month = Integer.valueOf(array[1]);
        int day = Integer.valueOf(array[2]);
        /**
         * 如果年份为400的倍数或者年份为4的倍数且不为100的倍数，则该年为闰年
         * 例如：2004、2000为闰年，1900、2002为平年
         */
        if ((year % 400 == 0) || (year % 4 == 0 && year % 100 != 0)) {
            for (int i = 0; i < month - 1; i++) {
                result += leapYear[i];
            }
            result += day;
        } else {
            for (int i = 0; i < month - 1; i++) {
                result += commonYear[i];
            }
            result += day;
        }
        return result;
    }
}
