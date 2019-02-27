package leetcode.algorithms;

/**
 * Description: String to Integer (atoi)
 *
 * @author Baltan
 * @date 2018/8/28 16:00
 */
public class MyAtoi {
    public static void main(String[] args) {
        System.out.println(myAtoi("42"));
        System.out.println(myAtoi("   -42"));
        System.out.println(myAtoi("4193 with words"));
        System.out.println(myAtoi("words and 987"));
        System.out.println(myAtoi("-91283472332"));
        System.out.println(myAtoi("9223372036854775808"));
    }

    public static int myAtoi(String str) {
        if (str == null) {
            return 0;
        }
        str = str.trim();
        if (str.length() == 0) {
            return 0;
        }
        char firstLetter = str.charAt(0);
        if (firstLetter != '-' && firstLetter != '+' && !(firstLetter >= '0' && firstLetter <= '9')) {
            return 0;
        }

        int index = 0;
        int strLength = str.length();
        char flag = '+';
        if (firstLetter == '+') {
            flag = '+';
            index++;
        } else if (firstLetter == '-') {
            flag = '-';
            index++;
        }
        double value = 0;
        while (index < strLength && str.charAt(index) >= '0' && str.charAt(index) <= '9') {
            value = value * 10 + str.charAt(index) - '0';
            index++;
        }
        if (flag == '-') {
            value = -value;
        }
        if (value < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        if (value > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        return (int) value;
    }
}
