package leetcode.algorithms;

import leetcode.entity.ListNode;
import leetcode.util.OutputUtils;

/**
 * Description: 23. Merge k Sorted Lists
 *
 * @author Baltan
 * @date 2018/8/31 14:17
 */
public class MergeKLists {
    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(5);
        head1.next = node1;
        node1.next = node2;
        ListNode head2 = new ListNode(1);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        head2.next = node3;
        node3.next = node4;
        ListNode head3 = new ListNode(2);
        ListNode node5 = new ListNode(6);
        head3.next = node5;
        OutputUtils.printListNode(mergeKLists(new ListNode[]{head1, head2, head3}));
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        } else if (lists.length == 1) {
            return lists[0];
        }
        int length = lists.length;
        ListNode res = merge2Lists(lists[0], lists[1]);
        for (int i = 2; i < length; i++) {
            res = merge2Lists(res, lists[i]);
        }
        return res;
    }

    public static ListNode merge2Lists(ListNode listNode1, ListNode listNode2) {
        if (listNode1 == null) {
            return listNode2;
        } else if (listNode2 == null) {
            return listNode1;
        } else {
            if (listNode1.val < listNode2.val) {
                ListNode head = new ListNode(listNode1.val);
                ListNode tail = merge2Lists(listNode1.next, listNode2);
                head.next = tail;
                return head;
            } else {
                ListNode head = new ListNode(listNode2.val);
                ListNode tail = merge2Lists(listNode1, listNode2.next);
                head.next = tail;
                return head;
            }
        }
    }
}
