package leetcode.algorithms;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * Description: 842. Split Array into Fibonacci Sequence
 *
 * @author Baltan
 * @date 2020-02-20 13:41
 * @see IsAdditiveNumber
 */
public class SplitIntoFibonacci {
    public static void main(String[] args) {
        System.out.println(splitIntoFibonacci("123456579"));
        System.out.println(splitIntoFibonacci("11235813"));
        System.out.println(splitIntoFibonacci("112358130"));
        System.out.println(splitIntoFibonacci("0123"));
        System.out.println(splitIntoFibonacci("1101111"));
        System.out.println(splitIntoFibonacci("74912134825162255812723932620170946950766784234934"));
    }

    public static List<Integer> splitIntoFibonacci(String S) {
        int length = S.length();
        int halfLength = length / 2;
        /**
         * 枚举所有最开始两个数可能的情况，两个数各自的长度都不会超过halfLength，否则即使另一
         * 个数只有1位，两数之和的长度也肯定大于剩余的数字
         */
        outer:
        for (int num1Length = 1; num1Length <= halfLength; num1Length++) {
            for (int num2Length = 1; num2Length <= halfLength; num2Length++) {
                String substring1 = S.substring(0, num1Length);
                /**
                 * 如果substring1超过了Integer.MAX_VALUE，则不再对substring1继续计算
                 */
                if (isGreaterThanMaxInteger(substring1)) {
                    break outer;
                }
                /**
                 * 如果substring1以"0"开头但是又不为"0"，不符合题目要求
                 */
                if (substring1.startsWith("0") && !Objects.equals(substring1, "0")) {
                    continue;
                }

                int num1 = Integer.valueOf(substring1);
                /**
                 * 除去substring1后剩余的字符串
                 */
                String tail = S.substring(num1Length);

                String substring2 = tail.substring(0, num2Length);
                /**
                 * 如果substring2超过了Integer.MAX_VALUE，则不再对substring2继续计算
                 */
                if (isGreaterThanMaxInteger(substring2)) {
                    continue outer;
                }
                /**
                 * 如果substring2以"0"开头但是又不为"0"，不符合题目要求
                 */
                if (substring2.startsWith("0") && !Objects.equals(substring2, "0")) {
                    continue;
                }

                int num2 = Integer.valueOf(substring2);
                /**
                 * 除去substring2后剩余的字符串
                 */
                String rest = tail.substring(num2Length);
                /**
                 * 如果除去substring1和substring2后剩余的字符串为""了，累加序列包含的数字不
                 * 足3个，不符合题目要求
                 */
                if (Objects.equals(rest, "")) {
                    continue;
                }

                long sum = num1 + num2;
                String sumString = String.valueOf(sum);
                List<Integer> result = new LinkedList<>();
                result.add(num1);
                result.add(num2);
                /**
                 * 循环计算斐波那契序列
                 */
                while (rest.startsWith(sumString)) {
                    /**
                     * 如果sumString超过了Integer.MAX_VALUE，则不再计算当前序列
                     */
                    if (isGreaterThanMaxInteger(sumString)) {
                        break;
                    }

                    result.add((int) sum);
                    int sumLength = sumString.length();
                    num1 = num2;
                    num2 = (int) sum;
                    /**
                     * 除去sumString后剩余的字符串
                     */
                    rest = rest.substring(sumLength);
                    sum = num1 + num2;
                    sumString = String.valueOf(sum);
                }
                /**
                 * 如果最后剩余的字符串为""，则所有数字构成了一个有效的累加序列
                 */
                if (Objects.equals(rest, "")) {
                    return result;
                }
            }
        }
        return Collections.emptyList();
    }

    /**
     * num字符串表示的数字是否大于Integer.MAX_VALUE
     *
     * @param num
     * @return
     */
    public static boolean isGreaterThanMaxInteger(String num) {
        int length = num.length();
        String maxInteger = String.valueOf(Integer.MAX_VALUE);

        if (length < maxInteger.length()) {
            return false;
        } else if (length > maxInteger.length()) {
            return true;
        } else {
            return num.compareTo(maxInteger) > 0;
        }
    }
}
