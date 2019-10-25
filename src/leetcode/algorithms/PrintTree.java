package leetcode.algorithms;

import leetcode.entity.TreeNode;
import leetcode.util.BinaryTreeUtils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Description: 655. Print Binary Tree
 *
 * @author Baltan
 * @date 2019-10-25 09:01
 */
public class PrintTree {
    public static void main(String[] args) {
        TreeNode root1 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{1, 2}, 0);
        System.out.println(printTree(root1));

        TreeNode root2 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{1, 2, 3, null, 4}, 0);
        System.out.println(printTree(root2));

        TreeNode root3 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{1, 2, 5, 3, null, null, null, 4}, 0);
        System.out.println(printTree(root3));

        TreeNode root4 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{1}, 0);
        System.out.println(printTree(root4));

        TreeNode root5 =
                BinaryTreeUtils.arrayToBinaryTree(new Integer[]{3, 1, 5, 0, 2, 4, 6, null, null, null, 3}, 0);
        System.out.println(printTree(root5));
    }

    public static List<List<String>> printTree(TreeNode root) {
        List<List<String>> result = new LinkedList<>();
        int height = getHeight(root);
        /**
         * 二维字符串数组的列数
         */
        int width = (int) (Math.pow(2, height) - 1);
        List<List<Integer>> levelList = new LinkedList<>();
        Queue<TreeNode> treeNodeQueue = new LinkedList<>();
        treeNodeQueue.offer(root);

        while (!treeNodeQueue.isEmpty() && levelList.size() < height) {
            int size = treeNodeQueue.size();
            /**
             * 将二叉树中每一层的值保存在同一个List中
             */
            List<Integer> valueList = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode node = treeNodeQueue.poll();
                valueList.add(node == null ? null : node.val);
                treeNodeQueue.offer(node == null ? null : node.left);
                treeNodeQueue.offer(node == null ? null : node.right);
            }
            levelList.add(valueList);
        }
        /**
         * 依次获得二叉树每一层的输出结果
         */
        for (int i = 0; i < height; i++) {
            List<Integer> valueList = levelList.get(i);
            result.add(distribute(valueList, width));
        }
        return result;
    }

    /**
     * 计算二叉树的高度
     *
     * @param root
     * @return
     */
    public static int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }

    /**
     * 将二叉树每一层的值分布到长度为width的数组中
     *
     * @param valueList
     * @param width
     * @return
     */
    public static List<String> distribute(List<Integer> valueList, int width) {
        List<String> result = new LinkedList<>();
        int valueCount = valueList.size();
        /**
         * 如果二叉树该层只有1个值，则该值位于长度为width的数组的正中间，两边补充等量的""；如果二叉树该层有多个值，
         * 将这些值均分为两份，左边的这些值分布在长度为width的数组的前半部分，右边的这些值分布在长度为width的数组
         * 的后半部分，数组的正中间补充""
         */
        if (valueCount == 1) {
            String value = valueList.get(0) == null ? "" : String.valueOf(valueList.get(0));
            /**
             * 两边应该补充的""的数量
             */
            int positionCountPerSide = (width - 1) >> 1;

            for (int i = 0; i < positionCountPerSide; i++) {
                result.add("");
            }

            result.add(value);

            for (int i = 0; i < positionCountPerSide; i++) {
                result.add("");
            }
        } else {
            int halfValueCount = valueCount >> 1;
            /**
             * 该层前一半值
             */
            List<Integer> leftValueList = new ArrayList<>();
            /**
             * 该层后一半值
             */
            List<Integer> rightValueList = new ArrayList<>();

            for (int i = 0; i < halfValueCount; i++) {
                leftValueList.add(valueList.get(i));
            }

            for (int i = halfValueCount; i < valueCount; i++) {
                rightValueList.add(valueList.get(i));
            }

            List<String> leftResult = distribute(leftValueList, (width - 1) >> 1);
            List<String> rightResult = distribute(rightValueList, (width - 1) >> 1);
            result.addAll(leftResult);
            result.add("");
            result.addAll(rightResult);
        }
        return result;
    }
}
