package leetcode.algorithms;

import leetcode.entity.ListNode;
import leetcode.util.OutputUtils;

/**
 * Description:Remove Linked List Elements
 *
 * @author Baltan
 * @date 2018/1/8 09:49
 */
public class RemoveElements {
    public static void main(String[] args) {
        ListNode listNode11 = new ListNode(1);
        ListNode listNode12 = new ListNode(2);
        ListNode listNode13 = new ListNode(6);
        ListNode listNode14 = new ListNode(3);
        ListNode listNode15 = new ListNode(4);
        ListNode listNode16 = new ListNode(5);
        ListNode listNode17 = new ListNode(6);
        listNode11.next = listNode12;
        listNode12.next = listNode13;
        listNode13.next = listNode14;
        listNode14.next = listNode15;
        listNode15.next = listNode16;
        listNode16.next = listNode17;
        OutputUtils.printListNode(removeElements(listNode11, 6));

        ListNode listNode21 = new ListNode(6);
        ListNode listNode22 = new ListNode(1);
        ListNode listNode23 = new ListNode(3);
        ListNode listNode24 = new ListNode(6);
        ListNode listNode25 = new ListNode(4);
        listNode21.next = listNode22;
        listNode22.next = listNode23;
        listNode23.next = listNode24;
        listNode24.next = listNode25;
        OutputUtils.printListNode(removeElements(listNode21, 6));

        ListNode listNode31 = new ListNode(1);
        OutputUtils.printListNode(removeElements(listNode31, 1));
    }

    public static ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        while (head != null) {
            if (head.val != val) {
                break;
            } else {
                if (head.next != null) {
                    head = head.next;
                } else {
                    return null;
                }
            }
        }
        ListNode temp1 = head;
        ListNode temp2 = head.next;
        while (temp2 != null) {
            if (temp2.val == val) {
                temp2 = temp2.next;
                temp1.next = temp2;
            } else {
                temp1.next = temp2;
                temp1 = temp2;
                temp2 = temp2.next;
            }
        }
        return head;
    }
}
