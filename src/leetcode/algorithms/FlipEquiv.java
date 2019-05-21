package leetcode.algorithms;

import leetcode.entity.TreeNode;
import leetcode.util.BinaryTreeUtils;

/**
 * Description: 951. Flip Equivalent Binary Trees
 *
 * @author Baltan
 * @date 2019-03-21 10:30
 */
public class FlipEquiv {
    public static void main(String[] args) {
        TreeNode root1 =
                BinaryTreeUtils.arrayToBinaryTree(new Integer[]{1, 2, 3, 4, 5, 6, null, null, null, 7, 8}, 0);
        TreeNode root2 =
                BinaryTreeUtils.arrayToBinaryTree(
                        new Integer[]{1, 3, 2, null, 6, 4, 5, null, null, null, null, null, null, 8, 7}, 0);
        System.out.println(flipEquiv(root1, root2));
    }

    public static boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null && root2 != null) {
            return false;
        }
        if (root1 != null && root2 == null) {
            return false;
        }
        if (root1.left == null && root1.right == null && root2.left == null && root2.right == null) {
            return root1.val == root2.val;
        }
        if (flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right)) {
            return true;
        } else if (flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left)) {
            return true;
        }
        return false;
    }
}
