package leetcode.algorithms;

import leetcode.entity.TreeNode;
import leetcode.util.BinaryTreeUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description: 2476. Closest Nodes Queries in a Binary Search Tree
 *
 * @author Baltan
 * @date 2022/11/21 15:40
 */
public class ClosestNodes {
    public static void main(String[] args) {
        TreeNode root1 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{6, 2, 13, 1, 4, 9, 15, null, null, null, null, null, null, 14}, 0);
        List<Integer> queries1 = Arrays.asList(2, 5, 16);
        System.out.println(closestNodes(root1, queries1));

        TreeNode root2 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{4, null, 9}, 0);
        List<Integer> queries2 = Arrays.asList(3);
        System.out.println(closestNodes(root2, queries2));

        TreeNode root3 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{4, null, 9}, 0);
        List<Integer> queries3 = Arrays.asList(3);
        System.out.println(closestNodes(root3, queries3));
    }

    public static List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        List<List<Integer>> result = new ArrayList<>(queries.size());

        for (int query : queries) {
            result.add(Arrays.asList(getSmaller(root, query), getGreater(root, query)));
        }
        return result;
    }

    /**
     * 在二叉搜索树中查找小于等于query的最大节点值
     *
     * @param node
     * @param query
     * @return
     */
    public static int getSmaller(TreeNode node, int query) {
        if (node == null) {
            return -1;
        }

        if (node.val == query) {
            return query;
        } else if (node.val < query) {
            /**
             * 在右子树中查找是否有大于node.val，并且小于等于query的节点值
             */
            int right = getSmaller(node.right, query);
            return right == -1 ? node.val : right;
        } else {
            /**
             * 在左子树中查找是否有小于等于query的节点值
             */
            int left = getSmaller(node.left, query);
            return left == -1 ? -1 : left;
        }
    }

    /**
     * 在二叉搜索树中查找大于等于query的最小节点值
     *
     * @param node
     * @param query
     * @return
     */
    public static int getGreater(TreeNode node, int query) {
        if (node == null) {
            return -1;
        }

        if (node.val == query) {
            return query;
        } else if (node.val < query) {
            /**
             * 在右子树中查找是否有大于等于query的节点值
             */
            int right = getGreater(node.right, query);
            return right == -1 ? -1 : right;
        } else {
            /**
             * 在左子树中查找是否有小于node.val，并且大于等于query的节点值
             */
            int left = getGreater(node.left, query);
            return left == -1 ? node.val : left;
        }
    }
}
