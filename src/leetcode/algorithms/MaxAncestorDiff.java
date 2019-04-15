package leetcode.algorithms;

import leetcode.entity.TreeNode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Description: Maximum Difference Between Node and Ancestor
 *
 * @author Baltan
 * @date 2019-04-15 13:37
 */
public class MaxAncestorDiff {
    public static void main(String[] args) {
        TreeNode node11 = new TreeNode(8);
        TreeNode node12 = new TreeNode(3);
        TreeNode node13 = new TreeNode(10);
        TreeNode node14 = new TreeNode(1);
        TreeNode node15 = new TreeNode(6);
        TreeNode node16 = new TreeNode(14);
        TreeNode node17 = new TreeNode(4);
        TreeNode node18 = new TreeNode(7);
        TreeNode node19 = new TreeNode(13);

        node11.left = node12;
        node11.right = node13;
        node12.left = node14;
        node12.right = node15;
        node13.right = node16;
        node15.left = node17;
        node15.right = node18;
        node16.left = node19;
        System.out.println(maxAncestorDiff(node11));

        TreeNode node21 = new TreeNode(1);
        TreeNode node22 = new TreeNode(2);
        TreeNode node23 = new TreeNode(0);
        TreeNode node24 = new TreeNode(3);

        node21.right = node22;
        node22.right = node23;
        node23.left = node24;
        System.out.println(maxAncestorDiff(node21));
    }

    public static int maxAncestorDiff(TreeNode root) {
        List<int[]> list = getAncestorDiff(root);
        return list.stream().map(x -> Math.abs(x[1])).max(Comparator.comparingInt(x -> x)).get();
    }

    public static List<int[]> getAncestorDiff(TreeNode root) {
        List<int[]> result = new ArrayList<>();
        if (root == null) {
            return result;
        } else {
            List<int[]> left = getAncestorDiff(root.left);
            List<int[]> right = getAncestorDiff(root.right);

            if (root.left != null) {
                result.add(new int[]{root.val, root.val - root.left.val});
            }

            if (root.right != null) {
                result.add(new int[]{root.val, root.val - root.right.val});
            }

            if (!left.isEmpty()) {
                for (int[] value : left) {
                    result.add(new int[]{root.val, root.val - value[0] + value[1]});
                }
            }

            if (!right.isEmpty()) {
                for (int[] value : right) {
                    result.add(new int[]{root.val, root.val - value[0] + value[1]});
                }
            }

            result.addAll(left);
            result.addAll(right);
            return result;
        }
    }
}
