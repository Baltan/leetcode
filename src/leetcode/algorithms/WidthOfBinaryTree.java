package leetcode.algorithms;

import leetcode.entity.TreeNode;
import leetcode.util.BinaryTreeUtils;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Description: 662. Maximum Width of Binary Tree
 *
 * @author Baltan
 * @date 2019-09-04 10:56
 */
public class WidthOfBinaryTree {
    public static void main(String[] args) {
        TreeNode root1 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{1, 3, 2, 5, 3, null, 9}, 0);
        System.out.println(widthOfBinaryTree(root1));

        TreeNode root2 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{1, 3, null, 5, 3}, 0);
        System.out.println(widthOfBinaryTree(root2));

        TreeNode root3 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{1, 3, 2, 5}, 0);
        System.out.println(widthOfBinaryTree(root3));

        TreeNode root4 = BinaryTreeUtils.arrayToBinaryTree(
                new Integer[]{1, 3, 2, 5, null, null, 9, 6, null, null, null, null, null, null, 7}, 0);
        System.out.println(widthOfBinaryTree(root4));

        TreeNode root5 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{1}, 0);
        System.out.println(widthOfBinaryTree(root5));

        TreeNode root6 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{}, 0);
        System.out.println(widthOfBinaryTree(root6));
    }

    public static int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        boolean flag = true;
        int maxSpan = 0;
        queue.offer(root);

        while (!queue.isEmpty() && flag) {
            int size = queue.size();
            flag = false;
            int left = size - 1;
            int right = 0;

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                if (node == null) {
                    queue.offer(null);
                    queue.offer(null);
                } else {
                    left = Math.min(left, i);
                    right = Math.max(right, i);
                    queue.offer(node.left);
                    queue.offer(node.right);
                    flag = true;
                }
            }
            maxSpan = Math.max(maxSpan, right - left + 1);
        }
        return maxSpan;
    }
}
