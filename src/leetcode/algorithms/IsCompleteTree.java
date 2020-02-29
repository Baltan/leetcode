package leetcode.algorithms;

import leetcode.entity.TreeNode;
import leetcode.util.BinaryTreeUtils;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Description: 958. Check Completeness of a Binary Tree
 *
 * @author Baltan
 * @date 2020-02-29 12:20
 */
public class IsCompleteTree {
    public static void main(String[] args) {
        TreeNode root1 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{1, 2, 3, 4, 5, 6}, 0);
        System.out.println(isCompleteTree(root1));

        TreeNode root2 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{1, 2, 3, 4, 5, null, 7}, 0);
        System.out.println(isCompleteTree(root2));

        TreeNode root3 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{1, 2, 3, 4, 5, 6, null, 8}, 0);
        System.out.println(isCompleteTree(root3));
    }

    public static boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        /**
         * 二叉树上一层的节点是否没有填满
         */
        boolean prevLevelNotFull = false;
        /**
         * 当前遍历的层数（0-based）
         */
        int level = 0;
        /**
         * 逐层遍历二叉树的节点
         */
        while (!queue.isEmpty()) {
            int size = queue.size();
            /**
             * 当前这层的二叉树节点是否中断
             */
            boolean currLevelNotContinual = false;
            level++;

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                /**
                 * 如果当前这层二叉树节点中断但是这层后面还有节点，或者上一层节点没有填满但是当
                 * 前这层还有节点，则这棵二叉树就不是完全二叉树
                 */
                if (node.left != null) {
                    if (currLevelNotContinual || prevLevelNotFull) {
                        return false;
                    } else {
                        queue.offer(node.left);
                    }
                } else {
                    /**
                     * 标记当前这层节点中断了
                     */
                    currLevelNotContinual = true;
                }

                if (node.right != null) {
                    if (currLevelNotContinual || prevLevelNotFull) {
                        return false;
                    } else {
                        queue.offer(node.right);
                    }
                } else {
                    /**
                     * 标记当前这层节点中断了
                     */
                    currLevelNotContinual = true;
                }
            }
            /**
             * 二叉树第i（0-based）层一共可以存在2^i个节点，如果这层节点数不为2^i个，说明当前
             * 这层节点没有填满
             */
            if (queue.size() != Math.pow(2, level)) {
                prevLevelNotFull = true;
            }
        }
        return true;
    }
}
