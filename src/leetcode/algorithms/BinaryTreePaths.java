package leetcode.algorithms;

import leetcode.entity.TreeNode;
import leetcode.util.BinaryTreeUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: 257. Binary Tree Paths
 *
 * @author Baltan
 * @date 2018/8/8 09:33
 */
public class BinaryTreePaths {
    public static void main(String[] args) {
        TreeNode root1 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{1, 2, 3, null, 5}, 0);
        System.out.println(binaryTreePaths(root1));

        TreeNode root2 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{}, 0);
        System.out.println(binaryTreePaths(root2));

        TreeNode root3 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{1}, 0);
        System.out.println(binaryTreePaths(root3));
    }

    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        /**
         * 如果root不包含任何节点，返回空数组
         */
        if (root == null) {
            return result;
        }
        /**
         * 如果root不包含左子树和右子树，则路径只包含根节点的值
         */
        if (root.left == null && root.right == null) {
            result.add(String.valueOf(root.val));
            return result;
        }
        /**
         * 左子树中的所有路径
         */
        List<String> leftList = binaryTreePaths(root.left);
        /**
         * 右子树中的所有路径
         */
        List<String> rightList = binaryTreePaths(root.right);
        /**
         * 从根节点经过左子树到叶子节点的所有路径
         */
        for (String s : leftList) {
            result.add(root.val + "->" + s);
        }
        /**
         * 从根节点经过右子树到叶子节点的所有路径
         */
        for (String s : rightList) {
            result.add(root.val + "->" + s);
        }
        return result;
    }
}
