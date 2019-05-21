package leetcode.algorithms;

import leetcode.entity.TreeNode;

/**
 * Description: 701. Insert into a Binary Search Tree
 *
 * @author Baltan
 * @date 2019-03-18 14:20
 */
public class InsertIntoBST {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(7);
        TreeNode node4 = new TreeNode(1);
        TreeNode node5 = new TreeNode(3);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;

        TreeNode root1 = insertIntoBST(node1, 5);
        System.out.println(root1.right.left.val);
    }

    public static TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (root.left == null && root.right == null) {
            if (val < root.val) {
                root.left = new TreeNode(val);
            } else if (val > root.val) {
                root.right = new TreeNode(val);
            }
        }
        if (val < root.val) {
            root.left = insertIntoBST(root.left, val);
        } else if (val > root.val) {
            root.right = insertIntoBST(root.right, val);
        }
        return root;
    }
}
