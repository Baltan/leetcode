package leetcode.algorithms;


import java.util.HashSet;
import java.util.Set;

/**
 * Description: 1684. Count the Number of Consistent Strings
 *
 * @author Baltan
 * @date 2022/9/3 11:42
 * @see CountConsistentStrings1
 */
public class CountConsistentStrings {
    public static void main(String[] args) {
        System.out.println(countConsistentStrings("ab", new String[]{"ad", "bd", "aaab", "baa", "badab"}));
        System.out.println(
                countConsistentStrings("abc", new String[]{"a", "b", "c", "ab", "ac", "bc", "abc"}));
        System.out.println(
                countConsistentStrings("cad", new String[]{"cc", "acd", "b", "ba", "bac", "bad", "ac", "d"}));
    }

    public static int countConsistentStrings(String allowed, String[] words) {
        int result = 0;
        /**
         * 字符串allowed中的所有字符集合
         */
        Set<Character> chars = new HashSet<>();

        for (char c : allowed.toCharArray()) {
            chars.add(c);
        }

        outer:
        for (String word : words) {
            /**
             * 判断字符串word中的每个字符是否包含在集合chars中
             */
            for (char c : word.toCharArray()) {
                if (!chars.contains(c)) {
                    continue outer;
                }
            }
            result++;
        }
        return result;
    }
}
