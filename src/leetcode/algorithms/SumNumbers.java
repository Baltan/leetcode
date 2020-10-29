package leetcode.algorithms;

import leetcode.entity.TreeNode;
import leetcode.util.BinaryTreeUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: 129. Sum Root to Leaf Numbers
 *
 * @author Baltan
 * @date 2019-05-27 12:13
 */
public class SumNumbers {
    public static void main(String[] args) {
        TreeNode root1 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{1, 2, 3}, 0);
        System.out.println(sumNumbers(root1));

        TreeNode root2 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{4, 9, 0, 5, 1}, 0);
        System.out.println(sumNumbers(root2));

        TreeNode treeNode3 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{9}, 0);
        System.out.println(sumNumbers(treeNode3));

        TreeNode treeNode4 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{0, 1}, 0);
        System.out.println(sumNumbers(treeNode4));
    }

    public static int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int result = 0;
        /**
         * 根节点到叶子节点的所有路径表示的数字
         */
        List<String> list = help(root);

        for (String s : list) {
            result += Integer.valueOf(s);
        }
        return result;
    }

    /**
     * 获取从根节点到叶子节点的所有路径表示的数字
     *
     * @param root
     * @return
     */
    public static List<String> help(TreeNode root) {
        List<String> result = new ArrayList<>();

        if (root.left == null && root.right == null) {
            result.add(String.valueOf(root.val));
            return result;
        }

        String head = String.valueOf(root.val);
        /**
         * 根节点通过左子节点到叶子节点的所有路径表示的数字
         */
        if (root.left != null) {
            List<String> left = help(root.left);

            for (String s : left) {
                result.add(head + s);
            }
        }
        /**
         * 根节点通过左子节点到叶子节点的所有路径表示的数字
         */
        if (root.right != null) {
            List<String> right = help(root.right);

            for (String s : right) {
                result.add(head + s);
            }
        }
        return result;
    }
}
