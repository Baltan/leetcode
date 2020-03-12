package leetcode.algorithms;

import leetcode.entity.TreeNode;
import leetcode.util.BinaryTreeUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: 1339. Maximum Product of Splitted Binary Tree
 *
 * @author Baltan
 * @date 2020-03-12 12:07
 */
public class MaxProduct2 {
    public static void main(String[] args) {
        TreeNode root1 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{1, 2, 3, 4, 5, 6}, 0);
        System.out.println(maxProduct(root1));

        TreeNode root2 = BinaryTreeUtils
                .arrayToBinaryTree(
                        new Integer[]{1, null, 2, null, null, 3, 4, null, null, null, null, null, null, 5, 6},
                        0);
        System.out.println(maxProduct(root2));

        TreeNode root3 =
                BinaryTreeUtils.arrayToBinaryTree(new Integer[]{2, 3, 9, 10, 7, 8, 6, 5, 4, 11, 1}, 0);
        System.out.println(maxProduct(root3));

        TreeNode root4 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{1, 1}, 0);
        System.out.println(maxProduct(root4));
    }

    public static int maxProduct(TreeNode root) {
        int result = 0;
        /**
         * 以二叉树根节点作为key，value为二叉树中所有节点的和，即root -> root中每个节点的和
         */
        Map<TreeNode, Integer> map = new HashMap<>();
        /**
         * 两棵子树各自所有元素之和的差的最小值，对于总和一定的一系列数字，两部分之差越接近，两部分的乘积越大
         */
        int minDifference = Integer.MAX_VALUE;
        int mod = 1000000007;
        getSum(root, map);
        /**
         * 所有节点的和
         */
        int sum = map.get(root);

        for (int currentSum : map.values()) {
            /**
             * 两部分之差
             */
            int difference = Math.abs(sum - currentSum - currentSum);

            if (difference < minDifference) {
                result = (int) (1L * (sum - currentSum) * currentSum % mod);
                minDifference = difference;
            }
        }
        return result;
    }

    /**
     * 求二叉树root中每个节点的和，并保存在map中
     *
     * @param root
     * @param map
     * @return
     */
    public static int getSum(TreeNode root, Map<TreeNode, Integer> map) {
        if (root == null) {
            return 0;
        }

        int leftSum = getSum(root.left, map);
        int rightSum = getSum(root.right, map);
        int sum = leftSum + rightSum + root.val;
        map.put(root, sum);
        return sum;
    }
}
