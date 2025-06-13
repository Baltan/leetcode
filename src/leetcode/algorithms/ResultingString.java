package leetcode.algorithms;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Description: 3561. Resulting String After Adjacent Removals
 *
 * @author baltan
 * @date 2025/6/12 17:12
 */
public class ResultingString {
    public static void main(String[] args) {
        System.out.println(resultingString("hkg"));
        System.out.println(resultingString("y"));
        System.out.println(resultingString("abc"));
        System.out.println(resultingString("adcb"));
        System.out.println(resultingString("zadb"));
        System.out.println(resultingString("babababaabababaababbabaabbabaaaaababccccbcabccbabcacbacbcacbacbacbacbacbacb"));
    }

    public static String resultingString(String s) {
        StringBuilder builder = new StringBuilder();
        Deque<Character> deque = new ArrayDeque<>();
        /**
         * 逐一将当前字符c和前一个字符比较，判断能否同时消去
         */
        for (char c : s.toCharArray()) {
            if (!deque.isEmpty() && (Math.abs(deque.peekLast() - c) == 1 || Math.abs(deque.peekLast() - c) == 25)) {
                deque.pollLast();
            } else {
                deque.offerLast(c);
            }
        }

        for (char c : deque) {
            builder.append(c);
        }
        return builder.toString();
    }
}
