package leetcode.algorithms;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: 76. Minimum Window Substring
 *
 * @author Baltan
 * @date 2020-05-23 09:09
 */
public class MinWindow {
    public static void main(String[] args) {
        System.out.println(minWindow("cabwefgewcwaefgcf", "cae"));
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
    }

    public static String minWindow(String s, String t) {
        if (s == "" || s.length() < t.length()) {
            return "";
        }
        /**
         * 符合条件的子串的最小长度
         */
        int substringLength = Integer.MAX_VALUE;
        /**
         * 字符c -> 字符c在子串s中出现的次数
         */
        Map<Character, Integer> sMap = new HashMap<>();
        /**
         * 字符c -> 字符c在字符串t中出现的次数
         */
        Map<Character, Integer> tMap = new HashMap<>();
        /**
         * 窗口起始索引位置
         */
        int lo = 0;
        /**
         * 窗口结束索引位置
         */
        int hi = 0;
        /**
         * 符合条件的最小子串的起始索引位置
         */
        int start = -1;
        /**
         * 符合条件的最小子串的结束索引位置
         */
        int end = -1;
        /**
         * 如果存在符合条件的子串，则该子串的起始索引位置至多为s.length()-t.length()，否则该子串的长度小于字符
         * 串t的长度，必定不符合条件
         */
        int last = s.length() - t.length();
        char[] sCharArray = s.toCharArray();
        sMap.put(s.charAt(0), 1);
        /**
         * 统计字符串t中各个字符出现的次数
         */
        for (char c : t.toCharArray()) {
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }
        /**
         * 滑动窗口查找符合条件的最小子串
         */
        while (lo <= last) {
            /**
             * 如果当前子串符合条件，则右移lo指针，缩小窗口，判断子串是否仍旧符合条件
             */
            if (contains(sMap, tMap)) {
                /**
                 * 如果当前得到的子串比之前得到的子串更小，更新最小子串的起始索引和结束索引位置
                 */
                if (hi - lo + 1 <= substringLength) {
                    start = lo;
                    end = hi;
                    substringLength = end - start + 1;
                }
                char deleteChar = sCharArray[lo];
                sMap.put(deleteChar, sMap.get(deleteChar) - 1);
                lo++;
            } else {
                /**
                 * 如果当前子串不符合条件，则右移hi指针，扩大窗口
                 */
                hi++;
                /**
                 * 当hi指针仍在字符串s范围内时，可以继续判断子串是否符合条件，否则可以结束判断
                 */
                if (hi < s.length()) {
                    char addChar = sCharArray[hi];
                    sMap.put(addChar, sMap.getOrDefault(addChar, 0) + 1);
                } else {
                    break;
                }
            }
        }
        return substringLength == Integer.MAX_VALUE ? "" : s.substring(start, end + 1);
    }

    /**
     * 判断s子串中是否包含字符串t中所有字符
     *
     * @param sMap
     * @param tMap
     * @return
     */
    public static boolean contains(Map<Character, Integer> sMap, Map<Character, Integer> tMap) {
        for (Map.Entry<Character, Integer> entry : tMap.entrySet()) {
            char c = entry.getKey();

            if (!sMap.containsKey(c) || sMap.get(c) < entry.getValue()) {
                return false;
            }
        }
        return true;
    }
}
