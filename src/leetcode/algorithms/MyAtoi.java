package leetcode.algorithms;

/**
 * Description: 8. String to Integer (atoi)
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
        /**
         * 取出str首尾的空格
         */
        str = str.trim();

        if (str.length() == 0) {
            return 0;
        }

        char firstLetter = str.charAt(0);
        /**
         * 如果str第一个字符既不是数字也不是正负号，则str无法进行有效转换
         */
        if (firstLetter != '-' && firstLetter != '+' && !(firstLetter >= '0' && firstLetter <= '9')) {
            return 0;
        }
        /**
         * str中当前判断的字符的索引位置
         */
        int index = 0;
        int strLength = str.length();
        /**
         * 转换得到的有效整数的值
         */
        double value = 0;
        /**
         * 转换得到的有效整数的值的符号
         */
        char flag = '+';

        if (firstLetter == '+') {
            flag = '+';
            index++;
        } else if (firstLetter == '-') {
            flag = '-';
            index++;
        }
        /**
         * 如果str当前判断的字符是数字，则累加到value中，继续判断下一个字符
         */
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
