package leetcode.algorithms;

import leetcode.entity.ListNode;
import leetcode.util.OutputUtils;

/**
 * Description: 328. Odd Even Linked List
 *
 * @author Baltan
 * @date 2019-06-21 15:43
 */
public class OddEvenList {
    public static void main(String[] args) {
        ListNode listNode11 = new ListNode(1);
        ListNode listNode12 = new ListNode(2);
        ListNode listNode13 = new ListNode(3);
        ListNode listNode14 = new ListNode(4);
        ListNode listNode15 = new ListNode(5);
        listNode11.next = listNode12;
        listNode12.next = listNode13;
        listNode13.next = listNode14;
        listNode14.next = listNode15;
        OutputUtils.printListNode(oddEvenList(listNode11));

        ListNode listNode21 = new ListNode(2);
        ListNode listNode22 = new ListNode(1);
        ListNode listNode23 = new ListNode(3);
        ListNode listNode24 = new ListNode(5);
        ListNode listNode25 = new ListNode(6);
        ListNode listNode26 = new ListNode(4);
        ListNode listNode27 = new ListNode(7);
        listNode21.next = listNode22;
        listNode22.next = listNode23;
        listNode23.next = listNode24;
        listNode24.next = listNode25;
        listNode25.next = listNode26;
        listNode26.next = listNode27;
        OutputUtils.printListNode(oddEvenList(listNode21));
    }

    public static ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }

        ListNode oddNode = head;
        ListNode evenHead = head.next;
        ListNode evenNode = evenHead;

        ListNode node = head.next.next;

        while (node != null) {
            oddNode.next = node;
            oddNode = oddNode.next;
            node = node.next;

            if (node != null) {
                evenNode.next = node;
                evenNode = evenNode.next;
                node = node.next;
            }
        }
        evenNode.next = null;
        oddNode.next = evenHead;
        return head;
    }
}
