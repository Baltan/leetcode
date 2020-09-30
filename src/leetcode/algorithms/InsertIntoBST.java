package leetcode.algorithms;

import leetcode.entity.TreeNode;
import leetcode.util.BinaryTreeUtils;

/**
 * Description: 701. Insert into a Binary Search Tree
 *
 * @author Baltan
 * @date 2019-03-18 14:20
 */
public class InsertIntoBST {
    public static void main(String[] args) {
        TreeNode root1 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{4, 2, 7, 1, 3}, 0);
        TreeNode root11 = insertIntoBST(root1, 5);
        System.out.println(root11);
    }

    public static TreeNode insertIntoBST(TreeNode root, int val) {
        /**
         * 如果二叉树不包含节点，则插入val后，包含了一个根节点
         */
        if (root == null) {
            return new TreeNode(val);
        }
        /**
         * 如果val小于二叉树根节点的值，在二叉树左子树中插入节点val；如果val大于二叉树根节点的值，在二叉树右
         * 子树中插入节点val
         */
        if (val < root.val) {
            root.left = insertIntoBST(root.left, val);
        } else if (val > root.val) {
            root.right = insertIntoBST(root.right, val);
        }
        return root;
    }
}
