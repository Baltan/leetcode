package leetcode.algorithms;

import leetcode.entity.ListNode;

/**
 * Description: Palindrome Linked List
 *
 * @author Baltan
 * @date 2018/8/10 11:17
 */
public class IsPalindrome2 {
    public static void main(String[] args) {
        ListNode node11 = new ListNode(1);
        System.out.println(isPalindrome(node11));

        ListNode node21 = new ListNode(1);
        ListNode node22 = new ListNode(1);
        node21.next = node22;
        System.out.println(isPalindrome(node21));

        ListNode node31 = new ListNode(1);
        ListNode node32 = new ListNode(2);
        node31.next = node32;
        System.out.println(isPalindrome(node31));

        ListNode node41 = new ListNode(1);
        ListNode node42 = new ListNode(2);
        ListNode node43 = new ListNode(1);
        node41.next = node42;
        node42.next = node43;
        System.out.println(isPalindrome(node41));


        ListNode node51 = new ListNode(1);
        ListNode node52 = new ListNode(2);
        ListNode node53 = new ListNode(2);
        ListNode node54 = new ListNode(1);
        node51.next = node52;
        node52.next = node53;
        node53.next = node54;
        System.out.println(isPalindrome(node51));
    }

    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        } else if (head.next.next == null) {
            return head.val == head.next.val;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode latterHalf = reverseListNode(slow.next);
        while (latterHalf != null) {
            if (latterHalf.val != head.val) {
                return false;
            }
            latterHalf = latterHalf.next;
            head = head.next;
        }
        return true;
    }

    public static ListNode reverseListNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode listNode = reverseListNode(head.next);
        head.next.next = head;
        head.next = null;
        return listNode;
    }
}
