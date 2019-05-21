package leetcode.algorithms;

import java.util.Stack;

/**
 * Description: 921. Minimum Add to Make Parentheses Valid
 *
 * @author Baltan
 * @date 2019-03-19 14:10
 */
public class MinAddToMakeValid {
    public static void main(String[] args) {
        System.out.println(minAddToMakeValid("())"));
        System.out.println(minAddToMakeValid("((("));
        System.out.println(minAddToMakeValid("()"));
        System.out.println(minAddToMakeValid("()))(("));
        System.out.println(minAddToMakeValid(""));
        System.out.println(minAddToMakeValid(")))))"));
        System.out.println(minAddToMakeValid("((((("));
        System.out.println(minAddToMakeValid(")))((("));
        System.out.println(minAddToMakeValid("))(()("));
    }

    public static int minAddToMakeValid(String S) {
        Stack<Character> stack = new Stack<>();
        int length = S.length();
        for (int i = 0; i < length; i++) {
            if (S.charAt(i) == ')' && !stack.isEmpty() && stack.peek() == '(') {
                stack.pop();
            } else {
                stack.add(S.charAt(i));
            }
        }
        return stack.size();
    }
}
