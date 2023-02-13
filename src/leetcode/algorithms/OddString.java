package leetcode.algorithms;

import java.util.Arrays;

/**
 * Description: 2451. Odd String Difference
 *
 * @author Baltan
 * @date 2023/2/8 09:40
 */
public class OddString {
    public static void main(String[] args) {
        System.out.println(oddString(new String[]{"adc", "wzy", "abc"}));
        System.out.println(oddString(new String[]{"aaa", "bob", "ccc", "ddd"}));
    }

    public static String oddString(String[] words) {
        int length = words.length;
        int n = words[0].length();
        int[][] differences = new int[length][n - 1];

        for (int i = 0; i < length; i++) {
            String word = words[i];
            int[] difference = new int[n - 1];
            /**
             * 计算每个字符串word的差值整数数组
             */
            for (int j = 0; j < n - 1; j++) {
                difference[j] = word.charAt(j + 1) - word.charAt(j);
            }
            differences[i] = difference;
        }

        for (int i = 0; i < length; i++) {
            /**
             * 如果一个差值整数数组和它左右两侧的都不同，这个差值整数数组对应的字符串就是所求的不同的字符串
             */
            if (!Arrays.equals(differences[i], differences[(i - 1 + length) % length]) && !Arrays.equals(differences[i], differences[(i + 1) % length])) {
                return words[i];
            }
        }
        return null;
    }
}
