package leetcode.algorithms;

import leetcode.entity.TreeNode;
import leetcode.util.BinaryTreeUtils;

/**
 * Description: 1080. Insufficient Nodes in Root to Leaf Paths
 *
 * @author Baltan
 * @date 2019-07-31 08:53
 */
public class SufficientSubset {
    public static void main(String[] args) {
        TreeNode root1 =
                BinaryTreeUtils.arrayToBinaryTree(new Integer[]{1, 2, 3, 4, -99, -99, 7, 8, 9, -99, -99, 12,
                        13, -99, 14}, 0);
        System.out.println(sufficientSubset(root1, 1));

        TreeNode root2 =
                BinaryTreeUtils.arrayToBinaryTree(new Integer[]{5, 4, 8, 11, null, 17, 4, 7, 1, null, null,
                        null, null, 5, 3}, 0);
        System.out.println(sufficientSubset(root2, 22));

        TreeNode root3 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{5, -6, -6}, 0);
        System.out.println(sufficientSubset(root3, 0));

        TreeNode root4 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{1, 2, -3, -5, null, 4, null}, 0);
        System.out.println(sufficientSubset(root4, -1));
    }

    public static TreeNode sufficientSubset(TreeNode root, int limit) {
        if (root == null) {
            return null;
        }

        if (root.left == null && root.right == null) {
            return root.val < limit ? null : root;
        }
        /**
         * 递归计算根节点左子树和右子树的情况
         */
        TreeNode left = sufficientSubset(root.left, limit - root.val);
        TreeNode right = sufficientSubset(root.right, limit - root.val);
        /**
         * 如果一个节点原来存在左子树和右子树，但是左子树和右子树的节点都是不足节点，那么该节点也是不足节点；
         * 如果一个节点原来只有左子树，但是左子树的节点都是不足节点，那么该节点也是不足节点；
         * 如果一个节点原来只有右子树，但是右子树的节点都是不足节点，那么该节点也是不足节点。
         */
        if (root.left != null && left == null && root.right != null && right == null) {
            root = null;
        } else if (root.left != null && left == null && root.right == null) {
            root = null;
        } else if (root.right != null && right == null && root.left == null) {
            root = null;
        } else {
            root.left = left;
            root.right = right;
        }
        return root;
    }
}
