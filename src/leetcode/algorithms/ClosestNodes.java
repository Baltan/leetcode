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
    }

    public static List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        List<List<Integer>> result = new ArrayList<>(queries.size());
        List<Integer> inOrder = new ArrayList<>();
        inOrder(root, inOrder);

        for (int query : queries) {
            result.add(Arrays.asList(getSmaller(inOrder, query), getGreater(inOrder, query)));
        }
        return result;
    }

    /**
     * 中序遍历二叉搜索树
     *
     * @param root
     * @param inOrder
     */
    public static void inOrder(TreeNode root, List<Integer> inOrder) {
        if (root == null) {
            return;
        }
        inOrder(root.left, inOrder);
        inOrder.add(root.val);
        inOrder(root.right, inOrder);
    }

    /**
     * 在升序数组inOrder中二分查找小于等于query的最大值
     *
     * @param inOrder
     * @param query
     * @return
     */
    public static int getSmaller(List<Integer> inOrder, int query) {
        if (inOrder.get(0) > query) {
            return -1;
        }
        int lo = 0;
        int hi = inOrder.size() - 1;

        while (lo < hi) {
            int mid = (lo + hi + 1) / 2;

            if (inOrder.get(mid) > query) {
                hi = mid - 1;
            } else {
                lo = mid;
            }
        }
        return inOrder.get(lo);
    }

    /**
     * 在升序数组inOrder中二分查找大于等于query的最小值
     *
     * @param inOrder
     * @param query
     * @return
     */
    public static int getGreater(List<Integer> inOrder, int query) {
        if (inOrder.get(inOrder.size() - 1) < query) {
            return -1;
        }
        int lo = 0;
        int hi = inOrder.size() - 1;

        while (lo < hi) {
            int mid = (lo + hi) / 2;

            if (inOrder.get(mid) < query) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return inOrder.get(lo);
    }
}
