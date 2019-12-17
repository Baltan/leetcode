package leetcode.algorithms;

import leetcode.entity.ListNode;
import leetcode.util.ListNodeUtils;
import leetcode.util.OutputUtils;

/**
 * Description: 725. Split Linked List in Parts
 *
 * @author Baltan
 * @date 2019-08-04 11:20
 */
public class SplitListToParts {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3};
        ListNode root1 = ListNodeUtils.arrayToListNode(arr1);
        OutputUtils.print1DListNodeArray(splitListToParts(root1, 5));

        System.out.println("------------------------------------------------------------");

        int[] arr2 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        ListNode root2 = ListNodeUtils.arrayToListNode(arr2);
        OutputUtils.print1DListNodeArray(splitListToParts(root2, 3));

        System.out.println("------------------------------------------------------------");

        int[] arr3 = {};
        ListNode root3 = ListNodeUtils.arrayToListNode(arr3);
        OutputUtils.print1DListNodeArray(splitListToParts(root3, 3));
    }

    public static ListNode[] splitListToParts(ListNode root, int k) {
        ListNode[] result = new ListNode[k];
        int length = 0;
        ListNode temp = root;
        /**
         * 计算链表长度
         */
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        /**
         * 数组后面部分链表的长度（短链表）
         */
        int lastLength = length / k;
        /**
         * 数组前面部分链表的长度（长链表）
         */
        int firstLength = lastLength + 1;
        /**
         * 长链表的数量
         */
        int firstLengthCount = length - lastLength * k;
        /**
         * 短链表的数量
         */
        int lastLengthCount = k - firstLengthCount;
        /**
         * 获得所有长链表
         */
        for (int i = 0; i < firstLengthCount; i++) {
            if (firstLength == 0) {
                result[i] = null;
            } else {
                temp = root;

                for (int j = 0; j < firstLength - 1; j++) {
                    temp = temp.next;
                }

                ListNode tail = temp.next;
                temp.next = null;
                result[i] = root;
                root = tail;
            }
        }
        /**
         * 获得所有短链表
         */
        for (int i = 0; i < lastLengthCount; i++) {
            if (lastLength == 0) {
                result[i + firstLengthCount] = null;
            } else {
                temp = root;

                for (int j = 0; j < lastLength - 1; j++) {
                    temp = temp.next;
                }

                ListNode tail = temp.next;
                temp.next = null;
                result[i + firstLengthCount] = root;
                root = tail;
            }
        }
        return result;
    }
}
