package leetcode.algorithms;

import leetcode.entity.ListNode;

/**
 * Description: Linked List Cycle
 *
 * @author Baltan
 * @date 2018/8/9 23:11
 */
public class HasCycle {
    public static void main(String[] args) {
        ListNode node11 = new ListNode(1);
        System.out.println(hasCycle(node11));

        ListNode node21 = new ListNode(1);
        ListNode node22 = new ListNode(2);
        node21.next = node22;
        System.out.println(hasCycle(node21));

        ListNode node31 = new ListNode(1);
        ListNode node32 = new ListNode(2);
        node31.next = node32;
        node32.next = node31;
        System.out.println(hasCycle(node31));

        ListNode node41 = new ListNode(1);
        ListNode node42 = new ListNode(2);
        ListNode node43 = new ListNode(3);
        ListNode node44 = new ListNode(4);
        ListNode node45 = new ListNode(5);
        node41.next = node42;
        node42.next = node43;
        node43.next = node44;
        node44.next = node45;
        node45.next = node41;
        System.out.println(hasCycle(node41));

        ListNode node51 = new ListNode(1);
        ListNode node52 = new ListNode(2);
        ListNode node53 = new ListNode(3);
        ListNode node54 = new ListNode(4);
        ListNode node55 = new ListNode(5);
        node51.next = node52;
        node52.next = node53;
        node53.next = node54;
        node54.next = node55;
        node55.next = node53;
        System.out.println(hasCycle(node51));

        ListNode node61 = new ListNode(1);
        ListNode node62 = new ListNode(2);
        ListNode node63 = new ListNode(3);
        ListNode node64 = new ListNode(4);
        ListNode node65 = new ListNode(5);
        ListNode node66 = new ListNode(6);
        ListNode node67 = new ListNode(7);
        node61.next = node62;
        node62.next = node63;
        node63.next = node64;
        node64.next = node65;
        node65.next = node66;
        node66.next = node67;
        System.out.println(hasCycle(node61));
    }

    public static boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode node1 = null;
        ListNode node2 = null;
        if (head.next != null) {
            node1 = head.next;
        }
        if (head.next != null && head.next.next != null) {
            node2 = head.next.next;
        }
        while (node2 != null && node1 != null) {
            if (node2 == node1) {
                return true;
            }
            if (node1.next != null) {
                node1 = node1.next;
            } else {
                return false;
            }
            if (node2.next != null && node2.next.next != null) {
                node2 = node2.next.next;
            } else {
                return false;
            }
        }
        return false;
    }
}
