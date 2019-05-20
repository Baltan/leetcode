package leetcode.algorithms;

import leetcode.entity.ListNode;
import leetcode.util.OutputUtils;

/**
 * Description: Remove Duplicates from Sorted List II
 *
 * @author Baltan
 * @date 2019-05-20 09:53
 */
public class DeleteDuplicates1 {
    public static void main(String[] args) {
        ListNode listNode11 = new ListNode(1);
        ListNode listNode12 = new ListNode(2);
        ListNode listNode13 = new ListNode(3);
        ListNode listNode14 = new ListNode(3);
        ListNode listNode15 = new ListNode(4);
        ListNode listNode16 = new ListNode(4);
        ListNode listNode17 = new ListNode(5);
        listNode11.next = listNode12;
        listNode12.next = listNode13;
        listNode13.next = listNode14;
        listNode14.next = listNode15;
        listNode15.next = listNode16;
        listNode16.next = listNode17;
        OutputUtils.printListNode(deleteDuplicates(listNode11));

        ListNode listNode21 = new ListNode(1);
        ListNode listNode22 = new ListNode(1);
        ListNode listNode23 = new ListNode(1);
        ListNode listNode24 = new ListNode(2);
        ListNode listNode25 = new ListNode(3);
        listNode21.next = listNode22;
        listNode22.next = listNode23;
        listNode23.next = listNode24;
        listNode24.next = listNode25;
        OutputUtils.printListNode(deleteDuplicates(listNode21));

        ListNode listNode31 = new ListNode(1);
        ListNode listNode32 = new ListNode(1);
        ListNode listNode33 = new ListNode(1);
        ListNode listNode34 = new ListNode(1);
        ListNode listNode35 = new ListNode(1);
        listNode31.next = listNode32;
        listNode32.next = listNode33;
        listNode33.next = listNode34;
        listNode34.next = listNode35;
        OutputUtils.printListNode(deleteDuplicates(listNode31));

        ListNode listNode41 = new ListNode(2);
        ListNode listNode42 = new ListNode(1);
        listNode41.next = listNode42;
        OutputUtils.printListNode(deleteDuplicates(listNode41));

        ListNode listNode51 = new ListNode(-1);
        ListNode listNode52 = new ListNode(0);
        ListNode listNode53 = new ListNode(0);
        ListNode listNode54 = new ListNode(0);
        ListNode listNode55 = new ListNode(0);
        ListNode listNode56 = new ListNode(3);
        ListNode listNode57 = new ListNode(3);
        listNode51.next = listNode52;
        listNode52.next = listNode53;
        listNode53.next = listNode54;
        listNode54.next = listNode55;
        listNode55.next = listNode56;
        listNode56.next = listNode57;
        OutputUtils.printListNode(deleteDuplicates(listNode51));
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        ListNode node = newHead;

        Integer duplicateValue = null;

        while (node.next != null) {
            if (duplicateValue != null && node.next.val == duplicateValue) {
                node.next = node.next.next;
            } else if (node.next.next != null && node.next.val == node.next.next.val) {
                duplicateValue = node.next.val;
                node.next = node.next.next.next;
            } else {
                node = node.next;
            }
        }
        return newHead.next;
    }
}
