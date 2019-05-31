package leetcode.algorithms;

import leetcode.entity.ListNode;

/**
 * Description: 142. Linked List Cycle II
 *
 * @author Baltan
 * @date 2019-05-31 14:23
 */
public class DetectCycle {
    public static void main(String[] args) {
        ListNode listNode11 = new ListNode(3);
        ListNode listNode12 = new ListNode(2);
        ListNode listNode13 = new ListNode(0);
        ListNode listNode14 = new ListNode(-4);
        listNode11.next = listNode12;
        listNode12.next = listNode13;
        listNode13.next = listNode14;
        listNode14.next = listNode12;
        System.out.println(detectCycle(listNode11));

        ListNode listNode21 = new ListNode(1);
        ListNode listNode22 = new ListNode(2);
        listNode21.next = listNode22;
        listNode22.next = listNode21;
        System.out.println(detectCycle(listNode21));
    }

    public static ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode fast = head;
        ListNode slow = head;
        boolean hasLoop = false;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                hasLoop = true;
                break;
            }
        }

        if (hasLoop) {
            fast = head;

            while (fast != slow) {
                fast = fast.next;
                slow = slow.next;
            }
            return fast;
        }
        return null;
    }
}
