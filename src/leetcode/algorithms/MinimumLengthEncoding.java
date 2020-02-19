package leetcode.algorithms;

import java.util.Arrays;

/**
 * Description: 820. Short Encoding of Words
 *
 * @author Baltan
 * @date 2020-02-19 13:14
 */
public class MinimumLengthEncoding {
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

        for (String word : words) {
            /**
             * 如果当前索引字符串中已经包含了word+"#"，说明这个单词可以在当前索引字符串中直接定
             * 位索引，否则就要在索引字符串中追加这个单词
             */
            if (builder.indexOf(word + "#") != -1) {
                continue;
            } else {
                builder.append(word + "#");
            }
        }
        return builder.length();
    }
}
