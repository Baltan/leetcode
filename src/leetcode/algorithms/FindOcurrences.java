package leetcode.algorithms;

import leetcode.util.OutputUtils;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * Description: 1078. Occurrences After Bigram
 *
 * @author Baltan
 * @date 2019-06-10 09:05
 */
public class FindOcurrences {
    public static void main(String[] args) {
        String text1 = "alice is a good girl she is a good student";
        String first1 = "a";
        String second1 = "good";
        OutputUtils.print1DStringArray(findOcurrences(text1, first1, second1));

        String text2 = "we will we will rock you";
        String first2 = "we";
        String second2 = "will";
        OutputUtils.print1DStringArray(findOcurrences(text2, first2, second2));

        String text3 = "we will";
        String first3 = "we";
        String second3 = "will";
        OutputUtils.print1DStringArray(findOcurrences(text3, first3, second3));
    }

    public static String[] findOcurrences(String text, String first, String second) {
        List<String> result = new LinkedList<>();
        String[] words = text.split(" ");
        int length = words.length;

        for (int i = 2; i < length; i++) {
            if (Objects.equals(first, words[i - 2]) && Objects.equals(second, words[i - 1])) {
                result.add(words[i]);
            }
        }
        return result.toArray(new String[0]);
    }
}
