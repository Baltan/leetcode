package leetcode.algorithms;

import leetcode.entity.ListNode;
import leetcode.util.ListNodeUtils;
import leetcode.util.OutputUtils;

/**
 * Description: 2807. Insert Greatest Common Divisors in Linked List
 *
 * @author baltan
 * @date 2023/8/9 12:27
 */
public class InsertGreatestCommonDivisors {
    public static void main(String[] args) {
        OutputUtils.printListNode(insertGreatestCommonDivisors(ListNodeUtils.arrayToListNode(new int[]{18, 6, 10, 3})));
        OutputUtils.printListNode(insertGreatestCommonDivisors(ListNodeUtils.arrayToListNode(new int[]{7})));
    }

    public static ListNode insertGreatestCommonDivisors(ListNode head) {
        if (head.next == null) {
            return head;
        }
        /**
         * 相邻的两个节点中后面的节点
         */
        ListNode slow = head;
        /**
         * 相邻的两个节点中前面的节点
         */
        ListNode fast = head.next;

        while (fast != null) {
            /**
             * 相邻的两个节点中间要插入的节点
             */
            ListNode mid = new ListNode(gcd(slow.val, fast.val));
            slow.next = mid;
            mid.next = fast;
            /**
             * 移动快慢指针到下一组相邻的节点
             */
            fast = fast.next;
            slow = mid.next;
        }
        return head;
    }

    /**
     * 求x和y的最大公约数
     *
     * @param x
     * @param y
     * @return
     */
    public static int gcd(int x, int y) {
        int max = Math.max(x, y);
        int min = Math.min(x, y);

        while (max % min != 0) {
            int remainder = max % min;
            max = min;
            min = remainder;
        }
        return min;
    }
}
