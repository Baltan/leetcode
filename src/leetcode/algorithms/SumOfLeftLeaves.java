package leetcode.algorithms;

import leetcode.entity.TreeNode;
import leetcode.util.BinaryTreeUtils;

/**
 * Description: 404. Sum of Left Leaves
 *
 * @author Baltan
 * @date 2018/8/2 11:59
 */
public class SumOfLeftLeaves {
    public static void main(String[] args) {
        TreeNode root1 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{3, 9, 20, null, null, 15, 7}, 0);
        System.out.println(sumOfLeftLeaves(root1));
    }

    public static int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int sum = 0;

        if (root.left != null) {
            /**
             * 当左子树只有一个节点时，该节点就是一个左叶子节点
             */
            if (root.left.left == null && root.left.right == null) {
                sum += root.left.val;
            } else {
                /**
                 * 对左子树递归
                 */
                sum = sum + sumOfLeftLeaves(root.left);
            }
        }

        if (root.right != null) {
            /**
             * 对右子树递归
             */
            sum = sum + sumOfLeftLeaves(root.right);
        }
        return sum;
    }
}
