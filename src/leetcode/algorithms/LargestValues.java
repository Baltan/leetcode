package leetcode.algorithms;

import leetcode.entity.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * Description: 515. Find Largest Value in Each Tree Row
 *
 * @author Baltan
 * @date 2018/8/12 19:01
 */
public class LargestValues {
    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(5);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(9);
        root1.left = node1;
        root1.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.right = node5;
        System.out.println(largestValues(root1));

        TreeNode root2 = new TreeNode(1);
        TreeNode node6 = new TreeNode(2);
        root2.right = node6;
        System.out.println(largestValues(root2));
    }

    public static List<Integer> largestValues(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int queueLength = queue.size();
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < queueLength; i++) {
                TreeNode node = queue.poll();
                max = max > node.val ? max : node.val;
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            list.add(max);
        }
        return list;
    }
}
