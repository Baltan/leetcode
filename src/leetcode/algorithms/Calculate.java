package leetcode.algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Description: 224. Basic Calculator
 *
 * @author Baltan
 * @date 2019-06-11 21:55
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
        List<Character> signList = new ArrayList<>();
        int value = 0;

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
                    i = j - 1;
                }
            }
        } else {
            for (int i = 0; i < length; i++) {
                char c = s.charAt(i);

                if (c == ' ') {
                    continue;
                } else if (c == '(') {
                    boolean flag = false;

                    for (int j = i - 1; j >= 0; j--) {
                        char c1 = s.charAt(j);

                        if (c1 == '-') {
                            if (signList.size() == 0 || signList.get(signList.size() - 1) == '+') {
                                signList.add('-');
                            } else {
                                signList.add('+');
                            }
                            flag = true;
                            break;
                        } else if (c1 == '+') {
                            if (signList.size() == 0 || signList.get(signList.size() - 1) == '+') {
                                signList.add('+');
                            } else {
                                signList.add('-');
                            }
                            flag = true;
                            break;
                        }
                    }

                    if (!flag) {
                        signList.add('+');
                    }
                    stack.push(c);
                } else if (c == ')') {
                    stack.pop();
                    signList.remove(signList.size() - 1);
                } else if (c == '-') {
                    if (!stack.isEmpty()) {
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
                    i = j - 1;
                }
            }
        }
        return result;
    }
}
