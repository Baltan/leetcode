package leetcode.interview;

import leetcode.entity.ListNode;
import leetcode.util.ListNodeUtils;

/**
 * Description: 面试题 02.02. 返回倒数第 k 个节点
 *
 * @author Baltan
 * @date 2020-03-12 13:31
 */
public class KthToLast {
    public static void main(String[] args) {
        ListNode head1 = ListNodeUtils.arrayToListNode(new int[]{1, 2, 3, 4, 5});
        System.out.println(kthToLast(head1, 2));
    }

    public static int kthToLast(ListNode head, int k) {
        /**
         * 走在前面的指针
         */
        ListNode prev = head;
        /**
         * 走在后面的指针
         */
        ListNode last = head;
        /**
         * 走在前面的指针先走k步，然后两个指针同步向前移动，当前面的指针走出链表时，后面的指针指向的就是倒数
         * 第k个节点
         */
        for (int i = 0; i < k; i++) {
            prev = prev.next;
        }
        /**
         * 两个指针同步向前移动，直到前面的指针走出链表
         */
        while (prev != null) {
            prev = prev.next;
            last = last.next;
        }
        return last.val;
    }
}
