package leetcode.algorithms;

import leetcode.entity.TreeNode;

/**
 * Description: Convert BST to Greater Tree
 *
 * @author Baltan
 * @date 2019-02-25 10:02
 */
public class ConvertBST {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(13);

        node1.left = node2;
        node1.right = node3;

        TreeNode node = convertBST(node1);
        System.out.println(node.val);
        System.out.println(node.left.val);
        System.out.println(node.right.val);
    }

    private static int sum = 0;

    public static TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return null;
        }

        convertBST(root.right);
        sum += root.val;
        root.val = sum;
        convertBST(root.left);
        return root;
    }
}
