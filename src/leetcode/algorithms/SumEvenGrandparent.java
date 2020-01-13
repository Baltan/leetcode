package leetcode.algorithms;

import leetcode.entity.TreeNode;
import leetcode.util.BinaryTreeUtils;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Description: 1315. Sum of Nodes with Even-Valued Grandparent
 *
 * @author Baltan
 * @date 2020-01-13 11:09
 */
public class SumEvenGrandparent {
    public static void main(String[] args) {
        TreeNode root1 = BinaryTreeUtils
                .arrayToBinaryTree(new Integer[]{6, 7, 8, 2, 7, 1, 3, 9, null, 1, 4, null, null, null, 5}, 0);
        System.out.println(sumEvenGrandparent(root1));

        TreeNode root2 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{2, 4, 6, 100}, 0);
        System.out.println(sumEvenGrandparent(root2));
    }

    public static int sumEvenGrandparent(TreeNode root) {
        int result = 0;
        /**
         * 逐层将二叉树的节点进队
         */
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                /**
                 * 如果该节点有左子节点，就将左子节点进队
                 */
                if (node.left != null) {
                    queue.offer(node.left);
                    /**
                     * 如果该节点的值为偶数，并且有孙子节点，就将孙子节点的值计入总数
                     */
                    if ((node.val & 1) == 0) {
                        if (node.left.left != null) {
                            result += node.left.left.val;
                        }

                        if (node.left.right != null) {
                            result += node.left.right.val;
                        }
                    }
                }
                /**
                 * 如果该节点有右子节点，就将右子节点进队
                 */
                if (node.right != null) {
                    queue.offer(node.right);
                    /**
                     * 如果该节点的值为偶数，并且有孙子节点，就将孙子节点的值计入总数
                     */
                    if ((node.val & 1) == 0) {
                        if (node.right.left != null) {
                            result += node.right.left.val;
                        }

                        if (node.right.right != null) {
                            result += node.right.right.val;
                        }
                    }
                }
            }
        }
        return result;
    }
}
