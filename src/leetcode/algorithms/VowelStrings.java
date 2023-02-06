package leetcode.algorithms;

import leetcode.util.OutputUtils;

/**
 * Description: 2559. Count Vowel Strings in Ranges
 *
 * @author Baltan
 * @date 2023/2/5 15:19
 */
public class VowelStrings {
    public static void main(String[] args) {
        OutputUtils.print1DIntegerArray(vowelStrings(new String[]{"aba", "bcb", "ece", "aa", "e"}, new int[][]{{0, 2}, {1, 4}, {1, 1}}));
        OutputUtils.print1DIntegerArray(vowelStrings(new String[]{"a", "e", "i"}, new int[][]{{0, 2}, {0, 1}, {2, 2}}));
    }

    public static int[] vowelStrings(String[] words, int[][] queries) {
        int[] result = new int[queries.length];
        int length = words.length;
        /**
         * prefixCounts[i]表示在子数组words[0]……words[i-1]中元音字符串的数量
         */
        int[] prefixCounts = new int[length + 1];
        int index = 0;

        for (int i = 0; i < length; i++) {
            char start = words[i].charAt(0);
            char end = words[i].charAt(words[i].length() - 1);

            if ((start == 'a' || start == 'e' || start == 'i' || start == 'o' || start == 'u') && (end == 'a' || end == 'e' || end == 'i' || end == 'o' || end == 'u')) {
                prefixCounts[i + 1] = prefixCounts[i] + 1;
            } else {
                prefixCounts[i + 1] = prefixCounts[i];
            }
        }

        for (int[] query : queries) {
            /**
             * 子数组words[0]……words[query[1]]中元音字符串的数量扣除子数组子数组words[0]……words[query[0]-1]中元音字符串的数量
             */
            result[index++] = prefixCounts[query[1] + 1] - prefixCounts[query[0]];
        }
        return result;
    }
}
