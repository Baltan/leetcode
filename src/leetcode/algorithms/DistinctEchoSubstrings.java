package leetcode.algorithms;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Description: 1316. Distinct Echo Substrings
 *
 * @author Baltan
 * @date 2020-01-13 11:29
 */
public class DistinctEchoSubstrings {
    public static void main(String[] args) {
        System.out.println(distinctEchoSubstrings("abcabcabc"));
        System.out.println(distinctEchoSubstrings("leetcodeleetcode"));
        System.out.println(distinctEchoSubstrings("aaaaaaa"));
    }

    public static int distinctEchoSubstrings(String text) {
        int result = 0;
        /**
         * 符合题意的子串的前半部分的集合
         */
        Set<String> substrings = new HashSet<>();
        int length = text.length();
        /**
         * 尝试所有可能的子串，i为子串的起始索引，最小可能为0，最大可能为length-2
         */
        for (int i = 0, startIndexMax = length - 2; i <= startIndexMax; i++) {
            /**
             * j为子串前半部分的长度，最小可能为1，最大可能为(length-i)/2
             */
            for (int j = 1, lengthMax = (length - i) / 2; j <= lengthMax; j++) {
                String prev = text.substring(i, i + j);
                String next = text.substring(i + j, i + 2 * j);
                /**
                 * 如果前半部分的子串和后半部分的子串相等，则连在一起的子串就是一个循环子字符串
                 */
                if (Objects.equals(prev, next) && !substrings.contains(prev)) {
                    result++;
                    /**
                     * 将这个循环子字符串加入substrings，避免将重复的循环子字符串计数
                     */
                    substrings.add(prev);
                }
            }
        }
        return result;
    }
}
