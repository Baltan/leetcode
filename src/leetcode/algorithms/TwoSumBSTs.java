package leetcode.algorithms;

import leetcode.entity.TreeNode;
import leetcode.util.BinaryTreeUtils;

/**
 * Description: 1214. Two Sum BSTs
 *
 * @author Baltan
 * @date 2019-10-07 09:04
 */
public class TwoSumBSTs {
    public static void main(String[] args) {
        TreeNode treeNode11 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{2, 1, 4}, 0);
        TreeNode treeNode12 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{1, 0, 3}, 0);
        System.out.println(twoSumBSTs(treeNode11, treeNode12, 5));

        TreeNode treeNode21 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{0, -10, 10}, 0);
        TreeNode treeNode22 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{5, 1, 7, 0, 2}, 0);
        System.out.println(twoSumBSTs(treeNode21, treeNode22, 18));
    }

    public static boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
        if (root1 == null || root2 == null) {
            return false;
        }
        /**
         * 有三种情况符合题意：
         * 1、一个节点为root1的根节点，另一个节点为root2的某个节点，两个节点和为target；
         * 2、一个节点为root1的左子树的某个节点，另一个节点为root2的某个节点，两个节点和为target；
         * 3、一个节点为root1的右子树的某个节点，另一个节点为root2的某个节点，两个节点和为target。
         */
        return help(root2, target - root1.val) || twoSumBSTs(root1.left, root2, target) ||
                twoSumBSTs(root1.right, root2, target);
    }

    /**
     * 判断在一棵二叉树中能否找到目标值target
     *
     * @param root
     * @param target
     * @return
     */
    public static boolean help(TreeNode root, int target) {
        if (root == null) {
            return false;
        } else if (root.val == target) {
            return true;
        } else if (root.val < target) {
            return help(root.right, target);
        } else {
            return help(root.left, target);
        }
    }
}
