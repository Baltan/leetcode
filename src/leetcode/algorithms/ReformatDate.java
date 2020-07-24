package leetcode.algorithms;

import java.util.Objects;

/**
 * Description: 1507. Reformat Date
 *
 * @author Baltan
 * @date 2020-07-24 23:26
 */
public class ReformatDate {
    public static void main(String[] args) {
        System.out.println(reformatDate("20th Oct 2052"));
        System.out.println(reformatDate("6th Jun 1933"));
        System.out.println(reformatDate("26th May 1960"));
    }

    public static String reformatDate(String date) {
        StringBuilder builder = new StringBuilder(10);
        String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov",
                "Dec"};
        String[] str = date.split(" ");
        String dayStr = str[0];
        /**
         * 日期
         */
        String day = dayStr.substring(0, dayStr.length() - 2);
        int month = 0;
        /**
         * 确定月份
         */
        for (int i = 0; i < 12; i++) {
            if (Objects.equals(months[i], str[1])) {
                month = i + 1;
                break;
            }
        }

        builder.append(str[2]).append("-");
        /**
         * 如果月份数是一位数，前面补零
         */
        if (month < 10) {
            builder.append(0).append(month).append("-");
        } else {
            builder.append(month).append("-");
        }
        /**
         * 如果日期数是一位数，前面补零
         */
        if (day.length() < 2) {
            builder.append(0).append(day);
        } else {
            builder.append(day);
        }
        return builder.toString();
    }
}
