package leetcode.algorithms;

import leetcode.entity.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: 113. Path Sum II
 *
 * @author Baltan
 * @date 2019-05-24 09:49
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
        TreeNode treeNode11 = new TreeNode(5);
        TreeNode treeNode12 = new TreeNode(4);
        TreeNode treeNode13 = new TreeNode(8);
        TreeNode treeNode14 = new TreeNode(11);
        TreeNode treeNode15 = new TreeNode(13);
        TreeNode treeNode16 = new TreeNode(4);
        TreeNode treeNode17 = new TreeNode(7);
        TreeNode treeNode18 = new TreeNode(2);
        TreeNode treeNode19 = new TreeNode(5);
        TreeNode treeNode110 = new TreeNode(1);
        treeNode11.left = treeNode12;
        treeNode11.right = treeNode13;
        treeNode12.left = treeNode14;
        treeNode13.left = treeNode15;
        treeNode13.right = treeNode16;
        treeNode14.left = treeNode17;
        treeNode14.right = treeNode18;
        treeNode16.left = treeNode19;
        treeNode16.right = treeNode110;
        System.out.println(pathSum(treeNode11, 22));

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
        TreeNode treeNode21 = new TreeNode(10);
        TreeNode treeNode22 = new TreeNode(5);
        TreeNode treeNode23 = new TreeNode(-3);
        TreeNode treeNode24 = new TreeNode(3);
        TreeNode treeNode25 = new TreeNode(2);
        TreeNode treeNode26 = new TreeNode(11);
        TreeNode treeNode27 = new TreeNode(3);
        TreeNode treeNode28 = new TreeNode(-2);
        TreeNode treeNode29 = new TreeNode(1);
        treeNode21.left = treeNode22;
        treeNode21.right = treeNode23;
        treeNode22.left = treeNode24;
        treeNode22.right = treeNode25;
        treeNode23.right = treeNode26;
        treeNode24.left = treeNode27;
        treeNode24.right = treeNode28;
        treeNode25.right = treeNode29;
        System.out.println(pathSum(treeNode21, 18));

        TreeNode treeNode31 = new TreeNode(1);
        TreeNode treeNode32 = new TreeNode(2);
        TreeNode treeNode33 = new TreeNode(2);
        treeNode31.left = treeNode32;
        treeNode31.right = treeNode33;
        System.out.println(pathSum(treeNode31, 3));
    }

    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        return help(root, sum);
    }

    public static List<List<Integer>> help(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        if (root.left == null && root.right == null) {
            if (root.val == sum) {
                List<Integer> list = new ArrayList<>();
                list.add(root.val);
                result.add(list);
            }
        } else {
            List<List<Integer>> leftList = help(root.left, sum - root.val);
            List<List<Integer>> rightList = help(root.right, sum - root.val);

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
