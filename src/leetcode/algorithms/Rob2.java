package leetcode.algorithms;

import leetcode.entity.TreeNode;
import leetcode.util.BinaryTreeUtils;

/**
 * Description: 337. House Robber III
 *
 * @author Baltan
 * @date 2019-06-25 09:21
 * @see Rob
 * @see Rob1
 */
public class Rob2 {
    public static void main(String[] args) {
        TreeNode root1 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{3, 2, 3, null, 3, null, 1}, 0);
        System.out.println(rob(root1));

        TreeNode root2 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{3, 4, 5, 1, 3, null, 1}, 0);
        System.out.println(rob(root2));

        TreeNode root3 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{2, 1, 3}, 0);
        System.out.println(rob(root3));
    }

    public static int rob(TreeNode root) {
        if (root == null) {
            return 0;
        } else if (root.left == null && root.right == null) {
            return root.val;
        } else {
            /**
             * 选择根节点可以得到的最大金额
             */
            int chooseRoot = root.val;
            /**
             * 向左子树方向选择
             */
            if (root.left != null) {
                chooseRoot = chooseRoot + rob(root.left.left) + rob(root.left.right);
            }
            /**
             * 向右子树方向选择
             */
            if (root.right != null) {
                chooseRoot = chooseRoot + rob(root.right.left) + rob(root.right.right);
            }
            /**
             * 不选择根节点可以得到的最大金额
             */
            int notChooseRoot = rob(root.left) + rob(root.right);
            return Math.max(chooseRoot, notChooseRoot);
        }
    }
}
