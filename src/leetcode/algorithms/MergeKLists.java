package leetcode.algorithms;

import leetcode.entity.ListNode;
import leetcode.util.ListNodeUtils;
import leetcode.util.OutputUtils;

/**
 * Description: 23. Merge k Sorted Lists
 *
 * @author Baltan
 * @date 2018/8/31 14:17
 * @see MergeKLists1
 */
public class MergeKLists {
    public static void main(String[] args) {
        ListNode head1 = ListNodeUtils.arrayToListNode(new int[]{1, 4, 5});
        ListNode head2 = ListNodeUtils.arrayToListNode(new int[]{1, 3, 4});
        ListNode head3 = ListNodeUtils.arrayToListNode(new int[]{1, 2, 6});
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
        /**
         * 逐一按顺序合并lists中的各个链表
         */
        for (int i = 2; i < length; i++) {
            res = merge2Lists(res, lists[i]);
        }
        return res;
    }

    /**
     * 合并两个链表
     *
     * @param listNode1
     * @param listNode2
     * @return
     */
    public static ListNode merge2Lists(ListNode listNode1, ListNode listNode2) {
        if (listNode1 == null) {
            return listNode2;
        } else if (listNode2 == null) {
            return listNode1;
        } else {
            if (listNode1.val < listNode2.val) {
                ListNode head = new ListNode(listNode1.val);
                /**
                 * 递归合并listNode1剩余部分链表和listNode2
                 */
                ListNode tail = merge2Lists(listNode1.next, listNode2);
                head.next = tail;
                return head;
            } else {
                ListNode head = new ListNode(listNode2.val);
                /**
                 * 递归合并listNode2剩余部分链表和listNode1
                 */
                ListNode tail = merge2Lists(listNode1, listNode2.next);
                head.next = tail;
                return head;
            }
        }
    }
}
