package leetcode.algorithms;

import java.util.Arrays;

/**
 * Description: 1255. Maximum Score Words Formed by Letters
 *
 * @author Baltan
 * @date 2019-11-13 08:58
 */
public class MaxScoreWords {
    public static void main(String[] args) {
        String[] words1 = {"dog", "cat", "dad", "good"};
        char[] letters1 = {'a', 'a', 'c', 'd', 'd', 'd', 'g', 'o', 'o'};
        int[] score1 = {1, 0, 9, 5, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        System.out.println(maxScoreWords(words1, letters1, score1));

        String[] words2 = {"xxxz", "ax", "bx", "cx"};
        char[] letters2 = {'z', 'a', 'b', 'c', 'x', 'x', 'x'};
        int[] score2 = {4, 4, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 0, 10};
        System.out.println(maxScoreWords(words2, letters2, score2));

        String[] words3 = {"leetcode"};
        char[] letters3 = {'l', 'e', 't', 'c', 'o', 'd'};
        int[] score3 = {0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0};
        System.out.println(maxScoreWords(words3, letters3, score3));
    }

    public static int maxScoreWords(String[] words, char[] letters, int[] score) {
        /**
         * 统计字母表中每个字母出现的次数
         */
        int[] letterCount = new int[26];

        for (char letter : letters) {
            letterCount[letter - 'a']++;
        }
        return maxScoreWords(words, letterCount, score);
    }

    public static int maxScoreWords(String[] words, int[] letterCount, int[] score) {
        int maxScore = 0;
        int length = words.length;
        /**
         * 如果单词表中只有一个单词，并且这个单词可以用字母表中的字母拼写，则返回这个单词的得分；如果这个单词不能用字母
         * 表中的字母拼写，则无法获得得分，返回0
         */
        if (length == 1) {
            String word = words[0];

            for (char c : word.toCharArray()) {
                if (letterCount[c - 'a'] == 0) {
                    return 0;
                } else {
                    letterCount[c - 'a']--;
                    maxScore += score[c - 'a'];
                }
            }
            return maxScore;
        }
        /**
         * 如果单词表中有多个单词，假设我们尝试必须拼写单词表中的某一个单词，如果这个单词不能用字母表中的字母拼写，则这
         * 种尝试无法实现，继续尝试必须拼写单词表中的下一个单词的情况，以此类推；如果这个单词可以用字母表中的字母拼写，
         * 则将这个单词的得分记录下，并且字母表中要扣减这个单词用过的字母。递归操作这个单词之后剩余的单词表和字母表获得
         * 最大得分，加上这个单词已获得的得分，就是我们这个尝试可以获得的最大得分，更新我们所有尝试可能获得的最大得分
         */
        outer:
        for (int i = 0; i < length; i++) {
            /**
             * 这次尝试的得分
             */
            int currentScore = 0;
            /**
             * 这次尝试必须要拼写的单词
             */
            String word = words[i];
            char[] charArray = word.toCharArray();
            String[] otherWords = Arrays.copyOfRange(words, i + 1, length);
            int[] letterCountCopy = Arrays.copyOf(letterCount, letterCount.length);

            for (char c : charArray) {
                /**
                 * 这个单词可以获得的得分
                 */
                currentScore += score[c - 'a'];

                if (letterCountCopy[c - 'a'] == 0) {
                    /**
                     * 这个单词不能用字母表中的字母拼写，继续尝试必须拼写单词表中的下一个单词的情况
                     */
                    continue outer;
                } else {
                    /**
                     * 字母表中扣减掉这个单词用过的字母
                     */
                    letterCountCopy[c - 'a']--;
                }
            }
            /**
             * 递归操作这个单词之后剩余的单词表和字母表获得最大得分
             */
            currentScore += maxScoreWords(otherWords, letterCountCopy, score);
            /**
             * 更新我们所有尝试可能获得的最大得分
             */
            maxScore = Math.max(maxScore, currentScore);
        }
        return maxScore;
    }
}
