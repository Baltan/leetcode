package leetcode.algorithms;

import java.util.LinkedList;
import java.util.List;

/**
 * Description: 1291. Sequential Digits
 *
 * @author Baltan
 * @date 2019-12-18 08:51
 */
public class SequentialDigits {
    public static void main(String[] args) {
        System.out.println(sequentialDigits(100, 300));
        System.out.println(sequentialDigits(1000, 13000));
        System.out.println(sequentialDigits(10, 1000000000));
        System.out.println(sequentialDigits(1234, 1234));
        System.out.println(sequentialDigits(12344, 12344));
    }

    public static List<Integer> sequentialDigits(int low, int high) {
        List<Integer> result = new LinkedList<>();
        String lowString = String.valueOf(low);
        String highString = String.valueOf(high);
        /**
         * 下界数字的长度
         */
        int lowLength = lowString.length();
        /**
         * 上届数字的长度
         */
        int highLength = highString.length();

        outer:
        for (int i = lowLength; i <= highLength; i++) {
            /**
             * 长度为i位的顺次数，最高位的数字可能为[1,10-i]
             */
            for (int j = 1; j <= 10 - i; j++) {
                /**
                 * 顺次数每一位的数字
                 */
                int num = j;
                int value = 0;
                /**
                 * 从最高位开始计算顺次数的值
                 */
                for (int l = 0; l < i; l++) {
                    value += num * Math.pow(10, i - l - 1);
                    num++;
                }

                if (value < low) {
                    continue;
                }
                /**
                 * 如果当前顺次数大于上届了，说明已找到从小到大的所有符合要求的顺次数
                 */
                if (value > high) {
                    break outer;
                }
                result.add(value);
            }
        }
        return result;
    }
}
