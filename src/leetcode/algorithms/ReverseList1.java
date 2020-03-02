package leetcode.algorithms;

import leetcode.entity.ListNode;
import leetcode.util.OutputUtils;

/**
 * Description: 206. Reverse Linked List
 *
 * @author Baltan
 * @date 2018/1/3 15:14
 */
public class ReverseList1 {
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
        if (head == null || head.next == null) {
            return head;
        }

        ListNode next = head.next;
        /**
         * 原来的链表head之后的部分反转之后得到的新链表
         */
        ListNode reverse = reverseList(next);
        ListNode temp = reverse;
        /**
         * 找到新链表的最后一个节点
         */
        while (temp.next != null) {
            temp = temp.next;
        }
        /**
         * 将原来的head节点追加到新链表的最后
         */
        temp.next = new ListNode(head.val);
        return reverse;
    }
}