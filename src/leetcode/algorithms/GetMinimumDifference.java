package leetcode.algorithms;

import leetcode.entity.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: 530. Minimum Absolute Difference in BST
 *
 * @author Baltan
 * @date 2019-02-25 11:19
 */
public class GetMinimumDifference {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(2);

        node1.right = node2;
        node2.left = node3;

        System.out.println(getMinimumDifference(node1));
    }

    public static int getMinimumDifference(TreeNode root) {
        List<Integer> list = midOrder(root);
        int difference = Integer.MAX_VALUE;

        for (int i = 0, size = list.size(); i < size - 1; i++) {
            difference =
                    list.get(i + 1) - list.get(i) < difference ? list.get(i + 1) - list.get(i) : difference;
        }
        return difference;
    }

    public static List<Integer> midOrder(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        if (root == null) {
            return list;
        }

        list.addAll(midOrder(root.left));
        list.add(root.val);
        list.addAll(midOrder(root.right));

        return list;
    }
}
