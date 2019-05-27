package leetcode.algorithms;

import leetcode.entity.TreeNode;

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
        TreeNode treeNode11 = new TreeNode(1);
        TreeNode treeNode12 = new TreeNode(2);
        TreeNode treeNode13 = new TreeNode(3);
        treeNode11.left = treeNode12;
        treeNode11.right = treeNode13;
        System.out.println(sumNumbers(treeNode11));

        TreeNode treeNode21 = new TreeNode(4);
        TreeNode treeNode22 = new TreeNode(9);
        TreeNode treeNode23 = new TreeNode(0);
        TreeNode treeNode24 = new TreeNode(5);
        TreeNode treeNode25 = new TreeNode(1);
        treeNode21.left = treeNode22;
        treeNode21.right = treeNode23;
        treeNode22.left = treeNode24;
        treeNode22.right = treeNode25;
        System.out.println(sumNumbers(treeNode21));

        TreeNode treeNode31 = new TreeNode(9);
        System.out.println(sumNumbers(treeNode31));

        TreeNode treeNode41 = new TreeNode(0);
        TreeNode treeNode42 = new TreeNode(1);
        treeNode41.left = treeNode42;
        System.out.println(sumNumbers(treeNode41));
    }

    public static int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int result = 0;
        List<String> list = help(root);

        for (String s : list) {
            result += Integer.valueOf(s);
        }
        return result;
    }

    public static List<String> help(TreeNode root) {
        List<String> result = new ArrayList<>();

        if (root.left == null && root.right == null) {
            result.add(String.valueOf(root.val));
            return result;
        }

        String head = String.valueOf(root.val);

        if (root.left != null) {
            List<String> left = help(root.left);

            for (String s : left) {
                result.add(head + s);
            }
        }

        if (root.right != null) {
            List<String> right = help(root.right);

            for (String s : right) {
                result.add(head + s);
            }
        }
        return result;
    }
}
