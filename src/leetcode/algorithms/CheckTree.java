package leetcode.algorithms;

import leetcode.entity.TreeNode;
import leetcode.util.BinaryTreeUtils;

/**
 * Description: 2236. Root Equals Sum of Children
 *
 * @author Baltan
 * @date 2022/4/12 22:35
 */
public class CheckTree {
    public static void main(String[] args) {
        TreeNode root1 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{10, 4, 6}, 0);
        System.out.println(checkTree(root1));

        TreeNode root2 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{5, 3, 1}, 0);
        System.out.println(checkTree(root2));
    }

    public static boolean checkTree(TreeNode root) {
        return root.val == root.left.val + root.right.val;
    }
}
