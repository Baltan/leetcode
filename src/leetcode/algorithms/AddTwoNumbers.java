package leetcode.algorithms;

import leetcode.entity.ListNode;
import leetcode.util.OutputUtils;

/**
 * Description: 2. Add Two Numbers
 *
 * @author Baltan
 * @date 2018/1/12 09:14
 */
public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode listNode11 = new ListNode(2);
        ListNode listNode12 = new ListNode(4);
        ListNode listNode13 = new ListNode(3);
        listNode11.next = listNode12;
        listNode12.next = listNode13;
        ListNode listNode21 = new ListNode(5);
        ListNode listNode22 = new ListNode(6);
        ListNode listNode23 = new ListNode(4);
        listNode21.next = listNode22;
        listNode22.next = listNode23;
        OutputUtils.printListNode(addTwoNumbers(listNode11, listNode21));

        ListNode listNode31 = new ListNode(1);
        ListNode listNode32 = new ListNode(2);
        ListNode listNode33 = new ListNode(1);
        listNode31.next = listNode32;
        listNode32.next = listNode33;
        ListNode listNode41 = new ListNode(9);
        ListNode listNode42 = new ListNode(9);
        ListNode listNode43 = new ListNode(9);
        listNode41.next = listNode42;
        listNode42.next = listNode43;
        OutputUtils.printListNode(addTwoNumbers(listNode31, listNode41));
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int val = l1.val + l2.val;
        ListNode l3 = new ListNode(val >= 10 ? val - 10 : val);
        ListNode temp = l3;
        int carryBit = val >= 10 ? 1 : 0;
        while (l1.next != null || l2.next != null) {
            if (l1.next != null && l2.next != null) {
                val = l1.next.val + l2.next.val + carryBit;
                l1 = l1.next;
                l2 = l2.next;
            } else if (l1.next != null && l2.next == null) {
                val = l1.next.val + carryBit;
                l1 = l1.next;
            } else {
                val = l2.next.val + carryBit;
                l2 = l2.next;
            }
            ListNode currentListNode = new ListNode(val >= 10 ? val - 10 : val);
            carryBit = val >= 10 ? 1 : 0;
            temp.next = currentListNode;
            temp = currentListNode;
        }
        if (carryBit == 1) {
            ListNode currentListNode = new ListNode(1);
            temp.next = currentListNode;
        }
        return l3;
    }


}
