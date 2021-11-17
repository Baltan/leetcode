package leetcode.algorithms;

import leetcode.entity.ListNode;
import leetcode.util.ListNodeUtils;
import leetcode.util.OutputUtils;

/**
 * Description: 2058. Find the Minimum and Maximum Number of Nodes Between Critical Points
 *
 * @author Baltan
 * @date 2021/11/17 17:54
 */
public class NodesBetweenCriticalPoints {
    public static void main(String[] args) {
        ListNode head1 = ListNodeUtils.arrayToListNode(new int[]{3, 1});
        OutputUtils.print1DIntegerArray(nodesBetweenCriticalPoints(head1));

        ListNode head2 = ListNodeUtils.arrayToListNode(new int[]{5, 3, 1, 2, 5, 1, 2});
        OutputUtils.print1DIntegerArray(nodesBetweenCriticalPoints(head2));

        ListNode head3 = ListNodeUtils.arrayToListNode(new int[]{1, 3, 2, 2, 3, 2, 2, 2, 7});
        OutputUtils.print1DIntegerArray(nodesBetweenCriticalPoints(head3));

        ListNode head4 = ListNodeUtils.arrayToListNode(new int[]{2, 3, 3, 2});
        OutputUtils.print1DIntegerArray(nodesBetweenCriticalPoints(head4));
    }

    public static int[] nodesBetweenCriticalPoints(ListNode head) {
        /**
         * 如果链表没有节点或只存在一个节点，则临界点数量肯定少于2
         */
        if (head == null || head.next == null) {
            return new int[]{-1, -1};
        }

        int[] result = {Integer.MAX_VALUE, Integer.MIN_VALUE};
        /**
         * 第一个临界点的索引位置
         */
        int firstIndex = -1;
        /**
         * 最后一个临界点的索引位置
         */
        int lastIndex = -1;
        /**
         * 对当前节点来说前一个临界点的索引位置
         */
        int prevIndex = -1;
        /**
         * 当前节点的索引位置
         */
        int currIndex = 0;
        /**
         * 当前节点前一个节点的值
         */
        int prevValue = head.val;
        head = head.next;
        /**
         * 从第二个节点（即索引为1）的节点开始逐一判断，直到倒数第二个节点
         */
        while (head != null && head.next != null) {
            currIndex++;
            /**
             * 如果当前节点是一个临界点
             */
            if ((head.val > prevValue && head.val > head.next.val) ||
                    (head.val < prevValue && head.val < head.next.val)) {
                lastIndex = currIndex;

                if (firstIndex == -1) {
                    /**
                     * 更新第一个临界点的索引位置
                     */
                    firstIndex = currIndex;
                } else {
                    /**
                     * 更新两个不同临界点之间的最小距离
                     */
                    result[0] = Math.min(result[0], currIndex - prevIndex);
                }

                prevIndex = currIndex;
            }

            prevValue = head.val;
            head = head.next;
        }
        /**
         * 如果不存在临界点或者第一个临界点和最后一个临界点是同一个临界点（即只存在1个临界点）
         */
        if (firstIndex == -1 || firstIndex == lastIndex) {
            return new int[]{-1, -1};
        }
        /**
         * 更新两个不同临界点之间的最大距离
         */
        result[1] = lastIndex - firstIndex;
        return result;
    }
}
