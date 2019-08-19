package leetcode.algorithms;

import leetcode.entity.TreeNode;
import leetcode.util.BinaryTreeUtils;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Description: 1161. Maximum Level Sum of a Binary Tree
 *
 * @author Baltan
 * @date 2019-08-19 09:17
 */
public class MaxLevelSum {
    public static void main(String[] args) {
        TreeNode root1 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{1, 7, 0, 7, -8}, 0);
        System.out.println(maxLevelSum(root1));

        TreeNode root2 =
                BinaryTreeUtils.arrayToBinaryTree(new Integer[]{1, 2, 3, 4, 5, 6, 7, 3, 3, 3, 3, 3, 3,
                        4}, 0);
        System.out.println(maxLevelSum(root2));

        TreeNode root3 =
                BinaryTreeUtils.arrayToBinaryTree(new Integer[]{1, 1}, 0);
        System.out.println(maxLevelSum(root3));

        TreeNode root4 = BinaryTreeUtils.arrayToBinaryTree(
                new Integer[]{989, null, 10250, null, null, 98693, -89388, null, null, null, null, null, null,
                        null, -32127}, 0);
        System.out.println(maxLevelSum(root4));
    }

    public static int maxLevelSum(TreeNode root) {
        /**
         * 同一层节点总和最大值所在层数（总和相同的情况下层数取最小）
         */
        int level = 1;
        /**
         * 当前同一层节点总和最大值所在层数（总和相同的情况下层数取最小）
         */
        int maxSumLevel = 1;
        /**
         * 当前同一层节点总和最大值
         */
        int maxSum = Integer.MIN_VALUE;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            int sum = 0;
            /**
             * 将该层的节点依次取出，加节点的值加入到该层的总和中，并且如果节点有子节点的话，将子节点加入到queue中
             */
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                sum += node.val;

                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            /**
             * 如果这层的节点总和大于前面同一层节点总和的最大值，就更新同一层节点总和最大值
             */
            if (sum > maxSum) {
                level = maxSumLevel;
                maxSum = sum;
            }
            /**
             * 处理到的层数加1
             */
            maxSumLevel++;
        }
        return level;
    }
}
