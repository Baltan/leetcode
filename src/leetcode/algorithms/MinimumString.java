package leetcode.algorithms;

import java.util.Arrays;
import java.util.Objects;

/**
 * Description: 2800. Shortest String That Contains Three Strings
 *
 * @author Baltan
 * @date 2023/7/30 15:11
 */
public class MinimumString {
    public static void main(String[] args) {
        System.out.println(minimumString("a", "a", "cac"));
        System.out.println(minimumString("abc", "bca", "aaa"));
        System.out.println(minimumString("ab", "ba", "aba"));
    }

    public static String minimumString(String a, String b, String c) {
        /**
         * 枚举三个字符串所有可能的拼接方式
         */
        String[] words = {
                concat(concat(a, b), c), concat(a, concat(b, c)),
                concat(concat(a, c), b), concat(a, concat(c, b)),
                concat(concat(b, a), c), concat(b, concat(a, c)),
                concat(concat(b, c), a), concat(b, concat(c, a)),
                concat(concat(c, a), b), concat(c, concat(a, b)),
                concat(concat(c, b), a), concat(c, concat(b, a))
        };
        /**
         * 将所有拼接得到的字符串按照长度递增的顺序排序，如果出现两个字符串长度一样，则按照字典顺序排序
         */
        Arrays.sort(words, (x, y) -> x.length() == y.length() ? x.compareTo(y) : x.length() - y.length());
        return words[0];
    }

    /**
     * 将字符串x的尾部和字符串y的头部相连，其中x的尾部子串和y的头部子串如果有相等的，就将这部分子串重合
     *
     * @param x
     * @param y
     * @return
     */
    public static String concat(String x, String y) {
        if (x.contains(y)) {
            return x;
        }

        if (y.contains(x)) {
            return y;
        }
        /**
         * x的尾部子串和y的头部子串可能重合的最大长度
         */
        int length = Math.min(x.length(), y.length());

        while (length > 0 && !Objects.equals(x.substring(x.length() - length), y.substring(0, length))) {
            length--;
        }
        /**
         * 合并后的字符串为x的头部子串x.substring(0,length)、重合的字串x.substring(length,x.length(),x.length)、y的尾部子串
         * y.substring(length)三者的连接，即x+y.substring(length)
         */
        return x + y.substring(length);
    }
}
