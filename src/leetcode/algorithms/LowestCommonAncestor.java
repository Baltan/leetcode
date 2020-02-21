package leetcode.algorithms;

import leetcode.entity.TreeNode;
import leetcode.util.BinaryTreeUtils;

/**
 * Description: 235. Lowest Common Ancestor of a Binary Search Tree
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
        /**
         * 设k=(root.val-p.val)*(root.val-q.val)，如果k为0，则p和q中中至少有一个就是root节
         * 点，另一个可能是root节点，也可能是root的子孙节点，不论什么情况，p和q的公共祖先都是
         * root；如果k<0，则p和q位于root的左子树和右子树中，p和q的公共节点只有root；如果k>0,
         * 则p和q同时在root的左子树中或同时在root的右子树中，在root的左子树或右子树中递归。
         */
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
