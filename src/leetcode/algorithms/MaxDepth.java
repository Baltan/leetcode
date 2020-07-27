package leetcode.algorithms;

import leetcode.entity.TreeNode;
import leetcode.util.BinaryTreeUtils;

/**
 * Description: 104. Maximum Depth of Binary Tree
 *
 * @author Baltan
 * @date 2018/7/27 23:49
 */
public class MaxDepth {
    public static void main(String[] args) {
        TreeNode root1 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{3, 9, 20, null, null, 15, 7}, 0);
        System.out.println(maxDepth(root1));

        TreeNode root2 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{1}, 0);
        System.out.println(maxDepth(root2));

        TreeNode root3 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{1, null, 2}, 0);
        System.out.println(maxDepth(root3));
    }

    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        /**
         * 递归计算左子树和右子树的最大深度，取较大值加上根节点的深度1即可
         */
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
