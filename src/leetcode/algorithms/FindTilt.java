package leetcode.algorithms;

import leetcode.entity.TreeNode;

/**
 * Description: 563. Binary Tree Tilt
 *
 * @author Baltan
 * @date 2018/8/2 14:43
 */
public class FindTilt {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        root.left = node1;
        root.right = node2;
        System.out.println(findTilt(root));
    }

    public static int findTilt(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int totalTilt;
        totalTilt = Math.abs(treeSum(root.left) - treeSum(root.right)) + findTilt(root.left) + findTilt(root
                .right);
        return totalTilt;
    }

    public static int treeSum(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return root.val + treeSum(root.left) + treeSum(root.right);
        }
    }
}
