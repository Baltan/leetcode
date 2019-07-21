package leetcode.algorithms;

import leetcode.entity.TreeNode;

import java.util.*;

/**
 * Description: 987. Vertical Order Traversal of a Binary Tree
 *
 * @author Baltan
 * @date 2019-07-21 17:28
 */
public class VerticalTraversal2 {
    public static void main(String[] args) {
        TreeNode treeNode11 = new TreeNode(3);
        TreeNode treeNode12 = new TreeNode(9);
        TreeNode treeNode13 = new TreeNode(20);
        TreeNode treeNode14 = new TreeNode(15);
        TreeNode treeNode15 = new TreeNode(7);
        treeNode11.left = treeNode12;
        treeNode11.right = treeNode13;
        treeNode13.left = treeNode14;
        treeNode13.right = treeNode15;
        System.out.println(verticalTraversal(treeNode11));

        TreeNode treeNode21 = new TreeNode(1);
        TreeNode treeNode22 = new TreeNode(2);
        TreeNode treeNode23 = new TreeNode(3);
        TreeNode treeNode24 = new TreeNode(4);
        TreeNode treeNode25 = new TreeNode(5);
        TreeNode treeNode26 = new TreeNode(6);
        TreeNode treeNode27 = new TreeNode(7);
        treeNode21.left = treeNode22;
        treeNode21.right = treeNode23;
        treeNode22.left = treeNode24;
        treeNode22.right = treeNode25;
        treeNode23.left = treeNode26;
        treeNode23.right = treeNode27;
        System.out.println(verticalTraversal(treeNode21));

        TreeNode treeNode31 = new TreeNode(1);
        System.out.println(verticalTraversal(treeNode31));
    }

    public static List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        /**
         * xMap的key值为树节点x坐标的值，xMap中的元素按照x坐标的值从小到大排列，xMap的value值为一个TreeMap，
         * TreeMap的key值为树节点y坐标的值，TreeMap中的元素按照y坐标的值从大到小排列，TreeMap的value值为一个PriorityQueue,
         * PriorityQueue中的元素按照树节点的节点值从小到大排列
         */
        Map<Integer, Map<Integer, Queue<Integer>>> xMap = new TreeMap<>();

        help(root, 0, 0, xMap);

        for (int x : xMap.keySet()) {
            List<Integer> list = new LinkedList<>();
            Map<Integer, Queue<Integer>> yMap = xMap.get(x);

            for (int y : yMap.keySet()) {
                Queue<Integer> queue = yMap.get(y);

                while (!queue.isEmpty()) {
                    list.add(queue.poll());
                }
            }
            result.add(list);
        }
        return result;
    }

    public static void help(TreeNode root, int x, int y, Map<Integer, Map<Integer, Queue<Integer>>> xMap) {
        if (xMap.containsKey(x)) {
            Map<Integer, Queue<Integer>> yMap = xMap.get(x);

            if (yMap.containsKey(y)) {
                yMap.get(y).offer(root.val);
            } else {
                Queue<Integer> queue = new PriorityQueue<>();
                queue.offer(root.val);
                yMap.put(y, queue);
            }
        } else {
            Queue<Integer> queue = new PriorityQueue<>();
            Map<Integer, Queue<Integer>> yMap = new TreeMap<>((m, n) -> n - m);
            queue.offer(root.val);
            yMap.put(y, queue);
            xMap.put(x, yMap);
        }

        if (root.left != null) {
            help(root.left, x - 1, y - 1, xMap);
        }

        if (root.right != null) {
            help(root.right, x + 1, y - 1, xMap);
        }
    }
}
