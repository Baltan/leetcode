package leetcode.algorithms;

import java.util.Objects;

/**
 * Description: 1576. Replace All ?'s to Avoid Consecutive Repeating Characters
 *
 * @author Baltan
 * @date 2022/10/21 22:31
 */
public class ModifyString {
    public static void main(String[] args) {
        System.out.println(modifyString("?zs"));
        System.out.println(modifyString("ubv?w"));
        System.out.println(modifyString("?"));
        System.out.println(modifyString("a"));
        System.out.println(modifyString("ab"));
        System.out.println(modifyString("???"));
    }

    public static String modifyString(String s) {
        if (s.length() == 1) {
            return Objects.equals(s, "?") ? "a" : s;
        }
        char[] charArray = s.toCharArray();
        int length = charArray.length;

        for (int i = 0; i < length; i++) {
            if (charArray[i] == '?') {
                char prev = i > 0 ? charArray[i - 1] : charArray[i + 1];
                char next = i < length - 1 ? charArray[i + 1] : charArray[i - 1];
                charArray[i] = help(prev, next);
            }
        }
        return new String(charArray);
    }

    /**
     * 获取一个和prev和next都不同的小写英文字符
     *
     * @param prev
     * @param next
     * @return
     */
    public static char help(char prev, char next) {
        for (int i = 0; i < 26; i++) {
            char c = (char) ('a' + i);

            if (c != prev && c != next) {
                return c;
            }
        }
        return ' ';
    }
}
