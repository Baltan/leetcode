package leetcode.algorithms;

import leetcode.entity.ListNode;
import leetcode.util.ListNodeUtils;
import leetcode.util.OutputUtils;

import java.util.Stack;

/**
 * Description: 445. Add Two Numbers II
 *
 * @author Baltan
 * @date 2019-07-11 10:17
 */
public class AddTwoNumbers1 {
    public static void main(String[] args) {
        ListNode l11 = ListNodeUtils.arrayToListNode(new int[]{7, 2, 4, 3});
        ListNode l12 = ListNodeUtils.arrayToListNode(new int[]{5, 6, 4});
        OutputUtils.printListNode(addTwoNumbers(l11, l12));

        ListNode l21 = ListNodeUtils.arrayToListNode(new int[]{9, 9, 9, 9});
        ListNode l22 = ListNodeUtils.arrayToListNode(new int[]{2});
        OutputUtils.printListNode(addTwoNumbers(l21, l22));
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result;
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        Stack<Integer> s3 = new Stack<>();
        int num1;
        int num2;
        /**
         * 进位值
         */
        int carry = 0;
        /**
         * 将l1的数字逐一入栈，最低位位于栈顶
         */
        while (l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        }
        /**
         * 将l2的数字逐一入栈，最低位位于栈顶
         */
        while (l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }
        /**
         * 从低位开始将s1和s2的数字一起出栈进行求和，如果某一个栈中已经没有数字了，看做栈顶数字为0，将求
         * 和结果再入栈
         */
        while (!s1.isEmpty() || !s2.isEmpty()) {
            num1 = s1.isEmpty() ? 0 : s1.pop();
            num2 = s2.isEmpty() ? 0 : s2.pop();

            if (num1 + num2 + carry >= 10) {
                s3.push(num1 + num2 + carry - 10);
                carry = 1;
            } else {
                s3.push(num1 + num2 + carry);
                carry = 0;
            }
        }
        /**
         * 如果最高位求和完后还有进位，也要入栈
         */
        if (carry == 1) {
            s3.push(carry);
        }
        /**
         * 将s3中的数字逐一出栈连成一个新的链表
         */
        result = new ListNode(s3.pop());
        ListNode temp = result;

        while (!s3.isEmpty()) {
            ListNode node = new ListNode(s3.pop());
            temp.next = node;
            temp = node;
        }
        return result;
    }
}
