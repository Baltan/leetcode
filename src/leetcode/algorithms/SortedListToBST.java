package leetcode.algorithms;

import leetcode.entity.ListNode;
import leetcode.entity.TreeNode;
import leetcode.util.BinaryTreeUtils;

/**
 * Description: 109. Convert Sorted List to Binary Search Tree
 *
 * @author Baltan
 * @date 2019-05-24 09:12
 */
public class SortedListToBST {
    public static void main(String[] args) {
        ListNode listNode11 = new ListNode(-10);
        ListNode listNode12 = new ListNode(-3);
        ListNode listNode13 = new ListNode(0);
        ListNode listNode14 = new ListNode(5);
        ListNode listNode15 = new ListNode(9);
        listNode11.next = listNode12;
        listNode12.next = listNode13;
        listNode13.next = listNode14;
        listNode14.next = listNode15;
        TreeNode treeNode1 = sortedListToBST(listNode11);
        System.out.println(BinaryTreeUtils.recursivelyPreOrder(treeNode1));
        System.out.println(BinaryTreeUtils.recursivelyInOrder(treeNode1));
        System.out.println(BinaryTreeUtils.recursivelyPostOrder(treeNode1));
    }

    public static TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }

        if (head.next == null) {
            return new TreeNode(head.val);
        }

        ListNode fast = head;
        ListNode slow = head;
        ListNode node = new ListNode(0);
        node.next = head;

        while (fast != null && fast.next != null) {
            node = node.next;
            slow = slow.next;
            fast = fast.next.next;
        }

        TreeNode root = new TreeNode(slow.val);
        root.right = sortedListToBST(slow.next);
        node.next = null;
        root.left = sortedListToBST(head);
        return root;
    }
}
