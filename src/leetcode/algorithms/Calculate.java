package leetcode.algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Description: 224. Basic Calculator
 *
 * @author Baltan
 * @date 2019-06-11 21:55
 * @see Calculate1
 * @see leetcode.interview.Calculate
 */
public class Calculate {
    public static void main(String[] args) {
        System.out.println(calculate("1 + 1"));
        System.out.println(calculate(" 2-1 + 2 "));
        System.out.println(calculate(" - 5 -6 -8  +7 "));
        System.out.println(calculate("(1+(4+5+2)-3)+(6+8)"));
        System.out.println(calculate("-(5-(3-2-(8+7)-(6-3))+(1+2))"));
        System.out.println(calculate("-5+3-2-8-7-6+3-1-2"));
        System.out.println(calculate("(1+2+3-(4-5-6+(7-(8-9)))"));
        System.out.println(calculate("-(1-3)"));
        System.out.println(calculate("-(1   +5)"));
        System.out.println(calculate("2147483647"));
        System.out.println(calculate("-(3131-(322-21+(4234-321-(31321-311)))"));
        System.out.println(calculate("-65789"));
    }

    public static int calculate(String s) {
        int result = 0;
        int length = s.length();
        char sign = ' ';
        Stack<Character> stack = new Stack<>();
        /**
         * 保存每一层小括号前带着的运算符号
         */
        List<Character> signList = new ArrayList<>();
        int value = 0;

        /**
         * 如果表达式没有括号，只需从左向右计算即可
         */
        if (!s.contains("(")) {
            for (int i = 0; i < length; i++) {
                char c = s.charAt(i);

                if (c == ' ') {
                    continue;
                } else if (c == '-') {
                    sign = '-';
                } else if (c == '+') {
                    sign = '+';
                } else {
                    int j;
                    /**
                     * 如果当前遍历到的字符为数字
                     */
                    for (j = i; j < length; j++) {
                        char c1 = s.charAt(j);

                        if (c1 == ' ') {
                            continue;
                        } else if (c1 >= '0' && c1 <= '9') {
                            value = value * 10 + (c1 - '0');
                        } else {
                            break;
                        }
                    }

                    if (sign == '-') {
                        result -= value;
                    } else {
                        result += value;
                    }
                    value = 0;
                    /**
                     * 因为以上循环遍历到非数字或表达式最后时跳出，相当于最后第j个字符被忽略了，
                     * 需要将索引i-1，后面循环还是要处理这个字符的
                     */
                    i = j - 1;
                }
            }
        } else {
            for (int i = 0; i < length; i++) {
                char c = s.charAt(i);

                if (c == ' ') {
                    continue;
                } else if (c == '(') {
                    /**
                     * 标记小括号前是否还有作用于这个括号内表达式的运算符号
                     */
                    boolean flag = false;
                    /**
                     * 查找小括号前作用于这个括号内表达式的运算符号
                     */
                    for (int j = i - 1; j >= 0; j--) {
                        char c1 = s.charAt(j);

                        if (c1 == '-') {
                            /**
                             * 如果再外层没有小括号了或者再外层小括号前带"+"，则当前这层小括号前带"-"
                             */
                            if (signList.size() == 0 || signList.get(signList.size() - 1) == '+') {
                                signList.add('-');
                            } else {
                                signList.add('+');
                            }
                            flag = true;
                            break;
                        } else if (c1 == '+') {
                            /**
                             * 如果再外层没有小括号了或者再外层小括号前带"+"，则当前这层小括号前带"+"
                             */
                            if (signList.size() == 0 || signList.get(signList.size() - 1) == '+') {
                                signList.add('+');
                            } else {
                                signList.add('-');
                            }
                            flag = true;
                            break;
                        }
                    }
                    /**
                     * 如果小括号前没有作用于这个括号内表达式的运算符号了，则括号内表达式的计算结果带"+"
                     */
                    if (!flag) {
                        signList.add('+');
                    }
                    stack.push(c);
                } else if (c == ')') {
                    stack.pop();
                    signList.remove(signList.size() - 1);
                } else if (c == '-') {
                    /**
                     * 如果stack不为空，说明含当前字符的表达式是在小括号中的
                     */
                    if (!stack.isEmpty()) {
                        /**
                         * 如果作用于这个括号内表达式的运算符号为"-"，则当前运算实际上要"+"后面的数字
                         */
                        if (signList.get(stack.size() - 1) == '-') {
                            sign = '+';
                        } else {
                            sign = '-';
                        }
                    } else {
                        sign = '-';
                    }
                } else if (c == '+') {
                    if (!stack.isEmpty()) {
                        if (signList.get(stack.size() - 1) == '-') {
                            sign = '-';
                        } else {
                            sign = '+';
                        }
                    } else {
                        sign = '+';
                    }
                } else {
                    int j;
                    /**
                     * 如果当前遍历到的字符为数字
                     */
                    for (j = i; j < length; j++) {
                        char c1 = s.charAt(j);

                        if (c1 == ' ') {
                            continue;
                        } else if (c1 >= '0' && c1 <= '9') {
                            value = value * 10 + (c1 - '0');
                        } else {
                            break;
                        }
                    }

                    if (sign == '-') {
                        result -= value;
                    } else {
                        result += value;
                    }
                    value = 0;
                    /**
                     * 因为以上循环遍历到非数字或表达式最后时跳出，相当于最后第j个字符被忽略了，
                     * 需要将索引i-1，后面循环还是要处理这个字符的
                     */
                    i = j - 1;
                }
            }
        }
        return result;
    }
}
