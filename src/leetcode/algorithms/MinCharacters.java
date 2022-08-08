package leetcode.algorithms;

/**
 * Description: 1737. Change Minimum Characters to Satisfy One of Three Conditions
 *
 * @author Baltan
 * @date 2022/7/31 14:06
 */
public class MinCharacters {
    public static void main(String[] args) {
        System.out.println(minCharacters("ace", "abe"));
        System.out.println(minCharacters("acac", "bd"));
        System.out.println(minCharacters("aba", "caa"));
        System.out.println(minCharacters("dabadd", "cda"));
    }

    public static int minCharacters(String a, String b) {
        int result = Integer.MAX_VALUE;
        /**
         * countArrayA[0]-countArrayA[25]依次表示字符a-z在字符串a中出现的次数
         */
        int[] countArrayA = new int[26];
        /**
         * countArrayB[0]-countArrayB[25]依次表示字符a-z在字符串b中出现的次数
         */
        int[] countArrayB = new int[26];
        char[] charArrayA = a.toCharArray();
        char[] charArrayB = b.toCharArray();
        /**
         * 字符串a中出现过次数最多的字符出现的总次数
         */
        int maxFrequencyA = 0;
        /**
         * 字符串b中出现过次数最多的字符出现的总次数
         */
        int maxFrequencyB = 0;

        for (char c : charArrayA) {
            countArrayA[c - 'a']++;
            maxFrequencyA = Math.max(maxFrequencyA, countArrayA[c - 'a']);
        }

        for (char c : charArrayB) {
            countArrayB[c - 'a']++;
            maxFrequencyB = Math.max(maxFrequencyB, countArrayB[c - 'a']);
        }
        /**
         * 令a中的字符都严格小于b中的字符
         */
        for (int i = 0; i < 25; i++) {
            /**
             * 为了满足题目要求的第一种情况，需要的操作次数
             */
            int operations1 = 0;
            /**
             * 令a中的字符都小于等于alphabet[i]
             */
            for (int j = i + 1; j < 26; j++) {
                operations1 += countArrayA[j];
            }
            /**
             * 令b中的字符都大于alphabet[i]
             */
            for (int j = 0; j <= i; j++) {
                operations1 += countArrayB[j];
            }
            result = Math.min(result, operations1);
        }
        /**
         * 令b中的字符都严格小于a中的字符
         */
        for (int i = 0; i < 25; i++) {
            /**
             * 为了满足题目要求的第二种情况，需要的操作次数
             */
            int operations2 = 0;
            /**
             * 令b中的字符都小于等于alphabet[i]
             */
            for (int j = i + 1; j < 26; j++) {
                operations2 += countArrayB[j];
            }
            /**
             * 令a中的字符都大于alphabet[i]
             */
            for (int j = 0; j <= i; j++) {
                operations2 += countArrayA[j];
            }
            result = Math.min(result, operations2);
        }
        /**
         * 为了满足题目要求的第三种情况，需要的操作次数
         */
        int operations3 = 0;
        /**
         * 令a和b都由同一个字母组成
         */
        operations3 += charArrayA.length - maxFrequencyA;
        operations3 += charArrayB.length - maxFrequencyB;
        result = Math.min(result, operations3);
        return result;
    }
}
