package leetcode.algorithms;

import leetcode.entity.ListNode;
import leetcode.util.OutputUtils;

/**
 * Description: 876. Middle of the Linked List
 *
 * @author Baltan
 * @date 2018/7/30 09:13
 */
public class MiddleNode {
    public static void main(String[] args) {
        ListNode head1 = null;
        OutputUtils.printListNode(middleNode(head1));

        ListNode head2 = new ListNode(1);
        OutputUtils.printListNode(middleNode(head2));

        ListNode head3 = new ListNode(1);
        ListNode node32 = new ListNode(2);
        ListNode node33 = new ListNode(3);
        ListNode node34 = new ListNode(4);
        head3.next = node32;
        node32.next = node33;
        node33.next = node34;
        OutputUtils.printListNode(middleNode(head3));

        ListNode head4 = new ListNode(1);
        ListNode node42 = new ListNode(2);
        ListNode node43 = new ListNode(3);
        ListNode node44 = new ListNode(4);
        ListNode node45 = new ListNode(5);
        head4.next = node42;
        node42.next = node43;
        node43.next = node44;
        node44.next = node45;
        OutputUtils.printListNode(middleNode(head4));
    }

    public static ListNode middleNode(ListNode head) {
        if (head == null) {
            return null;
        }
        int length = 1;
        ListNode headCopy = head;
        while (headCopy.next != null) {
            length++;
            headCopy = headCopy.next;
        }
        int middleIndex = (int) Math.ceil((length + 1) / 2.0);
        int currentIndex = 1;
        while (currentIndex < middleIndex) {
            head = head.next;
            currentIndex++;
        }
        return head;
    }
}
