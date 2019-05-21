package leetcode.algorithms;

import leetcode.entity.ListNode;
import leetcode.util.OutputUtils;

/**
 * Description: 83. Remove Duplicates from Sorted List
 *
 * @author Baltan
 * @date 2018/1/5 15:17
 */
public class DeleteDuplicates {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(1);
        ListNode listNode3 = new ListNode(2);
        ListNode listNode4 = new ListNode(3);
        ListNode listNode5 = new ListNode(3);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        OutputUtils.printListNode(deleteDuplicates(listNode1));

        ListNode listNode6 = new ListNode(1);
        OutputUtils.printListNode(deleteDuplicates(listNode6));

        ListNode listNode7 = new ListNode(1);
        ListNode listNode8 = new ListNode(1);
        ListNode listNode9 = new ListNode(1);
        listNode7.next = listNode8;
        listNode8.next = listNode9;
        OutputUtils.printListNode(deleteDuplicates(listNode7));
    }

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode temp = head;
        while (temp != null && temp.next != null) {
            if (temp.next.val == temp.val) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }
        return head;
    }
}
