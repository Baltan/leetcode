package leetcode.algorithms;

import leetcode.entity.TreeNode;

/**
 * Description: 222. Count Complete Tree Nodes
 *
 * @author Baltan
 * @date 2019-06-11 17:04
 */
public class CountNodes {
    public static void main(String[] args) {
        TreeNode treeNode11 = new TreeNode(1);
        TreeNode treeNode12 = new TreeNode(2);
        TreeNode treeNode13 = new TreeNode(3);
        TreeNode treeNode14 = new TreeNode(4);
        TreeNode treeNode15 = new TreeNode(5);
        TreeNode treeNode16 = new TreeNode(6);
        treeNode11.left = treeNode12;
        treeNode11.right = treeNode13;
        treeNode12.left = treeNode14;
        treeNode12.right = treeNode15;
        treeNode13.left = treeNode16;
        System.out.println(countNodes(treeNode11));
    }

    public static int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        } else if (root.left == null && root.right == null) {
            return 1;
        } else {
            return countNodes(root.left) + countNodes(root.right) + 1;
        }
    }
}
