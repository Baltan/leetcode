package leetcode.algorithms;

import leetcode.entity.TreeNode;

/**
 * Description: 226. Invert Binary Tree
 *
 * @author Baltan
 * @date 2018/7/31 16:24
 */
public class InvertTree {
    public static void main(String[] args) {

    }

    public static TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        if (root.left != null & root.right == null) {
            root.right = root.left;
            invertTree(root.right);
            root.left = null;
        } else if (root.left == null && root.right != null) {
            root.left = root.right;
            invertTree(root.left);
            root.right = null;
        } else if (root.left != null && root.right != null) {
            TreeNode tempNode = root.left;
            root.left = root.right;
            root.right = tempNode;

            invertTree(root.left);
            invertTree(root.right);
        }
        return root;
    }
}
