package leetcode.algorithms;

import leetcode.entity.TreeNode;
import leetcode.util.BinaryTreeUtils;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Description: 1609. Even Odd Tree
 *
 * @author Baltan
 * @date 2020-11-15 21:34
 */
public class IsEvenOddTree {
    public static void main(String[] args) {
        TreeNode root1 = BinaryTreeUtils.arrayToBinaryTree(
                new Integer[]{1, 10, 4, 3, null, 7, 9, 12, 8, null, null, 6, null, null, 2}, 0);
        System.out.println(isEvenOddTree(root1));

        TreeNode root2 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{5, 4, 2, 3, 3, 7, null}, 0);
        System.out.println(isEvenOddTree(root2));

        TreeNode root3 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{5, 9, 1, 3, 5, 7, null}, 0);
        System.out.println(isEvenOddTree(root3));

        TreeNode root4 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{1}, 0);
        System.out.println(isEvenOddTree(root4));

        TreeNode root5 = BinaryTreeUtils
                .arrayToBinaryTree(new Integer[]{11, 8, 6, 1, 3, 9, 11, 30, 20, 18, 16, 12, 10, 4, 2,
                        17}, 0);
        System.out.println(isEvenOddTree(root5));

        TreeNode root6 =
                BinaryTreeUtils.arrayToBinaryTree(new Integer[]{2, 12, 8, 5, 9, null, null, 18, 16}, 0);
        System.out.println(isEvenOddTree(root6));
    }

    public static boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        /**
         * 是否是偶数层
         */
        boolean evenLevel = true;
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            TreeNode prevNode = queue.poll();
            /**
             * 如果当前为偶数层但是当前节点值为偶数，则不是奇偶树，直接返回false
             */
            if (evenLevel && prevNode.val % 2 == 0) {
                return false;
            }
            /**
             * 如果当前为奇数层但是当前节点值为奇数，则不是奇偶树，直接返回false
             */
            if (!evenLevel && prevNode.val % 2 == 1) {
                return false;
            }

            if (prevNode.left != null) {
                queue.offer(prevNode.left);
            }

            if (prevNode.right != null) {
                queue.offer(prevNode.right);
            }

            for (int i = 1; i < size; i++) {
                TreeNode currNode = queue.poll();
                /**
                 * 如果当前为偶数层但是当前节点值为偶数或当前节点值不大于前一个节点值，则不是奇偶树，
                 * 直接返回false
                 */
                if (evenLevel && (currNode.val % 2 == 0 || prevNode.val >= currNode.val)) {
                    return false;
                }
                /**
                 * 如果当前为奇数层但是当前节点值为奇数或当前节点值不小于前一个节点值，则不是奇偶树，
                 * 直接返回false
                 */
                if (!evenLevel && (currNode.val % 2 == 1 || prevNode.val <= currNode.val)) {
                    return false;
                }

                if (currNode.left != null) {
                    queue.offer(currNode.left);
                }

                if (currNode.right != null) {
                    queue.offer(currNode.right);
                }
                prevNode = currNode;
            }
            evenLevel = !evenLevel;
        }
        return true;
    }
}
