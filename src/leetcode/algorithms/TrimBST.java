package leetcode.algorithms;

import leetcode.entity.TreeNode;

/**
 * Description: 669. Trim a Binary Search Tree
 *
 * @author Baltan
 * @date 2018/7/31 12:28
 */
public class TrimBST {
    public static void main(String[] args) {

    }

    public static TreeNode trimBST(TreeNode root, int L, int R) {
        if (root == null) {
            return null;
        } else if (root.val >= L && root.val <= R) {
            root.left = trimBST(root.left, L, R);
            root.right = trimBST(root.right, L, R);
        } else if (root.val < L) {
            root = trimBST(root.right, L, R);
        } else {
            root = trimBST(root.left, L, R);
        }
        return root;
    }
}
