package leetcode.algorithms;

import leetcode.entity.ListNode;
import leetcode.util.ListNodeUtils;
import leetcode.util.OutputUtils;

/**
 * Description: 2074. Reverse Nodes in Even Length Groups
 *
 * @author Baltan
 * @date 2021/11/15 23:18
 */
public class ReverseEvenLengthGroups {
    public static void main(String[] args) {
        ListNode head1 = ListNodeUtils.arrayToListNode(new int[]{5, 2, 6, 3, 9, 1, 7, 3, 8, 4});
        OutputUtils.printListNode(reverseEvenLengthGroups(head1));

        ListNode head2 = ListNodeUtils.arrayToListNode(new int[]{1, 1, 0, 6});
        OutputUtils.printListNode(reverseEvenLengthGroups(head2));

        ListNode head3 = ListNodeUtils.arrayToListNode(new int[]{2, 1});
        OutputUtils.printListNode(reverseEvenLengthGroups(head3));

        ListNode head4 = ListNodeUtils.arrayToListNode(new int[]{8});
        OutputUtils.printListNode(reverseEvenLengthGroups(head4));

        ListNode head5 = ListNodeUtils.arrayToListNode(new int[]{0, 4, 2, 1, 3});
        OutputUtils.printListNode(reverseEvenLengthGroups(head5));

        ListNode head6 = ListNodeUtils.arrayToListNode(new int[]{0, 4, 2});
        OutputUtils.printListNode(reverseEvenLengthGroups(head6));

        ListNode head7 = ListNodeUtils.arrayToListNode(new int[]{1, 2, 3, 4, 5, 6});
        OutputUtils.printListNode(reverseEvenLengthGroups(head7));
    }

    public static ListNode reverseEvenLengthGroups(ListNode head) {
        ListNode dummy = new ListNode(-1);
        ListNode currNode = dummy;

        for (int currLength = 1; ; currLength++) {
            ListNode[] listNodes = cutListNode(head, currLength);

            if (listNodes[3].val % 2 == 0) {
                /**
                 * 如果截断链表的长度为偶数，需要将改部分链表翻转
                 */
                ListNode prev = reverse(listNodes[0]);
                /**
                 * 除去截断的链表外，原链表head剩余部分
                 */
                head = listNodes[2];
                /**
                 * 当前节点后拼接翻转后的截断链表
                 */
                currNode.next = prev;
                /**
                 * 当前节点指向截断链表翻转前的头节点（翻转后变成了尾结点）
                 */
                currNode = listNodes[0];
            } else {
                ListNode prev = listNodes[0];
                /**
                 * 除去截断的链表外，原链表head剩余部分
                 */
                head = listNodes[2];
                /**
                 * 当前节点后拼接截断链表
                 */
                currNode.next = prev;
                /**
                 * 当前节点指向截断链表的尾结点
                 */
                currNode = listNodes[1];
            }
            /**
             * 原链表head已被处理完
             */
            if (head == null) {
                break;
            }
        }
        return dummy.next;
    }

    /**
     * 翻转链表
     *
     * @param head
     * @return
     */
    public static ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        /**
         * 除头结点外，链表剩余的部分
         */
        ListNode tail = head.next;
        /**
         * 递归翻转链表剩余的部分
         */
        ListNode reverseTail = reverse(tail);
        /**
         * 原链表的头节点翻转后变成了最后一个节点，最后一个节点之后无其他节点
         */
        head.next = null;
        /**
         * 原链表剩余的部分的头节点翻转后变成了倒数第二个节点，后面连接原链表的头节点
         */
        tail.next = head;
        return reverseTail;
    }

    /**
     * 截断长度为length的链表，如果链表长度够长
     *
     * @param head
     * @param length
     * @return 返回链表数组依次代表：截断链表头节点、截断链表尾结点、原链表head剩余部分的头节点、截断链表长度（用一个单节点链表的值表示）
     * 例如：head = 7 - 6 - 5 - 4 - 3 - 2 - 1，
     * length = 3，
     * 则返回 [7 - 6 - 5, 5, 4 - 3 - 2 - 1, 3]
     */
    public static ListNode[] cutListNode(ListNode head, int length) {
        ListNode currNode = head;
        int cutLength = 1;

        for (int i = 1; i < length; i++) {
            /**
             * 如果当前节点后面没有其他节点，说明已到原链表head最后，无法再拼接节点
             */
            if (currNode.next == null) {
                break;
            }
            /**
             * 拼接后续节点
             */
            currNode = currNode.next;
            cutLength++;
        }
        /**
         * 除去截断的链表外，原链表head剩余部分
         */
        ListNode tail = currNode.next;
        /**
         * 当前节点指向截断的链表的最后一个节点，其后面无其他节点
         */
        currNode.next = null;
        return new ListNode[]{head, currNode, tail, new ListNode(cutLength)};
    }
}
