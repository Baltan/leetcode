package leetcode.algorithms;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Description: 557. Reverse Words in a String III
 *
 * @author Baltan
 * @date 2017/11/17 14:26
 */
public class ReverseWords {
    public static void main(String[] args) {
        String s1 = "Let's take LeetCode contest";
        System.out.println(reverseWords(s1));
    }

    public static String reverseWords(String s) {
        s = s + " ";
        StringBuilder builder = new StringBuilder(s.length());
        /**
         * 将当前单词逐个字符入栈
         */
        Deque<Character> deque = new ArrayDeque<>();
        char[] charArray = s.toCharArray();

        for (char c : charArray) {
            if (c != ' ') {
                deque.offerLast(c);
            } else {
                /**
                 * 将队列中的字符逐个出栈，可以实现将之前的单词颠倒
                 */
                while (!deque.isEmpty()) {
                    builder.append(deque.pollLast());
                }
                builder.append(' ');
            }
        }
        return builder.substring(0, builder.length() - 1);
    }
}
