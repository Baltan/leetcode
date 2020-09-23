package leetcode.algorithms;

import leetcode.entity.TreeNode;
import leetcode.util.BinaryTreeUtils;

/**
 * Description: 617. Merge Two Binary Trees
 *
 * @author Baltan
 * @date 2018/7/30 14:32
 */
public class MergeTrees {
    public static void main(String[] args) {
        TreeNode root1 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{1, 3, 2, 5}, 0);
        TreeNode root2 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{2, 1, 3, null, 4, null, 7}, 0);
        System.out.println(mergeTrees(root1, root2));
    }

    public static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return null;
        } else if (t1 == null) {
            return t2;
        } else if (t2 == null) {
            return t1;
        } else {
            TreeNode root = new TreeNode(t1.val + t2.val);
            /**
             * 合并t1和t2的左子树作为新的合并后的左子树，合并t1和t2的右子树作为新的合并后的右子树
             */
            root.left = mergeTrees(t1.left, t2.left);
            root.right = mergeTrees(t1.right, t2.right);
            return root;
        }
    }
}
