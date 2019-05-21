package leetcode.algorithms;

import leetcode.entity.ListNode;
import leetcode.util.OutputUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: 1019. Next Greater Node In Linked List
 *
 * @author Baltan
 * @date 2019-04-01 10:11
 */
public class NextLargerNodes {
    public static void main(String[] args) {
        ListNode head1 = new ListNode(2);
        ListNode node11 = new ListNode(1);
        ListNode node12 = new ListNode(5);

        head1.next = node11;
        node11.next = node12;
        OutputUtils.print1DIntegerArray(nextLargerNodes(head1));

        ListNode head2 = new ListNode(2);
        ListNode node21 = new ListNode(7);
        ListNode node22 = new ListNode(4);
        ListNode node23 = new ListNode(3);
        ListNode node24 = new ListNode(5);

        head2.next = node21;
        node21.next = node22;
        node22.next = node23;
        node23.next = node24;
        OutputUtils.print1DIntegerArray(nextLargerNodes(head2));

        ListNode head3 = new ListNode(1);
        ListNode node31 = new ListNode(7);
        ListNode node32 = new ListNode(5);
        ListNode node33 = new ListNode(1);
        ListNode node34 = new ListNode(9);
        ListNode node35 = new ListNode(2);
        ListNode node36 = new ListNode(5);
        ListNode node37 = new ListNode(1);

        head3.next = node31;
        node31.next = node32;
        node32.next = node33;
        node33.next = node34;
        node34.next = node35;
        node35.next = node36;
        node36.next = node37;
        OutputUtils.print1DIntegerArray(nextLargerNodes(head3));
    }

    public static int[] nextLargerNodes(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }

        int size = list.size();
        int[] result = new int[size];

        for (int i = 0; i < size - 1; i++) {
            int currentValue = list.get(i);
            for (int j = i + 1; j < size; j++) {
                if (list.get(j) > currentValue) {
                    result[i] = list.get(j);
                    break;
                }
            }
        }
        return result;
    }
}
