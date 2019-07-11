package leetcode.algorithms;

import leetcode.entity.ListNode;
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
        ListNode l11 = new ListNode(7);
        ListNode l12 = new ListNode(2);
        ListNode l13 = new ListNode(4);
        ListNode l14 = new ListNode(3);
        l11.next = l12;
        l12.next = l13;
        l13.next = l14;
        ListNode l21 = new ListNode(5);
        ListNode l22 = new ListNode(6);
        ListNode l23 = new ListNode(4);
        l21.next = l22;
        l22.next = l23;
        OutputUtils.printListNode(addTwoNumbers(l11, l21));

        ListNode l31 = new ListNode(9);
        ListNode l32 = new ListNode(9);
        ListNode l33 = new ListNode(9);
        ListNode l34 = new ListNode(9);
        l31.next = l32;
        l32.next = l33;
        l33.next = l34;
        ListNode l41 = new ListNode(2);
        OutputUtils.printListNode(addTwoNumbers(l31, l41));
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result;
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        Stack<Integer> s3 = new Stack<>();
        int num1;
        int num2;
        int carry = 0;

        while (l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        }

        while (l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }

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

        if (carry == 1) {
            s3.push(carry);
        }

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
