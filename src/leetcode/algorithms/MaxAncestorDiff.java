package leetcode.algorithms;

import leetcode.entity.TreeNode;

/**
 * Description: 1026. Maximum Difference Between Node and Ancestor
 *
 * @author Baltan
 * @date 2019-04-15 13:37
 */
public class MaxAncestorDiff {
    private static int result;

    public static void main(String[] args) {
        TreeNode node11 = new TreeNode(8);
        TreeNode node12 = new TreeNode(3);
        TreeNode node13 = new TreeNode(10);
        TreeNode node14 = new TreeNode(1);
        TreeNode node15 = new TreeNode(6);
        TreeNode node16 = new TreeNode(14);
        TreeNode node17 = new TreeNode(4);
        TreeNode node18 = new TreeNode(7);
        TreeNode node19 = new TreeNode(13);

        node11.left = node12;
        node11.right = node13;
        node12.left = node14;
        node12.right = node15;
        node13.right = node16;
        node15.left = node17;
        node15.right = node18;
        node16.left = node19;
        System.out.println(maxAncestorDiff(node11));

        TreeNode node21 = new TreeNode(1);
        TreeNode node22 = new TreeNode(2);
        TreeNode node23 = new TreeNode(0);
        TreeNode node24 = new TreeNode(3);

        node21.right = node22;
        node22.right = node23;
        node23.left = node24;
        System.out.println(maxAncestorDiff(node21));
    }

    public static int maxAncestorDiff(TreeNode root) {
        result = 0;
        dfs(root, root.val, root.val);
        return result;
    }

    public static void dfs(TreeNode node, int min, int max) {
        if (node != null) {
            int difference1 = Math.abs(node.val - min);
            int difference2 = Math.abs(node.val - max);
            result = Math.max(result, difference1);
            result = Math.max(result, difference2);
            dfs(node.left, Math.min(min, node.val), Math.max(max, node.val));
            dfs(node.right, Math.min(min, node.val), Math.max(max, node.val));
        }
    }
}
