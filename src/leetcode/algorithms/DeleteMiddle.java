package leetcode.algorithms;

import leetcode.entity.ListNode;
import leetcode.util.ListNodeUtils;
import leetcode.util.OutputUtils;

/**
 * Description: 2095. Delete the Middle Node of a Linked List
 *
 * @author Baltan
 * @date 2021/12/6 09:15
 */
public class DeleteMiddle {
    public static void main(String[] args) {
        OutputUtils.printListNode(
                deleteMiddle(ListNodeUtils.arrayToListNode(new int[]{1, 3, 4, 7, 1, 2, 6})));
        OutputUtils.printListNode(
                deleteMiddle(ListNodeUtils.arrayToListNode(new int[]{1, 2, 3, 4})));
        OutputUtils.printListNode(
                deleteMiddle(ListNodeUtils.arrayToListNode(new int[]{2, 1})));
        OutputUtils.printListNode(
                deleteMiddle(ListNodeUtils.arrayToListNode(new int[]{2})));
    }

    public static ListNode deleteMiddle(ListNode head) {
        if (head.next == null) {
            return null;
        }
        /**
         * slow指针一次走一步
         */
        ListNode slow = head;
        /**
         * fast指针一次走两步
         */
        ListNode fast = head;
        /**
         * fast指针可以走的次数，即可以走2*stepCount步
         */
        int stepCount = 0;
        /**
         * 计算fast指针可以走的次数
         */
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            stepCount++;
        }
        /**
         * 如果链表长度为奇数，即fast指针走了stepCount次后正好停留在最后一个节点，则slow指针走stepCount步后停留的
         * 节点就是要删除的节点，故先走stepCount-1步；如果链表长度为偶数，则slow指针走stepCount+1步后停留的节点就
         * 是要删除的节点，故先走stepCount步
         */
        if (fast.next == null) {
            for (int i = 1; i < stepCount; i++) {
                slow = slow.next;
            }
        } else {
            for (int i = 0; i < stepCount; i++) {
                slow = slow.next;
            }
        }
        /**
         * 将删除节点的前后链表相连
         */
        slow.next = slow.next.next;
        return head;
    }
}
