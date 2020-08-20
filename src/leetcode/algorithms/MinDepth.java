package leetcode.algorithms;

import leetcode.entity.TreeNode;
import leetcode.util.BinaryTreeUtils;

/**
 * Description: 111. Minimum Depth of Binary Tree
 *
 * @author Baltan
 * @date 2018/8/10 15:14
 */
public class MinDepth {
    public static void main(String[] args) {
        TreeNode root1 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{3, 9, 20, null, null, 15, 7}, 0);
        System.out.println(minDepth(root1));

        TreeNode root2 =
                BinaryTreeUtils.arrayToBinaryTree(
                        new Integer[]{1, 2, 2, 3, null, null, 3, 4, null, null, null, null, null, null, 4},
                        0);
        System.out.println(minDepth(root2));
    }

    public static int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null) {
            /**
             * 如果左子树为空，则在右子树上查找最近的叶节点
             */
            return 1 + minDepth(root.right);
        } else if (root.right == null) {
            /**
             * 如果右子树为空，则在左子树上查找最近的叶节点
             */
            return 1 + minDepth(root.left);
        } else {
            /**
             * 查找左子树和右子树中最近的叶节点
             */
            return 1 + Math.min(minDepth(root.left), minDepth(root.right));
        }
    }
}
