package leetcode.algorithms;

import leetcode.entity.ListNode;

/**
 * Description:Delete Node in a Linked List
 *
 * @author Baltan
 * @date 2018/1/3 10:43
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