package leetcode.algorithms;

import leetcode.entity.TreeNode;
import leetcode.util.BinaryTreeUtils;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Description: 107. Binary Tree Level Order Traversal II
 *
 * @author Baltan
 * @date 2018/7/27 23:56
 */
public class LevelOrderBottom {
    public static void main(String[] args) {
        TreeNode root1 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{3, 9, 20, null, null, 15, 7}, 0);
        System.out.println(levelOrderBottom(root1));

        TreeNode root2 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{1, 2, 3, 4, 5}, 0);
        System.out.println(levelOrderBottom(root2));

        TreeNode root3 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{1, 2, 2, 3, 4, 4, 3}, 0);
        System.out.println(levelOrderBottom(root3));
    }

    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        /**
         * 逐层遍历
         */
        while (!queue.isEmpty()) {
            /**
             * 该层节点的个数
             */
            int size = queue.size();
            /**
             * 保存该层所有节点的值
             */
            List<Integer> level = new LinkedList<>();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);

                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            /**
             * 因为自底向上逐层遍历，所以每次将该层的列表插入到result头部的位置
             */
            result.add(0, level);
        }
        return result;
    }
}
