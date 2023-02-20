package leetcode.algorithms;

import leetcode.entity.TreeNode;
import leetcode.util.BinaryTreeUtils;

/**
 * Description: 2331. Evaluate Boolean Binary Tree
 *
 * @author Baltan
 * @date 2023/2/15 10:43
 */
public class EvaluateTree {
    public static void main(String[] args) {
        TreeNode root1 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{2, 1, 3, null, null, 0, 1}, 0);
        System.out.println(evaluateTree(root1));

        TreeNode root2 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{0}, 0);
        System.out.println(evaluateTree(root2));
    }

    public static boolean evaluateTree(TreeNode root) {
        if (root.left == null && root.right == null) {
            return root.val == 1;
        } else {
            if (root.val == 2) {
                /**
                 * 左子节点的布尔值和右子节点的布尔值进行或运算
                 */
                return evaluateTree(root.left) || evaluateTree(root.right);
            } else {
                /**
                 * 左子节点的布尔值和右子节点的布尔值进行与运算
                 */
                return evaluateTree(root.left) && evaluateTree(root.right);
            }
        }
    }
}
