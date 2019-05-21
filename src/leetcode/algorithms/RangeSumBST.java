package leetcode.algorithms;

import leetcode.entity.TreeNode;
import leetcode.util.BinaryTreeUtils;

/**
 * Description: 938. Range Sum of BST
 *
 * @author Baltan
 * @date 2019-03-18 13:56
 */
public class RangeSumBST {
    public static void main(String[] args) {
        TreeNode root1 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{10, 5, 15, 3, 7, null, 18}, 0);
        System.out.println(rangeSumBST(root1, 7, 15));

        TreeNode root2 =
                BinaryTreeUtils.arrayToBinaryTree(new Integer[]{10, 5, 15, 3, 7, 13, 18, 1, null, 6}, 0);
        System.out.println(rangeSumBST(root2, 6, 10));
    }

    public static int rangeSumBST(TreeNode root, int L, int R) {
        if (root == null) {
            return 0;
        }

        int sum = 0;

        if (root.val >= L && root.val <= R) {
            sum += root.val;
        }

        if (root.val <= L) {
            return sum + rangeSumBST(root.right, L, R);
        } else if (root.val >= R) {
            return sum + rangeSumBST(root.left, L, R);
        } else {
            return sum + rangeSumBST(root.right, L, R) + rangeSumBST(root.left, L, R);
        }
    }
}
