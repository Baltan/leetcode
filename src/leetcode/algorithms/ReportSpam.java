package leetcode.algorithms;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: 3295. Report Spam Message
 *
 * @author baltan
 * @date 2024/9/23 19:21
 */
public class ReportSpam {
    public static void main(String[] args) {
        System.out.println(reportSpam(new String[]{"hello", "world", "leetcode"}, new String[]{"world", "hello"}));
        System.out.println(reportSpam(new String[]{"hello", "programming", "fun"}, new String[]{"world", "programming", "leetcode"}));
    }

    public static boolean reportSpam(String[] message, String[] bannedWords) {
        /**
         * 数组message中，禁用词的个数
         */
        int count = 0;
        TrieNode root = new TrieNode(new HashMap<>(), false);

        for (String bannedWord : bannedWords) {
            buildTrie(root, bannedWord);
        }

        for (String messageWord : message) {
            if (isBannedWord(root, messageWord)) {
                count++;
            }

            if (count == 2) {
                return true;
            }
        }
        return false;
    }

    /**
     * 在字典树node中，查找是否存在单词messageWord
     *
     * @param node
     * @param messageWord
     * @return
     */
    public static boolean isBannedWord(TrieNode node, String messageWord) {
        for (char c : messageWord.toCharArray()) {
            TrieNode child = node.children.get(c);

            if (child == null) {
                return false;
            }
            node = child;
        }
        /**
         * 只有messageWord的最后一个字母也是字典树中某个单词的结尾时，才说明字典树node中存在单词messageWord
         */
        return node.isEnd;
    }

    /**
     * 构建以节点node作为根节点的字典树
     *
     * @param node
     * @param bannedWord
     */
    public static void buildTrie(TrieNode node, String bannedWord) {
        for (char c : bannedWord.toCharArray()) {
            TrieNode child = node.children.get(c);

            if (child == null) {
                child = new TrieNode(new HashMap<>(), false);
            }
            node.children.put(c, child);
            node = child;
        }
        /**
         * 单词最后一个字母对应的节点，标记单词结尾
         */
        node.isEnd = true;
    }

    public static class TrieNode {
        /**
         * 当前节点的所有子节点
         */
        private final Map<Character, TrieNode> children;
        /**
         * 是否是单词结尾
         */
        private boolean isEnd;

        public TrieNode(Map<Character, TrieNode> children, boolean isEnd) {
            this.children = children;
            this.isEnd = isEnd;
        }
    }
}
