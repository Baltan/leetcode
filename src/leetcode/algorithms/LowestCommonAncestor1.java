package leetcode.algorithms;

import leetcode.entity.TreeNode;

/**
 * Description: 236. Lowest Common Ancestor of a Binary Tree
 *
 * @author Baltan
 * @date 2019-06-12 16:44
 */
public class LowestCommonAncestor1 {
    public static void main(String[] args) {
        TreeNode treeNode10 = new TreeNode(0);
        TreeNode treeNode11 = new TreeNode(1);
        TreeNode treeNode12 = new TreeNode(2);
        TreeNode treeNode13 = new TreeNode(3);
        TreeNode treeNode14 = new TreeNode(4);
        TreeNode treeNode15 = new TreeNode(5);
        TreeNode treeNode16 = new TreeNode(6);
        TreeNode treeNode17 = new TreeNode(7);
        TreeNode treeNode18 = new TreeNode(8);
        treeNode13.left = treeNode15;
        treeNode13.right = treeNode11;
        treeNode15.left = treeNode16;
        treeNode15.right = treeNode12;
        treeNode11.left = treeNode10;
        treeNode11.right = treeNode18;
        treeNode12.left = treeNode17;
        treeNode12.right = treeNode14;
        System.out.println(lowestCommonAncestor(treeNode13, treeNode15, treeNode11).val);
        System.out.println(lowestCommonAncestor(treeNode13, treeNode15, treeNode14).val);
        System.out.println(lowestCommonAncestor(treeNode13, treeNode15, null).val);
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }

        TreeNode leftAncestor = lowestCommonAncestor(root.left, p, q);
        TreeNode rightAncestor = lowestCommonAncestor(root.right, p, q);

        if (leftAncestor != null && rightAncestor != null) {
            return root;
        } else if (leftAncestor != null) {
            return leftAncestor;
        } else if (rightAncestor != null) {
            return rightAncestor;
        } else {
            return null;
        }
    }
}
