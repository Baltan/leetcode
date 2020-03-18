package leetcode.algorithms;

import leetcode.entity.ListNode;
import leetcode.entity.TreeNode;
import leetcode.util.BinaryTreeUtils;
import leetcode.util.ListNodeUtils;

/**
 * Description: 1367. Linked List in Binary Tree
 *
 * @author Baltan
 * @date 2020-03-18 11:27
 */
public class IsSubPath {
    public static void main(String[] args) {
        TreeNode root1 =
                BinaryTreeUtils.arrayToBinaryTree(new Integer[]{1, 4, 4, null, 2, 2, null, null, null, 1,
                        null, 6, 8, null, null, null, null, null, null, null, null, null, null, null, null, 1,
                        3}, 0);
        ListNode head1 = ListNodeUtils.arrayToListNode(new int[]{4, 2, 8});
        System.out.println(isSubPath(head1, root1));

        TreeNode root2 =
                BinaryTreeUtils.arrayToBinaryTree(new Integer[]{1, 4, 4, null, 2, 2, null, null, null, 1,
                        null, 6, 8, null, null, null, null, null, null, null, null, null, null, null, null, 1,
                        3}, 0);
        ListNode head2 = ListNodeUtils.arrayToListNode(new int[]{1, 4, 2, 6});
        System.out.println(isSubPath(head2, root2));

        TreeNode root3 =
                BinaryTreeUtils.arrayToBinaryTree(new Integer[]{1, 4, 4, null, 2, 2, null, null, null, 1,
                        null, 6, 8, null, null, null, null, null, null, null, null, null, null, null, null, 1,
                        3}, 0);
        ListNode head3 = ListNodeUtils.arrayToListNode(new int[]{1, 4, 2, 6, 8});
        System.out.println(isSubPath(head3, root3));
    }

    public static boolean isSubPath(ListNode head, TreeNode root) {
        if (head == null) {
            return true;
        }

        if (root == null) {
            return false;
        }
        /**
         * 有三种情况可以使得二叉树root中存在一条一直向下的路径和链表head的每个节点的值一一对应：
         * 1、从二叉树root的根节点开始，存在一条一直向下的路径和链表head的每个节点的值一一对应
         * 2、二叉树root的左子树中存在一条一直向下的路径和链表head的每个节点的值一一对应
         * 3、二叉树root的右子树中存在一条一直向下的路径和链表head的每个节点的值一一对应
         */
        return isSubPathFromRoot(head, root) || isSubPath(head, root.left) || isSubPath(head, root.right);
    }

    /**
     * 从二叉树root的根节点开始，是否存在一条一直向下的路径和链表head的每个节点的值一一对应
     *
     * @param head
     * @param root
     * @return
     */
    public static boolean isSubPathFromRoot(ListNode head, TreeNode root) {
        if (head == null) {
            return true;
        }

        if (root == null) {
            return false;
        }
        /**
         * 有两种情况可以使得从二叉树root的根节点开始，存在一条一直向下的路径和链表head的每个节点的值
         * 一一对应：
         * 1、二叉树根节点的值和链表头节点值相等，并且从二叉树root的根节点的左节点开始，存在一条一直向
         * 下的路径和链表head第二个节点开始的每个节点的值一一对应
         * 2、二叉树根节点的值和链表头节点值相等，并且从二叉树root的根节点的右节点开始，存在一条一直向
         * 下的路径和链表head第二个节点开始的每个节点的值一一对应
         */
        return head.val == root.val && (isSubPathFromRoot(head.next, root.left) || isSubPathFromRoot(head.next
                , root.right));
    }
}
