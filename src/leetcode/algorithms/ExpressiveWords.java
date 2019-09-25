package leetcode.algorithms;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: 809. Expressive Words
 *
 * @author Baltan
 * @date 2019-09-25 09:19
 */
public class ExpressiveWords {
    public static void main(String[] args) {
        String S1 = "heeellooo";
        String[] words1 = {"hello", "hi", "helo"};
        System.out.println(expressiveWords(S1, words1));

        String S2 = "";
        String[] words2 = {"", " ", ""};
        System.out.println(expressiveWords(S2, words2));

        String S3 = "       ";
        String[] words3 = {"", " ", ""};
        System.out.println(expressiveWords(S3, words3));

        String S4 = "aaa";
        String[] words4 = {"a", "aa", "a"};
        System.out.println(expressiveWords(S4, words4));

        String S5 = "heeellooo";
        String[] words5 = {"axxxrrzzz"};
        System.out.println(expressiveWords(S5, words5));
    }

    public static int expressiveWords(String S, String[] words) {
        int result = 0;

        if (S.length() == 0) {
            for (String word : words) {
                if (word.length() == 0) {
                    result++;
                }
            }
        } else {
            List<Pair<Character, Integer>> sCounts = help(S);

            outer:
            for (String word : words) {
                List<Pair<Character, Integer>> wordCounts = help(word);
                /**
                 * 比较S和当前word的相同字母组的统计结果，出现以下结果时word不能扩张得到S：
                 * 1、S的相同字母组的数量和word的相同字母组的数量不等
                 * 2、依次比较S的相同字母组和word的相同字母组对应位置的统计结果，两者的字符不等
                 * 3、依次比较S的相同字母组和word的相同字母组对应位置的统计结果，两者的字符相等，
                 *    但是S的字母组长度小于word的字母组长度
                 * 4、依次比较S的相同字母组和word的相同字母组对应位置的统计结果，两者的字符相等，
                 *    但是S的字母组长度不等于word的字母组长度并且S的字母组长度小于3
                 */
                if (sCounts.size() == wordCounts.size()) {
                    for (int i = 0; i < sCounts.size(); i++) {
                        char sChar = sCounts.get(i).getKey();
                        char wordChar = wordCounts.get(i).getKey();
                        int sCount = sCounts.get(i).getValue();
                        int wordCount = wordCounts.get(i).getValue();

                        if (sChar != wordChar || sCount < wordCount || (sCount != wordCount && sCount < 3)) {
                            continue outer;
                        }
                    }
                    result++;
                }
            }
        }
        return result;
    }

    public static List<Pair<Character, Integer>> help(String word) {
        List<Pair<Character, Integer>> counts = new ArrayList<>();
        int count = 1;
        int length = word.length();
        /**
         * 按顺序统计word中各个相同字母组的字母出现的次数
         */
        if (length == 1) {
            Pair<Character, Integer> pair = new Pair<>(word.charAt(0), count);
            counts.add(pair);
        } else if (length > 1) {
            for (int i = 1; i < length; i++) {
                char prev = word.charAt(i - 1);
                char curr = word.charAt(i);

                if (curr == prev) {
                    count++;
                } else {
                    Pair<Character, Integer> pair = new Pair<>(prev, count);
                    counts.add(pair);
                    count = 1;
                }
                /**
                 * 将最后一个相同字母组的统计结果加入结果counts
                 */
                if (i == length - 1) {
                    Pair<Character, Integer> pair = new Pair<>(curr, count);
                    counts.add(pair);
                }
            }
        }
        return counts;
    }
}
