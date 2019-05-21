package leetcode.algorithms;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Description: 720. Longest Word in Dictionary
 *
 * @author Baltan
 * @date 2018/8/8 15:32
 */
public class LongestWord {
    public static void main(String[] args) {
        System.out.println(longestWord(new String[]{"w", "wo", "wor", "worl", "world"}));
        System.out.println(longestWord(new String[]{"a", "banana", "app", "appl", "ap", "apply", "apple"}));
    }

    public static String longestWord(String[] words) {
        Arrays.sort(words);

        Set<String> set = new HashSet<>();

        String longestWord = "";

        for (String str : words) {
            if (str.length() == 1 || set.contains(str.substring(0, str.length() - 1))) {
                set.add(str);
                longestWord = str.length() > longestWord.length() ? str : longestWord;
            }
        }
        return longestWord;
    }
}
