package leetcode.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description: 2246. Longest Path With Different Adjacent Characters
 *
 * @author baltan
 * @date 2024/7/31 14:34
 */
public class LongestPath {
    public static void main(String[] args) {
        System.out.println(longestPath(new int[]{-1, 0, 0, 1, 1, 2}, "abacbe"));
        System.out.println(longestPath(new int[]{-1, 0, 0, 0}, "aabc"));
    }

    private static int result;

    public static int longestPath(int[] parent, String s) {
        result = 0;
        int length = s.length();
        /**
         * isVisited[i]表示以节点i作为根节点的多叉树是否已计算过高度
         */
        boolean[] isVisited = new boolean[length];
        /**
         * nodes[i]表示编号为i的节点
         */
        Node[] nodes = new Node[length];
        Arrays.setAll(nodes, i -> new Node(i, new ArrayList<>()));
        /**
         * 构建多叉树
         */
        for (int i = 1; i < length; i++) {
            nodes[parent[i]].children.add(nodes[i]);
        }
        help(nodes[0], s, isVisited);
        dfs(nodes[0], s);
        return result;
    }

    /**
     * 递归计算多叉树种的最长路径
     *
     * @param node
     * @param s
     */
    public static void dfs(Node node, String s) {
        /**
         * 多叉树node的被分配不同字符的子树的最大高度
         */
        int first = -1;
        /**
         * 多叉树node的被分配不同字符的子树的第二大高度
         */
        int second = -1;

        for (Node child : node.children) {
            if (s.charAt(node.number) != s.charAt(child.number)) {
                if (child.height > first) {
                    second = first;
                    first = child.height;
                } else if (child.height > second) {
                    second = child.height;
                }
            }
        }

        if (first == -1) {
            /**
             * 最长路径上只有唯一的节点node
             */
            result = Math.max(result, 1);
        } else if (second == -1) {
            /**
             * 最长路径由节点node和唯一子树中的最长路径连接而成
             */
            result = Math.max(result, first + 1);
        } else {
            /**
             * 最长路径由节点node、最高子树中的最长路径和第二高子树中的最长路径连接而成，节点node为连接点
             */
            result = Math.max(result, first + second + 1);
        }

        for (Node child : node.children) {
            dfs(child, s);
        }
    }

    /**
     * 递归计算以节点node作为根节点的多叉树的高度
     *
     * @param node
     * @param s
     * @param isVisited
     */
    public static void help(Node node, String s, boolean[] isVisited) {
        if (isVisited[node.number]) {
            return;
        }
        isVisited[node.number] = true;

        if (node.children.isEmpty()) {
            node.height = 1;
        } else {
            for (Node child : node.children) {
                help(child, s, isVisited);
                /**
                 * 如果节点node和节点child被分配的字符不同，则两个节点可以在同一路径上
                 */
                if (s.charAt(node.number) != s.charAt(child.number)) {
                    node.height = Math.max(node.height, child.height + 1);
                }
            }
        }
    }

    private static class Node {
        private final int number;
        private final List<Node> children;
        private int height;

        public Node(int number, List<Node> children) {
            this.number = number;
            this.children = children;
            this.height = 1;
        }
    }
}
