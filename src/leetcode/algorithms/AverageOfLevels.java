package leetcode.algorithms;

import leetcode.entity.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * Description: 637. Average of Levels in Binary Tree
 *
 * @author Baltan
 * @date 2018/8/12 15:53
 */
public class AverageOfLevels {
    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(3);
        TreeNode node1 = new TreeNode(9);
        TreeNode node2 = new TreeNode(20);
        TreeNode node3 = new TreeNode(15);
        TreeNode node4 = new TreeNode(7);
        root1.left = node1;
        root1.right = node2;
        node2.left = node3;
        node2.right = node4;
        System.out.println(averageOfLevels(root1));

        TreeNode root2 = new TreeNode(5);
        TreeNode node5 = new TreeNode(14);
        TreeNode node6 = new TreeNode(1);
        root2.left = node5;
        node5.left = node6;
        System.out.println(averageOfLevels(root2));
    }

    public static List<Double> averageOfLevels(TreeNode root) {
        List<Double> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            long levelSum = 0;
            int levelNodeNum = queue.size();
            for (int i = 0; i < levelNodeNum; i++) {
                TreeNode current = queue.poll();
                levelSum += current.val;
                if (current.left != null) {
                    queue.add(current.left);
                }
                if (current.right != null) {
                    queue.add(current.right);
                }
            }
            if (levelNodeNum != 0) {
                list.add((double) levelSum / levelNodeNum);
            }
        }
        return list;
    }
}
