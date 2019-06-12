package leetcode.algorithms;

/**
 * Description: 227. Basic Calculator II
 *
 * @author Baltan
 * @date 2019-06-12 09:10
 */
public class Calculate1 {
    public static void main(String[] args) {
        System.out.println(calculate("3+2*2"));
        System.out.println(calculate(" 3/2 "));
        System.out.println(calculate(" 3+5 / 2 "));
        System.out.println(calculate("7/3*4"));
        System.out.println(calculate("423/313*23+423-322  *23 /342 -32"));
    }

    public static int calculate(String s) {
        int result = 0;
        char sign = ' ';
        int value = 0;
        int length = s.length();

        if (!s.contains("-") && !s.contains("+")) {
            result = 1;

            for (int i = 0; i < length; i++) {
                char c = s.charAt(i);

                if (c == ' ') {
                    continue;
                } else if (c >= '0' && c <= '9') {
                    value = value * 10 + (c - '0');
                } else {
                    if (sign == '/') {
                        result /= value;
                    } else {
                        result *= value;
                    }
                    sign = c;
                    value = 0;
                }
            }

            if (sign == '/') {
                result /= value;
            } else {
                result *= value;
            }
        } else {
            for (int i = 0; i < length; i++) {
                char c = s.charAt(i);

                if (c == ' ') {
                    continue;
                } else if (c >= '0' && c <= '9') {
                    value = value * 10 + (c - '0');
                } else if (c == '+' || c == '-') {
                    if (sign == '-') {
                        result -= value;
                    } else {
                        result += value;
                    }
                    sign = c;
                    value = 0;
                } else {
                    int j;
                    StringBuilder builder = new StringBuilder();
                    builder.append(value).append(c);

                    for (j = i + 1; j < length; j++) {
                        char c1 = s.charAt(j);

                        if (c1 == '+' || c1 == '-') {
                            break;
                        } else {
                            builder.append(c1);
                        }
                    }
                    value = calculate(builder.toString());
                    i = j - 1;
                }
            }

            if (sign == '-') {
                result -= value;
            } else {
                result += value;
            }
        }
        return result;
    }
}
