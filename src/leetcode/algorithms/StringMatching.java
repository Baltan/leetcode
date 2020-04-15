package leetcode.algorithms;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * Description: 1408. String Matching in an Array
 *
 * @author Baltan
 * @date 2020-04-15 18:48
 */
public class StringMatching {
    public static void main(String[] args) {
        System.out.println(stringMatching(new String[]{"mass", "as", "hero", "superhero"}));
        System.out.println(stringMatching(new String[]{"leetcode", "et", "code"}));
        System.out.println(stringMatching(new String[]{"blue", "green", "bu"}));
    }

    public static List<String> stringMatching(String[] words) {
        List<String> result = new LinkedList<>();
        int length = words.length;
        /**
         * 将words中所有单词按照长度升序排列
         */
        Arrays.sort(words, Comparator.comparingInt(String::length));

        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (words[j].contains(words[i])) {
                    result.add(words[i]);
                    break;
                }
            }
        }
        return result;
    }
}
