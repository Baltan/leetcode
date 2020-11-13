package leetcode.algorithms;

import leetcode.entity.ListNode;
import leetcode.util.ListNodeUtils;
import leetcode.util.OutputUtils;

/**
 * Description: 328. Odd Even Linked List
 *
 * @author Baltan
 * @date 2019-06-21 15:43
 */
public class OddEvenList {
    public static void main(String[] args) {
        ListNode head1 = ListNodeUtils.arrayToListNode(new int[]{1, 2, 3, 4, 5});
        OutputUtils.printListNode(oddEvenList(head1));

        ListNode head2 = ListNodeUtils.arrayToListNode(new int[]{2, 1, 3, 5, 6, 4, 7});
        OutputUtils.printListNode(oddEvenList(head2));

        ListNode head3 = ListNodeUtils.arrayToListNode(new int[]{1});
        OutputUtils.printListNode(oddEvenList(head3));

        ListNode head4 = ListNodeUtils.arrayToListNode(new int[]{1, 4});
        OutputUtils.printListNode(oddEvenList(head4));

        ListNode head5 = ListNodeUtils.arrayToListNode(new int[]{});
        OutputUtils.printListNode(oddEvenList(head5));
    }

    public static ListNode oddEvenList(ListNode head) {
        /**
         * 奇数节点链表头节点
         */
        ListNode oddHead = new ListNode(-1);
        /**
         * 偶数节点链表头节点
         */
        ListNode evenHead = new ListNode(-1);
        /**
         * 奇数节点链表
         */
        ListNode oddNode = oddHead;
        /**
         * 偶数节点链表
         */
        ListNode evenNode = evenHead;
        /**
         * 原链表当前处理到的节点
         */
        ListNode currNode = head;
        /**
         * 当前节点在原链表中是否是奇数节点
         */
        boolean isOdd = true;

        while (currNode != null) {
            if (isOdd) {
                /**
                 * 拼接奇数链表
                 */
                oddNode.next = currNode;
                oddNode = oddNode.next;
            } else {
                /**
                 * 拼接偶数链表
                 */
                evenNode.next = currNode;
                evenNode = evenNode.next;
            }
            currNode = currNode.next;
            isOdd = !isOdd;
        }
        /**
         * 将偶数链表拼接到奇数链表后面
         */
        oddNode.next = evenHead.next;
        /**
         * 删除新链表最后多余的节点
         */
        evenNode.next = null;
        return oddHead.next;
    }
}
