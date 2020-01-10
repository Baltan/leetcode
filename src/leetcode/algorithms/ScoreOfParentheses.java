package leetcode.algorithms;

import java.util.Stack;

/**
 * Description: 856. Score of Parentheses
 *
 * @author Baltan
 * @date 2020-01-09 11:51
 */
public class ScoreOfParentheses {
    public static void main(String[] args) {
        System.out.println(scoreOfParentheses("()"));
        System.out.println(scoreOfParentheses("(())"));
        System.out.println(scoreOfParentheses("()()"));
        System.out.println(scoreOfParentheses("(()(()))"));
    }

    public static int scoreOfParentheses(String S) {
        int result = 0;
        Stack<Character> stack = new Stack<>();
        int length = S.length();

        for (int i = 0; i < length; i++) {
            char c = S.charAt(i);

            if (c == '(') {
                stack.push(c);
            } else {
                stack.pop();
                /**
                 * 如果当前的")"前面是"("，则这两个括号是一对，可以得分，此时stack中还有几个"("，就
                 * 说明这对括号外面被包裹了几层，需要在1分的基础上翻几番
                 */
                if (S.charAt(i - 1) == '(') {
                    result += 1 << stack.size();
                }
            }

        }
        return result;
    }
}
