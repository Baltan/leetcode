package leetcode.algorithms;

import leetcode.entity.ListNode;
import leetcode.util.ListNodeUtils;
import leetcode.util.OutputUtils;

/**
 * Description: 21. Merge Two Sorted Lists
 *
 * @author Baltan
 * @date 2018/1/6 13:46
 */
public class MergeTwoLists {
    public static void main(String[] args) {
        ListNode l11 = ListNodeUtils.arrayToListNode(new int[]{1, 2, 4});
        ListNode l12 = ListNodeUtils.arrayToListNode(new int[]{1, 3, 4});
        OutputUtils.printListNode(mergeTwoLists(l11, l12));
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        ListNode dummy = new ListNode(-1);
        ListNode currNode = dummy;
        /**
         * 只要两个链表都还有节点，就将较小的那个头节点截取下来接到合并后的链表最后，直到某一条链表的所有
         * 节点都拼接完后，将另一条链表剩余的部分直接拼接到合并后的链表最后即可
         */
        while (l1 != null && l2 != null) {
            if (l1.val >= l2.val) {
                currNode.next = l2;
                currNode = currNode.next;
                l2 = l2.next;
                currNode.next = null;
            } else {
                currNode.next = l1;
                currNode = currNode.next;
                l1 = l1.next;
                currNode.next = null;
            }
        }

        if (l1 != null) {
            currNode.next = l1;
        } else {
            currNode.next = l2;
        }
        return dummy.next;
    }
}
