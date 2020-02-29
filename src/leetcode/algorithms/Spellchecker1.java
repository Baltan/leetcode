package leetcode.algorithms;

import leetcode.util.OutputUtils;

import java.util.*;

/**
 * Description: 966. Vowel Spellchecker
 *
 * @author Baltan
 * @date 2020-02-29 13:32
 */
public class Spellchecker1 {
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
         * wordlist中所有单词的集合
         */
        Set<String> wordSet = new HashSet<>();
        /**
         * 保存第一个匹配的大小写问题的单词
         */
        Map<String, String> caseInsensitiveMap = new HashMap<>();
        /**
         * 保存第一个匹配的元音问题的单词
         */
        Map<String, String> vowelReplacingMap = new HashMap<>();
        /**
         * 元音小写字母集合
         */
        Set<Character> vowelSet = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));

        for (String word : wordlist) {
            wordSet.add(word);
            /**
             * 将当前单词全部小写
             */
            String lowerCaseWord = word.toLowerCase();
            /**
             * 将当前单词进行元音转换，并且其他字母全部转为小写
             */
            String vowelReplacingWord = vowelReplacing(word, vowelSet);
            caseInsensitiveMap.putIfAbsent(lowerCaseWord, word);
            vowelReplacingMap.putIfAbsent(vowelReplacingWord, word);
        }

        for (int i = 0; i < length; i++) {
            String query = queries[i];
            /**
             * 将当前单词全部小写
             */
            String lowerCaseQuery = query.toLowerCase();
            /**
             * 将当前单词进行元音转换，并且其他字母全部转为小写
             */
            String vowelReplacingQuery = vowelReplacing(query, vowelSet);
            /**
             * 首先在wordSet中查找是否有和查询单词完全相同的单词；再尝试在caseInsensitiveMap
             * 中查找是否有和查询单词只存在大小写问题的单词；在尝试在vowelReplacingMap中查找
             * 是否有和查询单词存在元音问题的单词；如果以上都没找到，则没有符合匹配规则的单词
             */
            if (wordSet.contains(query)) {
                result[i] = query;
            } else if (caseInsensitiveMap.containsKey(lowerCaseQuery)) {
                result[i] = caseInsensitiveMap.get(lowerCaseQuery);
            } else if (vowelReplacingMap.containsKey(vowelReplacingQuery)) {
                result[i] = vowelReplacingMap.get(vowelReplacingQuery);
            } else {
                result[i] = "";
            }
        }
        return result;
    }

    /**
     * 将word中的所有元音字母替换成"*"，其他字母替换成对应的小写字母
     *
     * @param word
     * @param vowelSet
     * @return
     */
    public static String vowelReplacing(String word, Set<Character> vowelSet) {
        StringBuilder builder = new StringBuilder();

        for (char c : word.toCharArray()) {
            c = Character.toLowerCase(c);

            if (vowelSet.contains(c)) {
                builder.append('*');
            } else {
                builder.append(c);
            }
        }
        return builder.toString();
    }
}
