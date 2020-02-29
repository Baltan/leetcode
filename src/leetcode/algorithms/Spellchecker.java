package leetcode.algorithms;

import leetcode.util.OutputUtils;

import java.util.*;

/**
 * Description: 966. Vowel Spellchecker
 *
 * @author Baltan
 * @date 2020-02-29 13:32
 */
public class Spellchecker {
    public static void main(String[] args) {
        String[] wordlist1 = {"yellow"};
        String[] queries1 = {"YellOw"};
        OutputUtils.print1DStringArray(spellchecker(wordlist1, queries1));

        String[] wordlist2 = {"Yellow"};
        String[] queries2 = {"yellow"};
        OutputUtils.print1DStringArray(spellchecker(wordlist2, queries2));

        String[] wordlist3 = {"yellow"};
        String[] queries3 = {"yellow"};
        OutputUtils.print1DStringArray(spellchecker(wordlist3, queries3));

        String[] wordlist4 = {"YellOw"};
        String[] queries4 = {"yollow"};
        OutputUtils.print1DStringArray(spellchecker(wordlist4, queries4));

        String[] wordlist5 = {"YellOw"};
        String[] queries5 = {"yeellow"};
        OutputUtils.print1DStringArray(spellchecker(wordlist5, queries5));

        String[] wordlist6 = {"YellOw"};
        String[] queries6 = {"yllw"};
        OutputUtils.print1DStringArray(spellchecker(wordlist6, queries6));

        String[] wordlist7 = {"KiTe", "kite", "hare", "Hare"};
        String[] queries7 = {"kite", "Kite", "KiTe", "Hare", "HARE", "Hear", "hear", "keti", "keet", "keto"};
        OutputUtils.print1DStringArray(spellchecker(wordlist7, queries7));
    }

    public static String[] spellchecker(String[] wordlist, String[] queries) {
        int length = queries.length;
        String[] result = new String[length];
        /**
         * 保存所有忽略大小写之后相等的单词的列表
         */
        Map<String, List<String>> wordLists = new HashMap<>();
        /**
         * 保存所有忽略大小写之后相等的单词的集合
         */
        Map<String, Set<String>> wordSets = new HashMap<>();
        /**
         * 保存wordLists（wordSets）中所有的key
         */
        List<String> lowerCaseWordList = new LinkedList<>();
        /**
         * 元音小写字母集合
         */
        Set<Character> vowelSet = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));

        for (String word : wordlist) {
            String lowerCaseWord = word.toLowerCase();

            if (wordLists.containsKey(lowerCaseWord)) {
                wordLists.get(lowerCaseWord).add(word);
                wordSets.get(lowerCaseWord).add(word);
            } else {
                List<String> wordList = new LinkedList<>();
                Set<String> wordSet = new HashSet<>();
                wordList.add(word);
                wordSet.add(word);
                wordLists.put(lowerCaseWord, wordList);
                wordSets.put(lowerCaseWord, wordSet);
                lowerCaseWordList.add(lowerCaseWord);
            }
        }

        for (int i = 0; i < length; i++) {
            result[i] = "";
            String query = queries[i];
            String lowerCaseQuery = query.toLowerCase();
            /**
             * 先根据大小写来查询
             */
            if (wordSets.containsKey(lowerCaseQuery)) {
                /**
                 * 查询wordlist中是否有和查询单词完全一致的单词
                 */
                if (wordSets.get(lowerCaseQuery).contains(query)) {
                    result[i] = query;
                } else {
                    /**
                     * wordlist中第一个和查询单词只有大小写不一致问题的单词
                     */
                    result[i] = wordLists.get(lowerCaseQuery).get(0);
                }
            } else {
                /**
                 * 查询wordlist中第一个和查询单词有元音问题（不区分大小写）的单词
                 */
                for (String lowerCaseWord : lowerCaseWordList) {
                    if (vowelChecker(lowerCaseQuery, lowerCaseWord, vowelSet)) {
                        result[i] = wordLists.get(lowerCaseWord).get(0);
                        break;
                    }
                }
            }
        }
        return result;
    }

    /**
     * 判断lowerCaseQuery和lowerCaseWord是否只有元音问题（不区分大小写）
     *
     * @param lowerCaseQuery
     * @param lowerCaseWord
     * @param vowelSet
     * @return
     */
    public static boolean vowelChecker(String lowerCaseQuery, String lowerCaseWord, Set<Character> vowelSet) {
        if (lowerCaseQuery.length() != lowerCaseWord.length()) {
            return false;
        }

        int length = lowerCaseQuery.length();

        for (int i = 0; i < length; i++) {
            char c1 = lowerCaseQuery.charAt(i);
            char c2 = lowerCaseWord.charAt(i);
            /**
             * 如果当前的两个字母不一致并且至少有一个不是元音字母，则两个单词替换元音后也无法
             * 匹配，返回false
             */
            if (c1 != c2) {
                if (!vowelSet.contains(c1) || !vowelSet.contains(c2)) {
                    return false;
                }
            }
        }
        return true;
    }
}
