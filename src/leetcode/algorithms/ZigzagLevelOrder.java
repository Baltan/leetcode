package leetcode.algorithms;

import leetcode.entity.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Description: 103. Binary Tree Zigzag Level Order Traversal
 *
 * @author Baltan
 * @date 2019-05-23 10:20
 */
public class ZigzagLevelOrder {
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
        System.out.println(zigzagLevelOrder(treeNode11));

        TreeNode treeNode21 = new TreeNode(1);
        TreeNode treeNode22 = new TreeNode(2);
        TreeNode treeNode23 = new TreeNode(3);
        TreeNode treeNode24 = new TreeNode(4);
        TreeNode treeNode25 = new TreeNode(5);
        TreeNode treeNode26 = new TreeNode(6);
        TreeNode treeNode27 = new TreeNode(7);
        TreeNode treeNode28 = new TreeNode(8);
        TreeNode treeNode29 = new TreeNode(9);
        treeNode21.left = treeNode22;
        treeNode21.right = treeNode23;
        treeNode22.left = treeNode24;
        treeNode22.right = treeNode25;
        treeNode23.left = treeNode26;
        treeNode23.right = treeNode27;
        treeNode24.left = treeNode28;
        treeNode27.left = treeNode29;
        System.out.println(zigzagLevelOrder(treeNode21));

        TreeNode treeNode31 = new TreeNode(1);
        System.out.println(zigzagLevelOrder(treeNode31));

        TreeNode treeNode41 = new TreeNode(1);
        TreeNode treeNode42 = new TreeNode(2);
        treeNode41.left = treeNode42;
        System.out.println(zigzagLevelOrder(treeNode41));
    }

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();

        if (root == null) {
            return result;
        }

        Deque<TreeNode> queue = new LinkedList<>();
        boolean flag = true;

        queue.addLast(root);

        while (!queue.isEmpty()) {
            List<Integer> list = new LinkedList<>();
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                if (flag) {
                    TreeNode node = queue.removeFirst();
                    if (node != null) {
                        list.add(node.val);
                        if (node.left != null) {
                            queue.addLast(node.left);
                        }
                        if (node.right != null) {
                            queue.addLast(node.right);
                        }
                    }
                } else {
                    TreeNode node = queue.removeLast();
                    if (node != null) {
                        list.add(node.val);
                        if (node.right != null) {
                            queue.addFirst(node.right);
                        }
                        if (node.left != null) {
                            queue.addFirst(node.left);
                        }
                    }
                }

                if (i == size - 1) {
                    flag = !flag;
                    result.add(list);
                }
            }
        }
        return result;
    }
}
