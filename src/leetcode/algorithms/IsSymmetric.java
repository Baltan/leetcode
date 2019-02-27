package leetcode.algorithms;

import leetcode.entity.TreeNode;

/**
 * Description: Symmetric Tree
 *
 * @author Baltan
 * @date 2018/7/27 15:01
 */
public class IsSymmetric {
    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        TreeNode node11 = new TreeNode(2);
        TreeNode node12 = new TreeNode(2);
        TreeNode node21 = new TreeNode(3);
        TreeNode node22 = new TreeNode(4);
        TreeNode node23 = new TreeNode(4);
        TreeNode node24 = new TreeNode(3);
        root1.left = node11;
        root1.right = node12;
        node11.left = node21;
        node11.right = node22;
        node12.left = node23;
        node12.right = node24;
        System.out.println(isSymmetric(root1));

        TreeNode root2 = new TreeNode(1);
        TreeNode node31 = new TreeNode(2);
        TreeNode node32 = new TreeNode(2);
        TreeNode node42 = new TreeNode(3);
        TreeNode node44 = new TreeNode(3);
        root2.left = node31;
        root2.right = node32;
        node31.right = node42;
        node32.right = node44;
        System.out.println(isSymmetric(root2));
    }

    public static boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left == null && root.right == null) {
            return true;
        } else if (root.left == null && root.right != null) {
            return false;
        } else if (root.left != null & root.right == null) {
            return false;
        } else {
            return isSymmetricTree(root.left, root.right);
        }
    }

    public static boolean isSymmetricTree(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        } else if (left == null && right != null) {
            return false;
        } else if (left != null && right == null) {
            return false;
        } else {
            if (left.val != right.val) {
                return false;
            } else {
                return isSymmetricTree(left.left, right.right) && isSymmetricTree(left.right, right.left);
            }
        }
    }
}
