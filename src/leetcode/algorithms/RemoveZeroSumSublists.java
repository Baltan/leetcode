package leetcode.algorithms;

import leetcode.entity.ListNode;
import leetcode.util.ListNodeUtils;
import leetcode.util.OutputUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: 1171. Remove Zero Sum Consecutive Nodes from Linked List
 *
 * @author Baltan
 * @date 2019-08-27 10:40
 */
public class RemoveZeroSumSublists {
    public static void main(String[] args) {
        ListNode head1 = ListNodeUtils.arrayToListNode(new int[]{1, 2, -3, 3, 1});
        OutputUtils.printListNode(removeZeroSumSublists(head1));

        ListNode head2 = ListNodeUtils.arrayToListNode(new int[]{1, 2, 3, -3, 4});
        OutputUtils.printListNode(removeZeroSumSublists(head2));

        ListNode head3 = ListNodeUtils.arrayToListNode(new int[]{1, 2, 3, -3, -2});
        OutputUtils.printListNode(removeZeroSumSublists(head3));

        ListNode head4 = ListNodeUtils.arrayToListNode(new int[]{0});
        OutputUtils.printListNode(removeZeroSumSublists(head4));
    }

    public static ListNode removeZeroSumSublists(ListNode head) {
        /**
         * 在链表头上追加一个值为0的头节点，当原链表头部若干节点值的和为0的时候，这些节点可以被删除
         */
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        /**
         * 到某个节点为止的前缀和作为key，该节点作为value
         */
        Map<Integer, ListNode> map = new HashMap<>();
        ListNode temp = dummy;
        /**
         * 到某个节点为止的前缀和
         */
        int prefixSum = 0;

        while (temp != null) {
            /**
             * 到当前节点为止的前缀和
             */
            prefixSum += temp.val;
            /**
             * 如果之前已经存在某个前缀和与当前前缀和相等，则之前前缀和对应的节点之后直到该节点（包含该节点）为止的所有
             * 节点的值的和为0，这些节点都可以被删除，否则就将当前前缀和与当前节点加入map中做记录
             * 例如：
             * [1, 2, 3, -3, -2]前缀和为[1, 3, 6, 3, 1]，第3、4个节点可以被删除
             * [1, 2, -3, 3, 1]前缀和为[1, 3, 0, 3, 4]，第0、1、2个节点可以被删除（因为头部追加了的值为0的节点）
             */
            if (map.containsKey(prefixSum)) {
                map.get(prefixSum).next = temp.next;
            } else {
                map.put(prefixSum, temp);
            }
            temp = temp.next;
        }
        return dummy.next;
    }
}
