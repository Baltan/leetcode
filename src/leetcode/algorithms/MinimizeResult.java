package leetcode.algorithms;

/**
 * Description: 2232. Minimize Result by Adding Parentheses to Expression
 *
 * @author Baltan
 * @date 2022/4/13 23:04
 */
public class MinimizeResult {
    public static void main(String[] args) {
        System.out.println(minimizeResult("247+38"));
        System.out.println(minimizeResult("12+34"));
        System.out.println(minimizeResult("999+999"));
    }

    public static String minimizeResult(String expression) {
        String result = null;
        int min = Integer.MAX_VALUE;
        int plusIndex = expression.indexOf("+");
        /**
         * 加号前的字符串
         */
        String str1 = expression.substring(0, plusIndex);
        /**
         * 加号后的字符串
         */
        String str2 = expression.substring(plusIndex + 1);
        int length1 = str1.length();
        int length2 = str2.length();
        /**
         * i为第一个加数的长度
         */
        for (int i = 1; i <= length1; i++) {
            /**
             * j为第二个加数的长度
             */
            for (int j = 1; j <= length2; j++) {
                /**
                 * 左括号前的字符串，即第一个数字
                 */
                String num1 = str1.substring(0, length1 - i);
                /**
                 * 左括号和加号之间的字符串，即第二个数字
                 */
                String num2 = str1.substring(length1 - i);
                /**
                 * 加号和右括号之间的字符串，即第三个数字
                 */
                String num3 = str2.substring(0, j);
                /**
                 * 右括号后面的字符串，即第四个数字
                 */
                String num4 = str2.substring(j);

                int product = Integer.valueOf(num2) + Integer.valueOf(num3);
                /**
                 * 左括号左边还存在数字的情况
                 */
                if (i != length1) {
                    product *= Integer.valueOf(num1);
                }
                /**
                 * 右括号右边还存在数字的情况
                 */
                if (j != length2) {
                    product *= Integer.valueOf(num4);
                }

                if (product < min) {
                    min = product;
                    result = num1 + "(" + num2 + "+" + num3 + ")" + num4;
                }
            }
        }
        return result;
    }
}
