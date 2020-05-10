package leetcode.algorithms;

import java.util.HashSet;
import java.util.Set;

/**
 * Description: 1432. Max Difference You Can Get From Changing an Integer
 *
 * @author Baltan
 * @date 2020-05-10 11:22
 */
public class MaxDiff {
    public static void main(String[] args) {
        System.out.println(maxDiff(555));
        System.out.println(maxDiff(9));
        System.out.println(maxDiff(123456));
        System.out.println(maxDiff(10000));
        System.out.println(maxDiff(9288));
        System.out.println(maxDiff(1101057));
    }

    public static int maxDiff(int num) {
        char[] charArray = String.valueOf(num).toCharArray();
        /**
         * 统计num中各位上出现过的不同数字的个数
         */
        Set<Character> set = new HashSet<>();
        int length = charArray.length;
        /**
         * num修改后可以得到的最大值
         */
        int max = 0;
        /**
         * num修改后可以得到的最小值
         */
        int min = 0;

        for (char c : charArray) {
            set.add(c);
        }
        /**
         * 如果num中各位上出现过的不同数字的个数只有1个，则num修改后的最大值各位上都是9，修改后的最小值各位上
         * 都是1，两者差值各位上都是8
         */
        if (set.size() == 1) {
            int value = 0;

            for (int i = 0; i < length; i++) {
                value = value * 10 + 8;
            }
            return value;
        }
        /**
         * 如果num最高位不是9，则将最高位以及各位上和最高位相同的数字都改为9，可以得到num修改后的最大值；如果
         * num最高位是9，则从最高位开始向最低位找到第一个不是9的数字，将num中各位上和该位数字相同的都改为9，
         * 可以得到num修改后的最大值。例如：
         * 123456 -> 923456
         * 10000 -> 90000
         * 9288 -> 9988
         * 1101057 -> 9909057
         */
        if (charArray[0] != '9') {
            char prevDigit = charArray[0];

            for (int i = 0; i < length; i++) {
                max = charArray[i] == prevDigit ? max * 10 + 9 : max * 10 + (charArray[i] - '0');
            }
        } else {
            char prevDigit = '9';

            for (int i = 1; i < length; i++) {
                if (charArray[i] != '9') {
                    prevDigit = charArray[i];
                    break;
                }
            }

            for (int i = 0; i < length; i++) {
                max = charArray[i] == prevDigit ? max * 10 + 9 : max * 10 + (charArray[i] - '0');
            }
        }
        /**
         * 如果num最高位不是1，则将最高位以及各位上和最高位相同的数字都改为1，可以得到num修改后的最小值；如果
         * num最高位是1，则从最高位开始向最低位找到第一个不是0，并且和最高位不同的的数字，将num中各位上和该位
         * 数字相同的都改为0，可以得到num修改后的最小值。例如：
         * 123456 -> 103456
         * 10000 -> 10000
         * 9288 -> 1288
         * 1101057 -> 1101007
         */
        if (charArray[0] != '1') {
            char prevDigit = charArray[0];

            for (int i = 0; i < length; i++) {
                min = charArray[i] == prevDigit ? min * 10 + 1 : min * 10 + (charArray[i] - '0');
            }
        } else {
            char prevDigit = '0';

            for (int i = 1; i < length; i++) {
                if (charArray[i] != '0' && charArray[i] != charArray[0]) {
                    prevDigit = charArray[i];
                    break;
                }
            }

            for (int i = 0; i < length; i++) {
                min = charArray[i] == prevDigit ? min * 10 + 0 : min * 10 + (charArray[i] - '0');
            }
        }
        return max - min;
    }
}
