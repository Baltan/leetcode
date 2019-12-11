package leetcode.algorithms;

/**
 * Description: 32. Longest Valid Parentheses
 *
 * @author Baltan
 * @date 2019-12-11 08:41
 */
public class LongestValidParentheses1 {
    public static void main(String[] args) {
        System.out.println(longestValidParentheses("(()"));
        System.out.println(longestValidParentheses(")()())"));
        System.out.println(longestValidParentheses("())(())"));
        System.out.println(longestValidParentheses(""));
        System.out.println(longestValidParentheses("()((())"));
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
        /**
         * 当前"("的个数
         */
        int left = 0;
        /**
         * 当前")"的个数
         */
        int right = 0;
        int length = s.length();

        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);

            if (c == '(') {
                left++;
            } else {
                right++;
            }

            if (left == right) {
                result = Math.max(result, right * 2);
            } else if (right > left) {
                left = 0;
                right = 0;
            }
        }
        /**
         * 因为对称性，需要从右到左再遍历一次，否则类似"()((())"的字符串得不到正确答案
         */
        left = 0;
        right = 0;

        for (int i = length - 1; i >= 0; i--) {
            char c = s.charAt(i);

            if (c == '(') {
                left++;
            } else {
                right++;
            }

            if (left == right) {
                result = Math.max(result, right * 2);
            } else if (left > right) {
                left = 0;
                right = 0;
            }
        }
        return result;
    }
}
