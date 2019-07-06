package leetcode.algorithms;

import java.util.Stack;

/**
 * Description: 394. Decode String
 *
 * @author Baltan
 * @date 2019-07-05 20:55
 */
public class DecodeString {
    public static void main(String[] args) {
        System.out.println(decodeString("3[a]2[bc]"));
        System.out.println(decodeString("3[a2[c]]"));
        System.out.println(decodeString("2[abc]3[cd]ef"));
        System.out.println(decodeString("11[abc]ef"));
    }

    public static String decodeString(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        StringBuilder builder = new StringBuilder();
        int length = s.length();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);

            if (c == ']') {
                StringBuilder substr = new StringBuilder("]");
                char c1 = stack.peek();

                /**
                 * 将非数字的字符出栈，拼接在字符串头上，可以获得[abc]这种形式的字符串
                 */
                while (!(c1 >= '0' && c1 <= '9')) {
                    substr.insert(0, stack.pop());
                    c1 = stack.peek();
                }
                /**
                 * 将数字字符出栈，拼接在字符串头上，可以获得22[abc]这种形式的字符串
                 */
                while (c1 >= '0' && c1 <= '9') {
                    substr.insert(0, stack.pop());

                    if (stack.isEmpty()) {
                        break;
                    }
                    c1 = stack.peek();
                }

                /**
                 * 将以上获得的字符串展开，重新入栈
                 */
                String s1 = help(substr.toString());

                for (char c2 : s1.toCharArray()) {
                    stack.push(c2);
                }
            } else {
                stack.push(c);
            }
        }

        for (char c : stack) {
            builder.append(c);
        }
        return builder.toString();
    }

    /**
     * @param s 形式为3[abc]、22[defg]……之类的符合题目要求的字符串
     * @return
     */
    public static String help(String s) {
        StringBuilder builder = new StringBuilder();
        int length = s.length();
        int index1 = s.indexOf("[");
        int count = Integer.valueOf(s.substring(0, index1));
        String part = s.substring(index1 + 1, length - 1);

        for (int i = 0; i < count; i++) {
            builder.append(part);
        }
        return builder.toString();
    }
}
