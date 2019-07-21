package leetcode.algorithms;

import leetcode.entity.TreeNode;

import java.util.*;

/**
 * Description: 987. Vertical Order Traversal of a Binary Tree
 *
 * @author Baltan
 * @date 2019-07-21 17:28
 */
public class VerticalTraversal1 {
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
         * map的key值为树节点x坐标的值，map中的元素按照x坐标的值从小到大排列，
         * map的value值为一个链表，链表中保存的数组有两个元素，
         * 第一个元素为树节点的y坐标值，第二个元素为树节点的节点值
         */
        Map<Integer, List<int[]>> map = new TreeMap<>();

        help(root, 0, 0, map);

        for (int x : map.keySet()) {
            List<int[]> arrays = map.get(x);
            List<Integer> list = new LinkedList<>();
            /**
             * 将链表中的元素排序，按照y坐标值由大到小排列，若y坐标值相同，则按照树节点的节点值从小到大排列
             */
            Collections.sort(arrays, (m, n) -> {
                if (m[0] != n[0]) {
                    return n[0] - m[0];
                } else {
                    return m[1] - n[1];
                }
            });

            for (int[] array : arrays) {
                list.add(array[1]);
            }
            result.add(list);
        }
        return result;
    }

    public static void help(TreeNode root, int x, int y, Map<Integer, List<int[]>> map) {
        if (map.containsKey(x)) {
            map.get(x).add(new int[]{y, root.val});
        } else {
            List<int[]> list = new LinkedList<>();
            list.add(new int[]{y, root.val});
            map.put(x, list);
        }

        if (root.left != null) {
            help(root.left, x - 1, y - 1, map);
        }

        if (root.right != null) {
            help(root.right, x + 1, y - 1, map);
        }
    }
}
