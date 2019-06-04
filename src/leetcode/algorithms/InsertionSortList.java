package leetcode.algorithms;

import leetcode.entity.ListNode;
import leetcode.util.OutputUtils;

/**
 * Description: 147. Insertion Sort List
 *
 * @author Baltan
 * @date 2019-06-03 23:26
 */
public class InsertionSortList {
    public static void main(String[] args) {
        ListNode listNode11 = new ListNode(4);
        ListNode listNode12 = new ListNode(2);
        ListNode listNode13 = new ListNode(1);
        ListNode listNode14 = new ListNode(3);
        listNode11.next = listNode12;
        listNode12.next = listNode13;
        listNode13.next = listNode14;
        OutputUtils.printListNode(insertionSortList(listNode11));

        ListNode listNode21 = new ListNode(-1);
        ListNode listNode22 = new ListNode(5);
        ListNode listNode23 = new ListNode(3);
        ListNode listNode24 = new ListNode(4);
        ListNode listNode25 = new ListNode(0);
        listNode21.next = listNode22;
        listNode22.next = listNode23;
        listNode23.next = listNode24;
        listNode24.next = listNode25;
        OutputUtils.printListNode(insertionSortList(listNode21));

        ListNode listNode31 = new ListNode(1);
        ListNode listNode32 = new ListNode(2);
        ListNode listNode33 = new ListNode(3);
        ListNode listNode34 = new ListNode(4);
        ListNode listNode35 = new ListNode(5);
        listNode31.next = listNode32;
        listNode32.next = listNode33;
        listNode33.next = listNode34;
        listNode34.next = listNode35;
        OutputUtils.printListNode(insertionSortList(listNode31));

        ListNode listNode41 = new ListNode(5);
        ListNode listNode42 = new ListNode(4);
        ListNode listNode43 = new ListNode(3);
        ListNode listNode44 = new ListNode(2);
        ListNode listNode45 = new ListNode(1);
        listNode41.next = listNode42;
        listNode42.next = listNode43;
        listNode43.next = listNode44;
        listNode44.next = listNode45;
        OutputUtils.printListNode(insertionSortList(listNode41));

        ListNode listNode51 = new ListNode(2);
        ListNode listNode52 = new ListNode(1);
        listNode51.next = listNode52;
        OutputUtils.printListNode(insertionSortList(listNode51));
    }

    public static ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        int length = 0;
        ListNode temp = head;
        /**
         * 计算链表长度
         */
        while (temp != null) {
            length++;
            temp = temp.next;
        }

        for (int i = 1; i < length; i++) {
            ListNode node = head;
            ListNode current = head;
            /**
             * 操作第i的节点（0-based）
             */
            for (int j = 0; j < i; j++) {
                node = node.next;
            }
            /**
             * 要操作节点的前一个节点
             */
            for (int j = 0; j < i - 1; j++) {
                current = current.next;
            }

            /**
             * 将要操作的节点单独取出，剩下的节点连接起来
             */
            current.next = node.next;
            node.next = null;
            /**
             * 如果要操作的节点小于头节点，直接将头节点连在要操作的节点后面，并且将被操作的节点作为头节点
             */
            if (node.val < head.val) {
                node.next = head;
                head = node;
                continue;
            }

            current = head;
            int k = 1;
            /**
             * 从头节点开始遍历，如果当前节点后面还有节点，并且后继节点大于要操作的节点，取当前节点的后继节点
             * k记录当前节点是链表中的第几个节点（1-based）
             */
            while (current.next != null && current.next.val < node.val) {
                current = current.next;
                k++;
            }
            /**
             * 将要操作的节点插入链表
             */
            node.next = current.next;
            current.next = node;
            /**
             * 如果被操作的节点插入到原来位置的后面，下一轮循环仍应该操作链表的第i个节点
             */
            if (k > i) {
                i--;
            }
        }
        return head;
    }
}
