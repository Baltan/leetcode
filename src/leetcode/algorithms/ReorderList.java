package leetcode.algorithms;

import leetcode.entity.ListNode;
import leetcode.util.OutputUtils;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Description: 143. Reorder List
 *
 * @author Baltan
 * @date 2019-05-31 15:07
 */
public class ReorderList {
    public static void main(String[] args) {
        ListNode listNode11 = new ListNode(1);
        ListNode listNode12 = new ListNode(2);
        ListNode listNode13 = new ListNode(3);
        ListNode listNode14 = new ListNode(4);
        listNode11.next = listNode12;
        listNode12.next = listNode13;
        listNode13.next = listNode14;
        reorderList(listNode11);
        OutputUtils.printListNode(listNode11);

        ListNode listNode21 = new ListNode(1);
        ListNode listNode22 = new ListNode(2);
        ListNode listNode23 = new ListNode(3);
        ListNode listNode24 = new ListNode(4);
        ListNode listNode25 = new ListNode(5);
        listNode21.next = listNode22;
        listNode22.next = listNode23;
        listNode23.next = listNode24;
        listNode24.next = listNode25;
        reorderList(listNode21);
        OutputUtils.printListNode(listNode21);

        ListNode listNode31 = new ListNode(1);
        ListNode listNode32 = new ListNode(2);
        listNode31.next = listNode32;
        reorderList(listNode31);
        OutputUtils.printListNode(listNode31);

        ListNode listNode41 = new ListNode(1);
        reorderList(listNode41);
        OutputUtils.printListNode(listNode41);
    }

    public static void reorderList(ListNode head) {
        if (head == null) {
            return;
        }

        Deque<ListNode> queue = new ArrayDeque<>();

        while (head != null) {
            queue.offer(head);
            head = head.next;
        }

        boolean flag = false;
        ListNode newHead = queue.pollFirst();
        ListNode currentNode = newHead;

        while (!queue.isEmpty()) {
            if (flag) {
                currentNode.next = queue.pollFirst();
                currentNode = currentNode.next;
                flag = false;
            } else {
                currentNode.next = queue.pollLast();
                currentNode = currentNode.next;
                flag = true;
            }
        }
        currentNode.next = null;
    }
}
