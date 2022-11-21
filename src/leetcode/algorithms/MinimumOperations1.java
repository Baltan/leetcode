package leetcode.algorithms;

import leetcode.entity.TreeNode;
import leetcode.util.BinaryTreeUtils;

import java.util.*;

/**
 * Description: 2471. Minimum Number of Operations to Sort a Binary Tree by Level
 *
 * @author Baltan
 * @date 2022/11/19 11:10
 */
public class MinimumOperations1 {
    public static void main(String[] args) {
        TreeNode root1 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{1, 4, 3, 7, 6, 8, 5, null, null, null, null, 9, null, 10}, 0);
        System.out.println(minimumOperations(root1));

        TreeNode root2 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{1, 3, 2, 7, 6, 5, 4}, 0);
        System.out.println(minimumOperations(root2));

        TreeNode root3 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{1, 2, 3, 4, 5, 6}, 0);
        System.out.println(minimumOperations(root3));
    }

    public static int minimumOperations(TreeNode root) {
        int result = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            /**
             * 保存当前一层节点从左至右遍历的值
             */
            List<Integer> originalList = new ArrayList<>(size);
            /**
             * 当前一层某个节点值i -> 节点值在originalList中的索引值
             */
            HashMap<Integer, Integer> originalValueIndexMap = new HashMap<>();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                originalList.add(node.val);
                originalValueIndexMap.put(node.val, i);

                if (Objects.nonNull(node.left)) {
                    queue.offer(node.left);
                }

                if (Objects.nonNull(node.right)) {
                    queue.offer(node.right);
                }
            }
            /**
             * 当前一层节点最终正确的位置
             */
            List<Integer> sortedList = new ArrayList<>(originalList);
            Collections.sort(sortedList);
            /**
             * 从左至右逐一判断当前一层每个节点上的值是否位置正确
             */
            for (int i = 0; i < size; i++) {
                /**
                 * 当前位置的值
                 */
                int currNum = originalList.get(i);
                /**
                 * 最终状态下这个位置的正确值
                 */
                int rightNum = sortedList.get(i);

                if (Objects.equals(currNum, rightNum)) {
                    continue;
                }
                /**
                 * 正确值当前所在的索引位置
                 */
                int swapIndex = originalValueIndexMap.get(rightNum);
                /**
                 * 交换当前位置的值和最终这个位置的正确值
                 */
                originalList.set(i, rightNum);
                originalList.set(swapIndex, currNum);
                originalValueIndexMap.put(rightNum, i);
                originalValueIndexMap.put(currNum, swapIndex);
                result++;
            }
        }
        return result;
    }
}
