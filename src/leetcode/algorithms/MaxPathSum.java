package leetcode.algorithms;

import leetcode.entity.TreeNode;
import leetcode.util.BinaryTreeUtils;

/**
 * Description: 124. Binary Tree Maximum Path Sum
 *
 * @author Baltan
 * @date 2020-06-21 09:58
 */
public class MaxPathSum {
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

    public static int maxPathSum(TreeNode root) {
        /**
         * 当根节点为null时，记录该二叉树的最大路径和为Integer.MIN_VALUE，如果记录为0，则当二叉树只有一个
         * 节点，且根节点值小于0时，会错误地得到二叉树中的最大路径和为0
         */
        if (root == null) {
            return Integer.MIN_VALUE;
        }
        /**
         * 包含根节点的最大路径和
         */
        result = Math.max(result, maxPathPassRoot(root));
        /**
         * 根节点左子树中的最大路径和
         */
        result = Math.max(result, maxPathSum(root.left));
        /**
         * 根节点右子树中的最大路径和
         */
        result = Math.max(result, maxPathSum(root.right));
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
        return Math
                .max(root.val, root.val + Math.max(maxPathFromRoot(root.left), maxPathFromRoot(root.right)));
    }

    /**
     * 穿过根节点，即路径包括根节点但是不以根节点作为路径端点的最大路径和
     *
     * @param root
     * @return
     */
    public static int maxPathThroughRoot(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return root.val + maxPathFromRoot(root.left) + maxPathFromRoot(root.right);
    }

    /**
     * 包含根节点的最大路径和
     *
     * @param root
     * @return
     */
    public static int maxPathPassRoot(TreeNode root) {
        return Math.max(maxPathFromRoot(root), maxPathThroughRoot(root));
    }
}
