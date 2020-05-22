package leetcode.interview;

/**
 * Description: 面试题67. 把字符串转换成整数
 *
 * @author Baltan
 * @date 2020-05-22 11:15
 * @see leetcode.algorithms.MyAtoi
 */
public class StrToInt {
    public static void main(String[] args) {
        System.out.println(strToInt("-2147483648"));
        System.out.println(strToInt("42"));
        System.out.println(strToInt("   -42"));
        System.out.println(strToInt("4193 with words"));
        System.out.println(strToInt("words and 987"));
        System.out.println(strToInt("-91283472332"));
    }

    public static int strToInt(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }

        str = str.trim();

        if (str.length() == 0) {
            return 0;
        }
        /**
         * 转换得到的有效整数的值的符号
         */
        char sign = ' ';
        /**
         * 转换得到的有效整数的值
         */
        long value = 0;
        char first = str.charAt(0);

        if (Character.isDigit(first)) {
            value += first - '0';
        } else if (first == '+' || first == '-') {
            sign = first;
        } else {
            /**
             * 如果str第一个字符既不是数字也不是正负号，则str无法进行有效转换，返回0
             */
            return 0;
        }

        str = str.substring(1);

        for (char c : str.toCharArray()) {
            /**
             * 如果当前判断的字符不是数字，则结束循环
             */
            if (!Character.isDigit(c)) {
                if (sign == '-') {
                    return (int) -value;
                } else {
                    return (int) value;
                }
            }
            /**
             * 如果str当前判断的字符是数字，则累加到value中，继续判断下一个字符
             */
            value = value * 10 + (c - '0');
            /**
             * 如果负数值小于Integer.MIN_VALUE，则返回Integer.MIN_VALUE；如果正数值大于Integer.MAX_VALUE，
             * 则返回Integer.MAX_VALUE
             */
            if (sign == '-' && -value < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            } else if (sign != '-' && value > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
        }

        if (sign == '-') {
            /**
             * 如果负数值小于Integer.MIN_VALUE，则返回Integer.MIN_VALUE
             */
            if (-value < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            } else {
                return (int) -value;
            }
        } else {
            /**
             * 如果正数值大于Integer.MAX_VALUE，则返回Integer.MAX_VALUE
             */
            if (value > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            } else {
                return (int) value;
            }
        }
    }
}
