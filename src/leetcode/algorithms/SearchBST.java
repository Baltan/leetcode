package leetcode.algorithms;

import leetcode.entity.TreeNode;

/**
 * Description: Search in a Binary Search Tree
 *
 * @author Baltan
 * @date 2019-02-24 18:04
 */
public class SearchBST {
    public static void main(String[] args) {

    }

    public static TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        } else if (root.val < val) {
            return searchBST(root.right, val);
        } else {
            return searchBST(root.left, val);
        }
    }
}
