package leetcode.algorithms;

import leetcode.entity.ListNode;
import leetcode.util.ListNodeUtils;
import leetcode.util.OutputUtils;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Description: 2816. Double a Number Represented as a Linked List
 *
 * @author baltan
 * @date 2023/8/15 20:13
 */
public class DoubleIt {
    public static void main(String[] args) {
        ListNode head1 = ListNodeUtils.arrayToListNode(new int[]{1, 8, 9});
        OutputUtils.printListNode(doubleIt(head1));

        ListNode head2 = ListNodeUtils.arrayToListNode(new int[]{9, 9, 9});
        OutputUtils.printListNode(doubleIt(head2));
    }

    public static ListNode doubleIt(ListNode head) {
        ListNode result = null;
        /**
         * 将链表head代表的数字由高位到低位的每一个数字入栈
         */
        Deque<Integer> deque = new ArrayDeque<>();
        /**
         * 进位
         */
        int carry = 0;

        while (head != null) {
            deque.offerLast(head.val);
            head = head.next;
        }
        /**
         * 将链表head代表的数字乘以2
         */
        while (!deque.isEmpty()) {
            /**
             * 将链表head代表的数字由低位到高位依次出栈，计算得到结果乘积相应数位上的值
             */
            int sum = deque.pollLast() * 2 + carry;
            carry = sum >= 10 ? 1 : 0;
            /**
             * 结果乘积相应数位上的值
             */
            int bit = sum >= 10 ? sum - 10 : sum;
            ListNode node = new ListNode(bit);
            node.next = result;
            /**
             * result总是指向当前得到的结果乘积的最高位数字的节点
             */
            result = node;
        }
        /**
         * 判断结果乘积最高位需不需要再加上进位1
         */
        if (carry == 1) {
            ListNode node = new ListNode(1);
            node.next = result;
            result = node;
        }
        return result;
    }
}
