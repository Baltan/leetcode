package leetcode.algorithms;

import leetcode.entity.TreeNode;
import leetcode.util.BinaryTreeUtils;

import java.util.LinkedList;
import java.util.List;

/**
 * Description: 113. Path Sum II
 *
 * @author Baltan
 * @date 2019-05-24 09:49
 * @see PathSum
 * @see leetcode.interview.PathSum
 */
public class PathSum1 {
    public static void main(String[] args) {
        /**
         * <pre>
         *       5
         *      / \
         *     4   8
         *    /   / \
         *   11  13  4
         *  /  \    / \
         * 7    2  5   1
         * </pre>
         */
        TreeNode root1 =
                BinaryTreeUtils.arrayToBinaryTree(new Integer[]{5, 4, 8, 11, null, 13, 4, 7, 2, null, null,
                        null, null, 5, 1}, 0);
        System.out.println(pathSum(root1, 22));

        /**
         * <pre>
         *       10
         *      /  \
         *     5   -3
         *    / \    \
         *   3   2   11
         *  / \   \
         * 3  -2   1
         * </pre>
         */
        TreeNode root2 = BinaryTreeUtils
                .arrayToBinaryTree(new Integer[]{10, 5, -3, 3, 2, null, 11, 3, -2, null, 1}, 0);
        System.out.println(pathSum(root2, 18));

        TreeNode root3 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{1, 2, 3}, 0);
        System.out.println(pathSum(root3, 3));
    }

    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new LinkedList<>();

        if (root == null) {
            return result;
        }

        if (root.left == null && root.right == null) {
            if (root.val == sum) {
                List<Integer> list = new LinkedList<>();
                list.add(root.val);
                result.add(list);
            }
        } else {
            /**
             * root的左子树中查找从左子树根节点到叶节点路径和为sum-root.val的所有路径
             */
            List<List<Integer>> leftList = pathSum(root.left, sum - root.val);
            /**
             * root的右子树中查找从右子树根节点到叶节点路径和为sum-root.val的所有路径
             */
            List<List<Integer>> rightList = pathSum(root.right, sum - root.val);
            /**
             * 将leftList和rightList中的所有路径头上加上根节点，就是从根节点到叶节点路径和为sum的所有路径
             */
            for (List<Integer> list : leftList) {
                list.add(0, root.val);
                result.add(list);
            }

            for (List<Integer> list : rightList) {
                list.add(0, root.val);
                result.add(list);
            }
        }
        return result;
    }
}
