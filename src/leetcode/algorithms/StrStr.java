package leetcode.algorithms;

import java.util.Objects;

/**
 * Description: 28. Implement strStr()
 *
 * @author Baltan
 * @date 2017/11/28 08:28
 */
public class StrStr {
    public static void main(String[] args) {
        System.out.println(strStr("hello", "ll"));
        System.out.println(strStr("aaaaa", "bba"));
        System.out.println(strStr("aaaaa", ""));
    }

    public static int strStr(String haystack, String needle) {
        if (Objects.equals(needle, "")) {
            return 0;
        }

        int length = haystack.length();
        int wordLength = needle.length();

        for (int i = 0; i < length + 1 - wordLength; i++) {
            if (Objects.equals(haystack.substring(i, i + wordLength), needle)) {
                return i;
            }
        }
        return -1;
    }
}
