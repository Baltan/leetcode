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
        if (head == null || head.next == null) {
            return head;
        } else {
            /**
             * 指向反转之后的链表的头节点
             */
            ListNode reverseListNode = new ListNode(head.val);
            ListNode temp;
            /**
             * 从链表的第二个节点开始处理，每次循环之后，该节点以及之前的链表就被反转了，例如：
             * 原链表为：1-2-3-4-5
             * 第1次循环后得到新链表：2-1
             * 第2次循环后得到新链表：3-2-1
             * 第3次循环后得到新链表：4-3-2-1
             * 第4次循环后得到新链表：5-4-3-2-1
             */
            while (head.next != null) {
                head = head.next;
                /**
                 * 当前要处理的原链表的节点
                 */
                temp = new ListNode(head.val);
                /**
                 * temp节点后面追加之前反转得到的链表
                 */
                temp.next = reverseListNode;
                /**
                 * temp节点成为反转后的那部分原链表的头节点
                 */
                reverseListNode = temp;
            }
            return reverseListNode;
        }
    }
}