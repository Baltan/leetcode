package leetcode.algorithms;

import java.util.LinkedList;
import java.util.List;

/**
 * Description: 916. Word Subsets
 *
 * @author Baltan
 * @date 2019-11-22 09:07
 */
public class WordSubsets {
    public static void main(String[] args) {
        String[] A1 = {"amazon", "apple", "facebook", "google", "leetcode"};
        String[] B1 = {"e", "o"};
        System.out.println(wordSubsets(A1, B1));

        String[] A2 = {"amazon", "apple", "facebook", "google", "leetcode"};
        String[] B2 = {"l", "e"};
        System.out.println(wordSubsets(A2, B2));

        String[] A3 = {"amazon", "apple", "facebook", "google", "leetcode"};
        String[] B3 = {"e", "oo"};
        System.out.println(wordSubsets(A3, B3));

        String[] A4 = {"amazon", "apple", "facebook", "google", "leetcode"};
        String[] B4 = {"lo", "eo"};
        System.out.println(wordSubsets(A4, B4));

        String[] A5 = {"amazon", "apple", "facebook", "google", "leetcode"};
        String[] B5 = {"ec", "oc", "ceo"};
        System.out.println(wordSubsets(A5, B5));
    }

    public static List<String> wordSubsets(String[] A, String[] B) {
        List<String> result = new LinkedList<>();
        /**
         * 如果一个单词是通用的，计数该单词中每个字母至少应该出现的次数
         */
        int[] containedChars = new int[26];

        for (String b : B) {
            int[] chars = new int[26];
            /**
             * 统计单词b中每个字母出现的次数
             */
            for (char c : b.toCharArray()) {
                chars[c - 'a']++;
            }
            /**
             * 更新通用单词中每个字母至少应该出现的次数
             */
            for (int i = 0; i < 26; i++) {
                containedChars[i] = Math.max(containedChars[i], chars[i]);
            }
        }

        outer:
        for (String a : A) {
            int[] chars = new int[26];
            /**
             * 统计单词a中每个字母出现的次数
             */
            for (char c : a.toCharArray()) {
                chars[c - 'a']++;
            }
            /**
             * 只有单词a中每个字母出现的次数不少于通用单词中对应字母出现的次数，单词a才是通用的
             */
            for (int i = 0; i < 26; i++) {
                if (chars[i] < containedChars[i]) {
                    continue outer;
                }
            }
            result.add(a);
        }
        return result;
    }
}
