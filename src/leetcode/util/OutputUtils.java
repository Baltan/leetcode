package leetcode.util;

import leetcode.entity.*;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Description: 输出类
 *
 * @author Baltan
 * @date 2018/7/30 15:42
 */
public class OutputUtils {
    /**
     * 打印一维整型数组
     *
     * @param arr
     */
    public static void print1DIntegerArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
        System.out.println();
    }

    /**
     * 打印一维长整型数组
     *
     * @param arr
     */
    public static void print1DLongArray(long[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
        System.out.println();
    }

    /**
     * 打印一维double类型数组
     *
     * @param arr
     */
    public static void print1DDouleArray(double[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
        System.out.println();
    }

    /**
     * 打印一维字符串数组
     *
     * @param arr
     */
    public static void print1DStringArray(String[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
        System.out.println();
    }

    /**
     * 打印一维布尔类型数组
     *
     * @param arr
     */
    public static void print1DBooleanArray(boolean[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
        System.out.println();
    }

    /**
     * 打印一维ListNode（链表节点）类型数组
     *
     * @param arr
     */
    public static void print1DListNodeArray(ListNode[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == null) {
                System.out.println("null");
            } else {
                OutputUtils.printListNode(arr[i]);
            }
        }
    }

    /**
     * 打印二维整型数组
     *
     * @param arr
     */
    public static void print2DIntegerArray(int[][] arr) {
        if (arr != null) {
            int[] ele;
            for (int i = 0; i < arr.length; i++) {
                ele = arr[i];
                for (int j = 0; j < ele.length; j++) {
                    System.out.print(String.format("% 10d", ele[j]) + "\t");
                }
                System.out.println();
            }
        }
    }

    /**
     * 打印二维字符串数组
     *
     * @param arr
     */
    public static void print2DStringArray(String[][] arr) {
        if (arr != null) {
            String[] ele;
            for (int i = 0; i < arr.length; i++) {
                ele = arr[i];
                for (int j = 0; j < ele.length; j++) {
                    System.out.print(ele[j] + "\t");
                }
                System.out.println();
            }
        }
    }

    /**
     * 打印二维布尔类型数组
     *
     * @param arr
     */
    public static void print2DBooleanArray(boolean[][] arr) {
        if (arr != null) {
            boolean[] ele;
            for (int i = 0; i < arr.length; i++) {
                ele = arr[i];
                for (int j = 0; j < ele.length; j++) {
                    System.out.print(ele[j] + "\t");
                }
                System.out.println();
            }
        }
    }

    /**
     * 打印二维字符数组
     *
     * @param arr
     */
    public static void print2DCharacterArray(char[][] arr) {
        if (arr != null) {
            char[] ele;
            for (int i = 0; i < arr.length; i++) {
                ele = arr[i];
                for (int j = 0; j < ele.length; j++) {
                    System.out.print(ele[j] + "\t");
                }
                System.out.println();
            }
        }
    }

    /**
     * 打印ListNode（链表节点）
     *
     * @param listNode
     */
    public static void printListNode(ListNode listNode) {
        Set<ListNode> set = new HashSet<>();

        while (listNode != null) {
            set.add(listNode);
            System.out.format("[val=%s,next.val=%s]", listNode.val,
                    listNode.next == null ? null : listNode.next.val);
            listNode = listNode.next;

            if (listNode != null) {
                System.out.print(" ==> ");
            }

            if (set.contains(listNode)) {
                System.out.format("[val=%s,next.val=%s]", listNode.val,
                        listNode.next == null ? null : listNode.next.val);
                break;
            }
        }
        System.out.println();
    }

    /**
     * 打印前序遍历的二叉树
     *
     * @param root
     */
    public static void printPreOrderBinaryTree(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.val);
        printPreOrderBinaryTree(root.left);
        printPreOrderBinaryTree(root.right);
    }

    /**
     * 打印中序遍历的二叉树
     *
     * @param root
     */
    public static void printInOrderBinaryTree(TreeNode root) {
        if (root == null) {
            return;
        }
        printInOrderBinaryTree(root.left);
        System.out.println(root.val);
        printInOrderBinaryTree(root.right);
    }

    /**
     * 打印后序遍历的二叉树
     *
     * @param root
     */
    public static void printPostOrderBinaryTree(TreeNode root) {
        if (root == null) {
            return;
        }
        printPostOrderBinaryTree(root.left);
        printPostOrderBinaryTree(root.right);
        System.out.println(root.val);
    }

    /**
     * 打印GraphNode（无向连通图节点）
     *
     * @param node
     */
    public static void printGraphNode(GraphNode node) {
        if (node == null) {
            System.out.println();
        }

        Set<GraphNode> set = new HashSet<>();
        Queue<GraphNode> queue = new LinkedList<>();
        queue.offer(node);

        while (!queue.isEmpty()) {
            GraphNode gn = queue.poll();
            if (!set.contains(gn)) {
                set.add(gn);
                for (GraphNode neighbor : gn.neighbors) {
                    if (!set.contains(neighbor)) {
                        queue.offer(neighbor);
                    }
                }
                System.out.format("GraphNode[val=%s,neighbors=%s]", gn.val, gn.neighbors);
                System.out.println();
            }
        }
    }

    /**
     * 打印RandomNode（带有随机指针的链表节点）
     *
     * @param randomNode
     */
    public static void printRandomNode(RandomNode randomNode) {
        Set<RandomNode> set = new HashSet<>();

        while (randomNode != null) {
            set.add(randomNode);
            System.out.format("[val=%s,next.val=%s,random.val=%s]", randomNode.val,
                    randomNode.next == null ?
                            null : randomNode.next.val, randomNode.random == null ?
                            null : randomNode.random.val);
            randomNode = randomNode.next;

            if (randomNode != null) {
                System.out.print(" ==> ");
            }

            if (set.contains(randomNode)) {
                System.out.format("[val=%s,next.val=%s,random.val=%s]", randomNode.val,
                        randomNode.next == null ?
                                null : randomNode.next.val, randomNode.random == null ?
                                null : randomNode.random.val);
                break;
            }
        }
        System.out.println();
    }

    /**
     * 打印DoublyLinkedNode（多级双向链表）
     *
     * @param head
     */
    public static void printDoublyLinkedNode(DoublyLinkedNode head) {
        while (head != null) {
            String next = head.next == null ? "null" : String.valueOf(head.next.val);
            String prev = head.prev == null ? "null" : String.valueOf(head.prev.val);
            String child = head.child == null ? "null" : String.valueOf(head.child.val);
            System.out.println("val=" + head.val + ",next=" + next + ",prev=" + prev + ",child=" + child);

            if (head.child != null) {
                printDoublyLinkedNode(head.child);
            }

            head = head.next;
        }
    }
}
