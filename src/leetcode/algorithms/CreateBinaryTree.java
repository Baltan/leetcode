package leetcode.algorithms;

import leetcode.entity.TreeNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Description: 2196. Create Binary Tree From Descriptions
 *
 * @author Baltan
 * @date 2022/3/6 22:11
 */
public class CreateBinaryTree {
    public static void main(String[] args) {
        int[][] descriptions1 = {{20, 15, 1}, {20, 17, 0}, {50, 20, 1}, {50, 80, 0}, {80, 19, 1}};
        System.out.println(createBinaryTree(descriptions1));

        int[][] descriptions2 = {{1, 2, 1}, {2, 3, 0}, {3, 4, 1}};
        System.out.println(createBinaryTree(descriptions2));
    }

    public static TreeNode createBinaryTree(int[][] descriptions) {
        int length = descriptions.length;
        /**
         * 节点值 -> 节点
         */
        Map<Integer, TreeNode> nodeMap = new HashMap<>((int) (length / 0.75 + 1));
        /**
         * 保存所有的子节点
         */
        Set<Integer> children = new HashSet<>((int) (length / 0.75 + 1));

        for (int[] description : descriptions) {
            TreeNode parent = nodeMap.computeIfAbsent(description[0], x -> new TreeNode(description[0]));
            TreeNode child = nodeMap.computeIfAbsent(description[1], x -> new TreeNode(description[1]));

            if (description[2] == 1) {
                parent.left = child;
            } else {
                parent.right = child;
            }
            children.add(description[1]);
        }
        /**
         * 遍历所有节点，不在子节点集合中的即为根节点
         */
        for (int value : nodeMap.keySet()) {
            if (!children.contains(value)) {
                return nodeMap.get(value);
            }
        }
        return null;
    }
}
