package leetcode.algorithms;

import leetcode.entity.ListNode;
import leetcode.util.ListNodeUtils;
import leetcode.util.OutputUtils;

/**
 * Description: 19. Remove Nth Node From End of List
 *
 * @author Baltan
 * @date 2018/8/29 11:44
 */
public class RemoveNthFromEnd {
    public static void main(String[] args) {
        ListNode head1 = ListNodeUtils.arrayToListNode(new int[]{1, 2, 3, 4, 5});
        OutputUtils.printListNode(removeNthFromEnd(head1, 2));

        ListNode head2 = new ListNode(1);
        OutputUtils.printListNode(removeNthFromEnd(head2, 1));

        ListNode head3 = ListNodeUtils.arrayToListNode(new int[]{1, 2, 3});
        OutputUtils.printListNode(removeNthFromEnd(head3, 3));
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        /**
         * 快指针
         */
        ListNode fast = head;
        /**
         * 慢指针
         */
        ListNode slow = head;
        /**
         * 令快指针先走n+1步，然后快慢指针同步向前，当快指针刚好走出链表时，此时慢指针位于链表的倒数第
         * n+1个节点上，将该节点的后继节点指向下下个节点即可。但是如果快指针无法走到n+1步，说明n就为链
         * 表的长度，直接移除链表的头节点返回即可
         */
        for (int i = 0; i <= n; i++) {
            if (fast != null) {
                fast = fast.next;
            } else {
                return head.next;
            }
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        /**
         * 将倒数第n+1个节点的next指针指向倒数第n-1个节点
         */
        slow.next = slow.next.next;
        return head;
    }
}
