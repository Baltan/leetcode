package leetcode.algorithms;

import java.util.*;

/**
 * Description: Word Break II
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
        Map<String, List<String>> map = new HashMap<>();
        return dfs(s, wordDict, map);
    }

    public static List<String> dfs(String s, List<String> wordDict, Map<String, List<String>> map) {
        if (map.containsKey(s)) {
            return map.get(s);
        }

        List<String> result = new ArrayList<>();
        for (String word : wordDict) {
            if (Objects.equals(s, word)) {
                result.add(s);
            } else if (s.startsWith(word)) {
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
