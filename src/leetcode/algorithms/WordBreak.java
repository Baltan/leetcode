package leetcode.algorithms;

import java.util.*;

/**
 * Description: 139. Word Break
 *
 * @author Baltan
 * @date 2019-04-12 09:27
 */
public class WordBreak {
    public static void main(String[] args) {
        String s1 = "leetcode";
        List<String> wordDict1 = Arrays.asList("leet", "code");
        System.out.println(wordBreak(s1, wordDict1));

        String s2 = "applepenapple";
        List<String> wordDict2 = Arrays.asList("apple", "pen");
        System.out.println(wordBreak(s2, wordDict2));

        String s3 = "catsandog";
        List<String> wordDict3 = Arrays.asList("cats", "dog", "sand", "and", "cat");
        System.out.println(wordBreak(s3, wordDict3));

        String s4 =
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
        List<String> wordDict4 =
                Arrays.asList("a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa",
                        "aaaaaaaaaa");
        System.out.println(wordBreak(s4, wordDict4));
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        /**
         * 保存需要被拆分的子串
         */
        Queue<String> queue = new LinkedList<>();
        queue.offer(s);
        /**
         * 保存已经被拆分的子串，避免重复的子串加入到queue中
         */
        Set<String> set = new HashSet<>();
        set.add(s);

        while (!queue.isEmpty()) {
            /**
             * 当前将要被拆分的子串
             */
            String currentStr = queue.poll();

            for (String word : wordDict) {
                /**
                 * 如果wordDict中存在某个单词和当前将要被拆分的子串currentStr相同，则说明最原始的字符串
                 * s可以被拆分成wordDict中的若干个单词；否则如果wordDict中某个单词和currentStr的头部相
                 * 同，则将currentStr除去头部后剩余的子串加入queue中，后面继续尝试拆分剩余的子串
                 */
                if (Objects.equals(currentStr, word)) {
                    return true;
                } else if (currentStr.startsWith(word)) {
                    String newStr = currentStr.substring(word.length());
                    /**
                     * 如果剩余的子串已经被加入到queue中，就不再重复加入
                     */
                    if (!set.contains(newStr)) {
                        queue.offer(newStr);
                        set.add(newStr);
                    }
                }
            }
        }
        return false;
    }
}
