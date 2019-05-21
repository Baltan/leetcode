package leetcode.algorithms;

import leetcode.entity.TreeNode;

/**
 * Description: 617. Merge Two Binary Trees
 *
 * @author Baltan
 * @date 2018/7/30 14:32
 */
public class MergeTrees {
    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        TreeNode node11 = new TreeNode(3);
        TreeNode node12 = new TreeNode(2);
        TreeNode node21 = new TreeNode(5);
        root1.left = node11;
        root1.right = node12;
        node11.left = node21;

        TreeNode root2 = new TreeNode(2);
        TreeNode node31 = new TreeNode(1);
        TreeNode node32 = new TreeNode(3);
        TreeNode node42 = new TreeNode(4);
        TreeNode node44 = new TreeNode(7);
        root2.left = node31;
        root2.right = node32;
        node31.right = node42;
        node32.right = node44;

        mergeTrees(root1, root2);
    }

    public static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return null;
        } else if (t1 == null && t2 != null) {
            return t2;
        } else if (t1 != null && t2 == null) {
            return t1;
        } else {
            TreeNode root = new TreeNode(t1.val + t2.val);
            if (t1.left != null || t2.left != null) {
                TreeNode left = mergeTrees(t1.left, t2.left);
                root.left = left;
            }
            if (t1.right != null || t2.right != null) {
                TreeNode right = mergeTrees(t1.right, t2.right);
                root.right = right;
            }
            return root;
        }
    }
}
