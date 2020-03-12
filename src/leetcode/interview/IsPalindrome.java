package leetcode.interview;

import leetcode.entity.ListNode;
import leetcode.util.ListNodeUtils;

import java.util.LinkedList;
import java.util.Objects;

/**
 * Description: 面试题 02.06. 回文链表
 *
 * @author Baltan
 * @date 2018/8/10 11:17
 * @see IsPalindrome1
 * @see leetcode.algorithms.IsPalindrome2
 * @see leetcode.algorithms.IsPalindrome3
 */
public class IsPalindrome {
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

    public static boolean isPalindrome(ListNode head) {
        LinkedList<Integer> list = new LinkedList<>();
        /**
         * 将链表节点的值逐一加入一个双端队列
         */
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        /**
         * 逐一比较队列当前首尾的值是否相等，如果不相等的话说明原链表的不是一个回文链表，如果相等的话就将队
         * 列首尾元素出队
         */
        while (list.size() > 1) {
            if (!Objects.equals(list.pollFirst(), list.pollLast())) {
                return false;
            }
        }
        return true;
    }
}
