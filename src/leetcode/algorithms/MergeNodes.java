package leetcode.algorithms;

import leetcode.entity.ListNode;
import leetcode.util.ListNodeUtils;
import leetcode.util.OutputUtils;

/**
 * Description: 2181. Merge Nodes in Between Zeros
 *
 * @author Baltan
 * @date 2022/2/21 10:04
 */
public class MergeNodes {
    public static void main(String[] args) {
        ListNode head1 = ListNodeUtils.arrayToListNode(new int[]{0, 3, 1, 0, 4, 5, 2, 0});
        OutputUtils.printListNode(mergeNodes(head1));

        ListNode head2 = ListNodeUtils.arrayToListNode(new int[]{0, 1, 0, 3, 0, 2, 2, 0});
        OutputUtils.printListNode(mergeNodes(head2));

        ListNode head3 = ListNodeUtils.arrayToListNode(new int[]{0, 1, 0});
        OutputUtils.printListNode(mergeNodes(head3));
    }

    public static ListNode mergeNodes(ListNode head) {
        ListNode dummy = new ListNode(-1);
        ListNode node = dummy;
        /**
         * 当前区间内非零节点的节点值之和
         */
        int sum = 0;
        head = head.next;

        while (head != null) {
            if (head.val == 0) {
                /**
                 * 结束一段区间的节点值累加，将区间和重置为0
                 */
                node.next = new ListNode(sum);
                node = node.next;
                sum = 0;
            } else {
                sum += head.val;
            }
            head = head.next;
        }
        return dummy.next;
    }
}
