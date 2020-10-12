package leetcode.algorithms;

import leetcode.entity.TreeNode;
import leetcode.util.BinaryTreeUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: 530. Minimum Absolute Difference in BST
 *
 * @author Baltan
 * @date 2019-02-25 11:19
 */
public class GetMinimumDifference {
    public static void main(String[] args) {
        TreeNode root1 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{1, null, 3, null, null, 2}, 0);
        System.out.println(getMinimumDifference(root1));
    }

    public static int getMinimumDifference(TreeNode root) {
        int result = Integer.MAX_VALUE;
        List<Integer> list = inorder(root);

        for (int i = 0, size = list.size(); i < size - 1; i++) {
            result = Math.min(result, list.get(i + 1) - list.get(i));
        }
        return result;
    }

    public static List<Integer> inorder(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        if (root == null) {
            return list;
        }
        list.addAll(inorder(root.left));
        list.add(root.val);
        list.addAll(inorder(root.right));
        return list;
    }
}
