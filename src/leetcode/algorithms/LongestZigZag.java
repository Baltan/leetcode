package leetcode.algorithms;

import leetcode.entity.TreeNode;
import leetcode.util.BinaryTreeUtils;

/**
 * Description: 1372. Longest ZigZag Path in a Binary Tree
 *
 * @author Baltan
 * @date 2020-03-19 10:50
 */
public class LongestZigZag {
    public static void main(String[] args) {
        TreeNode root1 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{1, null, 1, null, null, 1, 1, null,
                null, null, null, null, null, 1, 1, null, null, null, null, null, null, null, null, null,
                null, null, null, null, 1, null, null, null, null, null, null, null, null, null, null, null,
                null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
                null, null, null, 1, null, null, null, null}, 0);
        System.out.println(longestZigZag(root1));

        TreeNode root2 =
                BinaryTreeUtils.arrayToBinaryTree(new Integer[]{1, 1, 1, null, 1, null, null, null, null, 1
                        , 1, null, null, null, null, null, null, null, null, null, 1, null, null, null,
                        null,
                        null, null, null, null, null, null}, 0);
        System.out.println(longestZigZag(root2));

        TreeNode root3 =
                BinaryTreeUtils.arrayToBinaryTree(new Integer[]{1}, 0);
        System.out.println(longestZigZag(root3));
    }

    public static int longestZigZag(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int result = 0;

        if (root.left != null) {
            result = Math.max(result, 1 + longestZigZagFromRoot(root.left, true));
        }

        if (root.right != null) {
            result = Math.max(result, 1 + longestZigZagFromRoot(root.right, false));
        }

        result = Math.max(result, longestZigZag(root.left));
        result = Math.max(result, longestZigZag(root.right));
        return result;
    }

    public static int longestZigZagFromRoot(TreeNode root, boolean direction) {
        if (root == null || (root.left == null && root.right == null)) {
            return 0;
        }

        int result = 0;

        if (!direction && root.left != null) {
            result = Math.max(result, 1 + longestZigZagFromRoot(root.left, true));
        }

        if (direction && root.right != null) {
            result = Math.max(result, 1 + longestZigZagFromRoot(root.right, false));
        }
        return result;
    }
}
