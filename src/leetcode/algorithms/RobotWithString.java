package leetcode.algorithms;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Description: 2434. Using a Robot to Print the Lexicographically Smallest String
 *
 * @author Baltan
 * @date 2022/12/11 12:02
 */
public class RobotWithString {
    public static void main(String[] args) {
        System.out.println(robotWithString("zza"));
        System.out.println(robotWithString("bac"));
        System.out.println(robotWithString("bdda"));
    }

    public static String robotWithString(String s) {
        StringBuilder builder = new StringBuilder();
        char[] charArray = s.toCharArray();
        /**
         * 表示字符串t
         */
        Deque<Character> deque = new ArrayDeque<>();
        /**
         * counts[0]-counts[25]依次表示字符串s中字母a-z的个数
         */
        int[] counts = new int[26];
        /**
         * 统计字符串s中每个字母出现的次数
         */
        for (char c : charArray) {
            counts[c - 'a']++;
        }

        for (char c : charArray) {
            counts[c - 'a']--;
            /**
             * 字符串s剩余子串中的最小字符
             */
            char minChar = 'z';
            /**
             * 计算字符串s剩余子串中的最小字符
             */
            for (char i = 'a'; i <= 'z'; i++) {
                if (counts[i - 'a'] > 0) {
                    minChar = i;
                    break;
                }
            }

            if (minChar < c) {
                /**
                 * 如果字符串s剩余子串中还有更小的字符，先将当前字符追加到字符串t尾部，因为优先在纸上写下后面更小的字符能使最终得到的字符串更小
                 */
                deque.offerLast(c);
            } else {
                builder.append(c);
                /**
                 * 如果字符串t尾部的字符都不大于字符串s剩余子串中的最小字符，将这部分字符都先写到纸上
                 */
                while (!deque.isEmpty() && deque.peekLast() <= minChar) {
                    builder.append(deque.pollLast());
                }
            }
        }
        return builder.toString();
    }
}
