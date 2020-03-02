package leetcode.algorithms;

import leetcode.entity.ListNode;
import leetcode.util.OutputUtils;

import java.util.Stack;

/**
 * Description: 206. Reverse Linked List
 *
 * @author Baltan
 * @date 2018/1/3 15:14
 */
public class ReverseList2 {
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
        }

        Stack<ListNode> stack = new Stack();
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        /**
         * 将原链表的节点依次入栈
         */
        while (head != null) {
            stack.push(new ListNode(head.val));
            head = head.next;
        }
        /**
         * 将栈中的节点依次出栈接在一起
         */
        while (!stack.isEmpty()) {
            curr.next = stack.pop();
            curr = curr.next;
        }
        return dummy.next;
    }
}