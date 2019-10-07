package leetcode.algorithms;

import leetcode.entity.TreeNode;
import leetcode.util.BinaryTreeUtils;

import java.util.HashSet;
import java.util.Set;

/**
 * Description: 1214. Two Sum BSTs（5080. 查找两棵二叉搜索树之和）
 *
 * @author Baltan
 * @date 2019-10-07 09:04
 */
public class TwoSumBSTs1 {
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

        Set<Integer> set = new HashSet<>();
        help(root2, set);
        return find(root1, set, target);
    }

    /**
     * 将一棵二叉树的所有节点的值保存在一个Set中
     *
     * @param root
     * @param set
     */
    public static void help(TreeNode root, Set<Integer> set) {
        if (root != null) {
            set.add(root.val);
            help(root.left, set);
            help(root.right, set);
        }
    }

    /**
     * 判断在一棵二叉树中取一个节点值，在一个Set中取一个值，能否使两数之和等于目标值target
     *
     * @param root
     * @param target
     * @return
     */
    public static boolean find(TreeNode root, Set<Integer> set, int target) {
        if (root == null) {
            return false;
        }
        /**
         * 有三种情况符合要求：
         * 1、节点值为root的根节点值x，Set中包含target-x；
         * 2、节点值为root的左子树的某个节点值x，Set中包含target-x；
         * 3、节点值为root的右子树的某个节点值x，Set中包含target-x。
         */
        return set.contains(target - root.val) || find(root.left, set, target) ||
                find(root.right, set, target);
    }
}
