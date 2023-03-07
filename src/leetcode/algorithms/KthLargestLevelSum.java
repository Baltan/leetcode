package leetcode.algorithms;

import leetcode.entity.TreeNode;
import leetcode.util.BinaryTreeUtils;

import java.util.*;

/**
 * Description: 2583. Kth Largest Sum in a Binary Tree
 *
 * @author Baltan
 * @date 2023/3/5 18:17
 */
public class KthLargestLevelSum {
    public static void main(String[] args) {
        TreeNode root1 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{5, 8, 9, 2, 1, 3, 7, 4, 6}, 0);
        System.out.println(kthLargestLevelSum(root1, 2));

        TreeNode root2 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{1, 2, null, 3}, 0);
        System.out.println(kthLargestLevelSum(root2, 1));
    }

    public static long kthLargestLevelSum(TreeNode root, int k) {
        List<Long> sums = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            /**
             * 二叉树root这一层所有节点的和
             */
            long sum = 0L;

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
            sums.add(sum);
        }
        /**
         * 二叉树层数小于k
         */
        if (sums.size() < k) {
            return -1;
        }
        /**
         * 将二叉树各层节点的和按照降序排列
         */
        Collections.sort(sums, Collections.reverseOrder());
        return sums.get(k - 1);
    }
}
