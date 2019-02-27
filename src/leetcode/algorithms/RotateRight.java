package leetcode.algorithms;

import leetcode.entity.ListNode;
import leetcode.util.OutputUtils;

/**
 * Description: Rotate List
 *
 * @author Baltan
 * @date 2018/9/20 09:58
 */
public class RotateRight {
    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(3);
        ListNode listNode3 = new ListNode(4);
        ListNode listNode4 = new ListNode(5);
        head1.next = listNode1;
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        OutputUtils.printListNode(rotateRight(head1, 2));

        ListNode head2 = new ListNode(1);
        ListNode listNode5 = new ListNode(2);
        head2.next = listNode5;
        OutputUtils.printListNode(rotateRight(head2, 2));
    }

    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        int length = 0;
        ListNode listNode1 = head;
        while (listNode1 != null) {
            length++;
            listNode1 = listNode1.next;
        }
        int num = length - k % length;
        if (num == length) {
            return head;
        }
        ListNode listNode2 = head;
        for (int i = 0; i < num; i++) {
            listNode2 = listNode2.next;
        }
        ListNode listNode3 = listNode2;
        for (int i = 0; i < k % length - 1; i++) {
            listNode3 = listNode3.next;
        }
        listNode3.next = head;
        for (int i = 0; i < num; i++) {
            listNode3 = listNode3.next;
        }
        listNode3.next = null;
        return listNode2;
    }
}
