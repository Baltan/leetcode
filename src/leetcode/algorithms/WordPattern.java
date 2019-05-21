package leetcode.algorithms;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: 290. Word Pattern
 *
 * @author Baltan
 * @date 2018/1/7 10:58
 */
public class WordPattern {
    public static void main(String[] args) {
        System.out.println(wordPattern("dog cat cat dog", "abba"));
        System.out.println(wordPattern("abba", "dog cat cat dog"));
        System.out.println(wordPattern("", "beef"));
        System.out.println(wordPattern("e", "eukera"));
        System.out.println(wordPattern("jquery", "jquery"));
    }

    public static boolean wordPattern(String pattern, String str) {
        String[] strArray = str.split(" ");
        if (pattern.length() != strArray.length) {
            return false;
        }
        String[] patternArray = pattern.split("");
        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < strArray.length; i++) {
            String letter = strArray[i];
            String patternWord = patternArray[i];
            if (!map.containsKey(letter) && !map.containsValue(patternWord)) {
                map.put(letter, patternWord);
            } else if (map.containsKey(letter) && !map.containsValue(patternWord)) {
                return false;
            } else if (!map.containsKey(letter) && map.containsValue(patternWord)) {
                return false;
            } else {
                if (!map.get(letter).equals(patternWord)) {
                    return false;
                }
            }
        }
        return true;
    }
}
