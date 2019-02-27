package leetcode.util;

import leetcode.entity.ListNode;
import leetcode.entity.TreeNode;

/**
 * Description: 输出类
 *
 * @author Baltan
 * @date 2018/7/30 15:42
 */
public class OutputUtils {

    public static void print1DIntegerArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
        System.out.println();
    }

    public static void print1DStringArray(String[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
        System.out.println();
    }

    public static void print2DIntegerArray(int[][] arr) {
        if (arr != null) {
            int[] ele;
            for (int i = 0; i < arr.length; i++) {
                ele = arr[i];
                for (int j = 0; j < ele.length; j++) {
                    System.out.print(ele[j] + "\t");
                }
                System.out.println();
            }
        }
    }

    public static void printListNode(ListNode listNode) {
        if (listNode != null) {
            System.out.print(listNode.val + "\t");
            while (listNode.next != null) {
                System.out.print(listNode.next.val + "\t");
                listNode = listNode.next;
            }
            System.out.println();
        }
    }

    public static void printPreOrderBinaryTree(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.val);
        printPreOrderBinaryTree(root.left);
        printPreOrderBinaryTree(root.right);
    }
}
