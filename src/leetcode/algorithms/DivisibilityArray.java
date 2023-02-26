package leetcode.algorithms;

import leetcode.util.OutputUtils;

/**
 * Description: 2575. Find the Divisibility Array of a String
 *
 * @author Baltan
 * @date 2023/2/26 13:22
 */
public class DivisibilityArray {
    public static void main(String[] args) {
        OutputUtils.print1DIntegerArray(divisibilityArray("998244353", 3));
        OutputUtils.print1DIntegerArray(divisibilityArray("1010", 10));
    }

    public static int[] divisibilityArray(String word, int m) {
        int[] result = new int[word.length()];
        /**
         * 前缀数字除以m的余数
         */
        long remainder = 0L;

        for (int i = 0; i < word.length(); i++) {
            int digit = word.charAt(i) - '0';
            /**
             * 当前前缀数字prefix等于上一个前缀数字prefix*10+digit，所以当前前缀数字除以m的余数remainder也等于(上一个前缀数字除以m的余数
             * remainder*10+digit)%m
             */
            remainder = (remainder * 10 + digit) % m;
            result[i] = remainder == 0L ? 1 : 0;
        }
        return result;
    }
}
