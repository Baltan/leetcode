package leetcode.algorithms;

import java.util.*;

/**
 * Description: 3291. Minimum Number of Valid Strings to Form Target I
 *
 * @author Baltan
 * @date 2024/9/19 23:20
 */
public class MinValidStrings {
    public static void main(String[] args) {
        System.out.println(minValidStrings(new String[]{"abc", "aaaaa", "bcdef"}, "aabcdabc"));
        System.out.println(minValidStrings(new String[]{"abababab", "ab"}, "ababaababa"));
        System.out.println(minValidStrings(new String[]{"abcdef"}, "xyz"));
    }

    public static int minValidStrings(String[] words, String target) {
        int length = target.length();
        /**
         * 数组words所构建的字典树的根节点
         */
        TrieNode root = new TrieNode(new HashMap<>());
        /**
         * parts[i]表示得到子串words.substring(i)，需要有效字符串的最少数量。初始化假设所有子串都无法通过若干个有效字符串得到
         */
        int[] parts = new int[length + 1];
        Arrays.fill(parts, Integer.MAX_VALUE);
        /**
         * 空字符串可以视为由0个有效字符串得到
         */
        parts[length] = 0;

        for (String word : words) {
            buildTrie(root, word);
        }
        /**
         * 依次计算得到子串target.substring(i)，需要有效字符串的最少数量
         */
        for (int i = length - 1; i >= 0; i--) {
            TrieNode node = root;

            for (int j = i; j < length; j++) {
                TrieNode child = node.children.get(target.charAt(j) - 'a');

                if (child != null) {
                    /**
                     * 只有子串target.substring(i,j+1)是一个有效字符串，并且子串target.substring(j+1)可以通过若干个有效字符串得到
                     * 时，子串target.substring(i)才能通过1+parts[j+1]个有效字符串得到
                     */
                    if (parts[j + 1] != Integer.MAX_VALUE) {
                        parts[i] = Math.min(parts[i], 1 + parts[j + 1]);
                    }
                    node = child;
                } else {
                    /**
                     * 子串target.substring(i,j+1)不是一个有效字符串，不需要继续计算
                     */
                    break;
                }
            }
        }
        return parts[0] == Integer.MAX_VALUE ? -1 : parts[0];
    }

    /**
     * 构建以节点node作为根节点的字典树
     *
     * @param node
     * @param word
     */
    public static void buildTrie(TrieNode node, String word) {
        for (int i = 0; i < word.length(); i++) {
            /**
             * 如果节点node的子节点集合中不包含代表字母word[i]的节点，则创建子节点并加入到node的子节点集合中
             */
            node = node.children.computeIfAbsent(word.charAt(i) - 'a', x -> new TrieNode(new HashMap<>()));
        }
    }

    public static class TrieNode {
        /**
         * 节点所代表的字母 -> 节点自身
         */
        private final Map<Integer, TrieNode> children;

        public TrieNode(Map<Integer, TrieNode> children) {
            this.children = children;
        }
    }
}
