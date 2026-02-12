package leetcode.algorithms;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: 3714. Longest Balanced Substring II
 *
 * @author baltan
 * @date 2025/11/18 11:27
 * @see LongestBalanced
 */
public class LongestBalanced2 {
    public static void main(String[] args) {
        System.out.println(longestBalanced("cacbb"));
        System.out.println(longestBalanced("abcbc"));
        System.out.println(longestBalanced("abbac"));
        System.out.println(longestBalanced("aabcc"));
        System.out.println(longestBalanced("aba"));
    }

    /**
     * 参考：<a href="https://leetcode.cn/problems/longest-balanced-substring-ii/solutions/3896558/zui-chang-de-ping-heng-zi-chuan-ii-by-le-0g8o/"></a>
     *
     * @param s
     * @return
     */
    public static int longestBalanced(String s) {
        int result = help1(s);
        result = Math.max(result, help2(s, 'a', 'b'));
        result = Math.max(result, help2(s, 'a', 'c'));
        result = Math.max(result, help2(s, 'b', 'c'));
        result = Math.max(result, help3(s));
        return result;
    }

    /**
     * 只包含一种字符的最长平衡子串的长度
     *
     * @param s
     * @return
     */
    public static int help1(String s) {
        int result = 1;
        /**
         * 前一个字符
         */
        char prev = ' ';
        /**
         * 当前平衡子串的长度
         */
        int length = 0;

        for (char c : s.toCharArray()) {
            if (c != prev) {
                length = 1;
            } else {
                length++;
                result = Math.max(result, length);
            }
            prev = c;
        }
        return result;
    }

    /**
     * 只包含c1和c2两种字符的最长平衡子串的长度
     *
     * @param s
     * @param c1
     * @param c2
     * @return
     */
    public static int help2(String s, char c1, char c2) {
        int result = 0;
        /**
         * 前缀子串中字符c1和c2的个数之差
         */
        int difference = 0;
        /**
         * i -> 前缀子串中第一次出现字符c1和c2的个数之差为i的索引位置
         */
        Map<Integer, Integer> map = new HashMap<>();
        /**
         * 哨兵，空字符串的情况
         */
        map.put(0, -1);

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c != c1 && c != c2) {
                /**
                 * 平衡子串中只能包含字符c1和c2，后续重新开始查找平衡子串
                 */
                map = new HashMap<>();
                map.clear();
                /**
                 * 哨兵，空字符串的情况
                 */
                map.put(0, i);
                difference = 0;
            } else {
                difference += c == c1 ? 1 : -1;

                if (map.containsKey(difference)) {
                    /**
                     * 子串s[x……map[difference]]和s[x……i]中字符c1和c2的个数之差都为difference，则子串s[map[difference]]+1……i]
                     * 中字符c1和c2的个数相等，该子串为平衡子串
                     */
                    result = Math.max(result, i - map.get(difference));
                } else {
                    /**
                     * 记录前缀子串中第一次出现字符c1和c2的个数之差为difference的索引位置
                     */
                    map.put(difference, i);
                }
            }
        }
        return result;
    }

    /**
     * 包含三种字符的最长平衡子串的长度
     *
     * @param s
     * @return
     */
    public static int help3(String s) {
        int result = 0;
        /**
         * 前缀子串中字符c1和c2的个数之差
         */
        int difference1 = 0;
        /**
         * 前缀子串中字符c1和c3的个数之差
         */
        int difference2 = 0;
        /**
         * (difference1,difference2) -> 前缀子串中第一次出现字符c1和c2的个数之差为difference1，且字符c1和c3的个数之差为difference2
         * 的索引位置
         */
        Map<Pair, Integer> map = new HashMap<>();
        /**
         * 哨兵，空字符串的情况
         */
        map.put(new Pair(0, 0), -1);

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == 'a') {
                difference1++;
                difference2++;
            } else if (c == 'b') {
                difference1--;
            } else {
                difference2--;
            }
            Pair pair = new Pair(difference1, difference2);

            if (map.containsKey(pair)) {
                /**
                 * 子串s[x……map[pair]]和s[x……i]中字符c1和c2的个数之差都为difference1，字符c1和c3的个数之差都为difference2，则子串
                 * s[map[pair]+1……i]中字符c1和c2的个数相等，且字符c1和c3的个数相等，该子串为平衡子串
                 */
                result = Math.max(result, i - map.get(pair));
            } else {
                /**
                 * 记录前缀子串中第一次出现字符c1和c2的个数之差为difference1，且字符c1和c3的个数之差为difference2的索引位置
                 */
                map.put(pair, i);
            }
        }
        return result;
    }

    private record Pair(int difference1, int difference2) {
    }
}
