package leetcode.algorithms;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Description: 2566. Maximum Difference by Remapping a Digit
 *
 * @author Baltan
 * @date 2023/2/20 10:28
 */
public class MinMaxDifference {
    public static void main(String[] args) {
        System.out.println(minMaxDifference(11891));
        System.out.println(minMaxDifference(90));
    }

    public static int minMaxDifference(int num) {
        int min = 0;
        int max = 0;
        /**
         * 权重
         */
        int weight = 1;
        /**
         * 为了得到最大值需要替换的数字
         */
        int maxReplacement = 0;
        /**
         * 为了得到最小值需要替换的数字
         */
        int minReplacement = 0;
        /**
         * 保存数字num中每一数位上的数字
         */
        Deque<Integer> deque = new ArrayDeque<>();

        while (num != 0) {
            int digit = num % 10;
            deque.offerLast(digit);
            num /= 10;
            /**
             * 找到最高位的非9的数字，将num中所有这个数字替换成9
             */
            maxReplacement = digit == 9 ? maxReplacement : digit;
            /**
             * 找到最高位的非0的数字，将num中所有这个数字替换成0
             */
            minReplacement = digit == 0 ? minReplacement : digit;
        }
        /**
         * 计算得到最大值和最小值
         */
        while (!deque.isEmpty()) {
            int digit = deque.pollFirst();
            /**
             * num中的数字minReplacement都替换成0
             */
            min += (digit == minReplacement ? 0 : digit) * weight;
            /**
             * num中的数字maxReplacement都替换成9
             */
            max += (digit == maxReplacement ? 9 : digit) * weight;
            weight *= 10;
        }
        return max - min;
    }
}
