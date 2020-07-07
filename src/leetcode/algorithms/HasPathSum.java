package leetcode.algorithms;

import leetcode.entity.TreeNode;
import leetcode.util.BinaryTreeUtils;

/**
 * Description: 112. Path Sum
 *
 * @author Baltan
 * @date 2018/8/9 22:56
 */
public class HasPathSum {
    public static void main(String[] args) {
        TreeNode root1 =
                BinaryTreeUtils.arrayToBinaryTree(new Integer[]{5, 4, 8, 11, null, 13, 4, 7, 2, null, null,
                        null, null, null, 1}, 0);
        System.out.println(hasPathSum(root1, 22));
    }

    public static boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }

        if (root.left == null && root.right == null) {
            return root.val == sum;
        }
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
}
