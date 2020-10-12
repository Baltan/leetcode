package leetcode.algorithms;

import leetcode.entity.ListNode;
import leetcode.util.ListNodeUtils;
import leetcode.util.OutputUtils;

/**
 * Description: 24. Swap Nodes in Pairs
 *
 * @author Baltan
 * @date 2018/9/1 14:28
 */
public class SwapPairs {
    public static void main(String[] args) {
        ListNode head1 = ListNodeUtils.arrayToListNode(new int[]{1, 2, 3, 4});
        OutputUtils.printListNode(swapPairs(head1));

        ListNode head2 = ListNodeUtils.arrayToListNode(new int[]{1, 2, 3});
        OutputUtils.printListNode(swapPairs(head2));
    }

    public static ListNode swapPairs(ListNode head) {
        /**
         * 如果链表中的节点数不超过1个，则直接返回自身
         */
        if (head == null || head.next == null) {
            return head;
        }
        /**
         * 如果链表中的节点数超过1个，则交换前面两个节点后，对后面的链表进行递归操作后再接在前面两个节点后面
         */
        ListNode listNode = head.next.next;
        ListNode temp = head;
        head = head.next;
        head.next = temp;
        /**
         * 对后面的链表进行递归操作
         */
        ListNode tail = swapPairs(listNode);
        temp.next = tail;
        return head;
    }
}
