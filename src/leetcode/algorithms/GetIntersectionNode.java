package leetcode.algorithms;

import leetcode.entity.ListNode;

/**
 * Description: Intersection of Two Linked Lists
 *
 * @author Baltan
 * @date 2019-03-17 10:48
 */
public class GetIntersectionNode {
    public static void main(String[] args) {
        ListNode a11 = new ListNode(4);
        ListNode a12 = new ListNode(1);
        ListNode b11 = new ListNode(5);
        ListNode b12 = new ListNode(0);
        ListNode b13 = new ListNode(1);
        ListNode p11 = new ListNode(8);
        ListNode p12 = new ListNode(4);
        ListNode p13 = new ListNode(5);

        p11.next = p12;
        p12.next = p13;

        a11.next = a12;
        a12.next = p11;

        b11.next = b12;
        b12.next = b13;
        b13.next = p11;

        System.out.println(getIntersectionNode(a11, b11));

        ListNode a21 = new ListNode(0);
        ListNode a22 = new ListNode(9);
        ListNode a23 = new ListNode(1);
        ListNode b21 = new ListNode(3);
        ListNode p21 = new ListNode(2);
        ListNode p22 = new ListNode(4);

        p21.next = p22;

        a21.next = a22;
        a22.next = a23;
        a23.next = p21;

        b21.next = p21;

        System.out.println(getIntersectionNode(a21, b21));

        ListNode a31 = new ListNode(2);
        ListNode a32 = new ListNode(6);
        ListNode a33 = new ListNode(4);
        ListNode b31 = new ListNode(1);
        ListNode b32 = new ListNode(5);

        a31.next = a32;
        a32.next = a33;

        b31.next = b32;

        System.out.println(getIntersectionNode(a31, b31));
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        int lengthA = 0;
        int lengthB = 0;
        ListNode tempA = headA;
        ListNode tempB = headB;

        while (tempA != null) {
            lengthA++;
            tempA = tempA.next;
        }

        while (tempB != null) {
            lengthB++;
            tempB = tempB.next;
        }

        if (lengthA == lengthB) {
            while (headA != headB) {
                headA = headA.next;
                headB = headB.next;
            }
            return headA;
        } else if (lengthA > lengthB) {
            int difference = lengthA - lengthB;
            for (int i = 0; i < difference; i++) {
                headA = headA.next;
            }
            while (headA != headB) {
                headA = headA.next;
                headB = headB.next;
            }
            return headA;
        } else {
            int difference = lengthB - lengthA;
            for (int i = 0; i < difference; i++) {
                headB = headB.next;
            }
            while (headA != headB) {
                headA = headA.next;
                headB = headB.next;
            }
            return headA;
        }
    }
}
