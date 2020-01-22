package leetcode.algorithms;

import java.util.Objects;

/**
 * Description: 467. Unique Substrings in Wraparound String
 *
 * @author Baltan
 * @date 2020-01-21 18:12
 */
public class FindSubstringInWraproundString {
    public static void main(String[] args) {
        System.out.println(findSubstringInWraproundString("a"));
        System.out.println(findSubstringInWraproundString("cac"));
        System.out.println(findSubstringInWraproundString("zab"));
        System.out.println(findSubstringInWraproundString(""));
        System.out.println(findSubstringInWraproundString(null));
    }

    public static int findSubstringInWraproundString(String p) {
        if (p == null || Objects.equals(p, "")) {
            return 0;
        }

        int result = 0;
        /**
         * count[i]记录以char(i+'a')这个字符结尾的最长连续字符串的长度
         */
        int[] count = new int[26];
        int pLength = p.length();
        /**
         * 当前遍历到的字符的前一个字符
         */
        char prev = p.charAt(0);
        /**
         * 当前遍历的连续字符串的长度
         */
        char length = 1;
        count[prev - 'a'] = 1;

        for (int i = 1; i < pLength; i++) {
            char c = p.charAt(i);

            if ((c == 'a' && prev == 'z') || c - prev == 1) {
                length++;
            } else {
                length = 1;
            }
            /**
             * 更新以当前字符结尾的最长连续字符串的长度
             */
            count[c - 'a'] = Math.max(count[c - 'a'], length);
            prev = c;
        }
        /**
         * 将以各个字符结尾的最长连续字符串的长度相加即为环绕字符串中p的唯一的子字符串的数量
         */
        for (int value : count) {
            result += value;
        }
        return result;
    }
}
