package leetcode.algorithms;

import leetcode.entity.ListNode;
import leetcode.util.OutputUtils;

/**
 * Description: Swap Nodes in Pairs
 *
 * @author Baltan
 * @date 2018/9/1 14:28
 */
public class SwapPairs {
    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        head1.next = node1;
        node1.next = node2;
        node2.next = node3;
        OutputUtils.printListNode(swapPairs(head1));

        ListNode head2 = new ListNode(1);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(3);
        head2.next = node4;
        node4.next = node5;
        OutputUtils.printListNode(swapPairs(head2));
    }

    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        if (head.next.next == null) {
            ListNode temp = head;
            head = head.next;
            head.next = temp;
            temp.next = null;
            return head;
        }
        ListNode listNode = head.next.next;
        ListNode temp = head;
        head = head.next;
        head.next = temp;
        ListNode tail = swapPairs(listNode);
        temp.next = tail;
        return head;
    }
}
