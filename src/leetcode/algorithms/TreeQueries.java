package leetcode.algorithms;

import leetcode.entity.TreeNode;
import leetcode.util.BinaryTreeUtils;
import leetcode.util.OutputUtils;

import java.util.*;

/**
 * Description: 2458. Height of Binary Tree After Subtree Removal Queries
 *
 * @author Baltan
 * @date 2024/11/3 20:11
 */
public class TreeQueries {
    public static void main(String[] args) {
        TreeNode root1 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{1, 3, 4, 2, null, 6, 5, null, null, null, null, null, null, null, 7}, 0);
        int[] queries1 = {4};
        OutputUtils.print1DIntegerArray(treeQueries(root1, queries1));

        TreeNode root2 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{5, 8, 9, 2, 1, 3, 7, 4, 6, null, null, null, null, null, null}, 0);
        int[] queries2 = {3, 2, 4, 8};
        OutputUtils.print1DIntegerArray(treeQueries(root2, queries2));

        TreeNode root3 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{1, null, 5, null, null, 3, null, null, null, null, null, 2, 4, null, null}, 0);
        int[] queries3 = {3, 5, 4, 2, 4};
        OutputUtils.print1DIntegerArray(treeQueries(root3, queries3));
    }

    public static int[] treeQueries(TreeNode root, int[] queries) {
        int[] result = new int[queries.length];
        int n = getNodeCount(root);
        /**
         * heights[i]表示二叉树root中以节点i作为根节点的子树的高度
         */
        int[] heights = new int[n + 1];
        getHeight(root, heights);
        /**
         * levelNodes[i]表示二叉树root中第i（0-based）层的节点的集合
         */
        List<Integer>[] levelNodes = new List[heights[root.val]];
        Arrays.setAll(levelNodes, i -> new ArrayList<>());
        getLevelNodes(root, levelNodes);

        for (int i = 0; i < queries.length; i++) {
            /**
             * 二叉树root中节点queries[i]在第level层
             */
            int level = heights[root.val] - heights[queries[i]];
            /**
             * 遍历和节点queries[i]同一层的其他节点作为根节点的子树，假设节点为x，二叉树root移除子树queries[i]后，剩余子树的高度就是子树
             * x的最大高度加上节点x在二叉树root中所在的层数（因为题目要求的高度为最长简单路径中的边数，所以还需要减去1）
             */
            for (int x : levelNodes[level]) {
                if (x != queries[i]) {
                    result[i] = Math.max(result[i], level + heights[x] - 1);
                }
            }
            /**
             * 如果节点queries[i]同一层没有其他节点了，则剩余子树的高度就是节点queries[i]的父节点所在的层数了
             */
            if (result[i] == 0) {
                result[i] = level - 1;
            }
        }
        return result;
    }

    /**
     * 计算二叉树root中每一层的节点的集合
     *
     * @param root
     * @param levelNodes
     */
    public static void getLevelNodes(TreeNode root, List<Integer>[] levelNodes) {
        int level = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                levelNodes[level].add(node.val);

                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            level++;
        }
    }

    /**
     * 计算二叉树root中每个节点作为根节点的子树的高度
     *
     * @param node
     * @param heights
     */
    public static void getHeight(TreeNode node, int[] heights) {
        /**
         * 叶子节点的高度为1
         */
        if (node.left == null && node.right == null) {
            heights[node.val] = 1;
            return;
        }

        if (node.left != null) {
            if (heights[node.left.val] == 0) {
                getHeight(node.left, heights);
            }
            heights[node.val] = Math.max(heights[node.val], heights[node.left.val] + 1);
        }

        if (node.right != null) {
            if (heights[node.right.val] == 0) {
                getHeight(node.right, heights);
            }
            heights[node.val] = Math.max(heights[node.val], heights[node.right.val] + 1);
        }
    }

    /**
     * 计算二叉树root中节点的总数
     *
     * @param root
     * @return
     */
    public static int getNodeCount(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + getNodeCount(root.left) + getNodeCount(root.right);
    }
}
