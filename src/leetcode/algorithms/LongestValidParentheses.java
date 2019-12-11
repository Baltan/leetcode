package leetcode.algorithms;

import java.util.Stack;

/**
 * Description: 32. Longest Valid Parentheses
 *
 * @author Baltan
 * @date 2019-12-11 08:41
 */
public class LongestValidParentheses {
    public static void main(String[] args) {
        System.out.println(longestValidParentheses("(()"));
        System.out.println(longestValidParentheses(")()())"));
        System.out.println(longestValidParentheses("())(())"));
        System.out.println(longestValidParentheses(""));
    }

    /**
     * 参考：
     * <a href="https://leetcode-cn.com/problems/longest-valid-parentheses/solution/zui-chang-you-xiao-gua-hao-by-leetcode/"></a>
     *
     * @param s
     * @return
     */
    public static int longestValidParentheses(String s) {
        if (s == null) {
            return 0;
        }

        int result = 0;
        Stack<Integer> stack = new Stack<>();
        /**
         * 当栈为空时加入的索引表示该索引为之前无效字符串的最后一个位置
         */
        stack.push(-1);
        int length = s.length();

        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);

            if (c == '(') {
                stack.push(i);
            } else {
                stack.pop();

                if (!stack.isEmpty()) {
                    result = Math.max(result, i - stack.peek());
                } else {
                    /**
                     * 当栈为空时加入的索引表示该索引为之前无效字符串的最后一个位置
                     */
                    stack.push(i);
                }
            }
        }
        return result;
    }
}
