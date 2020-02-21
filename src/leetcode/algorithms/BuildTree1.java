package leetcode.algorithms;

import leetcode.entity.TreeNode;
import leetcode.util.BinaryTreeUtils;

import java.util.Arrays;

/**
 * Description: 106. Construct Binary Tree from Inorder and Postorder Traversal
 *
 * @author Baltan
 * @date 2020-01-31 11:41
 * @see BuildTree
 * @see ConstructFromPrePost
 */
public class BuildTree1 {
    public static void main(String[] args) {
        int[] postorder1 = {9, 15, 7, 20, 3};
        int[] inorder1 = {9, 3, 15, 20, 7};
        TreeNode root1 = buildTree(inorder1, postorder1);
        System.out.println(BinaryTreeUtils.recursivelyPostOrder(root1));
        System.out.println(BinaryTreeUtils.recursivelyInOrder(root1));

        int[] postorder2 = {2, 1};
        int[] inorder2 = {2, 1};
        TreeNode root2 = buildTree(inorder2, postorder2);
        System.out.println(BinaryTreeUtils.recursivelyPostOrder(root2));
        System.out.println(BinaryTreeUtils.recursivelyInOrder(root2));

        int[] postorder3 = {3, 1};
        int[] inorder3 = {1, 3};
        TreeNode root3 = buildTree(inorder3, postorder3);
        System.out.println(BinaryTreeUtils.recursivelyPostOrder(root3));
        System.out.println(BinaryTreeUtils.recursivelyInOrder(root3));

        int[] postorder4 = {100};
        int[] inorder4 = {100};
        TreeNode root4 = buildTree(inorder4, postorder4);
        System.out.println(BinaryTreeUtils.recursivelyPostOrder(root4));
        System.out.println(BinaryTreeUtils.recursivelyInOrder(root4));
    }

    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        /**
         * 如果后序遍历数组为空，则没有节点，即二叉树为null
         */
        if (postorder.length == 0) {
            return null;
        } else {
            /**
             * 如果二叉树的后序遍历数组不为空，那么最后一个元素就是二叉树的根节点
             */
            int rootValue = postorder[postorder.length - 1];
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
             * 二叉树的后序遍历数组的前leftSubtreeNodeCount个数就是左子树的后序遍历数组，接下去到倒
             * 数第二个值为止的子数组就是右子树的后序遍历数组
             */
            int[] leftSubtreePostorder = Arrays.copyOfRange(postorder, 0, leftSubtreeNodeCount);
            int[] rightSubtreePostorder =
                    Arrays.copyOfRange(postorder, leftSubtreeNodeCount, postorder.length - 1);
            int[] leftSubtreeInorder = Arrays.copyOfRange(inorder, 0, leftSubtreeNodeCount);
            int[] rightSubtreeInorder = Arrays.copyOfRange(inorder, leftSubtreeNodeCount + 1, inorder.length);
            /**
             * 递归构造左子树和右子树
             */
            root.left = buildTree(leftSubtreeInorder, leftSubtreePostorder);
            root.right = buildTree(rightSubtreeInorder, rightSubtreePostorder);
            return root;
        }
    }
}
