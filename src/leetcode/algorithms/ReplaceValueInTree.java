package leetcode.algorithms;

import leetcode.entity.TreeNode;
import leetcode.util.BinaryTreeUtils;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Description: 2641. Cousins in Binary Tree II
 *
 * @author Baltan
 * @date 2023/4/16 11:59
 */
public class ReplaceValueInTree {
    public static void main(String[] args) {
        TreeNode root1 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{5, 4, 9, 1, 10, null, 7}, 0);
        System.out.println(replaceValueInTree(root1));

        TreeNode root2 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{3, 1, 2}, 0);
        System.out.println(replaceValueInTree(root2));
    }

    public static TreeNode replaceValueInTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        /**
         * 根节点没有堂兄弟节点，其修改后的值一定为0
         */
        root.val = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            /**
             * 下一层所有节点之和
             */
            int levelSum = 0;

            for (TreeNode node : queue) {
                levelSum += node.left == null ? 0 : node.left.val;
                levelSum += node.right == null ? 0 : node.right.val;
            }

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                /**
                 * 当前节点node的子节点之和
                 */
                int childrenSum = (node.left == null ? 0 : node.left.val) + (node.right == null ? 0 : node.right.val);
                /**
                 * 当前节点node的子节点修改后的值
                 */
                int cousinsSum = levelSum - childrenSum;
                /**
                 * 修改左子节点的值
                 */
                if (node.left != null) {
                    node.left.val = cousinsSum;
                    queue.offer(node.left);
                }
                /**
                 * 修改右子节点的值
                 */
                if (node.right != null) {
                    node.right.val = cousinsSum;
                    queue.offer(node.right);
                }
            }
        }
        return root;
    }
}
