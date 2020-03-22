package leetcode.algorithms;

import leetcode.entity.ListNode;
import leetcode.util.ListNodeUtils;
import leetcode.util.OutputUtils;

/**
 * Description: 148. Sort List
 *
 * @author Baltan
 * @date 2020-03-22 16:33
 */
public class SortList {
    public static void main(String[] args) {
        ListNode head1 = ListNodeUtils.arrayToListNode(new int[]{4, 2, 1, 3});
        OutputUtils.printListNode(sortList(head1));

        ListNode head2 = ListNodeUtils.arrayToListNode(new int[]{-1, 5, 3, 4, 0});
        OutputUtils.printListNode(sortList(head2));

        ListNode head3 = ListNodeUtils.arrayToListNode(new int[]{1, 2});
        OutputUtils.printListNode(sortList(head3));
    }

    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(-1);
        /**
         * 指向slow的前一个节点位置
         */
        dummy.next = head;
        /**
         * 快指针
         */
        ListNode fast = head;
        /**
         * 慢指针
         */
        ListNode slow = head;
        /**
         * 快慢指针找到链表的中点位置
         */
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            dummy = dummy.next;
        }
        /**
         * 此时slow为链表后半部分，head为链表前半部分
         */
        dummy.next = null;
        ListNode sortedListNode1 = sortList(head);
        ListNode sortedListNode2 = sortList(slow);
        /**
         * 将两个已排序的链表合并成一条排序的链表
         */
        return merge(sortedListNode1, sortedListNode2);
    }

    /**
     * 将两个已排序的链表合并成一条排序的链表
     *
     * @param sortedListNode1
     * @param sortedListNode2
     * @return
     */
    public static ListNode merge(ListNode sortedListNode1, ListNode sortedListNode2) {
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        while (sortedListNode1 != null || sortedListNode2 != null) {
            if (sortedListNode1 != null && sortedListNode2 != null) {
                if (sortedListNode1.val <= sortedListNode2.val) {
                    curr.next = sortedListNode1;
                    sortedListNode1 = sortedListNode1.next;
                    curr = curr.next;
                    curr.next = null;
                } else {
                    curr.next = sortedListNode2;
                    sortedListNode2 = sortedListNode2.next;
                    curr = curr.next;
                    curr.next = null;
                }
            } else if (sortedListNode1 != null) {
                curr.next = sortedListNode1;
                break;
            } else {
                curr.next = sortedListNode2;
                break;
            }
        }
        return dummy.next;
    }
}
