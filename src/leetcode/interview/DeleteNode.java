package leetcode.interview;

import leetcode.entity.ListNode;

/**
 * Description: 面试题 02.03. 删除中间节点
 *
 * @author Baltan
 * @date 2018/1/3 10:43
 * @see leetcode.algorithms.DeleteNode
 */
public class DeleteNode {
    public static void main(String[] args) {

    }

    public static void deleteNode(ListNode node) {
        if (node != null) {
            node.val = node.next.val;
            node.next = node.next.next;
        }
    }
}