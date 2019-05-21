package leetcode.algorithms;

import leetcode.entity.ListNode;
import leetcode.util.OutputUtils;

/**
 * Description: 25. Reverse Nodes in k-Group
 *
 * @author Baltan
 * @date 2018/9/1 15:10
 */
public class ReverseKGroup {
    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);
        head1.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        OutputUtils.printListNode(reverseKGroup(head1, 2));

        ListNode head2 = new ListNode(1);
        ListNode node5 = new ListNode(2);
        ListNode node6 = new ListNode(3);
        ListNode node7 = new ListNode(4);
        ListNode node8 = new ListNode(5);
        head2.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        OutputUtils.printListNode(reverseKGroup(head2, 3));

        ListNode head3 = new ListNode(1);
        ListNode node9 = new ListNode(2);
        ListNode node10 = new ListNode(3);
        ListNode node11 = new ListNode(4);
        ListNode node12 = new ListNode(5);
        head3.next = node9;
        node9.next = node10;
        node10.next = node11;
        node11.next = node12;
        OutputUtils.printListNode(reverseKGroup(head3, 5));

        ListNode head4 = new ListNode(1);
        ListNode node13 = new ListNode(2);
        ListNode node14 = new ListNode(3);
        ListNode node15 = new ListNode(4);
        ListNode node16 = new ListNode(5);
        head4.next = node13;
        node13.next = node14;
        node14.next = node15;
        node15.next = node16;
        OutputUtils.printListNode(reverseKGroup(head4, 6));
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) {
            return head;
        }
        ListNode node = head;
        ListNode head1 = head;
        ListNode head2 = head1;
        for (int i = 0; i < k - 1; i++) {
            node = node.next;
            if (node == null) {
                return head;
            } else {
                head1.next = node;
                head1 = head1.next;
            }
        }
        ListNode tail = node.next;
        head1.next = null;
        ListNode temp = reverseKGroup(head2.next, k - 1);
        ListNode temp1 = temp;
        while (temp.next != null) {
            temp = temp.next;
        }
        if (temp != null) {
            temp.next = head2;
        }
        head2.next = reverseKGroup(tail, k);
        return temp1;
    }
}
