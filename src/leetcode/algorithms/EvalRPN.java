package leetcode.algorithms;

import java.util.Objects;
import java.util.Stack;

/**
 * Description: 150. Evaluate Reverse Polish Notation
 *
 * @author Baltan
 * @date 2020-01-31 10:30
 */
public class EvalRPN {
    public static void main(String[] args) {
        String[] tokens1 = {"2", "1", "+", "3", "*"};
        System.out.println(evalRPN(tokens1));

        String[] tokens2 = {"4", "13", "5", "/", "+"};
        System.out.println(evalRPN(tokens2));

        String[] tokens3 = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        System.out.println(evalRPN(tokens3));
    }

    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {
            if (isInteger(token)) {
                /**
                 * 将所有整数字符串压入栈中
                 */
                stack.push(Integer.valueOf(token));
            } else {
                int num2 = stack.pop();
                int num1 = stack.pop();
                /**
                 * 将栈顶的两个数出栈进行运算，将运算的结果压回栈中
                 */
                if (Objects.equals("+", token)) {
                    stack.push(num1 + num2);
                } else if (Objects.equals("-", token)) {
                    stack.push(num1 - num2);
                } else if (Objects.equals("*", token)) {
                    stack.push(num1 * num2);
                } else if (Objects.equals("/", token)) {
                    stack.push(num1 / num2);
                }
            }
        }
        /**
         * 最后栈中仅存的一个数就是结果
         */
        return stack.pop();
    }

    /**
     * 判断某个字符串是否是整数
     *
     * @param token
     * @return
     */
    public static boolean isInteger(String token) {
        /**
         * 根据字符串的最后一个字符是否是数字字符来判断，不能根据第一个字符，因为字符串可能为负数，和
         * 减法运算符一样都是"-"开头
         */
        return Character.isDigit(token.charAt(token.length() - 1));
    }
}
