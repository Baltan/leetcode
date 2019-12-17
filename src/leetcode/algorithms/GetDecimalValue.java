package leetcode.algorithms;

import leetcode.entity.ListNode;
import leetcode.util.ListNodeUtils;

/**
 * Description: 1290. Convert Binary Number in a Linked List to Integer
 *
 * @author Baltan
 * @date 2019-12-17 08:52
 */
public class GetDecimalValue {
    public static void main(String[] args) {
        ListNode head1 = ListNodeUtils.arrayToListNode(new int[]{1, 0, 1});
        System.out.println(getDecimalValue(head1));

        ListNode head2 = ListNodeUtils.arrayToListNode(new int[]{0});
        System.out.println(getDecimalValue(head2));

        ListNode head3 = ListNodeUtils.arrayToListNode(new int[]{1});
        System.out.println(getDecimalValue(head3));

        ListNode head4 =
                ListNodeUtils.arrayToListNode(new int[]{1, 0, 0, 1, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0});
        System.out.println(getDecimalValue(head4));

        ListNode head5 = ListNodeUtils.arrayToListNode(new int[]{0, 0});
        System.out.println(getDecimalValue(head5));

        ListNode head6 = ListNodeUtils
                .arrayToListNode(new int[]{0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 1, 0, 0, 1, 1, 1, 1, 0, 0, 0, 1
                        , 1, 1, 1, 0, 0, 0, 0, 1, 1});
        System.out.println(getDecimalValue(head6));
    }

    public static int getDecimalValue(ListNode head) {
        int value = head.val;

        while (head.next != null) {
            /**
             * 链表后面每添加一个数字，相当于链表左移一位，即十进制值乘2
             */
            value = value * 2 + head.next.val;
            head = head.next;
        }
        return value;
    }
}
