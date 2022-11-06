package leetcode.algorithms;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Description: 1081. Smallest Subsequence of Distinct Characters
 *
 * @author Baltan
 * @date 2022/11/5 20:16
 * @see RemoveDuplicateLetters
 */
public class SmallestSubsequence {
    public static void main(String[] args) {
        System.out.println(smallestSubsequence("bcbcbcababa"));
        System.out.println(smallestSubsequence("bcabc"));
        System.out.println(smallestSubsequence("cbacdcbc"));
    }

    /**
     * 参考：<a href="https://leetcode.cn/problems/remove-duplicate-letters/solutions/527359/qu-chu-zhong-fu-zi-mu-by-leetcode-soluti-vuso/"></a>
     *
     * @param s
     * @return
     */
    public static String smallestSubsequence(String s) {
        /**
         * isVisited[i]表示对应小写字母是否在最终字符串中出现过
         */
        boolean[] isVisited = new boolean[26];
        /**
         * counts[i]表示对应小写字母在字符串s中出现的次数
         */
        int[] counts = new int[26];
        char[] charArray = s.toCharArray();
        Deque<Character> deque = new ArrayDeque();
        /**
         * 计算每个小写字母在字符串s中出现的次数
         */
        for (char c : charArray) {
            counts[c - 'a']++;
        }

        for (char c : charArray) {
            /**
             * 不论当前字符c是否被追加到最终字符串尾部，s后面可用的字符c都会减少1个
             */
            counts[c - 'a']--;
            /**
             * 因为每个字母在最终字符串中只会出现一次，所以直接跳过当前字符c
             */
            if (isVisited[c - 'a']) {
                continue;
            }
            /**
             * 假设最终得到的字符串为t，为了保证t的字典顺序最小，在遍历字符串s的过程中，总是希望将字典顺序更小字符排在t的前面，除非是遍历到的当
             * 前字符在这之后不会在s中再次出现。当前追加在t尾部的字符x如果大于当前遍历到的字符c，并且x在s后面的子串中还会出现，可以先将x移除，
             * 将c追加到t尾部，从而得到更小的字符串t
             */
            while (deque.size() > 0 && deque.peekLast() > c && counts[deque.peekLast() - 'a'] > 0) {
                isVisited[deque.peekLast() - 'a'] = false;
                deque.pollLast();
            }
            isVisited[c - 'a'] = true;
            deque.offerLast(c);
        }
        StringBuilder builder = new StringBuilder(deque.size());
        /**
         * 将deque中的字符按顺序拼接构成最终字符串
         */
        while (!deque.isEmpty()) {
            builder.append(deque.pollFirst());
        }
        return builder.toString();
    }
}
