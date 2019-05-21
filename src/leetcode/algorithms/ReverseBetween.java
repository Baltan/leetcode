package leetcode.algorithms;

import leetcode.entity.ListNode;
import leetcode.util.OutputUtils;

/**
 * Description: Reverse Linked List II
 *
 * @author Baltan
 * @date 2019-05-21 10:02
 */
public class ReverseBetween {
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
        OutputUtils.printListNode(reverseBetween(listNode11, 1, 1));
        OutputUtils.printListNode(reverseBetween(listNode11, 1, 2));
        OutputUtils.printListNode(reverseBetween(listNode11, 1, 3));
        OutputUtils.printListNode(reverseBetween(listNode11, 1, 4));
        OutputUtils.printListNode(reverseBetween(listNode11, 1, 5));
        OutputUtils.printListNode(reverseBetween(listNode11, 2, 2));
        OutputUtils.printListNode(reverseBetween(listNode11, 2, 3));
        OutputUtils.printListNode(reverseBetween(listNode11, 2, 4));
        OutputUtils.printListNode(reverseBetween(listNode11, 2, 5));
        OutputUtils.printListNode(reverseBetween(listNode11, 3, 3));
        OutputUtils.printListNode(reverseBetween(listNode11, 3, 4));
        OutputUtils.printListNode(reverseBetween(listNode11, 3, 5));
        OutputUtils.printListNode(reverseBetween(listNode11, 4, 4));
        OutputUtils.printListNode(reverseBetween(listNode11, 4, 5));
        OutputUtils.printListNode(reverseBetween(listNode11, 5, 5));

        ListNode listNode21 = new ListNode(1);
        OutputUtils.printListNode(reverseBetween(listNode21, 1, 1));

        ListNode listNode31 = new ListNode(1);
        ListNode listNode32 = new ListNode(2);
        listNode31.next = listNode32;
        OutputUtils.printListNode(reverseBetween(listNode31, 1, 1));
        OutputUtils.printListNode(reverseBetween(listNode31, 1, 2));
        OutputUtils.printListNode(reverseBetween(listNode31, 2, 2));
    }

    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) {
            return null;
        }

        ListNode node = head;
        int index = 1;
        ListNode prefixNode = null;

        while (index < m) {
            prefixNode = node;
            node = node.next;
            index++;
        }

        ListNode midHeadNode = new ListNode(node.val);
        ListNode midTailNode = midHeadNode;
        node = node.next;
        index++;

        while (index <= n) {
            ListNode currentNode = new ListNode(node.val);
            currentNode.next = midHeadNode;
            midHeadNode = currentNode;
            node = node.next;
            index++;
        }

        if (prefixNode == null) {
            midTailNode.next = node;
            return midHeadNode;
        } else {
            prefixNode.next = midHeadNode;
            midTailNode.next = node;
            return head;
        }
    }
}
