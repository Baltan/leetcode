package leetcode.algorithms;

import leetcode.entity.ListNode;

/**
 * Description: 142. Linked List Cycle II
 *
 * @author Baltan
 * @date 2019-05-31 14:23
 * @see leetcode.interview.DetectCycle
 */
public class DetectCycle {
    public static void main(String[] args) {
        ListNode listNode11 = new ListNode(3);
        ListNode listNode12 = new ListNode(2);
        ListNode listNode13 = new ListNode(0);
        ListNode listNode14 = new ListNode(-4);
        listNode11.next = listNode12;
        listNode12.next = listNode13;
        listNode13.next = listNode14;
        listNode14.next = listNode12;
        System.out.println(detectCycle(listNode11));

        ListNode listNode21 = new ListNode(1);
        ListNode listNode22 = new ListNode(2);
        listNode21.next = listNode22;
        listNode22.next = listNode21;
        System.out.println(detectCycle(listNode21));
    }

    /**
     * 参考：
     * <a href="https://leetcode-cn.com/problems/linked-list-cycle-ii/solution/linked-list-cycle-ii-kuai-man-zhi-zhen-shuang-zhi-/"></a>
     *
     * @param head
     * @return
     */
    public static ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        /**
         * 快指针从头开始一次走2步
         */
        ListNode fast = head;
        /**
         * 慢指针从头开始一次走1步
         */
        ListNode slow = head;
        /**
         * 是否找到环路
         */
        boolean hasLoop = false;
        /**
         * 快慢指针同步前进，如果存在环路的话，快指针一定会套圈追上慢指针
         */
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            /**
             * 当快慢指针相遇，说明找到了环路
             */
            if (fast == slow) {
                hasLoop = true;
                break;
            }
        }
        /**
         * 保持慢指针的位置不变，将快指针移到链表头部，接下去快慢指针都是每次走一步，直到相遇位置，相遇点就是
         * 环路的头节点
         */
        if (hasLoop) {
            fast = head;

            while (fast != slow) {
                fast = fast.next;
                slow = slow.next;
            }
            return fast;
        }
        return null;
    }
}
