package leetcode.algorithms;

import leetcode.entity.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: Leaf-Similar Trees
 *
 * @author Baltan
 * @date 2018/8/11 22:21
 */
public class LeafSimilar {
    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(3);
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(6);
        TreeNode node4 = new TreeNode(2);
        TreeNode node5 = new TreeNode(9);
        TreeNode node6 = new TreeNode(8);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(4);
        root1.left = node1;
        root1.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node2.right = node6;
        node4.left = node7;
        node4.right = node8;

        TreeNode root2 = new TreeNode(1);
        TreeNode node9 = new TreeNode(2);
        TreeNode node10 = new TreeNode(3);
        TreeNode node11 = new TreeNode(6);
        TreeNode node12 = new TreeNode(7);
        TreeNode node13 = new TreeNode(5);
        TreeNode node14 = new TreeNode(8);
        TreeNode node15 = new TreeNode(4);
        TreeNode node16 = new TreeNode(9);
        root2.left = node9;
        root2.right = node10;
        node9.left = node11;
        node9.right = node12;
        node10.left = node13;
        node10.right = node14;
        node13.left = node15;
        node13.right = node16;

        System.out.println(leafSimilar(root1, root2));
    }

    public static boolean leafSimilar(TreeNode root1, TreeNode root2) {
        return getLeaves(root1).equals(getLeaves(root2));
    }

    public static List<Integer> getLeaves(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        if (root.left == null && root.right == null) {
            list.add(root.val);
            return list;
        } else {
            list = getLeaves(root.left);
            list.addAll(getLeaves(root.right));
            return list;
        }
    }
}
