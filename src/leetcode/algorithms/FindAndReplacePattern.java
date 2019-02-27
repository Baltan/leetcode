package leetcode.algorithms;

import java.util.*;

/**
 * Description: Find and Replace Pattern
 *
 * @author Baltan
 * @date 2018/8/21 14:36
 */
public class FindAndReplacePattern {
    public static void main(String[] args) {
        System.out.println(
                findAndReplacePattern(new String[]{"abc", "deq", "mee", "aqq", "dkd", "ccc", "aab"}, "abb"));
        System.out.println(
                findAndReplacePattern(new String[]{"abc", "cba", "xyx", "yxx", "yyx"}, "abc"));
    }

    public static List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> list = new ArrayList<>();
        char[] patterArray = pattern.toCharArray();
        int length = patterArray.length;
        Set<Character> patternSet = new HashSet<>();
        for (char c : patterArray) {
            patternSet.add(c);
        }
        for (String word : words) {
            Map<Character, Character> map = new HashMap<>();
            char[] wordArray = word.toCharArray();
            Set<Character> wordSet = new HashSet<>();
            for (char c : wordArray) {
                wordSet.add(c);
            }
            if (wordSet.size() != patternSet.size()) {
                continue;
            }
            for (int i = 0; i < length; i++) {
                char c = wordArray[i];
                if (map.get(c) == null) {
                    map.put(c, patterArray[i]);
                }
                wordArray[i] = map.get(c);
            }
            if (Arrays.equals(wordArray, patterArray)) {
                list.add(word);
            }
        }
        return list;
    }
}