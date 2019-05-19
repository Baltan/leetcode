package leetcode.algorithms;

import java.util.Stack;

/**
 * Description: Remove All Adjacent Duplicates In String
 *
 * @author Baltan
 * @date 2019-05-19 14:25
 */
public class RemoveDuplicates2 {
    public static void main(String[] args) {
        System.out.println(removeDuplicates("abbaca"));
        System.out.println(removeDuplicates("abcdeedcbaffg"));
    }

    public static String removeDuplicates(String S) {
        Stack<Character> stack = new Stack<>();
        int length = S.length();
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < length; i++) {
            char c = S.charAt(i);

            if (stack.isEmpty() || stack.peek() != c) {
                stack.push(c);
            } else {
                stack.pop();
            }
        }

        for (char c : stack) {
            builder.append(c);
        }
        return builder.toString();
    }
}
