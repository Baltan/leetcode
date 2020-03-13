package leetcode.algorithms;

import leetcode.entity.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Description: 1379. Find a Corresponding Node of a Binary Tree in a Clone of That Tree
 *
 * @author Baltan
 * @date 2020-03-13 16:14
 */
public class GetTargetCopy {
    public static void main(String[] args) {
    }

    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned,
                                        final TreeNode target) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(cloned);
        /**
         * 因为二叉树中的节点值是唯一的，只需要将克隆二叉树中的节点逐一和target节点的值进行比较即可
         */
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if (node.val == target.val) {
                return node;
            }

            if (node.left != null) {
                queue.offer(node.left);
            }

            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        return null;
    }
}
