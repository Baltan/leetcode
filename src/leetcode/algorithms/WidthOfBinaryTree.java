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
        /**
         * 最大宽度
         */
        int maxSpan = 0;
        queue.offer(root);
        /**
         * 逐层将节点加入队列中
         */
        while (!queue.isEmpty()) {
            int size = queue.size();
            /**
             * 同一层最左边的节点的值，利用节点的值作为该节点在该层的索引
             */
            int left = Integer.MAX_VALUE;
            /**
             * 同一层最右边的节点的值，利用节点的值作为该节点在该层的索引
             */
            int right = 0;
            /**
             * 同一层将最左边的节点的值变为0需要减去的值，之后同一层的其他节点的值都需要减去该值，否则如果按照上图
             * 的形式为每个节点赋值，很大的二叉树节点的值会越界，所以处理成下图这样
             * <pre>
             *        1
             *       /  \
             *      2    3
             *     / \  /  \
             *    4  5 6    7
             *   ……
             * </pre>
             *
             * <pre>
             *        0
             *       /  \
             *      0    1
             *     / \  /  \
             *    0  1 2    3
             *   ……
             * </pre>
             */
            int diff = 0;

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                if (i == 0) {
                    /**
                     * 同一层将最左边的节点的值变为0需要减去的值，之后同一层的其他节点的值都需要减去该值
                     */
                    diff = node.val;
                }

                node.val = node.val - diff;
                /**
                 * 保存该层最左边的节点和最右边的节点的值（索引）
                 */
                left = Math.min(left, node.val);
                right = Math.max(right, node.val);

                if (node.left != null) {
                    node.left.val = node.val * 2;
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    node.right.val = node.val * 2 + 1;
                    queue.offer(node.right);
                }
            }
            /**
             * 更新最大宽度
             */
            maxSpan = Math.max(maxSpan, right - left + 1);
        }
        return maxSpan;
    }
}
