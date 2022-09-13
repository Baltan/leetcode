package leetcode.algorithms;

import leetcode.entity.ListNode;
import leetcode.util.ListNodeUtils;
import leetcode.util.OutputUtils;

/**
 * Description: 1669. Merge In Between Linked Lists
 *
 * @author Baltan
 * @date 2022/9/6 09:40
 */
public class MergeInBetween {
    public static void main(String[] args) {
        ListNode list11 = ListNodeUtils.arrayToListNode(new int[]{0, 1, 2, 3, 4, 5});
        int a1 = 3;
        int b1 = 4;
        ListNode list21 = ListNodeUtils.arrayToListNode(new int[]{1000000, 1000001, 1000002});
        OutputUtils.printListNode(mergeInBetween(list11, a1, b1, list21));

        ListNode list12 = ListNodeUtils.arrayToListNode(new int[]{0, 1, 2, 3, 4, 5, 6});
        int a2 = 2;
        int b2 = 5;
        ListNode list22 =
                ListNodeUtils.arrayToListNode(new int[]{1000000, 1000001, 1000002, 1000003, 1000004});
        OutputUtils.printListNode(mergeInBetween(list12, a2, b2, list22));
    }

    public static ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode head = list1;
        /**
         * list1的第a个节点的前一个节点
         */
        ListNode beforeA = list1;
        /**
         * list1的第b个节点的后一个节点
         */
        ListNode afterB = list1;
        /**
         * list2的最后一个节点
         */
        ListNode lastNode = list2;
        /**
         * 查找list1的第a个节点的前一个节点
         */
        for (int i = a - 1; i > 0; i--) {
            beforeA = beforeA.next;
        }
        /**
         * 查找list1的第b个节点的后一个节点
         */
        for (int i = b + 1; i > 0; i--) {
            afterB = afterB.next;
        }
        /**
         * 查找list2的最后一个节点
         */
        while (lastNode.next != null) {
            lastNode = lastNode.next;
        }
        /**
         * 将list2连接到节点beforeA后面
         */
        beforeA.next = list2;
        /**
         * 将节点afterB连接到节点lastNode后面
         */
        lastNode.next = afterB;
        return head;
    }
}
