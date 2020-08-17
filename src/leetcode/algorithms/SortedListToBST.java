package leetcode.algorithms;

import leetcode.entity.ListNode;
import leetcode.entity.TreeNode;
import leetcode.util.ListNodeUtils;

/**
 * Description: 109. Convert Sorted List to Binary Search Tree
 *
 * @author Baltan
 * @date 2019-05-24 09:12
 */
public class SortedListToBST {
    public static void main(String[] args) {
        ListNode head1 = ListNodeUtils.arrayToListNode(new int[]{-10, -3, 0, 5, 9});
        System.out.println(sortedListToBST(head1));
    }

    public static TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }

        if (head.next == null) {
            return new TreeNode(head.val);
        }
        /**
         * 双指针查找链表中间的节点
         */
        ListNode fast = head;
        ListNode slow = head;
        /**
         * node指针比slow指针慢一步，即当slow最终指向链表中间的节点时，node指向前半段链表的最后一个节点
         */
        ListNode node = new ListNode(0);
        node.next = head;

        while (fast != null && fast.next != null) {
            node = node.next;
            slow = slow.next;
            fast = fast.next.next;
        }
        /**
         * 链表中间的节点成为二叉搜索树的根节点
         */
        TreeNode root = new TreeNode(slow.val);
        /**
         * slow之后的链表递归生成右子树
         */
        root.right = sortedListToBST(slow.next);
        /**
         * 截取前半段链表
         */
        node.next = null;
        /**
         * 前半段链表递归生成左子树
         */
        root.left = sortedListToBST(head);
        return root;
    }
}
