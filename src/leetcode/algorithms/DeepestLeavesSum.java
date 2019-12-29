package leetcode.algorithms;

import leetcode.entity.TreeNode;
import leetcode.util.BinaryTreeUtils;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Description: 1302. Deepest Leaves Sum
 *
 * @author Baltan
 * @date 2019-12-29 11:47
 */
public class DeepestLeavesSum {
    public static void main(String[] args) {
        TreeNode root1 =
                BinaryTreeUtils.arrayToBinaryTree(new Integer[]{1, 2, 3, 4, 5, null, 6, 7, null, null, null,
                        null, null, null, 8}, 0);
        System.out.println(deepestLeavesSum(root1));

        TreeNode root2 =
                BinaryTreeUtils.arrayToBinaryTree(new Integer[]{1}, 0);
        System.out.println(deepestLeavesSum(root2));

        TreeNode root3 =
                BinaryTreeUtils.arrayToBinaryTree(new Integer[]{1, 2, 3, 4}, 0);
        System.out.println(deepestLeavesSum(root3));
    }

    public static int deepestLeavesSum(TreeNode root) {
        int result = 0;
        /**
         * 保存每一层的节点
         */
        Queue<TreeNode> queue = new LinkedList<>();
        /**
         * 保存所有最深层的叶节点
         */
        Queue<TreeNode> deepestQueue = new LinkedList<>();
        /**
         * 将第一层的节点，即根节点入队
         */
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            /**
             * 将队列中的所有节点出队，这些节点如果有子节点，这些子节点即为更深一层的节点，将这些子
             * 节点入队
             */
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                /**
                 * 假设node节点是最深层的叶节点，先加入deepestQueue
                 */
                deepestQueue.offer(node);

                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            /**
             * 如果此时queue中没有节点了，说明deepestQueue中的节点就是所有最深层的叶节点
             */
            if (!queue.isEmpty()) {
                deepestQueue.clear();
            }
        }
        /**
         * 将所有最深层的叶节点的值求和
         */
        for (TreeNode node : deepestQueue) {
            result += node.val;
        }
        return result;
    }
}
