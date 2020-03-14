package leetcode.interview;

import leetcode.entity.TreeNode;
import leetcode.util.BinaryTreeUtils;

/**
 * Description: 面试题 04.12. 求和路径
 *
 * @author Baltan
 * @date 2018/8/9 09:26
 * @see leetcode.algorithms.PathSum
 * @see leetcode.algorithms.PathSum1
 */
public class PathSum {
    public static void main(String[] args) {
        TreeNode root1 = BinaryTreeUtils
                .arrayToBinaryTree(new Integer[]{10, 5, -3, 3, 2, null, 11, 3, -2, null, 1}, 0);
        System.out.println(pathSum(root1, 8));

        TreeNode root2 =
                BinaryTreeUtils.arrayToBinaryTree(new Integer[]{1, 2, null, 3, null, null, null, 4, null,
                        null, null, null, null, null, null, 5}, 0);
        System.out.println(pathSum(root2, 3));
    }

    public static int pathSum(TreeNode root, int sum) {
        int result = 0;

        if (root == null) {
            return result;
        }
        /**
         * 从根节点开始，方向向下的路径总和为sum的路径条数
         */
        result += dfs(root, sum);
        /**
         * 在根节点的左子树中，从左子树根节点开始，方向向下的路径总和为sum的路径条数
         */
        result += pathSum(root.left, sum);
        /**
         * 在根节点的右子树中，从右子树根节点开始，方向向下的路径总和为sum的路径条数
         */
        result += pathSum(root.right, sum);
        return result;
    }

    /**
     * 从根节点开始，方向向下的路径总和为sum的路径条数
     *
     * @param root
     * @param sum
     * @return
     */
    public static int dfs(TreeNode root, int sum) {
        int result = 0;

        if (root == null) {
            return result;
        }

        if (root.val == sum) {
            result++;
        }
        /**
         * 在root的左子树中查找路径总和为sum-root.val的路径条数
         */
        result += dfs(root.left, sum - root.val);
        /**
         * 在root的右子树中查找路径总和为sum-root.val的路径条数
         */
        result += dfs(root.right, sum - root.val);
        return result;
    }
}
