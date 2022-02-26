package leetcode.algorithms;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Description: 1930. Unique Length-3 Palindromic Subsequences
 *
 * @author Baltan
 * @date 2022/2/25 21:43
 */
public class CountPalindromicSubsequence {
    public static void main(String[] args) {
        System.out.println(countPalindromicSubsequence("aabca"));
        System.out.println(countPalindromicSubsequence("adc"));
        System.out.println(countPalindromicSubsequence("bbcbaba"));
    }

    public static int countPalindromicSubsequence(String s) {
        int result = 0;
        int letterCount = 26;
        /**
         * firstIndexArray[0]到firstIndexArray[25]依次表示a-z在s中第一次出现的索引位置
         */
        int[] firstIndexArray = new int[letterCount];
        /**
         * lastIndexArray[0]lastIndexArray[25]依次表示a-z在s中最后一次出现的索引位置
         */
        int[] lastIndexArray = new int[letterCount];
        /**
         * midCharsArray[0]到midCharsArray[25]依次表示a-z各自第一次出现索引位置和最后一次出现索引位置中间部分子串存在的不
         * 同字符
         */
        Set<Character>[] midCharsArray = new Set[letterCount];
        Arrays.fill(firstIndexArray, Integer.MAX_VALUE);
        Arrays.fill(lastIndexArray, Integer.MIN_VALUE);
        /**
         * 查询a-z在s中第一次和最后一次出现的索引位置
         */
        for (int i = 0; i < s.length(); i++) {
            int pos = s.charAt(i) - 'a';

            if (firstIndexArray[pos] > i) {
                firstIndexArray[pos] = i;
            }

            if (lastIndexArray[pos] < i) {
                lastIndexArray[pos] = i;
            }
        }

        for (int i = 0; i < s.length(); i++) {
            /**
             * 判断当前字符是否位于某个字符第一次出现索引位置和最后一次出现索引位置中间部分某个子串上
             */
            for (int j = 0; j < letterCount; j++) {
                if (i > firstIndexArray[j] && i < lastIndexArray[j]) {
                    if (Objects.isNull(midCharsArray[j])) {
                        midCharsArray[j] = new HashSet<>();
                    }
                    midCharsArray[j].add(s.charAt(i));
                }
            }
        }
        /**
         * 统计回文字符串数量
         */
        for (Set<Character> midChars : midCharsArray) {
            if (Objects.nonNull(midChars)) {
                result += midChars.size();
            }
        }
        return result;
    }
}
