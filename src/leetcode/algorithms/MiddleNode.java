package leetcode.algorithms;

import leetcode.entity.ListNode;
import leetcode.util.ListNodeUtils;
import leetcode.util.OutputUtils;

/**
 * Description: 876. Middle of the Linked List
 *
 * @author Baltan
 * @date 2018/7/30 09:13
 */
public class MiddleNode {
    public static void main(String[] args) {
        ListNode head1 = null;
        OutputUtils.printListNode(middleNode(head1));

        ListNode head2 = ListNodeUtils.arrayToListNode(new int[]{1});
        OutputUtils.printListNode(middleNode(head2));

        ListNode head3 = ListNodeUtils.arrayToListNode(new int[]{1, 2, 3, 4});
        OutputUtils.printListNode(middleNode(head3));

        ListNode head4 = ListNodeUtils.arrayToListNode(new int[]{1, 2, 3, 4, 5});
        OutputUtils.printListNode(middleNode(head4));
    }

    public static ListNode middleNode(ListNode head) {
        /**
         * 快指针从head开始，一次走两步
         */
        ListNode fast = head;
        /**
         * 慢指针从head开始，一次走一步
         */
        ListNode slow = head;
        /**
         * 当fast不能向前走两步的时候，慢指针指向的位置就是链表的中间节点
         */
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
