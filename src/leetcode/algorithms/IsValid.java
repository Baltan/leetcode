package leetcode.algorithms;

import java.util.Stack;

/**
 * Description: 20. Valid Parentheses
 *
 * @author Baltan
 * @date 2017/11/25 12:07
 */
public class IsValid {
    public static void main(String[] args) {
        System.out.println(isValid("()"));
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("(]"));
        System.out.println(isValid("([)]"));
        System.out.println(isValid("]"));
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] charArray = s.toCharArray();

        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];

            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            }
            /**
             * 判断是否有"("可匹配，如果没有则字符串为无效括号
             */
            if (c == ')') {
                if (stack.isEmpty() || stack.peek() != '(') {
                    return false;
                } else {
                    stack.pop();
                }
            }
            /**
             * 判断是否有"["可匹配，如果没有则字符串为无效括号
             */
            if (c == ']') {
                if (stack.isEmpty() || stack.peek() != '[') {
                    return false;
                } else {
                    stack.pop();
                }
            }
            /**
             * 判断是否有"{"可匹配，如果没有则字符串为无效括号
             */
            if (c == '}') {
                if (stack.isEmpty() || stack.peek() != '{') {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }
        /**
         * 如果最后又多余的左括号没被匹配上，则字符串为无效括号
         */
        if (!stack.isEmpty()) {
            return false;
        }
        return true;
    }
}