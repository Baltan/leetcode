package leetcode.algorithms;

import leetcode.entity.TreeNode;
import leetcode.util.BinaryTreeUtils;

/**
 * Description: 101. Symmetric Tree
 *
 * @author Baltan
 * @date 2018/7/27 15:01
 */
public class IsSymmetric {
    public static void main(String[] args) {
        TreeNode root1 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{1, 2, 2, 3, 4, 4, 3}, 0);
        System.out.println(isSymmetric(root1));

        TreeNode root2 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{1, 2, 2, null, 3, null, 3}, 0);
        System.out.println(isSymmetric(root2));
    }

    public static boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetricTree(root.left, root.right);
    }

    /**
     * 判断left和right这两棵二叉树是否是镜像对称的
     *
     * @param left
     * @param right
     * @return
     */
    public static boolean isSymmetricTree(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
            /**
             * 如果left和right其中一棵树为null，另一棵树不为null，或者两棵树都不为null但是两棵树的根节点值
             * 不同，则两棵树不是镜像对称的
             */
        } else if (left == null || right == null || left.val != right.val) {
            return false;
        } else {
            return isSymmetricTree(left.left, right.right) && isSymmetricTree(left.right, right.left);
        }
    }
}
