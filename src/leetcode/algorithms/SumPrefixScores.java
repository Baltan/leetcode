package leetcode.algorithms;

import leetcode.util.OutputUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Description: 2416. Sum of Prefix Scores of Strings
 *
 * @author Baltan
 * @date 2024/9/27 20:16
 */
public class SumPrefixScores {
    public static void main(String[] args) {
        OutputUtils.print1DIntegerArray(sumPrefixScores(new String[]{"abc", "ab", "bc", "b"}));
        OutputUtils.print1DIntegerArray(sumPrefixScores(new String[]{"abcd"}));
    }

    public static int[] sumPrefixScores(String[] words) {
        int[] result = new int[words.length];
        /**
         * i-> 数组words中字符串i所在的索引位置集合
         */
        Map<String, List<Integer>> indexesMap = new HashMap<>();
        /**
         * 数组words构建的字典树的根节点
         */
        TrieNode root = new TrieNode(new HashMap<>(), 0);

        for (int i = 0; i < words.length; i++) {
            indexesMap.computeIfAbsent(words[i], x -> new ArrayList<>()).add(i);
            /**
             * 对数组words构建字典树
             */
            buildTrie(root, words[i]);
        }
        backtrack(result, indexesMap, root, 0, new StringBuilder());
        return result;
    }

    /**
     * 在字典树中回溯计算数组words中每个字符串的前缀分数和
     *
     * @param result
     * @param indexesMap
     * @param node
     * @param totalPass  经过字典树中当前节点所代表的子串的所有字符的总次数
     * @param builder    记录字典数中当前节点所代表的子串
     */
    private static void backtrack(int[] result, Map<String, List<Integer>> indexesMap, TrieNode node, int totalPass, StringBuilder builder) {
        /**
         * builder是数组words中存在的字符串
         */
        if (node.isEnd) {
            String word = builder.toString();

            for (int index : indexesMap.get(word)) {
                result[index] = totalPass;
            }
        }

        for (Map.Entry<Character, TrieNode> entry : node.children.entrySet()) {
            builder.append(entry.getKey());
            totalPass += entry.getValue().passCount;
            backtrack(result, indexesMap, entry.getValue(), totalPass, builder);
            /**
             * 回退到entry.getValue()节点后，还原数据
             */
            totalPass -= entry.getValue().passCount;
            builder.deleteCharAt(builder.length() - 1);
        }
    }

    /**
     * 构建字典树
     *
     * @param node
     * @param word
     */
    public static void buildTrie(TrieNode node, String word) {
        for (char c : word.toCharArray()) {
            node = node.children.computeIfAbsent(c, x -> new TrieNode(new HashMap<>(), 0));
            node.passCount++;
        }
        node.isEnd = Boolean.TRUE;
    }

    public static class TrieNode {
        /**
         * 当前节点的所有子节点
         */
        private final Map<Character, TrieNode> children;
        /**
         * 当前字符是否是某个字符串结尾
         */
        private boolean isEnd;
        /**
         * 经过当前字符的字符串的个数，即以当前子串作为前缀的字符串的个数
         */
        private int passCount;

        public TrieNode(Map<Character, TrieNode> children, int passCount) {
            this.children = children;
            this.passCount = passCount;
        }
    }
}
