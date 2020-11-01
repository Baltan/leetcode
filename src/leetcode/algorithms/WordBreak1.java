package leetcode.algorithms;

import java.util.*;

/**
 * Description: 140. Word Break II
 *
 * @author Baltan
 * @date 2019-04-13 16:31
 */
public class WordBreak1 {
    public static void main(String[] args) {
        String s1 = "catsanddog";
        List<String> wordDict1 = Arrays.asList("cat", "cats", "and", "sand", "dog");
        System.out.println(wordBreak(s1, wordDict1));

        String s2 = "pineapplepenapple";
        List<String> wordDict2 = Arrays.asList("apple", "pen", "applepen", "pine", "pineapple");
        System.out.println(wordBreak(s2, wordDict2));

        String s3 = "catsandog";
        List<String> wordDict3 = Arrays.asList("cats", "dog", "sand", "and", "cat");
        System.out.println(wordBreak(s3, wordDict3));

        String s4 =
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        List<String> wordDict4 =
                Arrays.asList("a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa",
                        "aaaaaaaaaa");
        System.out.println(wordBreak(s4, wordDict4));
    }

    public static List<String> wordBreak(String s, List<String> wordDict) {
        /**
         * 字符串 -> 该字符串可以得到的所有句子
         */
        Map<String, List<String>> map = new HashMap<>();
        return dfs(s, wordDict, map);
    }

    public static List<String> dfs(String s, List<String> wordDict, Map<String, List<String>> map) {
        /**
         * 已经对字符串s做过分隔，避免重复操作
         */
        if (map.containsKey(s)) {
            return map.get(s);
        }

        List<String> result = new ArrayList<>();
        /**
         * 依次判断字典wordDict中的单词是不是字符串s头部的字符串
         */
        for (String word : wordDict) {
            if (Objects.equals(s, word)) {
                result.add(s);
            } else if (s.startsWith(word)) {
                /**
                 * 除去头部的单词后，对后面的子字符串进行递归，获得子字符串可以得到的所有句子
                 */
                List<String> list = dfs(s.substring(word.length()), wordDict, map);

                for (String str : list) {
                    result.add(word + " " + str);
                }
            }
        }
        map.put(s, result);
        return result;
    }
}
