package leetcode.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description: 2788. Split Strings by Separator
 *
 * @author Baltan
 * @date 2023/7/27 21:35
 */
public class SplitWordsBySeparator {
    public static void main(String[] args) {
        System.out.println(splitWordsBySeparator(Arrays.asList("one.two.three", "four.five", "six"), '.'));
        System.out.println(splitWordsBySeparator(Arrays.asList("$easy$", "$problem$"), '$'));
        System.out.println(splitWordsBySeparator(Arrays.asList("|||"), '|'));
    }

    public static List<String> splitWordsBySeparator(List<String> words, char separator) {
        List<String> result = new ArrayList<>();
        StringBuilder builder = new StringBuilder();

        for (String word : words) {
            for (char c : word.toCharArray()) {
                if (c != separator) {
                    builder.append(c);
                } else if (builder.length() != 0) {
                    /**
                     * 每次遇到分隔符separator，且builder不为空的情况下就得到一个新的字符串
                     */
                    result.add(builder.toString());
                    builder = new StringBuilder();
                }
            }
            /**
             * 判断字符串word的最后一个分隔符separator后还是否存在字符串
             */
            if (builder.length() != 0) {
                result.add(builder.toString());
                builder = new StringBuilder();
            }
        }
        return result;
    }
}
