package leetcode.algorithms;

import leetcode.entity.TreeNode;

/**
 * Description: Binary Tree Pruning
 *
 * @author Baltan
 * @date 2018/8/11 14:26
 */
public class PruneTree {
    public static void main(String[] args) {

    }

    public static TreeNode pruneTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        if (root.left == null && root.right == null) {
            if (root.val == 1) {
                return root;
            } else {
                return null;
            }
        }

        if (isTreeContainsOne(root.left)) {
            root.left = pruneTree(root.left);
        } else {
            root.left = null;
        }

        if (isTreeContainsOne(root.right)) {
            root.right = pruneTree(root.right);
        } else {
            root.right = null;
        }
        return root;
    }

    public static boolean isTreeContainsOne(TreeNode root) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return root.val == 1;
        }
        return root.val == 1 || isTreeContainsOne(root.left) || isTreeContainsOne(root.right);
    }
}
