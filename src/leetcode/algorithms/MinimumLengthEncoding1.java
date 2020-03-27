package leetcode.algorithms;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Description: 820. Short Encoding of Words
 *
 * @author Baltan
 * @date 2020-02-19 13:14
 * @see MinimumLengthEncoding
 */
public class MinimumLengthEncoding1 {
    public static void main(String[] args) {
        System.out.println(minimumLengthEncoding(new String[]{"time", "me", "bell"}));
    }

    public static int minimumLengthEncoding(String[] words) {
        /**
         * 长字符串中可能包含短字符串，反过来则不可能，所以将words中字符串按照长度降序排列，优先
         * 处理长字符串
         */
        Arrays.sort(words, (x, y) -> y.length() - x.length());
        StringBuilder builder = new StringBuilder();
        /**
         * 已经加入编码的单词
         */
        Set<String> usedStrings = new HashSet<>();

        outer:
        for (String word : words) {
            for (String usedString : usedStrings) {
                if (usedString.endsWith(word)) {
                    continue outer;
                }
            }
            usedStrings.add(word);
            builder.append(word).append("#");
        }
        return builder.length();
    }
}
