package leetcode.algorithms;

import leetcode.entity.ListNode;
import leetcode.util.OutputUtils;

/**
 * Description: 206. Reverse Linked List
 *
 * @author Baltan
 * @date 2018/1/3 15:14
 */
public class ReverseList {
    public static void main(String[] args) {
        ListNode listNode3 = new ListNode(3);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode1 = new ListNode(1);
        listNode2.next = listNode3;
        listNode1.next = listNode2;
        OutputUtils.printListNode(listNode1);
        OutputUtils.printListNode(reverseList(listNode1));
    }

    public static ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        } else if (head.next == null) {
            return head;
        } else {
            ListNode reverseListNode = new ListNode(head.val);
            ListNode temp;
            while (head.next != null) {
                head = head.next;
                temp = new ListNode(head.val);
                temp.next = reverseListNode;
                reverseListNode = temp;
            }
            return reverseListNode;
        }
    }
}