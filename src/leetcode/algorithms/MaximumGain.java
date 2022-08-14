package leetcode.algorithms;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Description: 1717. Maximum Score From Removing Substrings
 *
 * @author Baltan
 * @date 2022/8/14 14:31
 */
public class MaximumGain {
    public static void main(String[] args) {
        System.out.println(maximumGain("cdbcbbaaabab", 4, 5));
        System.out.println(maximumGain("aabbaaxybbaabb", 5, 4));
    }

    public static int maximumGain(String s, int x, int y) {
        int result = 0;
        Queue<Character> queue = new LinkedList<>();

        for (char c : s.toCharArray()) {
            queue.offer(c);
        }
        /**
         * 总是优先删除可以获得较大得分的字串
         */
        if (x >= y) {
            result += help(queue, 'a', 'b', x);
            result += help(queue, 'b', 'a', y);
        } else {
            result += help(queue, 'b', 'a', y);
            result += help(queue, 'a', 'b', x);
        }
        return result;
    }

    /**
     * 在queue中删除所有子串concat(start,end)可以获得的总得分
     *
     * @param queue
     * @param start
     * @param end
     * @param score
     * @return
     */
    public static int help(Queue<Character> queue, char start, char end, int score) {
        int totalScore = 0;
        Deque<Character> deque = new ArrayDeque<>();

        for (Character c : queue) {
            /**
             * 当前字符为end，并且栈顶字符为start时，这两个字符可以构成一个子串concat(start,end)
             */
            if (c == end && !deque.isEmpty() && deque.peekLast() == start) {
                deque.pollLast();
                totalScore += score;
            } else {
                deque.offer(c);
            }
        }
        /**
         * 将栈中剩余的字符重新赋值到queue中，用于另一种子串的计算
         */
        queue.clear();

        for (Character c : deque) {
            queue.offer(c);
        }
        return totalScore;
    }
}
