package leetcode.algorithms;

import leetcode.entity.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: 653. Two Sum IV - Input is a BST
 *
 * @author Baltan
 * @date 2019-02-24 19:02
 */
public class FindTarget {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(6);
        TreeNode node4 = new TreeNode(2);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(7);

        node1.left = node2;
        node1.right = node3;

        node2.left = node4;
        node2.right = node5;

        node3.right = node6;

        System.out.println(findTarget(node1, 28));
        System.out.println(findTarget(node1, 9));
    }

    public static boolean findTarget(TreeNode root, int k) {
        if (root == null || (root.left == null && root.right == null)) {
            return false;
        }
        List<Integer> list = midOrder(root);

        int lo = 0;
        int hi = list.size() - 1;

        while (lo < hi) {
            if (list.get(lo) + list.get(hi) == k) {
                return true;
            } else if (list.get(lo) + list.get(hi) < k) {
                lo++;
            } else {
                hi--;
            }
        }
        return false;
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
