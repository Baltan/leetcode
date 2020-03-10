package leetcode.algorithms;

import leetcode.entity.TreeNode;

/**
 * Description: 543. Diameter of Binary Tree
 *
 * @author Baltan
 * @date 2019-03-16 12:16
 */
public class DiameterOfBinaryTree {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;

        System.out.println(diameterOfBinaryTree(node1));
    }

    public static int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        /**
         * 左子树的直径，即穿过根节点的左节点的最长路径的长度
         */
        int diameterOfLeftTree = diameterOfBinaryTree(root.left);
        /**
         * 右子树的直径，即穿过根节点的右节点的最长路径的长度
         */
        int diameterOfRigthTree = diameterOfBinaryTree(root.right);
        /**
         * 穿过根节点的最长路径的长度
         */
        int depthOfLeftAndRight = binaryTreeDepth(root.left) + binaryTreeDepth(root.right);
        /**
         * 以上三种情况取最大值
         */
        return Math.max(depthOfLeftAndRight, Math.max(diameterOfLeftTree, diameterOfRigthTree));
    }

    /**
     * 二叉树的最大深度
     *
     * @param root
     * @return
     */
    public static int binaryTreeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(binaryTreeDepth(root.left), binaryTreeDepth(root.right));
    }
}
