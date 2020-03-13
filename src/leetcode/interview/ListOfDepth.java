package leetcode.interview;

import leetcode.entity.ListNode;
import leetcode.entity.TreeNode;
import leetcode.util.BinaryTreeUtils;
import leetcode.util.OutputUtils;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Description: 面试题 04.03. 特定深度节点链表
 *
 * @author Baltan
 * @date 2020-03-13 17:20
 */
public class ListOfDepth {
    public static void main(String[] args) {
        TreeNode root1 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{1, 2, 3, 4, 5, null, 7, 8}, 0);
        OutputUtils.print1DListNodeArray(listOfDepth(root1));
    }

    public static ListNode[] listOfDepth(TreeNode tree) {
        if (tree == null) {
            return new ListNode[]{};
        }

        List<ListNode> list = new LinkedList<>();
        /**
         * 逐层将二叉树的节点加入队列中
         */
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(tree);

        while (!queue.isEmpty()) {
            int size = queue.size();
            ListNode dummy = new ListNode(-1);
            ListNode currNode = dummy;
            /**
             * 将当前一层的二叉树节点逐一出队连接成链表
             */
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                currNode.next = new ListNode(node.val);
                currNode = currNode.next;

                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            list.add(dummy.next);
        }
        return list.toArray(new ListNode[0]);
    }
}
