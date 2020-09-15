package leetcode.algorithms;

import leetcode.entity.TreeNode;
import leetcode.util.BinaryTreeUtils;

/**
 * Description: 226. Invert Binary Tree
 *
 * @author Baltan
 * @date 2018/7/31 16:24
 */
public class InvertTree {
    public static void main(String[] args) {
        TreeNode root1 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{4, 2, 7, 1, 3, 6, 9}, 0);
        System.out.println(invertTree(root1));
    }

    public static TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode leftTree = root.left;
        TreeNode rightTree = root.right;
        /**
         * 将原来的右子树翻转后作为翻转后的二叉树的左子树
         */
        root.left = invertTree(rightTree);
        /**
         * 将原来的左子树翻转后作为翻转后的二叉树的右子树
         */
        root.right = invertTree(leftTree);
        return root;
    }
}
