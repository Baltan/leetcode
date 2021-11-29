package leetcode.algorithms;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Description: 2085. Count Common Words With One Occurrence
 *
 * @author Baltan
 * @date 2021/11/29 13:36
 */
public class CountWords {
    public static void main(String[] args) {
        System.out.println(countWords(
                new String[]{"leetcode", "is", "amazing", "as", "is"},
                new String[]{"amazing", "leetcode", "is"}
        ));

        System.out.println(countWords(
                new String[]{"b", "bb", "bbb"},
                new String[]{"a", "aa", "aaa"}
        ));

        System.out.println(countWords(
                new String[]{"a", "ab"},
                new String[]{"a", "a", "a", "ab"}
        ));
    }

    public static int countWords(String[] words1, String[] words2) {
        int result = 0;
        /**
         * 单词 -> 单词在words1中出现的次数
         */
        Map<String, Integer> countMap1 = new HashMap<>();
        /**
         * 单词 -> 单词在words2中出现的次数
         */
        Map<String, Integer> countMap2 = new HashMap<>();
        /**
         * 对words1中的所有单词计数
         */
        for (String word : words1) {
            countMap1.put(word, countMap1.getOrDefault(word, 0) + 1);
        }
        /**
         * 对words2中的所有单词计数
         */
        for (String word : words2) {
            countMap2.put(word, countMap2.getOrDefault(word, 0) + 1);
        }

        for (Map.Entry<String, Integer> entry : countMap1.entrySet()) {
            if (entry.getValue() == 1 && Objects.equals(countMap2.get(entry.getKey()), 1)) {
                result++;
            }
        }
        return result;
    }
}
