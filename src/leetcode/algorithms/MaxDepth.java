package leetcode.algorithms;

import leetcode.entity.TreeNode;

/**
 * Description: 104. Maximum Depth of Binary Tree
 *
 * @author Baltan
 * @date 2018/7/27 23:49
 */
public class MaxDepth {
    public static void main(String[] args) {
        TreeNode node11 = new TreeNode(3);
        TreeNode node21 = new TreeNode(9);
        TreeNode node22 = new TreeNode(20);
        TreeNode node33 = new TreeNode(15);
        TreeNode node34 = new TreeNode(7);
        node11.left = node21;
        node11.right = node22;
        node22.left = node33;
        node22.right = node34;
        System.out.println(maxDepth(node11));
    }

    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            if (root.left == null && root.right == null) {
                return 1;
            } else if (root.left == null && root.right != null) {
                return 1 + maxDepth(root.right);
            } else if (root.left != null && root.right == null) {
                return 1 + maxDepth(root.left);
            } else {
                return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
            }
        }
    }
}
