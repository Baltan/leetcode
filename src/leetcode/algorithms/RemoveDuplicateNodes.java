package leetcode.algorithms;

import leetcode.entity.ListNode;
import leetcode.util.ListNodeUtils;
import leetcode.util.OutputUtils;

/**
 * Description: 面试题 02.01. 移除重复节点
 *
 * @author Baltan
 * @date 2020-03-12 01:19
 */
public class RemoveDuplicateNodes {
    public static void main(String[] args) {
        ListNode head1 = ListNodeUtils.arrayToListNode(new int[]{1, 2, 3, 3, 2, 1});
        OutputUtils.printListNode(removeDuplicateNodes(head1));

        ListNode head2 = ListNodeUtils.arrayToListNode(new int[]{1, 1, 1, 1, 2});
        OutputUtils.printListNode(removeDuplicateNodes(head2));
    }

    public static ListNode removeDuplicateNodes(ListNode head) {
        if (head == null) {
            return head;
        }
        /**
         * isVisited[i]表示值为i的节点是否出现过
         */
        boolean[] isVisited = new boolean[20001];
        /**
         * 当前处理的节点的前一个节点
         */
        ListNode prevNode = head;
        /**
         * 当前处理的节点
         */
        ListNode currNode = head.next;
        isVisited[head.val] = true;
        /**
         * 从链表第二个节点开始依次判断该节点的值之前是否出现过
         */
        while (currNode != null) {
            /**
             * 如果当前节点的值之前已经出现过，则需要移除该节点，即将该节点的前一个节点指向该节点的下一个节
             * 点
             */
            if (isVisited[currNode.val]) {
                prevNode.next = currNode.next;
                currNode = currNode.next;
            } else {
                /**
                 * 如果当前节点的值之前没有出现过，则标记该节点的值已经出现过
                 */
                isVisited[currNode.val] = true;
                prevNode = currNode;
                currNode = currNode.next;
            }
        }
        return head;
    }
}
