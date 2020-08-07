package leetcode.algorithms;


import leetcode.entity.TreeNode;
import leetcode.util.BinaryTreeUtils;

/**
 * Description: 100. Same Tree
 *
 * @author Baltan
 * @date 2018/7/27 14:30
 */
public class IsSameTree {
    public static void main(String[] args) {
        TreeNode root1 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{1, 2, 3}, 0);
        TreeNode root2 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{1, 2, 3}, 0);
        System.out.println(isSameTree(root1, root2));

        TreeNode root3 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{1, 2}, 0);
        TreeNode root4 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{1, null, 2}, 0);
        System.out.println(isSameTree(root3, root4));
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        } else {
            /**
             * p和q的根节点值相等，并且p的左子树和q的左子树相同，p的右子树和q的右子树相同，p才和q相同
             */
            return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
    }
}