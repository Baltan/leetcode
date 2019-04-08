package leetcode.algorithms;

import java.util.Stack;

/**
 * Description: Remove Outermost Parentheses
 *
 * @author Baltan
 * @date 2019-04-08 08:44
 */
public class RemoveOuterParentheses {
    public static void main(String[] args) {
        System.out.println(removeOuterParentheses("(()())(())"));
        System.out.println(removeOuterParentheses("(()())(())(()(()))"));
        System.out.println(removeOuterParentheses("()()"));
    }

    public static String removeOuterParentheses(String S) {
        Stack<Character> stack = new Stack<>();
        StringBuilder builder = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        int length = S.length();

        for (int i = 0; i < length; i++) {
            char c = S.charAt(i);
            if (c == '(') {
                stack.push(c);
                temp.append('(');
            } else {
                stack.pop();
                temp.append(')');
            }

            if (stack.isEmpty()) {
                temp.deleteCharAt(temp.length() - 1).deleteCharAt(0);
                builder.append(temp);
                temp.delete(0, temp.length());
            }
        }
        return builder.toString();
    }
}
