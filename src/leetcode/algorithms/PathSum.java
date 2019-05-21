package leetcode.algorithms;

import leetcode.entity.TreeNode;

/**
 * Description: 437. Path Sum III
 *
 * @author Baltan
 * @date 2018/8/9 09:26
 */
public class PathSum {
    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(10);
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(-3);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(2);
        TreeNode node5 = new TreeNode(11);
        TreeNode node6 = new TreeNode(3);
        TreeNode node7 = new TreeNode(-2);
        TreeNode node8 = new TreeNode(1);
        root1.left = node1;
        root1.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        node4.right = node8;
        System.out.println(pathSum(root1, 8));

        TreeNode root2 = new TreeNode(1);
        TreeNode node9 = new TreeNode(2);
        TreeNode node10 = new TreeNode(3);
        TreeNode node11 = new TreeNode(4);
        TreeNode node12 = new TreeNode(5);
        root2.right = node9;
        node9.right = node10;
        node10.right = node11;
        node11.right = node12;
        System.out.println(pathSum(root2, 3));
    }

    public static int pathSum(TreeNode root, int sum) {
        int num = 0;
        if (root == null) {
            return num;
        }
        num += dfs(root, sum);
        if (root.left != null) {
            num += pathSum(root.left, sum);
        }
        if (root.right != null) {
            num += pathSum(root.right, sum);
        }
        return num;
    }

    public static int dfs(TreeNode root, int sum) {
        int num = 0;
        if (root == null) {
            return num;
        }
        if (root.val == sum) {
            num++;
        }
        if (root.left != null) {
            num += dfs(root.left, sum - root.val);
        }
        if (root.right != null) {
            num += dfs(root.right, sum - root.val);
        }
        return num;
    }
}
