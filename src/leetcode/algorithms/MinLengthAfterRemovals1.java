package leetcode.algorithms;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Description: 3746. Minimum String Length After Balanced Removals
 *
 * @author baltan
 * @date 2026/1/22 13:58
 */
public class MinLengthAfterRemovals1 {
    public static void main(String[] args) {
        System.out.println(minLengthAfterRemovals("aabbab"));
        System.out.println(minLengthAfterRemovals("aaaa"));
        System.out.println(minLengthAfterRemovals("aaabb"));
    }

    public static int minLengthAfterRemovals(String s) {
        /**
         * 依次保存字符串s中未被配对消除的字符
         */
        Deque<Character> deque = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            if (deque.isEmpty() || deque.peekLast() == c) {
                deque.offerLast(c);
            } else {
                /**
                 * 当前字符deque.peekLast()可以和字符c配对消除
                 */
                deque.pollLast();
            }
        }
        return deque.size();
    }
}
