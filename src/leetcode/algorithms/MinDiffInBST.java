package leetcode.algorithms;

import leetcode.entity.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: Minimum Distance Between BST Nodes
 *
 * @author Baltan
 * @date 2019-02-25 11:09
 */
public class MinDiffInBST {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(6);
        TreeNode node4 = new TreeNode(1);
        TreeNode node5 = new TreeNode(3);

        node1.left = node2;
        node1.right = node3;

        node2.left = node4;
        node2.right = node5;

        System.out.println(minDiffInBST(node1));
    }

    public static int minDiffInBST(TreeNode root) {
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
