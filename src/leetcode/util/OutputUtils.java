package leetcode.util;

import leetcode.entity.GraphNode;
import leetcode.entity.ListNode;
import leetcode.entity.RandomNode;
import leetcode.entity.TreeNode;

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

    public static void print1DBooleanArray(boolean[] arr) {
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

    public static void printPreOrderBinaryTree(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.val);
        printPreOrderBinaryTree(root.left);
        printPreOrderBinaryTree(root.right);
    }

    public static void printInOrderBinaryTree(TreeNode root) {
        if (root == null) {
            return;
        }
        printInOrderBinaryTree(root.left);
        System.out.println(root.val);
        printInOrderBinaryTree(root.right);
    }

    public static void printPostOrderBinaryTree(TreeNode root) {
        if (root == null) {
            return;
        }
        printPostOrderBinaryTree(root.left);
        printPostOrderBinaryTree(root.right);
        System.out.println(root.val);
    }

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
}
