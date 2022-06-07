package leetcode.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * Description: 2273. Find Resultant Array After Removing Anagrams
 *
 * @author Baltan
 * @date 2022/6/5 13:46
 */
public class RemoveAnagrams {
    public static void main(String[] args) {
        System.out.println(removeAnagrams(new String[]{"abba", "baba", "bbaa", "cd", "cd"}));
        System.out.println(removeAnagrams(new String[]{"a", "b", "c", "d", "e"}));
    }

    public static List<String> removeAnagrams(String[] words) {
        List<String> result = new ArrayList<>();
        String[] clonedWords = words.clone();
        /**
         * 将clonedWords中的每个单词中的所有字母按照升序排列
         */
        for (int i = 0; i < clonedWords.length; i++) {
            char[] charArray = clonedWords[i].toCharArray();
            Arrays.sort(charArray);
            clonedWords[i] = new String(charArray);
        }
        /**
         * standard为判断后面的单词是否会和前面的单词构成字母异位词的比较标准
         */
        String standard = clonedWords[0];
        /**
         * 不论words[0]是否和后面的单词构成字母异位词，都会被加入结果集中
         */
        result.add(words[0]);

        for (int i = 1; i < clonedWords.length; i++) {
            /**
             * 当前单词不和前面的单词构成字母异位词时，words中该索引位置的单词将被加入结果集中，并且clonedWords[i]成为判断后
             * 面的单词是否会和前面的单词构成字母异位词的比较标准
             */
            if (!Objects.equals(standard, clonedWords[i])) {
                result.add(words[i]);
                standard = clonedWords[i];
            }
        }
        return result;
    }
}
