package leetcode.interview;

import leetcode.entity.TreeNode;
import leetcode.util.BinaryTreeUtils;

/**
 * Description: 面试题 04.10. 检查子树
 *
 * @author Baltan
 * @date 2020-03-14 13:19
 */
public class CheckSubTree {
    public static void main(String[] args) {
        TreeNode root11 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{1, 2, 3}, 0);
        TreeNode root12 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{2}, 0);
        System.out.println(checkSubTree(root11, root12));

        TreeNode root21 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{1, null, 2, 4}, 0);
        TreeNode root22 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{3, 2}, 0);
        System.out.println(checkSubTree(root21, root22));

        TreeNode root31 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{}, 0);
        TreeNode root32 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{}, 0);
        System.out.println(checkSubTree(root31, root32));

        TreeNode root41 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{1}, 0);
        TreeNode root42 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{}, 0);
        System.out.println(checkSubTree(root41, root42));
    }

    public static boolean checkSubTree(TreeNode t1, TreeNode t2) {
        /**
         * 如果t2为空树，不论t1是不是空树，t2都是t1的子树
         */
        if (t2 == null) {
            return true;
        }
        /**
         * 如果t2不为空树，t1位空树，t2不是t1的子树
         */
        if (t1 == null) {
            return false;
        }
        /**
         * 如果t1和t2完全一样，t2是t1的子树
         */
        if (isSame(t1, t2)) {
            return true;
        }
        /**
         * 在t1的左子树和右子树中查找是否存在t2子树
         */
        return checkSubTree(t1.left, t2) || checkSubTree(t1.right, t2);
    }

    /**
     * 比较两棵二叉树是否完全一样
     *
     * @param t1
     * @param t2
     * @return
     */
    public static boolean isSame(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        }
        /**
         * 如果t1和t2一棵为空树，另一棵不为空树，则t1和t2不一样
         */
        if (t1 == null || t2 == null) {
            return false;
        }
        /**
         * 两棵二叉树完全一样的条件：
         * 1、两棵二叉树的根节点的值相等
         * 2、两个根节点各自的左子树完全一样
         * 3、两个根节点各自的右子树完全一样
         */
        return t1.val == t2.val && isSame(t1.left, t2.left) && isSame(t1.right, t2.right);
    }
}
