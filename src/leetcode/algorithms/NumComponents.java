package leetcode.algorithms;

import leetcode.entity.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * Description: 817. Linked List Components
 *
 * @author Baltan
 * @date 2018/8/20 15:46
 */
public class NumComponents {
    public static void main(String[] args) {
        ListNode head1 = new ListNode(0);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        head1.next = node1;
        node1.next = node2;
        node2.next = node3;
        int[] G1 = {0, 1, 3};
        System.out.println(numComponents(head1, G1));

        ListNode head2 = new ListNode(0);
        ListNode node4 = new ListNode(1);
        ListNode node5 = new ListNode(2);
        ListNode node6 = new ListNode(3);
        ListNode node7 = new ListNode(4);
        head2.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        int[] G2 = {0, 3, 1, 4};
        System.out.println(numComponents(head2, G2));
    }

    public static int numComponents(ListNode head, int[] G) {
        Set<Integer> set = new HashSet<>();
        for (int num : G) {
            set.add(num);
        }
        int componentNum = set.contains(head.val) ? 1 : 0;
        while (head.next != null) {
            if (!set.contains(head.val) && set.contains(head.next.val)) {
                componentNum++;
            }
            head = head.next;
        }
        return componentNum;
    }
}
