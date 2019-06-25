package leetcode.algorithms;

import leetcode.entity.TreeNode;

/**
 * Description: 337. House Robber III
 *
 * @author Baltan
 * @date 2019-06-25 09:21
 */
public class Rob2 {
    public static void main(String[] args) {
        TreeNode treeNode11 = new TreeNode(3);
        TreeNode treeNode12 = new TreeNode(2);
        TreeNode treeNode13 = new TreeNode(3);
        TreeNode treeNode14 = new TreeNode(3);
        TreeNode treeNode15 = new TreeNode(1);
        treeNode11.left = treeNode12;
        treeNode11.right = treeNode13;
        treeNode12.right = treeNode14;
        treeNode13.right = treeNode15;
        System.out.println(rob(treeNode11));

        TreeNode treeNode21 = new TreeNode(3);
        TreeNode treeNode22 = new TreeNode(4);
        TreeNode treeNode23 = new TreeNode(5);
        TreeNode treeNode24 = new TreeNode(1);
        TreeNode treeNode25 = new TreeNode(3);
        TreeNode treeNode26 = new TreeNode(1);
        treeNode21.left = treeNode22;
        treeNode21.right = treeNode23;
        treeNode22.left = treeNode24;
        treeNode22.right = treeNode25;
        treeNode23.right = treeNode26;
        System.out.println(rob(treeNode21));

        TreeNode treeNode31 = new TreeNode(2);
        TreeNode treeNode32 = new TreeNode(1);
        TreeNode treeNode33 = new TreeNode(3);
        treeNode31.left = treeNode32;
        treeNode31.right = treeNode33;
        System.out.println(rob(treeNode31));
    }

    public static int rob(TreeNode root) {
        if (root == null) {
            return 0;
        } else if (root.left == null && root.right == null) {
            return root.val;
        } else {
            int chooseRoot = root.val;

            if (root.left != null) {
                chooseRoot = chooseRoot + rob(root.left.left) + rob(root.left.right);
            }

            if (root.right != null) {
                chooseRoot = chooseRoot + rob(root.right.left) + rob(root.right.right);
            }

            int notChooseRoot = rob(root.left) + rob(root.right);
            return Math.max(chooseRoot, notChooseRoot);
        }
    }
}
