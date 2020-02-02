package leetcode.algorithms;

import leetcode.entity.TreeNode;
import leetcode.util.BinaryTreeUtils;

/**
 * Description: 1325. Delete Leaves With a Given Value
 *
 * @author Baltan
 * @date 2020-02-02 14:38
 */
public class RemoveLeafNodes {
    public static void main(String[] args) {
        TreeNode root1 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{1, 2, 3, 2, null, 2, 4}, 0);
        System.out.println(removeLeafNodes(root1, 2));

        TreeNode root2 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{1, 3, 3, 3, 2}, 0);
        System.out.println(removeLeafNodes(root2, 3));

        TreeNode root3 =
                BinaryTreeUtils.arrayToBinaryTree(new Integer[]{1, 2, null, 2, null, null, null, 2}, 0);
        System.out.println(removeLeafNodes(root3, 2));

        TreeNode root4 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{1, 1, 1}, 0);
        System.out.println(removeLeafNodes(root4, 1));

        TreeNode root5 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{1, 2, 3}, 0);
        System.out.println(removeLeafNodes(root5, 1));
    }

    public static TreeNode removeLeafNodes(TreeNode root, int target) {
        if (root == null) {
            return null;
        }
        /**
         * 如果根节点没有左右子树，那么根节点也就是叶节点，如果根节点的值为target，根节点被删除
         */
        if (root.left == null && root.right == null) {
            return root.val == target ? null : root;
        }
        /**
         * 递归处理根节点的左子树
         */
        TreeNode leftNode = removeLeafNodes(root.left, target);
        /**
         * 递归处理根节点的右子树
         */
        TreeNode rightNode = removeLeafNodes(root.right, target);
        root.left = leftNode;
        root.right = rightNode;
        /**
         * 如果处理完成后的左右子树都为null，此时原来的非叶节点变成了叶节点，需要对这个新的叶节点继续
         * 递归处理
         */
        if (leftNode == null && rightNode == null) {
            root = removeLeafNodes(root, target);
        }
        return root;
    }
}
