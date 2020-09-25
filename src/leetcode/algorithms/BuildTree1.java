package leetcode.algorithms;

import leetcode.entity.TreeNode;
import leetcode.util.BinaryTreeUtils;

/**
 * Description: 106. Construct Binary Tree from Inorder and Postorder Traversal
 *
 * @author Baltan
 * @date 2020-01-31 11:41
 * @see BuildTree
 * @see BuildTree2
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
        return buildTree(inorder, 0, inorder.length, postorder, 0, postorder.length);
    }

    private static TreeNode buildTree(int[] inorder, int inorderStart, int inorderEnd, int[] postorder,
                                      int postorderStart, int postorderEnd) {
        /**
         * 如果后序遍历数组为空，则没有节点，即二叉树为null
         */
        if (postorderStart == postorderEnd) {
            return null;
        } else {
            /**
             * 如果二叉树的后序遍历数组不为空，那么最后一个元素就是二叉树的根节点
             */
            int rootValue = postorder[postorderEnd - 1];
            TreeNode root = new TreeNode(rootValue);
            /**
             * 二叉树根节点在中序遍历数组中的位置
             */
            int rootIndexInInorder = 0;
            /**
             * 在二叉树的中序遍历数组中找到根节点值的位置，则该值左边的所有值就是左子树的中序遍历数组，
             * 该值右边的所有值就是右子树的中序遍历数组
             */
            for (int i = inorderStart; i < inorderEnd; i++) {
                if (inorder[i] == rootValue) {
                    rootIndexInInorder = i;
                    break;
                }
            }
            /**
             * 二叉树的左子树中节点的数量
             */
            int leftTreeNodeCount = rootIndexInInorder - inorderStart;
            /**
             * 递归构造左子树和右子树
             */
            root.left = buildTree(inorder, inorderStart, inorderStart + leftTreeNodeCount, postorder,
                    postorderStart, postorderStart + leftTreeNodeCount);
            root.right = buildTree(inorder, inorderStart + leftTreeNodeCount + 1, inorderEnd, postorder,
                    postorderStart + leftTreeNodeCount, postorderEnd - 1);
            return root;
        }
    }
}
