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
        Queue<String> queue = new LinkedList<>();
        queue.offer(s);
        Set<String> set = new HashSet<>();
        set.add(s);

        while (!queue.isEmpty()) {
            String currentStr = queue.poll();
            for (int i = 0, size = wordDict.size(); i < size; i++) {
                String wordStr = wordDict.get(i);
                if (currentStr.startsWith(wordStr)) {
                    if (Objects.equals(currentStr, wordStr)) {
                        return true;
                    } else if (wordStr.length() < currentStr.length()) {
                        String newStr = currentStr.substring(wordStr.length());
                        if (!set.contains(newStr)) {
                            queue.offer(newStr);
                            set.add(newStr);
                        }
                    }
                }
            }
        }
        return false;
    }
}
