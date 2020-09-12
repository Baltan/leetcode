package leetcode.algorithms;

import leetcode.entity.TreeNode;
import leetcode.util.BinaryTreeUtils;

import java.util.*;

/**
 * Description: 637. Average of Levels in Binary Tree
 *
 * @author Baltan
 * @date 2018/8/12 15:53
 */
public class AverageOfLevels {
    public static void main(String[] args) {
        TreeNode root1 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{3, 9, 20, null, null, 15, 7}, 0);
        System.out.println(averageOfLevels(root1));

        TreeNode root2 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{5, 14, 1}, 0);
        System.out.println(averageOfLevels(root2));
    }

    public static List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            /**
             * 该层所有节点的和
             */
            long sum = 0;
            /**
             * 该层的节点数
             */
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                sum += node.val;

                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            if (size != 0) {
                result.add((double) sum / size);
            }
        }
        return result;
    }
}
