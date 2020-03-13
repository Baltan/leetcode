package leetcode.interview;

import leetcode.entity.TreeNode;
import leetcode.util.BinaryTreeUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: 面试题 04.05. 合法二叉搜索树
 *
 * @author Baltan
 * @date 2019-05-23 09:40
 * @see leetcode.algorithms.IsValidBST
 */
public class IsValidBST {
    public static void main(String[] args) {
        TreeNode root1 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{2, 1, 3}, 0);
        System.out.println(isValidBST(root1));

        TreeNode root2 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{5, 1, 4, null, null, 3, 6}, 0);
        System.out.println(isValidBST(root2));

        TreeNode root3 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{1}, 0);
        System.out.println(isValidBST(root3));

        TreeNode root4 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{5, 2, 8, 3, null, null, 9}, 0);
        System.out.println(isValidBST(root4));

        TreeNode root5 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{1, null, 1}, 0);
        System.out.println(isValidBST(root5));

        TreeNode root6 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{1, null, 1}, 0);
        System.out.println(isValidBST(root6));
    }

    public static boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        List<Integer> result = inOrder(root);
        int size = result.size();
        /**
         * 二叉搜索树的中序遍历结果是严格递增的
         */
        for (int i = 1; i < size; i++) {
            if (result.get(i) <= result.get(i - 1)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 中序遍历二叉树
     *
     * @param root
     * @return
     */
    public static List<Integer> inOrder(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        result.addAll(inOrder(root.left));
        result.add(root.val);
        result.addAll(inOrder(root.right));
        return result;
    }
}
