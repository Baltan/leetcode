package leetcode.algorithms;

import leetcode.entity.TreeNode;
import leetcode.util.BinaryTreeUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Description: 3319. K-th Largest Perfect Subtree Size in Binary Tree
 *
 * @author Baltan
 * @date 2024/10/20 14:55
 */
public class KthLargestPerfectSubtree {
    public static void main(String[] args) {
        TreeNode root1 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{5, 3, 6, 5, 2, 5, 7, 1, 8, null, null, 6, 8, null, null}, 0);
        System.out.println(kthLargestPerfectSubtree(root1, 2));

        TreeNode root2 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{1, 2, 3, 4, 5, 6, 7}, 0);
        System.out.println(kthLargestPerfectSubtree(root2, 1));

        TreeNode root3 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{1, 2, 3, null, 4, null, null}, 0);
        System.out.println(kthLargestPerfectSubtree(root3, 3));
    }

    public static int kthLargestPerfectSubtree(TreeNode root, int k) {
        List<Integer> nodeCounts = new ArrayList<>();
        /**
         * 保存所有满二叉树的节点个数
         */
        getPerfectSubtreeNodeCount(root, nodeCounts);

        if (nodeCounts.size() < k) {
            return -1;
        }
        nodeCounts.sort(Collections.reverseOrder());
        return nodeCounts.get(k - 1);
    }

    /**
     * 计算二叉树root的节点个数，如果二叉树不是满二叉树时返回-1
     *
     * @param root
     * @param nodeCounts
     * @return
     */
    public static int getPerfectSubtreeNodeCount(TreeNode root, List<Integer> nodeCounts) {
        if (root == null) {
            return 0;
        }
        /**
         * 二叉树root的左子树的节点个数，如果左子树不是满二叉树则为-1
         */
        int left = getPerfectSubtreeNodeCount(root.left, nodeCounts);
        /**
         * 二叉树root的右子树的节点个数，如果右子树不是满二叉树则为-1
         */
        int right = getPerfectSubtreeNodeCount(root.right, nodeCounts);
        /**
         * 如果二叉树root是满二叉树，则它的左子树和右子树也都是满二叉树，并且两个子树的节点数相同
         */
        if (left == -1 || left != right) {
            return -1;
        }
        int nodeCount = left + right + 1;
        nodeCounts.add(nodeCount);
        return nodeCount;
    }
}
