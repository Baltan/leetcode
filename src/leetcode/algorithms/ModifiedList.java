package leetcode.algorithms;

import leetcode.entity.ListNode;
import leetcode.util.ListNodeUtils;
import leetcode.util.OutputUtils;

/**
 * Description: 3217. Delete Nodes From Linked List Present in Array
 *
 * @author Baltan
 * @date 2024/7/14 19:13
 */
public class ModifiedList {
    public static void main(String[] args) {
        ListNode head1 = ListNodeUtils.arrayToListNode(new int[]{1, 2, 3, 4, 5});
        OutputUtils.printListNode(modifiedList(new int[]{1, 2, 3}, head1));

        ListNode head2 = ListNodeUtils.arrayToListNode(new int[]{1, 2, 1, 2, 1, 2});
        OutputUtils.printListNode(modifiedList(new int[]{1}, head2));

        ListNode head3 = ListNodeUtils.arrayToListNode(new int[]{1, 2, 3, 4});
        OutputUtils.printListNode(modifiedList(new int[]{5}, head3));

        ListNode head4 = ListNodeUtils.arrayToListNode(new int[]{2, 10, 9});
        OutputUtils.printListNode(modifiedList(new int[]{9, 2, 5}, head4));
    }

    public static ListNode modifiedList(int[] nums, ListNode head) {
        /**
         * isVisited[i]表示数组nums中是否存在数字i，根据题意，i∈[1,100000]
         */
        boolean[] isVisited = new boolean[100001];
        ListNode dummy = new ListNode(0);
        ListNode node = dummy;

        for (int num : nums) {
            isVisited[num] = true;
        }
        /**
         * 按顺序查找链表head中，值不在数组nums中的节点，拼接到节点node之后
         */
        while (head != null) {
            if (!isVisited[head.val]) {
                node.next = head;
                node = node.next;
                head = head.next;
                node.next = null;
            } else {
                head = head.next;
            }
        }
        return dummy.next;
    }
}
