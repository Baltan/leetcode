package leetcode.algorithms;

import leetcode.entity.TreeNode;
import leetcode.util.BinaryTreeUtils;

/**
 * Description: 572. Subtree of Another Tree
 *
 * @author Baltan
 * @date 2020-05-07 08:00
 * @see IsSubtree
 */
public class IsSubtree1 {
    public static void main(String[] args) {
        TreeNode s1 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{3, 4, 5, 1, 2}, 0);
        TreeNode t1 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{4, 1, 2}, 0);
        System.out.println(isSubtree(s1, t1));

        TreeNode s2 =
                BinaryTreeUtils.arrayToBinaryTree(new Integer[]{3, 4, 5, 1, 2, null, null, null, null, 0},
                        0);
        TreeNode t2 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{4, 1, 2}, 0);
        System.out.println(isSubtree(s2, t2));

        TreeNode s3 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{1, 2, 3}, 0);
        TreeNode t3 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{1, 2}, 0);
        System.out.println(isSubtree(s3, t3));

        TreeNode s4 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{1}, 0);
        TreeNode t4 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{1}, 0);
        System.out.println(isSubtree(s4, t4));
    }

    public static boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }

        if (s == null || t == null) {
            return false;
        }
        /**
         * 如果s和t的值相等，要么s和t一样（s的左子树和t的左子树一样并且s的右子树和t的右子树一样），要么s的左子树
         * 中包含t，要么s的右子树中包含t
         */
        if (s.val == t.val) {
            return (isSame(s.left, t.left) && isSame(s.right, t.right)) || isSubtree(s.left, t) ||
                    isSubtree(s.right, t);
        } else {
            /**
             * 如果s和t的值不一样，要么s的左子树中包含t，要么s的右子树中包含t
             */
            return isSubtree(s.left, t) || isSubtree(s.right, t);
        }
    }

    /**
     * 判断两棵二叉树s和t是否完全一样
     *
     * @param s
     * @param t
     * @return
     */
    public static boolean isSame(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }

        if (s == null || t == null) {
            return false;
        }

        if (s.val != t.val) {
            return false;
        }
        /**
         * 如果s和t一样，则s和t的值相等并且s的左子树和t的左子树一样并且s的右子树和t的右子树一样
         */
        return isSame(s.left, t.left) && isSame(s.right, t.right);
    }
}
