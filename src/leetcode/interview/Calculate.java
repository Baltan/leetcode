package leetcode.interview;

/**
 * Description: 面试题 16.26. 计算器
 *
 * @author Baltan
 * @date 2020-04-12 14:01
 * @see leetcode.algorithms.Calculate1
 * @see leetcode.algorithms.Calculate
 */
public class Calculate {
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
        /**
         * 如果表达式没有加减运算，从左向右处理乘除运算即可
         */
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
            /**
             * 最后一个数字没有计算，需要追加计算
             */
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
                    /**
                     * 如果遇到乘除符号，则从符号前的数字开始向后遍历直到遇到加减号前的数字为止，
                     * 这部分表达式的结果需要优先计算
                     */
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
                    /**
                     * 因为以上循环遍历到加减号或表达式最后时跳出，相当于最后第j个字符被忽略了，
                     * 需要将索引i-1，后面循环还是要处理这个字符的
                     */
                    i = j - 1;
                }
            }
            /**
             * 最后一个数字没有计算，需要追加计算
             */
            if (sign == '-') {
                result -= value;
            } else {
                result += value;
            }
        }
        return result;
    }
}
