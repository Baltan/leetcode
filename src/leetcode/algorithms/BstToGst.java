package leetcode.algorithms;

import leetcode.entity.TreeNode;
import leetcode.util.BinaryTreeUtils;

/**
 * Description: 1038. Binary Search Tree to Greater Sum Tree
 *
 * @author Baltan
 * @date 2019-05-06 09:24
 * @see ConvertBST
 */
public class BstToGst {
    public static void main(String[] args) {
        TreeNode root1 = BinaryTreeUtils.arrayToBinaryTree(
                new Integer[]{4, 1, 6, 0, 2, 5, 7, null, null, null, 3, null, null, null, 8}, 0);
        System.out.println(BinaryTreeUtils.recursivelyPreOrder(bstToGst(root1)));
    }

    private static int sum = 0;

    public static TreeNode bstToGst(TreeNode root) {
        if (root == null) {
            return null;
        }

        bstToGst(root.right);
        sum += root.val;
        root.val = sum;
        bstToGst(root.left);
        return root;
    }
}
