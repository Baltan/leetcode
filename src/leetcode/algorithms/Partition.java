package leetcode.algorithms;

import leetcode.entity.ListNode;
import leetcode.util.OutputUtils;

/**
 * Description: Partition List
 *
 * @author Baltan
 * @date 2019-03-26 09:13
 */
public class Partition {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(2);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;

        OutputUtils.printListNode(partition(node1, 3));
    }

    public static ListNode partition(ListNode head, int x) {
        if (head == null) {
            return null;
        }
        ListNode start = new ListNode(0);
        start.next = head;
        ListNode startCopy = start;
        ListNode temp = new ListNode(0);
        ListNode tempCopy = temp;

        while (start.next != null) {
            if (start.next.val < x) {
                ListNode ln = new ListNode(start.next.val);
                temp.next = ln;
                temp = temp.next;
                start.next = start.next.next;
            } else {
                start = start.next;
            }
        }
        temp.next = startCopy.next;
        return tempCopy.next;
    }
}
