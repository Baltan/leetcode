package leetcode.algorithms;

import leetcode.entity.TreeNode;
import leetcode.util.BinaryTreeUtils;

/**
 * Description: 114. Flatten Binary Tree to Linked List
 *
 * @author Baltan
 * @date 2019-05-24 14:42
 */
public class Flatten {
    public static void main(String[] args) {
        /**
         * <pre>
         *     1
         *    / \
         *   2   5
         *  / \   \
         * 3   4   6
         * </pre>
         */
        TreeNode root1 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{1, 2, 5, 3, 4, null, 6}, 0);
        flatten(root1);
        System.out.println(root1);

        TreeNode root2 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{1, 2}, 0);
        flatten(root2);
        System.out.println(root2);


        TreeNode root3 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{1}, 0);
        flatten(root3);
        System.out.println(root3);


        TreeNode root4 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{}, 0);
        flatten(root4);
        System.out.println(root4);

    }

    public static void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        TreeNode right = root.right;
        TreeNode left = root.left;
        /**
         * 左子树展平得到的单链表
         */
        TreeNode flattenLeft = help(left);
        TreeNode flattenRight = help(right);
        /**
         * 先将根节点的左右子树设为null，此时所求单链表只有一个头节点（即根节点）
         */
        root.left = null;
        /**
         * 右子树展平得到的单链表
         */
        root.right = null;
        /**
         * 将左子树展平得到的单链表追加到根节点右子树的位置
         */
        if (flattenLeft != null) {
            root.right = flattenLeft;
        }
        /**
         * 当前单链表最右边的节点
         */
        TreeNode rightmostNode = root;

        while (rightmostNode.right != null) {
            rightmostNode = rightmostNode.right;
        }
        /**
         * 将右子树展平得到的单链表追加到最右边的节点的右子树位置
         */
        rightmostNode.right = flattenRight;
    }

    /**
     * 将二叉树展平成单链表
     *
     * @param root
     * @return
     */
    public static TreeNode help(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode right = root.right;
        TreeNode left = root.left;
        /**
         * 左子树展平得到的单链表
         */
        TreeNode flattenLeft = help(left);
        /**
         * 右子树展平得到的单链表
         */
        TreeNode flattenRight = help(right);
        /**
         * 先将根节点的左右子树设为null，此时所求单链表只有一个头节点（即根节点）
         */
        root.left = null;
        root.right = null;
        /**
         * 将左子树展平得到的单链表追加到根节点右子树的位置
         */
        if (flattenLeft != null) {
            root.right = flattenLeft;
        }
        /**
         * 当前单链表最右边的节点
         */
        TreeNode rightmostNode = root;

        while (rightmostNode.right != null) {
            rightmostNode = rightmostNode.right;
        }
        /**
         * 将右子树展平得到的单链表追加到最右边的节点的右子树位置
         */
        rightmostNode.right = flattenRight;
        return root;
    }
}
