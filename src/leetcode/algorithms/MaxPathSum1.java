package leetcode.algorithms;

import leetcode.entity.TreeNode;
import leetcode.util.BinaryTreeUtils;

/**
 * Description: 124. Binary Tree Maximum Path Sum
 *
 * @author Baltan
 * @date 2020-06-21 09:58
 */
public class MaxPathSum1 {
    private static int result;

    public static void main(String[] args) {
        result = Integer.MIN_VALUE;
        TreeNode root1 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{1, 2, 3}, 0);
        System.out.println(maxPathSum(root1));

        result = Integer.MIN_VALUE;
        TreeNode root2 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{-10, 9, 20, null, null, 15, 7}, 0);
        System.out.println(maxPathSum(root2));

        result = Integer.MIN_VALUE;
        TreeNode root3 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{-3}, 0);
        System.out.println(maxPathSum(root3));
    }

    /**
     * 参考：
     * <a href="https://leetcode-cn.com/problems/binary-tree-maximum-path-sum/solution/er-cha-shu-zhong-de-zui-da-lu-jing-he-by-leetcode-/"></a>
     *
     * @param root
     * @return
     */
    public static int maxPathSum(TreeNode root) {
        maxPathFromRoot(root);
        return result;
    }

    /**
     * 从根节点出发，即以根节点作为路径端点的最大路径和（包括路径上只有根节点一个节点的情况）
     *
     * @param root
     * @return
     */
    public static int maxPathFromRoot(TreeNode root) {
        if (root == null) {
            return 0;
        }
        /**
         * 当以根节点的左子节点作为路径端点的最大路径和大于0时，才将该路径连接到根节点上
         */
        int maxPathFromLeftNode = Math.max(0, maxPathFromRoot(root.left));
        /**
         * 当以根节点的右子节点作为路径端点的最大路径和大于0时，才将该路径连接到根节点上
         */
        int maxPathFromRightNode = Math.max(0, maxPathFromRoot(root.right));
        /**
         * 包含根节点的最大路径和为root.val+maxPathFromLeftNode+maxPathFromRightNode
         */
        result = Math.max(result, root.val + maxPathFromLeftNode + maxPathFromRightNode);
        return root.val + Math.max(maxPathFromLeftNode, maxPathFromRightNode);
    }
}
