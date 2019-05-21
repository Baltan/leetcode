package leetcode.algorithms;

import leetcode.entity.ListNode;
import leetcode.util.OutputUtils;

/**
 * Description: 19. Remove Nth Node From End of List
 *
 * @author Baltan
 * @date 2018/8/29 11:44
 */
public class RemoveNthFromEnd {
    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(3);
        ListNode listNode3 = new ListNode(4);
        ListNode listNode4 = new ListNode(5);
        head1.next = listNode1;
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        OutputUtils.printListNode(removeNthFromEnd(head1, 2));

        ListNode head2 = new ListNode(1);
        OutputUtils.printListNode(removeNthFromEnd(head2, 1));

        ListNode head3 = new ListNode(1);
        ListNode listNode5 = new ListNode(2);
        ListNode listNode6 = new ListNode(3);
        head3.next = listNode5;
        listNode5.next = listNode6;
        OutputUtils.printListNode(removeNthFromEnd(head3, 3));
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode listNode1 = head;
        ListNode listNode2 = head;
        for (int i = 0; i < n; i++) {
            listNode1 = listNode1.next;
        }
        if (listNode1 == null) {
            listNode2 = listNode2.next;
            return listNode2;
        } else {
            while (listNode1.next != null) {
                listNode1 = listNode1.next;
                listNode2 = listNode2.next;
            }
            listNode2.next = listNode2.next.next;
            return head;
        }
    }
}
