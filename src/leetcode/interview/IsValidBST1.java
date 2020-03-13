package leetcode.interview;

import leetcode.entity.TreeNode;
import leetcode.util.BinaryTreeUtils;

/**
 * Description: 面试题 04.05. 合法二叉搜索树
 *
 * @author Baltan
 * @date 2019-05-23 09:40
 * @see IsValidBST
 * @see leetcode.algorithms.IsValidBST
 * @see leetcode.algorithms.IsValidBST1
 */
public class IsValidBST1 {
    public static void main(String[] args) {
        TreeNode root1 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{2, 1, 3}, 0);
        System.out.println(isValidBST(root1));

        TreeNode root2 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{5, 1, 4, null, null, 3, 6}, 0);
        System.out.println(isValidBST(root2));

        TreeNode root3 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{1}, 0);
        System.out.println(isValidBST(root3));

        TreeNode root4 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{5, 2, 8, 3, null, null, 9}, 0);
        System.out.println(isValidBST(root4));

        TreeNode root5 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{1, null, 1}, 0);
        System.out.println(isValidBST(root5));

        TreeNode root6 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{1, null, 1}, 0);
        System.out.println(isValidBST(root6));

        TreeNode root7 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{Integer.MAX_VALUE}, 0);
        System.out.println(isValidBST(root7));

        TreeNode root8 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{Integer.MIN_VALUE}, 0);
        System.out.println(isValidBST(root8));
    }

    /**
     * 参考：
     * <a href="https://leetcode-cn.com/problems/validate-binary-search-tree/solution/yan-zheng-er-cha-sou-suo-shu-by-leetcode/"></a>
     *
     * @param root
     * @return
     */
    public static boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    /**
     * @param root
     * @param min  二叉树root节点值的下限
     * @param max  二叉树root节点值的上限
     * @return
     */
    public static boolean isValidBST(TreeNode root, long min, long max) {
        if (root == null) {
            return true;
        }
        /**
         * 对于root的左子树，root根节点的值就是左子树所有节点值的上限；对于root的右子树，root根节点的值就
         * 是右子树所有节点值的下限
         */
        return root.val > min && root.val < max && isValidBST(root.left, min, root.val) &&
                isValidBST(root.right, root.val, max);
    }
}
