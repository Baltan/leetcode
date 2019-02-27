package leetcode.algorithms;

import leetcode.entity.ListNode;
import leetcode.util.OutputUtils;

/**
 * Description:Merge Two Sorted Lists
 *
 * @author Baltan
 * @date 2018/1/6 13:46
 */
public class MergeTwoLists {
    public static void main(String[] args) {
        ListNode listNode11 = new ListNode(1);
        ListNode listNode12 = new ListNode(2);
        ListNode listNode13 = new ListNode(4);
        listNode11.next = listNode12;
        listNode12.next = listNode13;

        ListNode listNode21 = new ListNode(1);
        ListNode listNode22 = new ListNode(3);
        ListNode listNode23 = new ListNode(4);
        listNode21.next = listNode22;
        listNode22.next = listNode23;

        OutputUtils.printListNode(mergeTwoLists(listNode11, listNode21));
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        } else if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }
        ListNode listNode;
        if (l1.val <= l2.val) {
            listNode = new ListNode(l1.val);
            l1 = l1.next;
        } else {
            listNode = new ListNode((l2.val));
            l2 = l2.next;
        }
        ListNode temp = listNode;
        while (l1 != null || l2 != null) {
            if (l1 == null && l2 != null) {
                temp.next = l2;
                temp = temp.next;
                l2 = l2.next;
            } else if (l2 == null && l1 != null) {
                temp.next = l1;
                temp = temp.next;
                l1 = l1.next;
            } else if (l1 != null && l2 != null) {
                if (l1.val <= l2.val) {
                    temp.next = l1;
                    temp = temp.next;
                    l1 = l1.next;
                } else {
                    temp.next = l2;
                    temp = temp.next;
                    l2 = l2.next;
                }
            }
        }
        return listNode;
    }
}
