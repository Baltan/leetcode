package leetcode.algorithms;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Description: 1859. Sorting the Sentence
 *
 * @author Baltan
 * @date 2022/5/29 14:50
 */
public class SortSentence {
    public static void main(String[] args) {
        System.out.println(sortSentence("is2 sentence4 This1 a3"));
        System.out.println(sortSentence("Myself2 Me1 I4 and3"));
    }

    public static String sortSentence(String s) {
        /**
         * 乱序单词数组
         */
        String[] shuffledWords = s.split(" ");
        /**
         * 排好序的单词数组
         */
        String[] orderedWords = new String[shuffledWords.length];

        for (String word : shuffledWords) {
            int length = word.length();
            /**
             * word的最后一个数字字符表示单词原来的位置
             */
            int index = word.charAt(length - 1) - '1';
            /**
             * 截去word的最后一个数字字符
             */
            word = word.substring(0, length - 1);
            orderedWords[index] = word;
        }
        return Arrays.stream(orderedWords).collect(Collectors.joining(" "));
    }
}
