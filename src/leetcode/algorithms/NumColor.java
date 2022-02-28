package leetcode.algorithms;

import leetcode.entity.TreeNode;
import leetcode.util.BinaryTreeUtils;

import java.util.HashSet;
import java.util.Set;

/**
 * Description: LCP 44. 开幕式焰火
 *
 * @author Baltan
 * @date 2022/2/28 10:31
 */
public class NumColor {
    public static void main(String[] args) {
        TreeNode root1 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{1, 3, 2, 1, null, 2}, 0);
        System.out.println(numColor(root1));

        TreeNode root2 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{3, 3, 3}, 0);
        System.out.println(numColor(root2));
    }

    public static int numColor(TreeNode root) {
        /**
         * 颜色集合
         */
        Set<Integer> colorSet = new HashSet<>();
        dfs(root, colorSet);
        return colorSet.size();
    }

    /**
     * 递归将所有节点的颜色加入颜色集合
     *
     * @param root
     * @param colorSet
     */
    public static void dfs(TreeNode root, Set<Integer> colorSet) {
        if (root == null) {
            return;
        }
        colorSet.add(root.val);
        dfs(root.left, colorSet);
        dfs(root.right, colorSet);
    }
}
