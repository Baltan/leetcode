package leetcode.algorithms;

import java.util.Stack;

/**
 * Description: 1249. Minimum Remove to Make Valid Parentheses
 *
 * @author Baltan
 * @date 2019-11-15 09:14
 */
public class MinRemoveToMakeValid {
    public static void main(String[] args) {
        System.out.println(minRemoveToMakeValid("lee(t(c)o)de)"));
        System.out.println(minRemoveToMakeValid("a)b(c)d"));
        System.out.println(minRemoveToMakeValid("))(("));
        System.out.println(minRemoveToMakeValid("(a(b(c)d)"));
    }

    public static String minRemoveToMakeValid(String s) {
        StringBuilder builder1 = new StringBuilder();
        Stack<Character> stack1 = new Stack<>();
        /**
         * 正向遍历一遍字符串，将多余的")"删除
         */
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack1.push(c);
                builder1.append(c);
            } else if (c == ')') {
                if (!stack1.isEmpty()) {
                    stack1.pop();
                    builder1.append(c);
                }
            } else {
                builder1.append(c);
            }
        }

        if (stack1.isEmpty()) {
            return builder1.toString();
        } else {
            /**
             * 如果stack1不为空的话，说面前面有多余的"("
             */
            int length = builder1.length();
            StringBuilder builder2 = new StringBuilder();
            Stack<Character> stack2 = new Stack<>();
            /**
             * 反向遍历一遍字符串，将多余的"("删除
             */
            for (int i = length - 1; i >= 0; i--) {
                char c = builder1.charAt(i);

                if (c == ')') {
                    stack2.push(c);
                    builder2.insert(0, c);
                } else if (c == '(') {
                    if (!stack2.isEmpty()) {
                        stack2.pop();
                        builder2.insert(0, c);
                    }
                } else {
                    builder2.insert(0, c);
                }
            }
            return builder2.toString();
        }
    }
}
