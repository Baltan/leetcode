package leetcode.algorithms;

import leetcode.entity.TreeNode;

/**
 * Description: Minimum Depth of Binary Tree
 *
 * @author Baltan
 * @date 2018/8/10 15:14
 */
public class MinDepth {
    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(3);
        TreeNode node1 = new TreeNode(9);
        TreeNode node2 = new TreeNode(20);
        TreeNode node3 = new TreeNode(15);
        TreeNode node4 = new TreeNode(7);
        root1.left = node1;
        root1.right = node2;
        node2.left = node3;
        node2.right = node4;
        System.out.println(minDepth(root1));

        TreeNode root2 = new TreeNode(1);
        TreeNode node5 = new TreeNode(2);
        TreeNode node6 = new TreeNode(2);
        TreeNode node7 = new TreeNode(3);
        TreeNode node8 = new TreeNode(3);
        TreeNode node9 = new TreeNode(4);
        TreeNode node10 = new TreeNode(4);
        root2.left = node5;
        root2.right = node6;
        node5.left = node7;
        node6.right = node8;
        node7.left = node9;
        node8.right = node10;
        System.out.println(minDepth(root2));
    }

    public static int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        } else if (root.left == null) {
            return 1 + minDepth(root.right);
        } else if (root.right == null) {
            return 1 + minDepth(root.left);
        } else {
            return 1 + Math.min(minDepth(root.left), minDepth(root.right));
        }
    }
}
