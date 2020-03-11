package leetcode.algorithms;

import java.util.Objects;

/**
 * Description: 1071. Greatest Common Divisor of Strings
 *
 * @author Baltan
 * @date 2019-06-02 16:50
 */
public class GcdOfStrings1 {
    public static void main(String[] args) {
        System.out.println(gcdOfStrings("ABCABC", "ABC"));
        System.out.println(gcdOfStrings("ABABAB", "ABAB"));
        System.out.println(gcdOfStrings("ABCABCABCABC", "ABCABCABCABC"));
        System.out.println(gcdOfStrings("LEET", "CODE"));
        System.out.println(gcdOfStrings("LEET", ""));
    }

    public static String gcdOfStrings(String str1, String str2) {
        if (Objects.equals(str1, "") || Objects.equals(str2, "")) {
            return "";
        }

        int length1 = str1.length();
        int length2 = str2.length();
        /**
         * 两个字符串长度的最大公约数，如果两个字符串存在最大公因子的话，最大公因子的长度即为gcdLength
         */
        int gcdLength = gcd(length1, length2);
        /**
         * 如果两个字符串存在最大公因子的话，最大公因子的长度即为gcdString
         */
        String gcdString = str1.substring(0, gcdLength);
        StringBuilder builder1 = new StringBuilder(length1);
        StringBuilder builder2 = new StringBuilder(length2);
        /**
         * 将最大公因子重复拼接直到长度和str1相同
         */
        for (int i = length1 / gcdLength; i > 0; i--) {
            builder1.append(gcdString);
        }
        /**
         * 将最大公因子重复拼接直到长度和str2相同
         */
        for (int i = length2 / gcdLength; i > 0; i--) {
            builder2.append(gcdString);
        }
        /**
         * 比较重新拼接成的字符串和原来的str1和str2是否相同
         */
        if (Objects.equals(builder1.toString(), str1) && Objects.equals(builder2.toString(), str2)) {
            return gcdString;
        } else {
            return "";
        }
    }

    /**
     * 求x和y的最大公约数
     *
     * @param x
     * @param y
     * @return
     */
    public static int gcd(int x, int y) {
        int min = Math.min(x, y);
        int max = Math.max(x, y);

        while (max % min != 0) {
            int remainder = max % min;
            max = min;
            min = remainder;
        }
        return min;
    }
}
