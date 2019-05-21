package leetcode.algorithms;

import leetcode.entity.TreeNode;

/**
 * Description: 513. Find Bottom Left Tree Value
 *
 * @author Baltan
 * @date 2018/8/12 10:51
 */
public class FindBottomLeftValue {
    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(2);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(3);
        root1.left = node1;
        root1.right = node2;
        System.out.println(findBottomLeftValue(root1));

        TreeNode root2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(2);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(5);
        TreeNode node7 = new TreeNode(6);
        TreeNode node8 = new TreeNode(7);
        root2.left = node3;
        root2.right = node4;
        node3.left = node5;
        node4.left = node6;
        node4.right = node7;
        node6.left = node8;
        System.out.println(findBottomLeftValue(root2));
    }

    public static int findBottomLeftValue(TreeNode root) {
        if (root.left == null & root.right == null) {
            return root.val;
        }
        if (getTreeDepth(root.left) >= getTreeDepth(root.right)) {
            return findBottomLeftValue(root.left);
        } else {
            return findBottomLeftValue(root.right);
        }
    }

    public static int getTreeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        } else if (root.left == null) {
            return 1 + getTreeDepth(root.right);
        } else if (root.right == null) {
            return 1 + getTreeDepth(root.left);
        } else {
            return 1 + Math.max(getTreeDepth(root.left), getTreeDepth(root.right));
        }
    }
}
