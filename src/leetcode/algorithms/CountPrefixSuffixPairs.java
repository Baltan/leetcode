package leetcode.algorithms;

import java.util.Objects;

/**
 * Description: 3042. Count Prefix and Suffix Pairs I
 *
 * @author Baltan
 * @date 2024/2/28 22:23
 */
public class CountPrefixSuffixPairs {
    public static void main(String[] args) {
        System.out.println(countPrefixSuffixPairs(new String[]{"a", "aba", "ababa", "aa"}));
        System.out.println(countPrefixSuffixPairs(new String[]{"pa", "papa", "ma", "mama"}));
        System.out.println(countPrefixSuffixPairs(new String[]{"abab", "ab"}));
    }

    public static int countPrefixSuffixPairs(String[] words) {
        int result = 0;
        int length = words.length;
        /**
         * 对所有可能的索引对(i,j)逐一判定
         */
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (Objects.equals(words[i], words[j])) {
                    result++;
                } else if (words[j].length() > words[i].length() && words[j].startsWith(words[i]) && words[j].endsWith(words[i])) {
                    result++;
                }
            }
        }
        return result;
    }
}
