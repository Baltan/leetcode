package leetcode.algorithms;

import leetcode.entity.ListNode;
import leetcode.util.ListNodeUtils;
import leetcode.util.OutputUtils;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Description: 143. Reorder List
 *
 * @author Baltan
 * @date 2019-05-31 15:07
 */
public class ReorderList {
    public static void main(String[] args) {
        ListNode head1 = ListNodeUtils.arrayToListNode(new int[]{1, 2, 3, 4});
        reorderList(head1);
        OutputUtils.printListNode(head1);

        ListNode head2 = ListNodeUtils.arrayToListNode(new int[]{1, 2, 3, 4, 5});
        reorderList(head2);
        OutputUtils.printListNode(head2);

        ListNode head3 = ListNodeUtils.arrayToListNode(new int[]{1, 2});
        reorderList(head3);
        OutputUtils.printListNode(head3);

        ListNode head4 = ListNodeUtils.arrayToListNode(new int[]{1});
        reorderList(head4);
        OutputUtils.printListNode(head4);
    }

    public static void reorderList(ListNode head) {
        if (head == null) {
            return;
        }

        Deque<ListNode> queue = new ArrayDeque<>();
        /**
         * 将链表head中的节点逐一入队
         */
        while (head != null) {
            queue.offer(head);
            head = head.next;
        }
        /**
         * 是否从queue队首取出节点拼接到新链表上
         */
        boolean fromHead = true;
        ListNode currentNode = new ListNode(-1);

        while (!queue.isEmpty()) {
            if (fromHead) {
                /**
                 * 将队首的节点拼接到新链表上
                 */
                currentNode.next = queue.pollFirst();
                currentNode = currentNode.next;
                fromHead = false;
            } else {
                /**
                 * 将队尾的节点拼接到新链表上
                 */
                currentNode.next = queue.pollLast();
                currentNode = currentNode.next;
                fromHead = true;
            }
        }
        currentNode.next = null;
    }
}
