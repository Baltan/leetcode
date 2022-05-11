package leetcode.algorithms;

import leetcode.entity.TreeNode;
import leetcode.util.BinaryTreeUtils;

/**
 * Description: 2265. Count Nodes Equal to Average of Subtree
 *
 * @author Baltan
 * @date 2022/5/9 16:34
 */
public class AverageOfSubtree {
    public static void main(String[] args) {
        TreeNode root1 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{4, 8, 5, 0, 1, null, 6}, 0);
        System.out.println(averageOfSubtree(root1));

        TreeNode root2 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{1}, 0);
        System.out.println(averageOfSubtree(root2));
    }

    private static int result;

    public static int averageOfSubtree(TreeNode root) {
        result = 0;
        dfs(root);
        return result;
    }

    private static BinaryTree dfs(TreeNode root) {
        if (root == null) {
            return new BinaryTree(0, 0);
        }
        /**
         * root左子树的节点数和所有节点值的和
         */
        BinaryTree left = dfs(root.left);
        /**
         * root右子树的节点数和所有节点值的和
         */
        BinaryTree right = dfs(root.right);
        /**
         * 当前二叉树的节点数
         */
        int nodeCount = left.getNodeCount() + right.getNodeCount() + 1;
        /**
         * 当前二叉树的所有节点值的和
         */
        int nodeSum = left.getNodeSum() + right.getNodeSum() + root.val;
        int average = nodeSum / nodeCount;

        if (average == root.val) {
            result++;
        }
        return new BinaryTree(nodeCount, nodeSum);
    }

    private static class BinaryTree {
        /**
         * 节点数
         */
        private int nodeCount;
        /**
         * 所有节点值的和
         */
        private int nodeSum;

        public BinaryTree(int nodeCount, int nodeSum) {
            this.nodeCount = nodeCount;
            this.nodeSum = nodeSum;
        }

        public int getNodeCount() {
            return nodeCount;
        }

        public int getNodeSum() {
            return nodeSum;
        }
    }
}
