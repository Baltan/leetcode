package leetcode.algorithms;

import leetcode.entity.ListNode;
import leetcode.util.ListNodeUtils;

/**
 * Description: 234. Palindrome Linked List
 *
 * @author Baltan
 * @date 2020-03-12 15:51
 * @see IsPalindrome2
 */
public class IsPalindrome3 {
    public static void main(String[] args) {
        ListNode head1 = ListNodeUtils.arrayToListNode(new int[]{1});
        System.out.println(isPalindrome(head1));

        ListNode head2 = ListNodeUtils.arrayToListNode(new int[]{1, 1});
        System.out.println(isPalindrome(head2));

        ListNode head3 = ListNodeUtils.arrayToListNode(new int[]{1, 2});
        System.out.println(isPalindrome(head3));

        ListNode head4 = ListNodeUtils.arrayToListNode(new int[]{1, 2, 1});
        System.out.println(isPalindrome(head4));

        ListNode head5 = ListNodeUtils.arrayToListNode(new int[]{1, 2, 2, 1});
        System.out.println(isPalindrome(head5));
    }

    /**
     * 参考：
     * <a href="https://leetcode-cn.com/problems/palindrome-linked-list/solution/hui-wen-lian-biao-by-leetcode/"></a>
     *
     * @param head
     * @return
     */
    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        /**
         * 快指针一次走2步
         */
        ListNode fast = head;
        /**
         * 慢指针一次走1步
         */
        ListNode slow = head;
        /**
         * 当快指针前面不足两个节点时，此时慢指针走到链表前半部分的最后
         */
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        /**
         * 慢指针指向链表后半部分的开头，将链表后半部分翻转
         */
        ListNode reverseHalf = reverseListNode(slow.next);
        /**
         * 将链表前半部分和翻转后的链表后半部分，逐一比较
         */
        while (reverseHalf != null) {
            if (reverseHalf.val != head.val) {
                return false;
            }
            reverseHalf = reverseHalf.next;
            head = head.next;
        }
        return true;
    }

    /**
     * 翻转链表
     *
     * @param head
     * @return
     */
    public static ListNode reverseListNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        /**
         * 将链表头节点之后的部分翻转，则原来头节点之后的节点（即第二个节点）变为这部分翻转后的最后一个节
         * 点
         */
        ListNode listNode = reverseListNode(head.next);
        /**
         * 将原来的第二个节点指向原来的头节点
         */
        head.next.next = head;
        /**
         * 将原来的头节点指向null
         */
        head.next = null;
        return listNode;
    }
}