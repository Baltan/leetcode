package leetcode.algorithms;

import leetcode.entity.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: 98. Validate Binary Search Tree
 *
 * @author Baltan
 * @date 2019-05-23 09:40
 */
public class IsValidBST {
    public static void main(String[] args) {
        TreeNode treeNode11 = new TreeNode(2);
        TreeNode treeNode12 = new TreeNode(1);
        TreeNode treeNode13 = new TreeNode(3);
        treeNode11.left = treeNode12;
        treeNode11.right = treeNode13;
        System.out.println(isValidBST(treeNode11));

        TreeNode treeNode21 = new TreeNode(5);
        TreeNode treeNode22 = new TreeNode(1);
        TreeNode treeNode23 = new TreeNode(4);
        TreeNode treeNode24 = new TreeNode(3);
        TreeNode treeNode25 = new TreeNode(6);
        treeNode21.left = treeNode22;
        treeNode21.right = treeNode23;
        treeNode23.left = treeNode24;
        treeNode23.right = treeNode25;
        System.out.println(isValidBST(treeNode21));

        TreeNode treeNode31 = new TreeNode(1);
        System.out.println(isValidBST(treeNode31));

        TreeNode treeNode41 = new TreeNode(5);
        TreeNode treeNode42 = new TreeNode(2);
        TreeNode treeNode43 = new TreeNode(8);
        TreeNode treeNode44 = new TreeNode(3);
        TreeNode treeNode45 = new TreeNode(9);
        treeNode41.left = treeNode42;
        treeNode41.right = treeNode43;
        treeNode43.left = treeNode44;
        treeNode43.right = treeNode45;
        System.out.println(isValidBST(treeNode41));
    }

    public static boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        List<Integer> result = inOrder(root);
        int size = result.size();

        for (int i = 1; i < size; i++) {
            if (result.get(i) <= result.get(i - 1)) {
                return false;
            }
        }
        return true;
    }

    public static List<Integer> inOrder(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        result.addAll(inOrder(root.left));
        result.add(root.val);
        result.addAll(inOrder(root.right));
        return result;
    }
}
