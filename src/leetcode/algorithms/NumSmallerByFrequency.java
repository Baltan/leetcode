package leetcode.algorithms;

import leetcode.util.OutputUtils;

import java.util.Arrays;

/**
 * Description: 1170. Compare Strings by Frequency of the Smallest Character
 *
 * @author Baltan
 * @date 2019-08-25 16:12
 */
public class NumSmallerByFrequency {
    public static void main(String[] args) {
        String[] queries1 = {"cbd"};
        String[] words1 = {"zaaaz"};
        OutputUtils.print1DIntegerArray(numSmallerByFrequency(queries1, words1));

        String[] queries2 = {"bbb", "cc"};
        String[] words2 = {"a", "aa", "aaa", "aaaa"};
        OutputUtils.print1DIntegerArray(numSmallerByFrequency(queries2, words2));
    }

    public static int[] numSmallerByFrequency(String[] queries, String[] words) {
        int queriesLength = queries.length;
        int wordsLength = words.length;
        int[] wordFrequencyArray = new int[wordsLength];
        int[] result = new int[queriesLength];
        /**
         * 统计words中的每个单词的最小字母的出现频数
         */
        for (int i = 0; i < wordsLength; i++) {
            wordFrequencyArray[i] = help(words[i]);
        }

        Arrays.sort(wordFrequencyArray);
        /**
         * 对queries中的每个单词的最小字母的出现频数逐一和wordFrequencyArray中的统计结果比较
         */
        for (int i = 0; i < queriesLength; i++) {
            int queryFrequency = help(queries[i]);

            for (int j = wordsLength - 1; j >= 0; j--) {
                if (wordFrequencyArray[j] <= queryFrequency) {
                    break;
                }
                result[i]++;
            }
        }
        return result;
    }

    /**
     * 统计一个单词中最小字母的出现频数
     *
     * @param word
     * @return
     */
    public static int help(String word) {
        int count = 0;
        char smallestCharacter = 'z';
        int length = word.length();

        for (int i = 0; i < length; i++) {
            smallestCharacter = word.charAt(i) < smallestCharacter ? word.charAt(i) : smallestCharacter;
        }

        for (int i = 0; i < length; i++) {
            if (word.charAt(i) == smallestCharacter) {
                count++;
            }
        }
        return count;
    }
}
