package leetcode.interview;

import leetcode.entity.ListNode;
import leetcode.util.ListNodeUtils;
import leetcode.util.OutputUtils;

/**
 * Description: 面试题 02.05. 链表求和
 *
 * @author Baltan
 * @date 2018/1/12 09:14
 * @see leetcode.algorithms.AddTwoNumbers
 */
public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode listNode11 = ListNodeUtils.arrayToListNode(new int[]{2, 4, 3});
        ListNode listNode12 = ListNodeUtils.arrayToListNode(new int[]{5, 6, 4});
        OutputUtils.printListNode(addTwoNumbers(listNode11, listNode12));

        ListNode listNode21 = ListNodeUtils.arrayToListNode(new int[]{1, 2, 1});
        ListNode listNode22 = ListNodeUtils.arrayToListNode(new int[]{9, 9, 9});
        OutputUtils.printListNode(addTwoNumbers(listNode21, listNode22));

        ListNode listNode31 = ListNodeUtils.arrayToListNode(new int[]{7, 2, 4, 3});
        ListNode listNode32 = ListNodeUtils.arrayToListNode(new int[]{5, 6, 4});
        OutputUtils.printListNode(addTwoNumbers(listNode31, listNode32));
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        /**
         * 进位
         */
        int carryBit = 0;
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        while (l1 != null || l2 != null) {
            int sum = carryBit;

            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            /**
             * 判断是否有进位
             */
            if (sum >= 10) {
                sum -= 10;
                carryBit = 1;
            } else {
                carryBit = 0;
            }

            curr.next = new ListNode(sum);
            curr = curr.next;
        }
        /**
         * 如果链表最后的数字加完后还有进位，要将进位追加到链表最后
         */
        if (carryBit == 1) {
            curr.next = new ListNode(carryBit);
        }
        return dummy.next;
    }
}