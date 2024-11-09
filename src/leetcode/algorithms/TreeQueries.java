package leetcode.algorithms;

import leetcode.entity.TreeNode;
import leetcode.util.BinaryTreeUtils;
import leetcode.util.OutputUtils;

import java.util.ArrayList;
import java.util.List;

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

        TreeNode root4 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{2, 1, 4, null, null, 3, null}, 0);
        int[] queries4 = {1, 4, 3, 4};
        OutputUtils.print1DIntegerArray(treeQueries(root4, queries4));
    }

    public static int[] treeQueries(TreeNode root, int[] queries) {
        int[] result = new int[queries.length];
        int n = getNodeCount(root);
        /**
         * heights[i]表示二叉树root中节点i所在的层数（0-based）
         */
        int[] levels = new int[n + 1];
        /**
         * heights[i]表示二叉树root中以节点i作为根节点的子树的高度
         */
        int[] heights = new int[n + 1];
        /**
         * levelHighest[i][0]和levelHighest[i][1]分别表示二叉树root中第i层（0-based）的节点作为根节点的子树的最大高度和第二大高度
         */
        List<int[]> levelHighest = new ArrayList<>();
        prepare(root, levels, heights, levelHighest, 0);

        for (int i = 0; i < queries.length; i++) {
            /**
             * 二叉树root中节点queries[i]在第level层（0-based）
             */
            int level = levels[queries[i]];
            int[] topTwoHighest = levelHighest.get(level);
            /**
             * 如果节点queries[i]作为根节点的子树为这一层中的所有节点作为根节点的子树中高度最大的，则移除子树queries[i]后，二叉树root的
             * 高度变为当前所在层数level+这一层第二高的子树高度topTwoHighest[1]-1（因为题目所求的高度为路径数，所以要减去1），否则二叉树
             * root的高度为当前所在层数level+这一层最高的子树高度topTwoHighest[0]-1
             */
            result[i] = heights[queries[i]] == topTwoHighest[0] ? level + topTwoHighest[1] - 1 : level + topTwoHighest[0] - 1;
        }
        return result;
    }

    /**
     * 计算二叉树root中每个节点作为根节点的子树的高度，以及每一层中的节点作为根节点的子树的最大高度和第二大高度
     *
     * @param node
     * @param levels
     * @param heights
     * @param levelHighest
     * @param level
     */
    public static void prepare(TreeNode node, int[] levels, int[] heights, List<int[]> levelHighest, int level) {
        levels[node.val] = level;
        /**
         * 叶子节点的高度为1
         */
        if (node.left == null && node.right == null) {
            heights[node.val] = 1;
        } else {
            if (node.left != null) {
                if (heights[node.left.val] == 0) {
                    prepare(node.left, levels, heights, levelHighest, level + 1);
                }
                heights[node.val] = Math.max(heights[node.val], heights[node.left.val] + 1);
            }

            if (node.right != null) {
                if (heights[node.right.val] == 0) {
                    prepare(node.right, levels, heights, levelHighest, level + 1);
                }
                heights[node.val] = Math.max(heights[node.val], heights[node.right.val] + 1);
            }
        }
        /**
         * 计算每一层中的节点作为根节点的子树的最大高度和第二大高度
         */
        getLevelHighest(node, heights, levelHighest, level);
    }

    /**
     * 计算每一层中的节点作为根节点的子树的最大高度和第二大高度
     *
     * @param node
     * @param heights
     * @param levelHighest
     * @param level
     */
    public static void getLevelHighest(TreeNode node, int[] heights, List<int[]> levelHighest, int level) {
        /**
         * 如果当前位于二叉树root的第level层（0-based），则levelHighest中至少有level+1个数组保存二叉树中每一层的节点作为根节点的子树的
         * 最大高度和第二大高度，先初始化每一层的子树高度数组
         */
        if (levelHighest.size() <= level) {
            int diff = level - levelHighest.size();

            for (int i = 0; i <= diff; i++) {
                levelHighest.add(new int[2]);
            }
        }

        if (heights[node.val] > levelHighest.get(level)[0]) {
            /**
             * 以节点node作为根节点的子树为当前第level层（0-based）最高的子树
             */
            levelHighest.get(level)[1] = levelHighest.get(level)[0];
            levelHighest.get(level)[0] = heights[node.val];
        } else if (heights[node.val] > levelHighest.get(level)[1]) {
            /**
             * 以节点node作为根节点的子树为当前第level层（0-based）第二高的子树
             */
            levelHighest.get(level)[1] = heights[node.val];
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
