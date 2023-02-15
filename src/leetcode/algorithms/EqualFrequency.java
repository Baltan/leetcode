package leetcode.algorithms;

import java.util.Arrays;

/**
 * Description: 2423. Remove Letter To Equalize Frequency
 *
 * @author Baltan
 * @date 2023/2/10 09:32
 */
public class EqualFrequency {
    public static void main(String[] args) {
        System.out.println(equalFrequency("abbcc"));
        System.out.println(equalFrequency("ddaccb"));
        System.out.println(equalFrequency("bac"));
        System.out.println(equalFrequency("abcc"));
        System.out.println(equalFrequency("aazz"));
    }

    public static boolean equalFrequency(String word) {
        /**
         * counts[0]-count[25]依次表示字符串word中字符a-z的个数
         */
        int[] counts = new int[26];

        for (char c : word.toCharArray()) {
            counts[c - 'a']++;
        }
        /**
         * 所有字符串word中出现过的字母的频数
         */
        int[] frequencies = Arrays.stream(counts).filter(x -> x != 0).toArray();

        for (int i = 0; i < frequencies.length; i++) {
            /**
             * 假设将当前字母的频数减少一个，判断剩余字母的频数是否相同
             */
            frequencies[i]--;
            /**
             * 出现次数最少的字母的频数
             */
            int minFrequency = Integer.MAX_VALUE;
            /**
             * 出现次数最多的字母的频数
             */
            int maxFrequency = Integer.MIN_VALUE;

            for (int frequency : frequencies) {
                if (frequency != 0) {
                    minFrequency = Math.min(minFrequency, frequency);
                    maxFrequency = Math.max(maxFrequency, frequency);
                }
            }
            /**
             * 说明剩余字母的频数都相同
             */
            if (minFrequency == maxFrequency) {
                return true;
            }
            /**
             * 还原frequencies
             */
            frequencies[i]++;
        }
        return false;
    }
}
