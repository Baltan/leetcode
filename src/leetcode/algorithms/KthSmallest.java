package leetcode.algorithms;

import leetcode.entity.TreeNode;
import leetcode.util.BinaryTreeUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: 230. Kth Smallest Element in a BST
 *
 * @author Baltan
 * @date 2019-06-12 10:56
 */
public class KthSmallest {
    public static void main(String[] args) {
        TreeNode root1 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{3, 1, 4, null, 2}, 0);
        System.out.println(kthSmallest(root1, 1));
        System.out.println(kthSmallest(root1, 2));
        System.out.println(kthSmallest(root1, 3));
        System.out.println(kthSmallest(root1, 4));

        TreeNode root2 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{5, 3, 6, 2, 4, null, null, 1}, 0);
        System.out.println(kthSmallest(root2, 1));
        System.out.println(kthSmallest(root2, 2));
        System.out.println(kthSmallest(root2, 3));
        System.out.println(kthSmallest(root2, 4));
        System.out.println(kthSmallest(root2, 5));
        System.out.println(kthSmallest(root2, 6));
    }

    public static int kthSmallest(TreeNode root, int k) {
        return inOrder(root).get(k - 1);
    }

    public static List<Integer> inOrder(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if (root != null) {
            result.addAll(inOrder(root.left));
            result.add(root.val);
            result.addAll(inOrder(root.right));
        }
        return result;
    }
}
