package leetcode.algorithms;

/**
 * Description: 3541. Find Most Frequent Vowel and Consonant
 *
 * @author Baltan
 * @date 2025/5/23 23:12
 */
public class MaxFreqSum {
    public static void main(String[] args) {
        System.out.println(maxFreqSum("successes"));
        System.out.println(maxFreqSum("aeiaeia"));
    }

    public static int maxFreqSum(String s) {
        /**
         * frequencies[0]-frequencies[25]依次表示字符a-z在字符串s中出现的次数
         */
        int[] frequencies = new int[26];
        /**
         * 字符串s中出现次数最多的元音字母的频次
         */
        int vowelMaxFrequency = 0;
        /**
         * 字符串s中出现次数最多的辅音字母的频次
         */
        int consonantMaxFrequency = 0;

        for (char c : s.toCharArray()) {
            frequencies[c - 'a']++;

            switch (c) {
                case 'a', 'e', 'i', 'u', 'o':
                    vowelMaxFrequency = Math.max(vowelMaxFrequency, frequencies[c - 'a']);
                    break;
                default:
                    consonantMaxFrequency = Math.max(consonantMaxFrequency, frequencies[c - 'a']);
            }
        }
        return vowelMaxFrequency + consonantMaxFrequency;
    }
}
