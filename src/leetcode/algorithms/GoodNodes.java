package leetcode.algorithms;

import leetcode.entity.TreeNode;
import leetcode.util.BinaryTreeUtils;

/**
 * Description: 1448. Count Good Nodes in Binary Tree
 *
 * @author Baltan
 * @date 2020-05-18 16:18
 */
public class GoodNodes {
    public static void main(String[] args) {
        TreeNode root1 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{3, 1, 4, 3, null, 1, 5}, 0);
        System.out.println(goodNodes(root1));

        TreeNode root2 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{3, 3, null, 4, 2}, 0);
        System.out.println(goodNodes(root2));

        TreeNode root3 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{1}, 0);
        System.out.println(goodNodes(root3));
    }

    public static int goodNodes(TreeNode root) {
        return goodNodes(root, Integer.MIN_VALUE);
    }

    /**
     * @param subtree
     * @param value   从root根节点到达当前子树subtree的父节点路径上节点的最大值
     * @return
     */
    public static int goodNodes(TreeNode subtree, int value) {
        if (subtree == null) {
            return 0;
        }

        int result = 0;
        /**
         * subtree的根节点是好节点
         */
        if (subtree.val >= value) {
            result++;
        }

        value = Math.max(value, subtree.val);
        /**
         * 在subtree的左子树中继续递归查找好节点
         */
        result += goodNodes(subtree.left, value);
        /**
         * 在subtree的右子树中继续递归查找好节点
         */
        result += goodNodes(subtree.right, value);
        return result;
    }
}
