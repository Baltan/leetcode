package leetcode.algorithms;

import leetcode.entity.ListNode;
import leetcode.util.ListNodeUtils;
import leetcode.util.OutputUtils;

import java.util.Objects;

/**
 * Description: 23. Merge k Sorted Lists
 *
 * @author Baltan
 * @date 2020-04-27 16:47
 * @see MergeKLists
 */
public class MergeKLists1 {
    public static void main(String[] args) {
        ListNode head1 = ListNodeUtils.arrayToListNode(new int[]{1, 4, 5});
        ListNode head2 = ListNodeUtils.arrayToListNode(new int[]{1, 3, 4});
        ListNode head3 = ListNodeUtils.arrayToListNode(new int[]{1, 2, 6});
        OutputUtils.printListNode(mergeKLists(new ListNode[]{head1, head2, head3}));
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        int length = lists.length;
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;

        while (true) {
            /**
             * 剩下所有链表中头节点的最小值所在链表的索引
             */
            int minIndex = -1;
            /**
             * 剩下所有链表中头节点的最小值
             */
            int minValue = Integer.MAX_VALUE;
            /**
             * 获取剩下所有链表中头节点的最小值
             */
            for (int i = 0; i < length; i++) {
                if (Objects.nonNull(lists[i])) {
                    if (lists[i].val < minValue) {
                        minValue = lists[i].val;
                        minIndex = i;
                    }
                }
            }
            /**
             * 找到了值最小的节点，追加到dummy链表最后
             */
            if (minIndex != -1) {
                temp.next = new ListNode(minValue);
                temp = temp.next;
                lists[minIndex] = lists[minIndex].next;
            } else {
                /**
                 * 如果没有找到值最小的节点，说明所有链表都已经遍历到最后了
                 */
                break;
            }
        }
        return dummy.next;
    }
}
