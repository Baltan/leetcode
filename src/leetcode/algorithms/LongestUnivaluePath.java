package leetcode.algorithms;

import leetcode.entity.TreeNode;
import leetcode.util.BinaryTreeUtils;

/**
 * Description: 687. Longest Univalue Path
 *
 * @author Baltan
 * @date 2020-02-17 14:16
 */
public class LongestUnivaluePath {
    public static void main(String[] args) {
        TreeNode root1 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{5, 4, 5, 1, 1, null, 5}, 0);
        System.out.println(longestUnivaluePath(root1));

        TreeNode root2 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{1, 4, 5, 4, 4, null, 5}, 0);
        System.out.println(longestUnivaluePath(root2));

        TreeNode root3 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{1}, 0);
        System.out.println(longestUnivaluePath(root3));

        TreeNode root4 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{1, 2, 3, 4, 2}, 0);
        System.out.println(longestUnivaluePath(root4));
    }

    public static int longestUnivaluePath(TreeNode root) {
        int[] result = help(root);
        /**
         * 以根节点作为路径端点的最长路径的长度、不以根节点作为路径端点的最长路径的长度，两者取
         * 较大值
         */
        return Math.max(result[0], result[1]);
    }

    public static int[] help(TreeNode root) {
        /**
         * result[0]为以根节点作为路径端点的最长路径的长度，result[1]为不以根节点作为路径端点
         * 的最长路径的长度
         */
        int[] result = {0, 0};

        if (root == null || (root.left == null && root.right == null)) {
            return result;
        }

        int[] leftTreeLUPs = help(root.left);
        int[] rightTreeLUPs = help(root.right);
        /**
         * 左子树中以根节点作为路径端点的最长路径的长度
         */
        int leftTreeLUPFromRoot = leftTreeLUPs[0];
        /**
         * 左子树中不以根节点作为路径端点的最长路径的长度
         */
        int leftTreeLUPNotFromRoot = leftTreeLUPs[1];
        /**
         * 右子树中以根节点作为路径端点的最长路径的长度
         */
        int rightTreeLUPFromRoot = rightTreeLUPs[0];
        /**
         * 右子树中不以根节点作为路径端点的最长路径的长度
         */
        int rightTreeLUPNotFromRoot = rightTreeLUPs[1];
        /**
         * 如果根节点值和左节点值一样，则可以得到一条以根节点作为路径端点的路径，长度为
         * 1+leftTreeLUPFromRoot，更新result[0]
         */
        if (root.left != null && root.val == root.left.val) {
            result[0] = Math.max(result[0], 1 + leftTreeLUPFromRoot);
        }
        /**
         * 如果根节点值和右节点值一样，则可以得到一条以根节点作为路径端点的路径，长度为
         * 1+rightTreeLUPFromRoot，更新result[0]
         */
        if (root.right != null && root.val == root.right.val) {
            result[0] = Math.max(result[0], 1 + rightTreeLUPFromRoot);
        }
        /**
         * 左子树中不以根节点作为路径端点的最长路径和右子树中不以根节点作为路径端点的最长路径也
         * 是root中不以根节点作为路径端点的路径，更新result[1]
         */
        result[1] = Math.max(leftTreeLUPNotFromRoot, rightTreeLUPNotFromRoot);
        /**
         * 如果根节点值和左节点值。右节点值都一样，则可以得到一条root中不以根节点作为路径端点的
         * 路径，长度为2+leftTreeLUPFromRoot+rightTreeLUPFromRoot，更新result[1]
         */
        if (root.left != null && root.val == root.left.val && root.right != null &&
                root.val == root.right.val) {
            result[1] = Math.max(result[1], 2 + leftTreeLUPFromRoot + rightTreeLUPFromRoot);
        }
        /**
         * 如果根节点值和左节点值不一样，则左子树中以根节点作为路径端点的最长路径也是root中一条
         * 不以根节点作为路径端点的路径，长度为leftTreeLUPFromRoot，更新result[1]
         */
        if (root.left != null && root.val != root.left.val) {
            result[1] = Math.max(result[1], leftTreeLUPFromRoot);
        }
        /**
         * 如果根节点值和右节点值不一样，则右子树中以根节点作为路径端点的最长路径也是root中一条
         * 不以根节点作为路径端点的路径，长度为rightTreeLUPFromRoot，更新result[1]
         */
        if (root.right != null && root.val != root.right.val) {
            result[1] = Math.max(result[1], rightTreeLUPFromRoot);
        }
        return result;
    }
}
