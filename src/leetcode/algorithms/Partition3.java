package leetcode.algorithms;

import leetcode.entity.ListNode;
import leetcode.util.ListNodeUtils;
import leetcode.util.OutputUtils;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Description: 86. Partition List
 *
 * @author Baltan
 * @date 2020-03-12 14:26
 * @see Partition
 */
public class Partition3 {
    public static void main(String[] args) {
        ListNode head1 = ListNodeUtils.arrayToListNode(new int[]{1, 4, 3, 2, 5, 2});
        OutputUtils.printListNode(partition(head1, 3));

        ListNode head2 = ListNodeUtils.arrayToListNode(new int[]{3, 5, 8, 5, 10, 2, 1});
        OutputUtils.printListNode(partition(head2, 5));
    }

    public static ListNode partition(ListNode head, int x) {
        if (head == null) {
            return null;
        }
        /**
         * 保存所有值小于x的节点
         */
        Queue<ListNode> queue1 = new LinkedList<>();
        /**
         * 保存所有值不小于x的节点
         */
        Queue<ListNode> queue2 = new LinkedList();
        ListNode dummy = new ListNode(-1);
        ListNode newHead = dummy;

        while (head != null) {
            ListNode temp = head;
            head = head.next;
            temp.next = null;

            if (temp.val < x) {
                queue1.offer(temp);
            } else {
                queue2.offer(temp);
            }
        }
        /**
         * 先拼接所有值小于x的节点
         */
        while (!queue1.isEmpty()) {
            dummy.next = queue1.poll();
            dummy = dummy.next;
        }
        /**
         * 再拼接所有值不小于x的节点
         */
        while (!queue2.isEmpty()) {
            dummy.next = queue2.poll();
            dummy = dummy.next;
        }
        return newHead.next;
    }
}
