package leetcode.algorithms;

import leetcode.entity.ListNode;
import leetcode.util.ListNodeUtils;

/**
 * Description: 2130. Maximum Twin Sum of a Linked List
 *
 * @author Baltan
 * @date 2022/1/11 22:39
 */
public class PairSum {
    public static void main(String[] args) {
        ListNode head1 = ListNodeUtils.arrayToListNode(new int[]{5, 4, 2, 1});
        System.out.println(pairSum(head1));

        ListNode head2 = ListNodeUtils.arrayToListNode(new int[]{4, 2, 2, 3});
        System.out.println(pairSum(head2));

        ListNode head3 = ListNodeUtils.arrayToListNode(new int[]{1, 100000});
        System.out.println(pairSum(head3));
    }

    public static int pairSum(ListNode head) {
        int result = Integer.MIN_VALUE;
        /**
         * 按照题意，链表head最多包含100000个节点，arr用于保存链表中每个节点的值
         */
        int[] arr = new int[100000];
        int index = 0;

        while (head != null) {
            arr[index++] = head.val;
            head = head.next;
        }

        int twinsCount = index / 2;

        for (int i = 0; i < twinsCount; i++) {
            result = Math.max(result, arr[i] + arr[index - 1 - i]);
        }
        return result;
    }
}
