package leetcode.interview;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * Description: 剑指 Offer 20. 表示数值的字符串
 *
 * @author Baltan
 * @date 2020-09-02 07:54
 * @see leetcode.algorithms.IsNumber
 */
public class IsNumber {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("0", " 0.1 ", "abc", "1 a",
                "2e10", " -90e3   ", " 1e", "e3", " 6e-1", " 99e2.5 ", "53.5e93", " --6 ", "-+3",
                "95a54e53", "123", " 123 ", "0123", "00", "-10", "-0", "123.5", "123.000000",
                "-500.777", "0.0000001", "0.00000", "0.", "00.5", "0.5e04", "12 3", "1a3",
                "", "     ", ".1", ".", "2e0", "+.8", " 005047e+6", "4e+", "-1E-16");
        for (String s : list) {
            System.out.println(s + " : " + isNumber(s));
        }
    }

    public static boolean isNumber(String s) {
        if (s == null) {
            return false;
        }
        /**
         * 删去s左右两端的空格
         */
        s = s.trim();

        if (Objects.equals(s, "")) {
            return false;
        }
        /**
         * 统计字符串s中指定类型的字符出现的次数：
         * charStatistics[0]：0-9的数量，charStatistics[1]："e"或"E"的数量，charStatistics[2]："."
         * 的数量，charStatistics[3]："±"的数量，charStatistics[4]：其他字符的数量
         */
        int[] charStatistics = new int[5];
        /**
         * 如果字符串s开头为"±"，删去这个符号
         */
        if (s.startsWith("+") || s.startsWith("-")) {
            s = s.substring(1);
        }
        /**
         * 统计字符串s中指定类型的字符出现的次数
         */
        charCounts(charStatistics, s);
        /**
         * 如果字符串s中只包含0-9这些字符，则s是一个有效字符串，直接返回true
         */
        if (charStatistics[0] == s.length()) {
            return true;
        }
        /**
         * 如果字符串s中包含除0-9、"±"、"."、"e"、"E"之外的无效字符，则s是一个无效字符串，直接返回false
         */
        if (charStatistics[4] > 0) {
            return false;
        }
        /**
         * 如果s中包含多余一个"e"和"E"，则s是一个无效字符串，直接返回false
         */
        if (charStatistics[1] > 1) {
            return false;
        }
        /**
         * 如果s中包含多余一个"."，则s是一个无效字符串，直接返回false
         */
        if (charStatistics[2] > 1) {
            return false;
        }

        if (charStatistics[1] == 0) {
            /**
             * 如果s中不包含"e"和"E"，并且s中含有"±"或者s为"."，则s是一个无效字符串，直接返回false，除去
             * 这两中情况外s是有效的整数或小数字符串
             */
            if (charStatistics[3] != 0) {
                return false;
            }

            if (Objects.equals(s, ".")) {
                return false;
            }
        } else {
            /**
             * 如果s中包含"e"或"E"，并且s以"e"或"E"打头或结尾，则s是一个无效字符串，直接返回false
             */
            if (s.startsWith("e") || s.endsWith("e") || s.startsWith("E") || s.endsWith("E")) {
                return false;
            }

            int eIndex = s.contains("e") ? s.indexOf("e") : s.indexOf("E");
            /**
             * 截取获得底数字符串
             */
            String baseNumber = s.substring(0, eIndex);
            /**
             * 截取获得指数字符串
             */
            String exponent = s.substring(eIndex + 1);
            /**
             * 如果指数字符串exponent开头为"±"，删去这个符号
             */
            if (exponent.startsWith("+") || exponent.startsWith("-")) {
                exponent = exponent.substring(1);
            }

            if (Objects.equals(exponent, "")) {
                return false;
            }
            /**
             * 如果指数字符串exponent包含0-9之外的字符，则s是一个无效字符串，直接返回false
             */
            if (!containsOnlyDigits(exponent)) {
                return false;
            }
            /**
             * 统计字符串baseNumber中指定类型的字符出现的次数
             * baseNumberCharStatistics[0]：0-9的数量，baseNumberCharStatistics[1]："e"的数量，
             * baseNumberCharStatistics[2]："."的数量，baseNumberCharStatistics[3]："±"的数量，
             * baseNumberCharStatistics[4]：其他字符的数量
             */
            int[] baseNumberCharStatistics = new int[5];
            /**
             * 统计字符串baseNumber中指定类型的字符出现的次数
             */
            charCounts(baseNumberCharStatistics, baseNumber);
            /**
             * 如果底数字符串baseNumber中包含"±"，则s是一个无效字符串，直接返回false
             */
            if (baseNumberCharStatistics[3] > 0) {
                return false;
            }
            /**
             * 如果底数字符串baseNumber中包含多余一个"."，则s是一个无效字符串，直接返回false
             */
            if (baseNumberCharStatistics[2] > 1) {
                return false;
            }
            /**
             * 如果底数字符串baseNumber为"."，则s是一个无效字符串，直接返回false
             */
            if (Objects.equals(baseNumber, ".")) {
                return false;
            }
        }
        return true;
    }

    /**
     * 统计字符串中指定类型的字符出现的次数
     *
     * @param charStatistics
     * @param s
     */
    public static void charCounts(int[] charStatistics, String s) {
        /**
         * charStatistics[0]：0-9的数量，charStatistics[1]："e"或"E"的数量，charStatistics[2]："."
         * 的数量，charStatistics[3]："±"的数量，charStatistics[4]：其他字符的数量
         */
        for (char c : s.toCharArray()) {
            if (c >= '0' && c <= '9') {
                charStatistics[0]++;
            } else if (c == 'e' || c == 'E') {
                charStatistics[1]++;
            } else if (c == '.') {
                charStatistics[2]++;
            } else if (c == '+' || c == '-') {
                charStatistics[3]++;
            } else {
                charStatistics[4]++;
            }
        }
    }

    /**
     * 判断字符串中是否只包含0-9这些字符
     *
     * @param s
     * @return
     */
    public static boolean containsOnlyDigits(String s) {
        for (char c : s.toCharArray()) {
            if (c < '0' || c > '9') {
                return false;
            }
        }
        return true;
    }
}
