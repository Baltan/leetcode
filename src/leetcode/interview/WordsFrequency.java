package leetcode.interview;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: 面试题 16.02. 单词频率
 *
 * @author Baltan
 * @date 2020-03-19 16:09
 */
public class WordsFrequency {
    private Map<String, Integer> map;

    public WordsFrequency(String[] book) {
        this.map = new HashMap<>();

        for (String word : book) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
    }

    public int get(String word) {
        return map.getOrDefault(word, 0);
    }

    public static void main(String[] args) {
        String[] book1 = {"i", "have", "an", "apple", "he", "have", "a", "pen"};
        WordsFrequency wordsFrequency1 = new WordsFrequency(book1);
        System.out.println(wordsFrequency1.get("you"));
        System.out.println(wordsFrequency1.get("have"));
        System.out.println(wordsFrequency1.get("an"));
        System.out.println(wordsFrequency1.get("apple"));
        System.out.println(wordsFrequency1.get("pen"));
    }
}
