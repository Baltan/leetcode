package leetcode.algorithms;

import leetcode.entity.TreeNode;

import java.util.TreeSet;

/**
 * Description: 671. Second Minimum Node In a Binary Tree
 *
 * @author Baltan
 * @date 2018/8/8 11:37
 */
public class FindSecondMinimumValue {
    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(2);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(5);
        TreeNode node3 = new TreeNode(5);
        TreeNode node4 = new TreeNode(7);
        root1.left = node1;
        root1.right = node2;
        node2.left = node3;
        node2.right = node4;
        System.out.println(findSecondMinimumValue(root1));

        TreeNode root2 = new TreeNode(2);
        TreeNode node5 = new TreeNode(2);
        TreeNode node6 = new TreeNode(2);
        root2.left = node5;
        root2.right = node6;
        System.out.println(findSecondMinimumValue(root2));

        TreeNode root3 = new TreeNode(1);
        System.out.println(findSecondMinimumValue(root3));

        TreeNode root4 = new TreeNode(2);
        TreeNode node7 = new TreeNode(2);
        TreeNode node8 = new TreeNode(5);
        TreeNode node9 = new TreeNode(5);
        TreeNode node10 = new TreeNode(5);
        root4.left = node7;
        root4.right = node8;
        node8.left = node9;
        node8.right = node10;
        System.out.println(findSecondMinimumValue(root4));
    }

    public static int findSecondMinimumValue(TreeNode root) {
        return findMinAndSecondMin(root)[1];
    }

    public static int[] findMinAndSecondMin(TreeNode root) {
        int[] arr = new int[2];
        if (root.left == null && root.right == null) {
            arr[0] = root.val;
            arr[1] = -1;
            return arr;
        }
        int[] arr1 = findMinAndSecondMin(root.left);
        int[] arr2 = findMinAndSecondMin(root.right);

        TreeSet<Integer> set = new TreeSet<>();
        set.add(root.val);
        set.add(arr1[0]);
        set.add(arr2[0]);
        if (arr1[1] != -1) {
            set.add(arr1[1]);
        }
        if (arr2[1] != -1) {
            set.add(arr2[1]);
        }

        if (set.size() < 2) {
            arr[0] = set.pollFirst();
            arr[1] = -1;
        } else {
            arr[0] = set.pollFirst();
            arr[1] = set.pollFirst();
        }
        return arr;
    }
}
