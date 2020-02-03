package leetcode.algorithms;

import java.util.Objects;

/**
 * Description: 306. Additive Number
 *
 * @author Baltan
 * @date 2020-02-03 12:17
 */
public class IsAdditiveNumber {
    public static void main(String[] args) {
        System.out.println(isAdditiveNumber("112358"));
        System.out.println(isAdditiveNumber("199100199"));
        System.out.println(isAdditiveNumber("10"));
        System.out.println(isAdditiveNumber("199001200"));
        System.out.println(isAdditiveNumber("111122335588143"));
    }

    public static boolean isAdditiveNumber(String num) {
        int length = num.length();
        int halfLength = length / 2;
        /**
         * 枚举所有最开始两个数可能的情况，两个数各自的长度都不会超过halfLength，否则即使另一个数只有
         * 1位，两数之和的长度也肯定大于剩余的数字
         */
        for (int num1Length = 1; num1Length <= halfLength; num1Length++) {
            for (int num2Length = 1; num2Length <= halfLength; num2Length++) {
                String num1 = num.substring(0, num1Length);
                /**
                 * 如果num1以"0"开头但是又不为"0"，不符合题目要求
                 */
                if (num1.startsWith("0") && !Objects.equals(num1, "0")) {
                    continue;
                }
                /**
                 * 除去num1后剩余的字符串
                 */
                String tail = num.substring(num1Length);
                String num2 = tail.substring(0, num2Length);
                /**
                 * 如果num2以"0"开头但是又不为"0"，不符合题目要求
                 */
                if (num2.startsWith("0") && !Objects.equals(num2, "0")) {
                    continue;
                }
                /**
                 * 除去num2后剩余的字符串
                 */
                String rest = tail.substring(num2Length);
                String sum = add(num1, num2);
                /**
                 * 如果除去num1和num2后剩余的字符串为""了，累加序列包含的数字不足3个，不符合题目要求
                 */
                if (Objects.equals(rest, "")) {
                    continue;
                }
                /**
                 * 循环计算累加数列
                 */
                while (rest.startsWith(sum)) {
                    int sumLength = sum.length();
                    num1 = num2;
                    num2 = sum;
                    /**
                     * 除去sum后剩余的字符串
                     */
                    rest = rest.substring(sumLength);
                    sum = add(num1, num2);
                }
                /**
                 * 如果最后剩余的字符串为""，则所有数字构成了一个有效的累加序列
                 */
                if (Objects.equals(rest, "")) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 两个字符串表示的数字相加的和
     *
     * @param num1
     * @param num2
     * @return
     */
    public static String add(String num1, String num2) {
        int length1 = num1.length();
        int length2 = num2.length();
        StringBuilder builder = new StringBuilder();
        /**
         * 进位
         */
        int carry = 0;
        /**
         * 初始指向num1的个位
         */
        int index1 = length1 - 1;
        /**
         * 初始指向num2的个位
         */
        int index2 = length2 - 1;
        /**
         * 从个位开始两数逐位相加
         */
        while (index1 >= 0 || index2 >= 0) {
            int sum = carry;

            if (index1 >= 0) {
                sum += num1.charAt(index1) - '0';
            }

            if (index2 >= 0) {
                sum += num2.charAt(index2) - '0';
            }
            /**
             * 判断是否有进位
             */
            if (sum < 10) {
                builder.insert(0, sum);
                carry = 0;
            } else {
                builder.insert(0, sum - 10);
                carry = 1;
            }
            index1--;
            index2--;
        }
        /**
         * 最高位加完后如果还有进位，和要补上这个进位
         */
        if (carry == 1) {
            builder.insert(0, 1);
        }
        return builder.toString();
    }
}
