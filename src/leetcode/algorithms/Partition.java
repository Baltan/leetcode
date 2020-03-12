package leetcode.algorithms;

import leetcode.entity.ListNode;
import leetcode.util.ListNodeUtils;
import leetcode.util.OutputUtils;

/**
 * Description: 86. Partition List
 *
 * @author Baltan
 * @date 2019-03-26 09:13
 * @see Partition3
 * @see leetcode.interview.Partition
 * @see leetcode.interview.Partition1
 */
public class Partition {
    public static void main(String[] args) {
        ListNode head1 = ListNodeUtils.arrayToListNode(new int[]{1, 4, 3, 2, 5, 2});
        OutputUtils.printListNode(partition(head1, 3));
    }

    public static ListNode partition(ListNode head, int x) {
        if (head == null) {
            return null;
        }
        /**
         * start后面接值不小于x的节点
         */
        ListNode start = new ListNode(0);
        start.next = head;
        /**
         * 指向start这条链表的第一个节点
         */
        ListNode startCopy = start;
        /**
         * temp后面接值小于x的节点
         */
        ListNode temp = new ListNode(0);
        /**
         * 指向temp这条链表的第一个节点
         */
        ListNode tempCopy = temp;

        while (start.next != null) {
            if (start.next.val < x) {
                ListNode ln = new ListNode(start.next.val);
                temp.next = ln;
                temp = temp.next;
                start.next = start.next.next;
            } else {
                start = start.next;
            }
        }
        /**
         * 将start这条链表拼接到temp这条链表后面
         */
        temp.next = startCopy.next;
        return tempCopy.next;
    }
}
