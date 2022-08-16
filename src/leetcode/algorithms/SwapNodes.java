package leetcode.algorithms;

import leetcode.entity.ListNode;
import leetcode.util.ListNodeUtils;
import leetcode.util.OutputUtils;

/**
 * Description: 1721. Swapping Nodes in a Linked List
 *
 * @author Baltan
 * @date 2022/8/9 09:06
 */
public class SwapNodes {
    public static void main(String[] args) {
        ListNode head1 = ListNodeUtils.arrayToListNode(new int[]{1, 2, 3, 4, 5});
        int k1 = 2;
        OutputUtils.printListNode(swapNodes(head1, k1));

        ListNode head2 = ListNodeUtils.arrayToListNode(new int[]{7, 9, 6, 6, 7, 8, 3, 0, 9, 5});
        int k2 = 5;
        OutputUtils.printListNode(swapNodes(head2, k2));

        ListNode head3 = ListNodeUtils.arrayToListNode(new int[]{7, 9, 6, 6, 7, 8, 3, 0, 9, 5});
        int k3 = 1;
        OutputUtils.printListNode(swapNodes(head3, k3));
    }

    public static ListNode swapNodes(ListNode head, int k) {
        ListNode copy = head;
        /**
         * 链表的长度
         */
        int length = 0;
        /**
         * 计算链表的长度
         */
        while (copy != null) {
            length++;
            copy = copy.next;
        }
        /**
         * 需要交换的两个节点
         */
        ListNode swap1 = head;
        ListNode swap2 = head;
        /**
         * 查找第k（1-based）个节点
         */
        for (int i = k - 1; i > 0; i--) {
            swap1 = swap1.next;
        }
        /**
         * 查找倒数第k（1-based）个节点
         */
        for (int i = length - k; i > 0; i--) {
            swap2 = swap2.next;
        }
        /**
         * 交换两个节点的值
         */
        int value = swap1.val;
        swap1.val = swap2.val;
        swap2.val = value;
        return head;
    }
}
