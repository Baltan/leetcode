package leetcode.algorithms;

import leetcode.entity.TreeNode;
import leetcode.util.BinaryTreeUtils;

/**
 * Description: 110. Balanced Binary Tree
 *
 * @author Baltan
 * @date 2018/8/9 14:21
 * @see leetcode.interview.IsBalanced
 */
public class IsBalanced {
    public static void main(String[] args) {
        TreeNode root1 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{3, 9, 20, null, null, 15, 7}, 0);
        System.out.println(isBalanced(root1));

        TreeNode root2 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{1, 2, 2, 3, 3, null, null, 4, 4}, 0);
        System.out.println(isBalanced(root2));

        TreeNode root3 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{1}, 0);
        System.out.println(isBalanced(root3));

        TreeNode root4 =
                BinaryTreeUtils.arrayToBinaryTree(new Integer[]{1, 2, 2, 3, null, null, 3, 4, null, null,
                        null, null, null, null, 4}, 0);
        System.out.println(isBalanced(root4));
    }

    public static boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        /**
         * 如果root的左子树和右子树也为平衡二叉树，并且左子树和右子树的高度差不大于1，则root为平衡二叉树
         */
        return isBalanced(root.left) && isBalanced(root.right) &&
                Math.abs(getHeight(root.left) - getHeight(root.right)) <= 1;
    }

    /**
     * 计算二叉树的高度
     *
     * @param root
     * @return
     */
    public static int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }
}
