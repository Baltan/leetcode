package leetcode.algorithms;

import java.util.*;

/**
 * Description: 1048. Longest String Chain
 *
 * @author Baltan
 * @date 2019-09-28 16:55
 */
public class LongestStrChain {
    public static void main(String[] args) {
        String[] words1 = {"a", "b", "ba", "bca", "bda", "bdca"};
        System.out.println(longestStrChain(words1));

        String[] words2 = {"a"};
        System.out.println(longestStrChain(words2));

        String[] words3 = {"a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa",
                "aaaaaaaaaa", "aaaaaaaaaaa", "aaaaaaaaaaaa", "aaaaaaaaaaaaa", "aaaaaaaaaaaaaa",
                "aaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaa"};
        System.out.println(longestStrChain(words3));

        String[] words4 =
                {"ksqvsyq", "ks", "kss", "czvh", "zczpzvdhx", "zczpzvh", "zczpzvhx", "zcpzvh", "zczvh", "gr",
                        "grukmj", "ksqvsq", "gruj", "kssq", "ksqsq", "grukkmj", "grukj", "zczpzfvdhx", "gru"};
        System.out.println(longestStrChain(words4));
    }

    public static int longestStrChain(String[] words) {
        int result = 1;
        /**
         * 保存某个长度的所有单词集合
         */
        Map<Integer, List<String>> lengthMap = new HashMap<>();
        /**
         * 保存以某个单词作为终点的最长字符串链的长度
         */
        Map<String, Integer> currentChainLengthMap = new HashMap<>();
        /**
         * 单词的最短长度
         */
        int minLength = Integer.MAX_VALUE;
        /**
         * 单词的最长长度
         */
        int maxLength = Integer.MIN_VALUE;
        /**
         * 保存以某个单词作为终点的最长字符串链的长度，并记录下单词的最短长度和最长长度
         */
        for (String word : words) {
            int length = word.length();
            minLength = Math.min(minLength, length);
            maxLength = Math.max(maxLength, length);
            lengthMap.putIfAbsent(length, new LinkedList<>());
            lengthMap.get(length).add(word);
        }

        for (int i = minLength; i <= maxLength && lengthMap.containsKey(i); i++) {
            List<String> list = lengthMap.get(i);
            /**
             * 获得长度比当前单词长度少1的单词的集合otherList，即可能是当前单词前身的单词的集合
             */
            List<String> otherList = lengthMap.get(i - 1);
            /**
             * 如果otherList为空，说明当前单词没有前身，以当前单词作为终点的最长字符串链的长度为1；如果
             * otherList不为空，逐一判断otherList中的单词是否是当前单词的前身，如果是的话，更新以当前
             * 单词作为终点的最长字符串链的长度
             */
            if (otherList == null) {
                for (String word : list) {
                    currentChainLengthMap.put(word, 1);
                }
            } else {
                for (String word : list) {
                    int currentChainLength = 1;

                    for (String otherWord : otherList) {
                        if (isPredecessor(otherWord, word)) {
                            currentChainLength = Math.max(currentChainLength,
                                    currentChainLengthMap.get(otherWord) + 1);
                        }
                    }
                    currentChainLengthMap.put(word, currentChainLength);
                    result = Math.max(result, currentChainLength);
                }
            }
        }
        return result;
    }

    /**
     * 判断s1是否是s2的前身
     *
     * @param s1
     * @param s2
     * @return
     */
    public static boolean isPredecessor(String s1, String s2) {
        int length = s2.length();
        /**
         * 将s2的字母逐一删除后判断是否和s1相等
         */
        for (int i = 0; i < length; i++) {
            if (Objects.equals(s1, s2.substring(0, i) + s2.substring(i + 1))) {
                return true;
            }
        }
        return false;
    }
}
