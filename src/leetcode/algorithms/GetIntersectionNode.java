package leetcode.algorithms;

import leetcode.entity.ListNode;

/**
 * Description: 160. Intersection of Two Linked Lists
 *
 * @author Baltan
 * @date 2019-03-17 10:48
 * @see leetcode.interview.GetIntersectionNode
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
        a11.next = a12;
        a12.next = p11;
        b11.next = b12;
        b12.next = b13;
        b13.next = p11;
        p11.next = p12;
        p12.next = p13;
        System.out.println(getIntersectionNode(a11, b11));

        ListNode a21 = new ListNode(0);
        ListNode a22 = new ListNode(9);
        ListNode a23 = new ListNode(1);
        ListNode b21 = new ListNode(3);
        ListNode p21 = new ListNode(2);
        ListNode p22 = new ListNode(4);
        a21.next = a22;
        a22.next = a23;
        a23.next = p21;
        b21.next = p21;
        p21.next = p22;
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
        /**
         * 计算链表A的长度
         */
        while (tempA != null) {
            lengthA++;
            tempA = tempA.next;
        }
        /**
         * 计算链表B的长度
         */
        while (tempB != null) {
            lengthB++;
            tempB = tempB.next;
        }
        /**
         * 如果链表A和链表B的长度相同，就在两个链表上同步前进，直到同时走到交点或者走完链表
         */
        if (lengthA == lengthB) {
            while (headA != headB) {
                headA = headA.next;
                headB = headB.next;
            }
            return headA;
        } else if (lengthA > lengthB) {
            /**
             * 两条链表的长度差
             */
            int difference = lengthA - lengthB;
            /**
             * 较长的链表A先走difference步
             */
            for (int i = 0; i < difference; i++) {
                headA = headA.next;
            }
            /**
             * 在两个链表上同步前进，直到同时走到交点或者走完链表
             */
            while (headA != headB) {
                headA = headA.next;
                headB = headB.next;
            }
            return headA;
        } else {
            /**
             * 两条链表的长度差
             */
            int difference = lengthB - lengthA;
            /**
             * 较长的链表B先走difference步
             */
            for (int i = 0; i < difference; i++) {
                headB = headB.next;
            }
            /**
             * 在两个链表上同步前进，直到同时走到交点或者走完链表
             */
            while (headA != headB) {
                headA = headA.next;
                headB = headB.next;
            }
            return headA;
        }
    }
}
