package leetcode.algorithms;

import leetcode.entity.ListNode;
import leetcode.util.ListNodeUtils;
import leetcode.util.OutputUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: 2487. Remove Nodes From Linked List
 *
 * @author Baltan
 * @date 2022/11/28 10:23
 */
public class RemoveNodes {
    public static void main(String[] args) {
        ListNode head1 = ListNodeUtils.arrayToListNode(new int[]{5, 2, 13, 3, 8});
        OutputUtils.printListNode(removeNodes(head1));

        ListNode head2 = ListNodeUtils.arrayToListNode(new int[]{1, 1, 1, 1});
        OutputUtils.printListNode(removeNodes(head2));

        ListNode head3 = ListNodeUtils.arrayToListNode(new int[]{1, 2, 3, 4, 5});
        OutputUtils.printListNode(removeNodes(head3));
    }

    public static ListNode removeNodes(ListNode head) {
        ListNode dummy = new ListNode(-1);
        ListNode result = dummy;
        /**
         * 链表head中所有节点的列表
         */
        List<ListNode> nodeList = new ArrayList<>();
        /**
         * 最终保留下来的节点
         */
        List<ListNode> reservedNodeList = new ArrayList<>();

        while (head != null) {
            nodeList.add(head);
            ListNode next = head.next;
            head.next = null;
            head = next;
        }
        /**
         * 链表head中最后一个节点肯定会被保留下来
         */
        reservedNodeList.add(nodeList.get(nodeList.size() - 1));
        /**
         * 从倒数第二个节点开始向前遍历，如果值大于等于后面一个节点的话才可能被保留下来
         */
        for (int i = nodeList.size() - 2; i >= 0; i--) {
            ListNode node = nodeList.get(i);

            if (node.val >= reservedNodeList.get(0).val) {
                reservedNodeList.add(0, node);
            }
        }
        /**
         * 最终保留下来的节点重新组装成一个链表
         */
        for (ListNode node : reservedNodeList) {
            dummy.next = node;
            dummy = dummy.next;
        }
        return result.next;
    }
}
