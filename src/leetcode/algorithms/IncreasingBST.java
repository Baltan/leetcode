package leetcode.algorithms;

import leetcode.entity.TreeNode;
import leetcode.util.BinaryTreeUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: 897. Increasing Order Search Tree
 *
 * @author Baltan
 * @date 2019-03-14 15:50
 */
public class IncreasingBST {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);
        TreeNode node9 = new TreeNode(9);

        node5.left = node3;
        node5.right = node6;

        node3.left = node2;
        node3.right = node4;

        node6.right = node8;

        node2.left = node1;

        node8.left = node7;
        node8.right = node9;

        System.out.println(BinaryTreeUtils.inOrder(increasingBST(node5)));
    }

    public static TreeNode increasingBST(TreeNode root) {
        List<Integer> list = inOrder(root);
        TreeNode node = new TreeNode(list.get(0));
        TreeNode temp = node;
        int size = list.size();

        for (int i = 1; i < size; i++) {
            TreeNode current = new TreeNode(list.get(i));
            temp.right = current;
            temp = current;
        }
        return node;
    }

    public static List<Integer> inOrder(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        if (root == null) {
            return list;
        } else {
            list.addAll(inOrder(root.left));
            list.add(root.val);
            list.addAll(inOrder(root.right));
        }
        return list;
    }
}
