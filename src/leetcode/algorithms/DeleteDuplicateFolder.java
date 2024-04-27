package leetcode.algorithms;

import java.util.*;

/**
 * Description: 1948. Delete Duplicate Folders in System
 *
 * @author Baltan
 * @date 2024/4/21 15:07
 */
public class DeleteDuplicateFolder {
    public static void main(String[] args) {
        List<List<String>> paths1 = Arrays.asList(
                Arrays.asList("a"),
                Arrays.asList("c"),
                Arrays.asList("d"),
                Arrays.asList("a", "b"),
                Arrays.asList("c", "b"),
                Arrays.asList("d", "a")
        );
        System.out.println(deleteDuplicateFolder(paths1));

        List<List<String>> paths2 = Arrays.asList(
                Arrays.asList("a"),
                Arrays.asList("c"),
                Arrays.asList("a", "b"),
                Arrays.asList("c", "b"),
                Arrays.asList("a", "b", "x"),
                Arrays.asList("a", "b", "x", "y"),
                Arrays.asList("w"),
                Arrays.asList("w", "y")
        );
        System.out.println(deleteDuplicateFolder(paths2));

        List<List<String>> paths3 = Arrays.asList(
                Arrays.asList("a", "b"),
                Arrays.asList("c", "d"),
                Arrays.asList("c"),
                Arrays.asList("a"));
        System.out.println(deleteDuplicateFolder(paths3));

        List<List<String>> paths4 = Arrays.asList(
                Arrays.asList("a"),
                Arrays.asList("a", "x"),
                Arrays.asList("a", "x", "y"),
                Arrays.asList("a", "z"),
                Arrays.asList("b"),
                Arrays.asList("b", "x"),
                Arrays.asList("b", "x", "y"),
                Arrays.asList("b", "z")
        );
        System.out.println(deleteDuplicateFolder(paths4));

        List<List<String>> paths5 = Arrays.asList(
                Arrays.asList("a"),
                Arrays.asList("a", "x"),
                Arrays.asList("a", "x", "y"),
                Arrays.asList("a", "z"),
                Arrays.asList("b"),
                Arrays.asList("b", "x"),
                Arrays.asList("b", "x", "y"),
                Arrays.asList("b", "z"),
                Arrays.asList("b", "w")
        );
        System.out.println(deleteDuplicateFolder(paths5));

        List<List<String>> paths6 = Arrays.asList(
                Arrays.asList("trs", "krj", "xlg", "tvzn"),
                Arrays.asList("trs", "krj", "xlg"),
                Arrays.asList("trs", "krj"),
                Arrays.asList("trs"),
                Arrays.asList("trs", "krj", "xlg", "drye"),
                Arrays.asList("trs", "krj", "xlg", "npzy"),
                Arrays.asList("dem", "wbv", "wcq", "tvzn"),
                Arrays.asList("dem", "wbv", "wcq"),
                Arrays.asList("dem", "wbv"),
                Arrays.asList("dem"),
                Arrays.asList("dem", "wbv", "wcq", "drye"),
                Arrays.asList("dem", "wbv", "wcq", "n")
        );
        System.out.println(deleteDuplicateFolder(paths6));


        List<List<String>> paths7 = Arrays.asList(
                Arrays.asList("b"),
                Arrays.asList("f"),
                Arrays.asList("f", "r"),
                Arrays.asList("f", "r", "g"),
                Arrays.asList("f", "r", "g", "c"),
                Arrays.asList("f", "r", "g", "c", "r"),
                Arrays.asList("f", "o"),
                Arrays.asList("f", "o", "x"),
                Arrays.asList("f", "o", "x", "t"),
                Arrays.asList("f", "o", "x", "d"),
                Arrays.asList("f", "o", "l"),
                Arrays.asList("l"),
                Arrays.asList("l", "q"),
                Arrays.asList("c"),
                Arrays.asList("h"),
                Arrays.asList("h", "t"),
                Arrays.asList("h", "o"),
                Arrays.asList("h", "o", "d"),
                Arrays.asList("h", "o", "t")
        );
        System.out.println(deleteDuplicateFolder(paths7));
    }

    public static List<List<String>> deleteDuplicateFolder(List<List<String>> paths) {
        /**
         * 文件系统只存在唯一一个文件夹，不存在相同文件夹
         */
        if (paths.size() == 1) {
            return paths;
        }
        List<List<String>> result = new ArrayList<>();
        /**
         * 文件夹节点 -> 父文件夹节点
         */
        Map<TrieNode, TrieNode> parents = new HashMap<>();
        /**
         * 文件夹节点 -> 文件夹路径字符串
         */
        Map<TrieNode, String> nodeStrings = new HashMap<>();
        /**
         * 构建Trie树
         */
        TrieNode trie = buildTrie(paths, parents);
        /**
         * 将每个文件夹的路径转换为字符串
         */
        stringifyTrie(trie, nodeStrings);
        /**
         * 删除所有相同文件夹对应的节点
         */
        deleteTrieNodes(nodeStrings, parents);
        /**
         * 从根目录下的第一层级目录开始递归标记所有剩余文件夹的路径
         */
        trie.children.values().forEach(node -> findPaths(result, node, new ArrayList<>()));
        return result;
    }

    /**
     * 递归标记所有剩余文件夹的路径
     *
     * @param result
     * @param trie
     * @param parentPath
     */
    public static void findPaths(List<List<String>> result, TrieNode trie, List<String> parentPath) {
        List<String> path = new ArrayList<>(parentPath);
        /**
         * 将当前文件夹名称追加到父文件夹路径后
         */
        path.add(trie.value);
        result.add(path);

        for (TrieNode node : trie.children.values()) {
            findPaths(result, node, path);
        }
    }

    /**
     * 删除所有相同文件夹对应的节点
     *
     * @param nodeStrings
     * @param parents
     */
    public static void deleteTrieNodes(Map<TrieNode, String> nodeStrings, Map<TrieNode, TrieNode> parents) {
        /**
         * 子文件夹字符串 -> 子文件夹字符串相同的文件夹列表
         */
        Map<String, List<TrieNode>> substringNodes = new HashMap<>();

        for (Map.Entry<TrieNode, String> entry : nodeStrings.entrySet()) {
            /**
             * 当前文件夹路径字符串和文件夹名称一致，说明当前文件夹没有子文件夹，不可能存在相同文件夹
             */
            if (Objects.equals(entry.getKey().value, entry.getValue())) {
                continue;
            }
            /**
             * 文件夹路径字符串"文件夹名称[子文件夹1字符串,子文件夹2字符串,子文件夹3字符串……]"截去当前文件夹名称后，剩下的
             * "[子文件夹1字符串,子文件夹2字符串,子文件夹3字符串……]"即为子文件夹字符串
             */
            String substring = entry.getValue().substring(entry.getKey().value.length());
            substringNodes.computeIfAbsent(substring, x -> new ArrayList<>()).add(entry.getKey());
        }
        /**
         * 删除所有相同文件夹对应的节点
         */
        for (List<TrieNode> nodes : substringNodes.values()) {
            if (nodes.size() == 1) {
                continue;
            }

            for (TrieNode node : nodes) {
                /**
                 * 节点node的父节点
                 */
                TrieNode parent = parents.get(node);
                /**
                 * 从Trie树中删除节点node
                 */
                parent.children.remove(node.value);
            }
        }
    }

    /**
     * 将每个文件夹的路径转换为字符串，形式为"文件夹名称[子文件夹1字符串,子文件夹2字符串,子文件夹3字符串……]"
     *
     * @param trie
     * @param nodeStrings
     * @return
     */
    public static String stringifyTrie(TrieNode trie, Map<TrieNode, String> nodeStrings) {
        String trieString = trie.value;

        if (trie.children.isEmpty()) {
            /**
             * 当前文件夹没有子文件夹，则文件夹字符串就是文件夹名称
             */
            nodeStrings.put(trie, trieString);
            return trieString;
        }
        /**
         * 子文件夹字符串列表
         */
        List<String> trieStringList = new ArrayList<>(trie.children.size());

        for (TrieNode child : trie.children.values()) {
            trieStringList.add(stringifyTrie(child, nodeStrings));
        }
        /**
         * 因为同一级的文件夹名称不区分顺序，所以可以将所有子文件夹字符串按照字典顺序排列
         */
        Collections.sort(trieStringList);
        /**
         * 将子文件夹字符串"[子文件夹1字符串,子文件夹2字符串,子文件夹3字符串……]"拼接到当前文件夹名称后
         */
        trieString += trieStringList;
        nodeStrings.put(trie, trieString);
        return trieString;
    }

    /**
     * 构建Trie树
     *
     * @param paths
     * @param parents
     * @return
     */
    public static TrieNode buildTrie(List<List<String>> paths, Map<TrieNode, TrieNode> parents) {
        /**
         * 根文件夹节点
         */
        TrieNode root = new TrieNode("/");

        for (List<String> path : paths) {
            TrieNode node = root;
            /**
             * 遍历路径path的每一级文件夹名
             */
            for (String s : path) {
                if (!node.children.containsKey(s)) {
                    TrieNode newNode = new TrieNode(s);
                    parents.put(newNode, node);
                    node.children.put(s, newNode);
                }
                node = node.children.get(s);
            }
        }
        return root;
    }

    public static class TrieNode {
        private String value;
        /**
         * 子节点集合：子节点的值 -> 子节点对象
         */
        private Map<String, TrieNode> children;

        public TrieNode(String value) {
            this.value = value;
            this.children = new HashMap<>();
        }
    }
}
