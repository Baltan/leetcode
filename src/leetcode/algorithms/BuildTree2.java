package leetcode.algorithms;

import leetcode.entity.TreeNode;
import leetcode.util.BinaryTreeUtils;

import java.util.Arrays;

/**
 * Description: 105. Construct Binary Tree from Preorder and Inorder Traversal
 *
 * @author Baltan
 * @date 2020-05-22 09:18
 * @see BuildTree
 * @see BuildTree1
 * @see ConstructFromPrePost
 */
public class BuildTree2 {
    public static void main(String[] args) {
        int[] preorder1 = {3, 9, 20, 15, 7};
        int[] inorder1 = {9, 3, 15, 20, 7};
        TreeNode root1 = buildTree(preorder1, inorder1);
        System.out.println(BinaryTreeUtils.recursivelyPreOrder(root1));
        System.out.println(BinaryTreeUtils.recursivelyInOrder(root1));

        int[] preorder2 = {1, 2};
        int[] inorder2 = {2, 1};
        TreeNode root2 = buildTree(preorder2, inorder2);
        System.out.println(BinaryTreeUtils.recursivelyPreOrder(root2));
        System.out.println(BinaryTreeUtils.recursivelyInOrder(root2));

        int[] preorder3 = {1, 3};
        int[] inorder3 = {1, 3};
        TreeNode root3 = buildTree(preorder3, inorder3);
        System.out.println(BinaryTreeUtils.recursivelyPreOrder(root3));
        System.out.println(BinaryTreeUtils.recursivelyInOrder(root3));

        int[] preorder4 = {100};
        int[] inorder4 = {100};
        TreeNode root4 = buildTree(preorder4, inorder4);
        System.out.println(BinaryTreeUtils.recursivelyPreOrder(root4));
        System.out.println(BinaryTreeUtils.recursivelyInOrder(root4));
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        /**
         * 如果前序遍历数组为空，则没有节点，即二叉树为null
         */
        if (preorder.length == 0) {
            return null;
        } else {
            /**
             * 如果二叉树的前序遍历数组不为空，那么第一个元素就是二叉树的根节点
             */
            int rootValue = preorder[0];
            TreeNode root = new TreeNode(rootValue);
            /**
             * 二叉树左子树的节点数量
             */
            int leftSubtreeNodeCount = 0;
            /**
             * 在二叉树的中序遍历数组中找到根节点值的位置，则该值左边的所有值就是左子树的中序遍历数组，
             * 该值右边的所有值就是右子树的中序遍历数组
             */
            for (int value : inorder) {
                if (value == rootValue) {
                    break;
                } else {
                    leftSubtreeNodeCount++;
                }
            }
            /**
             * 二叉树的前序遍历数组从第1（0-based）个元素开始的leftSubtreeNodeCount个数就是左子树
             * 的前序遍历数组，最后那部分子数组就是右子树的前序遍历数组
             */
            int[] leftSubtreePreorder = Arrays.copyOfRange(preorder, 1, 1 + leftSubtreeNodeCount);
            int[] rightSubtreePreorder =
                    Arrays.copyOfRange(preorder, 1 + leftSubtreeNodeCount, preorder.length);
            int[] leftSubtreeInorder = Arrays.copyOfRange(inorder, 0, leftSubtreeNodeCount);
            int[] rightSubtreeInorder = Arrays.copyOfRange(inorder, leftSubtreeNodeCount + 1, inorder.length);
            /**
             * 递归构造左子树和右子树
             */
            root.left = buildTree(leftSubtreePreorder, leftSubtreeInorder);
            root.right = buildTree(rightSubtreePreorder, rightSubtreeInorder);
            return root;
        }
    }
}
