package leetcode.algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: 1032. Stream of Characters
 *
 * @author Baltan
 * @date 2024/10/10 22:58
 */
public class StreamChecker {
    private TrieNode root;
    /**
     * 按顺序保存输入的所有字符
     */
    private List<Character> letters;

    public StreamChecker(String[] words) {
        this.root = buildTrie(words);
        this.letters = new ArrayList<>();
    }

    public boolean query(char letter) {
        TrieNode node = root;
        letters.add(letter);
        /**
         * 判断已输入的字符串逆序后的前缀子串是否在字典树root中存在
         */
        for (int i = letters.size() - 1; i >= 0; i--) {
            int index = letters.get(i) - 'a';

            if (node.children[index] == null) {
                return false;
            }

            if (node.children[index].isEnd) {
                return true;
            }
            node = node.children[index];
        }
        return false;
    }

    /**
     * 构建字典树
     *
     * @param words
     * @return
     */
    public TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode(new TrieNode[26]);
        /**
         * 将每个单词word逆序构建到字典树中
         */
        for (String word : words) {
            TrieNode node = root;

            for (int i = word.length() - 1; i >= 0; i--) {
                int index = word.charAt(i) - 'a';

                if (node.children[index] == null) {
                    node.children[index] = new TrieNode(new TrieNode[26]);
                }
                node = node.children[index];
            }
            /**
             * 标记当前节点所代表的字符是一个单词的结尾
             */
            node.isEnd = true;
        }
        return root;
    }

    public static class TrieNode {
        /**
         * 是否是单词结尾
         */
        private boolean isEnd;
        /**
         * 当前节点的所有子节点
         */
        private final TrieNode[] children;

        public TrieNode(TrieNode[] children) {
            this.children = children;
        }
    }

    public static void main(String[] args) {
        StreamChecker streamChecker1 = new StreamChecker(new String[]{"cd", "f", "kl"});
        System.out.println(streamChecker1.query('a'));
        System.out.println(streamChecker1.query('b'));
        System.out.println(streamChecker1.query('c'));
        System.out.println(streamChecker1.query('d'));
        System.out.println(streamChecker1.query('e'));
        System.out.println(streamChecker1.query('f'));
        System.out.println(streamChecker1.query('g'));
        System.out.println(streamChecker1.query('h'));
        System.out.println(streamChecker1.query('i'));
        System.out.println(streamChecker1.query('j'));
        System.out.println(streamChecker1.query('k'));
        System.out.println(streamChecker1.query('l'));
    }
}
