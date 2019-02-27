package leetcode.algorithms;

import leetcode.entity.TreeNode;

/**
 * Description: Balanced Binary Tree
 *
 * @author Baltan
 * @date 2018/8/9 14:21
 */
public class IsBalanced {
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
        System.out.println(isBalanced(root1));

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
        node5.right = node8;
        node7.left = node9;
        node7.right = node10;
        System.out.println(isBalanced(root2));

        TreeNode root3 = new TreeNode(1);
        System.out.println(isBalanced(root3));

        TreeNode root4 = new TreeNode(1);
        TreeNode node11 = new TreeNode(2);
        TreeNode node12 = new TreeNode(2);
        TreeNode node13 = new TreeNode(3);
        TreeNode node14 = new TreeNode(3);
        TreeNode node15 = new TreeNode(4);
        TreeNode node16 = new TreeNode(4);
        root4.left = node11;
        root4.right = node12;
        node11.left = node13;
        node12.right = node14;
        node13.left = node15;
        node14.right = node16;
        System.out.println(isBalanced(root4));
    }

    public static boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left == null && root.right == null) {
            return true;
        }
        boolean flag = Math.abs(treeHeight(root.left) - treeHeight(root.right)) <= 1;
        if (!flag) {
            return flag;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }

    public static int treeHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int height = 1;
        if (root.left == null && root.right == null) {
            return height;
        }
        height = 1 + Math.max(treeHeight(root.left), treeHeight(root.right));
        return height;
    }
}
