package leetcode.algorithms;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: 1297. Maximum Number of Occurrences of a Substring
 *
 * @author Baltan
 * @date 2019-12-25 11:23
 */
public class MaxFreq {
    public static void main(String[] args) {
        System.out.println(maxFreq("aababcaab", 2, 3, 4));
        System.out.println(maxFreq("aaaa", 1, 3, 3));
        System.out.println(maxFreq("aabcabcab", 2, 2, 3));
        System.out.println(maxFreq("abcde", 2, 3, 3));
    }

    public static int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        int result = 0;
        /**
         * s的子串出现的次数
         */
        Map<String, Integer> substringCount = new HashMap<>();
        /**
         * 子串中每个字母出现的次数
         */
        Map<Character, Integer> charCount = new HashMap<>();
        int length = s.length();
        /**
         * s开头minSize个字母构成的子串，统计这个子串每个字母出现的次数
         */
        for (int i = 0; i < minSize; i++) {
            char c = s.charAt(i);
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }
        /**
         * 如果s开头minSize个字母构成的子串中不同字母的数目不大于maxLetters，则这个子串是一个符合要求
         * 的子串
         */
        if (charCount.size() <= maxLetters) {
            /**
             * 对s中这个子串出现的次数进行计数
             */
            substringCount.put(s.substring(0, minSize), 1);
            result = 1;
        }
        /**
         * 显然，长度为[minSize+1,maxSize]的子串出现的次数不会多余长度为minSize的子串，因为前者必然
         * 包含后者的出现，也就是说maxSize是一个没用的参数，只需考虑所有长度为minSize的子串即可。所以
         * 每次循环将前一个子串的第一个字母删去，在最后再加上一个字母即可获得一个新的长度为minSize的子
         * 串，判断这个子串是否符合要求即可。
         */
        for (int i = minSize; i < length; i++) {
            /**
             * 前一个子串的第一个字母，也就是当前子串要删去的字母
             */
            char deleteChar = s.charAt(i - minSize);
            /**
             * 前一个子串的第一个字母在子串中出现的次数
             */
            int deleteCharCount = charCount.get(deleteChar);

            if (deleteCharCount == 1) {
                charCount.remove(deleteChar);
            } else {
                charCount.put(deleteChar, deleteCharCount - 1);
            }
            /**
             * 当前子串要加上的字母
             */
            char addChar = s.charAt(i);
            /**
             * 当前子串要加上的字母在前一个子串中出现的次数
             */
            int addCharCount = charCount.getOrDefault(addChar, 0);
            charCount.put(addChar, addCharCount + 1);
            /**
             * 如果当前子串中不同字母的数目不大于maxLetters，则这个子串是一个符合要求的子串
             */
            if (charCount.size() <= maxLetters) {
                /**
                 * 截取获得当前子串
                 */
                String substring = s.substring(i + 1 - minSize, i + 1);
                /**
                 * s中这个子串出现的次数
                 */
                int frequency = substringCount.getOrDefault(substring, 0) + 1;
                /**
                 * 对s中这个子串出现的次数进行计数
                 */
                substringCount.put(substring, frequency);
                result = Math.max(result, frequency);
            }
        }
        return result;
    }
}
