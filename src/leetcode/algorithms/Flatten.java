package leetcode.algorithms;

import leetcode.entity.TreeNode;
import leetcode.util.BinaryTreeUtils;

/**
 * Description: 114. Flatten Binary Tree to Linked List
 *
 * @author Baltan
 * @date 2019-05-24 14:42
 */
public class Flatten {
    public static void main(String[] args) {
        /**
         * <pre>
         *     1
         *    / \
         *   2   5
         *  / \   \
         * 3   4   6
         * </pre>
         */
        TreeNode treeNode11 = new TreeNode(1);
        TreeNode treeNode12 = new TreeNode(2);
        TreeNode treeNode13 = new TreeNode(5);
        TreeNode treeNode14 = new TreeNode(3);
        TreeNode treeNode15 = new TreeNode(4);
        TreeNode treeNode16 = new TreeNode(6);
        treeNode11.left = treeNode12;
        treeNode11.right = treeNode13;
        treeNode12.left = treeNode14;
        treeNode12.right = treeNode15;
        treeNode13.right = treeNode16;
        flatten(treeNode11);
        System.out.println(BinaryTreeUtils.inOrder(treeNode11));

        TreeNode treeNode21 = new TreeNode(1);
        TreeNode treeNode22 = new TreeNode(2);
        treeNode21.left = treeNode22;
        flatten(treeNode21);
        System.out.println(BinaryTreeUtils.inOrder(treeNode21));

        TreeNode treeNode31 = new TreeNode(1);
        flatten(treeNode31);
        System.out.println(BinaryTreeUtils.inOrder(treeNode31));

        TreeNode treeNode41 = null;
        flatten(treeNode41);
        System.out.println(BinaryTreeUtils.inOrder(treeNode41));
    }

    public static void flatten(TreeNode root) {
        if (root != null) {
            TreeNode right = root.right;
            TreeNode left = root.left;
            TreeNode flattenLeft = help(left);
            root.left = null;
            root.right = null;

            if (flattenLeft != null) {
                root.right = flattenLeft;
            }

            TreeNode node = root;

            while (node.right != null) {
                node = node.right;
            }

            node.right = help(right);
        }
    }

    public static TreeNode help(TreeNode root) {
        if (root == null) {
            return null;
        }

        if (root.left == null && root.right == null) {
            return root;
        }

        TreeNode right = root.right;
        TreeNode left = root.left;
        TreeNode flattenLeft = help(left);
        root.left = null;
        root.right = null;

        if (flattenLeft != null) {
            root.right = flattenLeft;
        }

        TreeNode node = root;

        while (node.right != null) {
            node = node.right;
        }

        node.right = help(right);
        return root;
    }
}
