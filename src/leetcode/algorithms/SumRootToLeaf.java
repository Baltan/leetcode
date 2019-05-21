package leetcode.algorithms;

import leetcode.entity.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: 1022. Sum of Root To Leaf Binary Numbers
 *
 * @author Baltan
 * @date 2019-04-08 09:12
 */
public class SumRootToLeaf {
    public static void main(String[] args) {
        TreeNode node11 = new TreeNode(1);
        TreeNode node12 = new TreeNode(0);
        TreeNode node13 = new TreeNode(1);
        TreeNode node14 = new TreeNode(0);
        TreeNode node15 = new TreeNode(1);
        TreeNode node16 = new TreeNode(0);
        TreeNode node17 = new TreeNode(1);

        node11.left = node12;
        node11.right = node13;
        node12.left = node14;
        node12.right = node15;
        node13.left = node16;
        node13.right = node17;
        System.out.println(sumRootToLeaf(node11));

        TreeNode node21 = new TreeNode(1);
        TreeNode node22 = new TreeNode(1);

        node21.left = node22;
        System.out.println(sumRootToLeaf(node21));
    }

    public static int sumRootToLeaf(TreeNode root) {
        List<String> list = getPathString(root);
        return list.stream().map(str -> Integer.parseInt(str, 2)).reduce(0, (x, y) -> x + y);
    }

    public static List<String> getPathString(TreeNode root) {
        List<String> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        if (root.left == null && root.right == null) {
            result.add(root.val + "");
            return result;
        }

        List<String> leftList = getPathString(root.left);
        List<String> rightList = getPathString(root.right);

        for (String str : leftList) {
            result.add(root.val + str);
        }
        for (String str : rightList) {
            result.add(root.val + str);
        }
        return result;
    }
}
