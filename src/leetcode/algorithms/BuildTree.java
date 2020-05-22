package leetcode.algorithms;

import leetcode.entity.TreeNode;
import leetcode.util.BinaryTreeUtils;

/**
 * Description: 105. Construct Binary Tree from Preorder and Inorder Traversal
 *
 * @author Baltan
 * @date 2020-01-31 11:07
 * @see BuildTree1
 * @see BuildTree2
 * @see ConstructFromPrePost
 */
public class BuildTree {
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
        return buildTree(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder, int preorderStart, int preorderEnd,
                                     int inorderStart, int inorderEnd) {
        if (preorder.length == 0 || preorderStart > preorderEnd) {
            return null;
        }
        /**
         * 如果二叉树的前序遍历数组不为空，那么第一个元素就是二叉树的根节点
         */
        int rootValue = preorder[preorderStart];
        TreeNode root = new TreeNode(rootValue);
        /**
         * 二叉树的中序遍历数组中根节点值的位置
         */
        int rootValueInInorder = -1;
        /**
         * 在二叉树的中序遍历数组中找到根节点值的位置，则该值左边的所有值就是左子树的中序遍历数组，
         * 该值右边的所有值就是右子树的中序遍历数组
         */
        for (int i = inorderStart; i <= inorderEnd; i++) {
            if (inorder[i] == rootValue) {
                rootValueInInorder = i;
                break;
            }
        }
        /**
         * 二叉树左子树的节点数量
         */
        int leftNodeCount = rootValueInInorder - inorderStart;
        /**
         * 二叉树右子树的节点数量
         */
        int rightNodeCount = inorderEnd - rootValueInInorder;
        /**
         * 递归构造左子树和右子树
         */
        root.left = buildTree(preorder, inorder, preorderStart + 1, preorderStart + leftNodeCount,
                inorderStart, rootValueInInorder - 1);
        root.right = buildTree(preorder, inorder, preorderEnd - rightNodeCount + 1, preorderEnd,
                rootValueInInorder + 1, inorderEnd);
        return root;
    }
}
