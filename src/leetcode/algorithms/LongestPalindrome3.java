package leetcode.algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Description: 3503. Longest Palindrome After Substring Concatenation I
 *
 * @author Baltan
 * @date 2025/4/17 23:08
 */
public class LongestPalindrome3 {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("vn", "ln"));
        System.out.println(longestPalindrome("n", "no"));
        System.out.println(longestPalindrome("a", "a"));
        System.out.println(longestPalindrome("abc", "def"));
        System.out.println(longestPalindrome("b", "aaaa"));
        System.out.println(longestPalindrome("abcde", "ecdba"));
    }

    public static int longestPalindrome(String s, String t) {
        int result = 0;
        /**
         * 字符串s的子串substring -> 子串substring在s中的起始索引
         */
        Map<String, List<Integer>> startIndexesMap = new HashMap<>();
        /**
         * sLongestPalindromes[i]表示字符串s中以字符s[i]开头的最长回文子串的长度
         */
        int[] sLongestPalindromes = new int[s.length()];
        /**
         * tLongestPalindromes[i]表示字符串t中以字符t[i]结尾的最长回文子串的长度
         */
        int[] tLongestPalindromes = new int[t.length()];

        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j <= s.length(); j++) {
                String substring = s.substring(i, j);
                startIndexesMap.computeIfAbsent(substring, x -> new ArrayList<>()).add(i);
            }
        }

        for (int i = 0; i < s.length(); i++) {
            /**
             * 因为是要查找以字符s[i]开头的最长回文子串，所以按照子串最后一个字符的索引倒序遍历
             */
            for (int j = s.length() - 1; j >= i; j--) {
                if (isPalindrome(s, i, j)) {
                    sLongestPalindromes[i] = j - i + 1;
                    break;
                }
            }
        }

        for (int i = 0; i < t.length(); i++) {
            /**
             * 因为是要查找以字符t[i]结尾的最长回文子串，所以按照子串第一个字符的索引正序遍历
             */
            for (int j = 0; j <= i; j++) {
                if (isPalindrome(t, j, i)) {
                    tLongestPalindromes[i] = i - j + 1;
                    break;
                }
            }
        }

        for (int i = 0; i < t.length(); i++) {
            for (int j = i; j <= t.length(); j++) {
                String substring = new StringBuilder(t.substring(i, j)).reverse().toString();
                /**
                 * 子串substring自身就是个回文字符串，则s中的一个空串子串和substring拼接在一起仍旧为回文字符串
                 */
                if (isPalindrome(substring, 0, substring.length() - 1)) {
                    result = Math.max(result, substring.length());
                }
                List<Integer> startIndexes = startIndexesMap.get(substring);
                /**
                 * 对于t中反转后的子串substring，如果s中也有子串substring，则s中的子串substring和原始字符串t中的子串substring（逆）
                 * 拼接在一起可以构成一个回文子串
                 */
                if (startIndexes != null) {
                    for (int startIndex : startIndexes) {
                        /**
                         * 如果s中的子串substring之后还连接着回文子串x，则在s中的子串substring和原始字符串t中的子串substring（逆）之
                         * 间插入这个回文子串x仍旧成立，此时得到的回文子串的总长度为2*substring.length+x.length
                         */
                        result = Math.max(result, substring.length() * 2 +
                                (startIndex + substring.length() < s.length() ? sLongestPalindromes[startIndex + substring.length()] : 0));
                        /**
                         * 如果原始字符串t中的子串substring（逆）之前还连接着回文子串x，则在s中的子串substring和原始字符串t中的子串
                         * substring（逆）之间插入这个回文子串x仍旧成立
                         */
                        result = Math.max(result, substring.length() * 2 + (i - 1 >= 0 ? tLongestPalindromes[i - 1] : 0));
                    }
                }
            }
        }
        return result;
    }

    /**
     * 判断字符串str中，起始字符为str[start]，结束字符为str[end]的子串是否是回文字符串
     * @param str
     * @param start
     * @param end
     * @return
     */
    public static boolean isPalindrome(String str, int start, int end) {
        while (start < end) {
            if (str.charAt(start) != str.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
