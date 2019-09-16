package leetcode.algorithms;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Description: 1190. Reverse Substrings Between Each Pair of Parentheses
 *
 * @author Baltan
 * @date 2019-09-16 09:27
 */
public class ReverseParentheses {
    public static void main(String[] args) {
        System.out.println(reverseParentheses("(abcd)"));
        System.out.println(reverseParentheses("(u(love)i)"));
        System.out.println(reverseParentheses("(ed(et(oc))el)"));
        System.out.println(reverseParentheses("a(bcdefghijkl(mno)p)q"));
        System.out.println(reverseParentheses(""));
    }

    public static String reverseParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder builder = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (c != ')') {
                stack.push(c);
            } else {
                Queue<Character> queue = new LinkedList<>();
                /**
                 * 当遍历到")"时，将stack中的字符逐一出栈并加入到queue中，直到出现"("，抛弃"("，
                 * 将queue中的英文字符逐一出队加入stack中，实现将小括号中的英文字符串倒序排列的效果
                 */
                while (stack.peek() != '(') {
                    queue.offer(stack.pop());
                }
                stack.pop();

                for (char c1 : queue) {
                    stack.push(c1);
                }
            }
        }
        /**
         * 当所有的括号都被处理完毕后，将stack中的字符按顺序逐一取出拼接成字符串即可
         */
        for (char c : stack) {
            builder.append(c);
        }
        return builder.toString();
    }
}
