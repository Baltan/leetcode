package leetcode.algorithms;

import leetcode.entity.TreeNode;
import leetcode.util.BinaryTreeUtils;

/**
 * Description: Lowest Common Ancestor of a Binary Search Tree
 *
 * @author Baltan
 * @date 2019-02-27 09:03
 */
public class LowestCommonAncestor {
    public static void main(String[] args) {
        Integer[] arr1 = {6, 2, 8, 0, 4, 7, 9, null, null, 3, 5};
        TreeNode root1 =
                BinaryTreeUtils.arrayToBinaryTree(arr1, 0);

        System.out.println(lowestCommonAncestor(root1, new TreeNode(2), new TreeNode(8)).val);

        System.out.println(lowestCommonAncestor(root1, new TreeNode(2), new TreeNode(4)).val);
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) {
            return null;
        }
        if ((root.val - p.val) * (root.val - q.val) == 0) {
            return root;
        } else if ((root.val - p.val) * (root.val - q.val) < 0) {
            return root;
        } else {
            if (p.val < root.val) {
                return lowestCommonAncestor(root.left, p, q);
            } else {
                return lowestCommonAncestor(root.right, p, q);
            }
        }
    }
}
