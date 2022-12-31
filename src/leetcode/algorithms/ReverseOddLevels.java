package leetcode.algorithms;

import leetcode.entity.TreeNode;
import leetcode.util.BinaryTreeUtils;

import java.util.*;

/**
 * Description: 2415. Reverse Odd Levels of Binary Tree
 *
 * @author Baltan
 * @date 2022/12/18 15:34
 */
public class ReverseOddLevels {
    public static void main(String[] args) {
        TreeNode root1 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{2, 3, 5, 8, 13, 21, 34}, 0);
        System.out.println(reverseOddLevels(root1));

        TreeNode root2 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{7, 13, 11}, 0);
        System.out.println(reverseOddLevels(root2));

        TreeNode root3 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{0, 1, 2, 0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2}, 0);
        System.out.println(reverseOddLevels(root3));
    }

    public static TreeNode reverseOddLevels(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        /**
         * 当前判断的是否是二叉树的奇数层，初始时为第0层
         */
        boolean isOddLevel = false;
        queue.offer(root);
        /**
         * 广度优先搜索，逐层遍历二叉树的节点
         */
        while (!queue.isEmpty()) {
            if (isOddLevel) {
                List<TreeNode> nodeList = new ArrayList<>(queue);
                /**
                 * 反转这层的所有节点值
                 */
                reverse(nodeList);
            }
            isOddLevel = !isOddLevel;
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                if (Objects.nonNull(node.left)) {
                    queue.offer(node.left);
                }

                if (Objects.nonNull(node.right)) {
                    queue.offer(node.right);
                }
            }
        }
        return root;
    }

    /**
     * 反转nodeList中所有节点的值
     *
     * @param nodeList
     */
    public static void reverse(List<TreeNode> nodeList) {
        int lo = 0;
        int hi = nodeList.size() - 1;

        while (lo < hi) {
            int temp = nodeList.get(lo).val;
            nodeList.get(lo).val = nodeList.get(hi).val;
            nodeList.get(hi).val = temp;
            lo++;
            hi--;
        }
    }
}
