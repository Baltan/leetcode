package leetcode.algorithms;

import leetcode.entity.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: Binary Tree Level Order Traversal II
 *
 * @author Baltan
 * @date 2018/7/27 23:56
 */
public class LevelOrderBottom {
    public static void main(String[] args) {
        TreeNode node11 = new TreeNode(3);
        TreeNode node21 = new TreeNode(9);
        TreeNode node22 = new TreeNode(20);
        TreeNode node33 = new TreeNode(15);
        TreeNode node34 = new TreeNode(7);
        node11.left = node21;
        node11.right = node22;
        node22.left = node33;
        node22.right = node34;
        System.out.println(levelOrderBottom(node11));

        TreeNode node41 = new TreeNode(1);
        TreeNode node51 = new TreeNode(2);
        TreeNode node52 = new TreeNode(3);
        TreeNode node61 = new TreeNode(4);
        TreeNode node62 = new TreeNode(5);
        node41.left = node51;
        node41.right = node52;
        node51.left = node61;
        node51.right = node62;
        System.out.println(levelOrderBottom(node41));

        TreeNode node71 = new TreeNode(1);
        TreeNode node81 = new TreeNode(2);
        TreeNode node82 = new TreeNode(2);
        TreeNode node91 = new TreeNode(3);
        TreeNode node92 = new TreeNode(4);
        TreeNode node93 = new TreeNode(4);
        TreeNode node94 = new TreeNode(3);
        node71.left = node81;
        node71.right = node82;
        node81.left = node91;
        node81.right = node92;
        node82.left = node93;
        node82.right = node94;
        System.out.println(levelOrderBottom(node71));
    }

    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        } else {
            List<Integer> list = new ArrayList<>();
            list.add(root.val);
            res.add(list);
            if (root.left == null && root.right == null) {
                return res;
            } else {
                List<List<Integer>> list1 = new ArrayList<>();
                List<List<Integer>> leftRes = levelOrderBottom(root.left);
                List<List<Integer>> rightRes = levelOrderBottom(root.right);
                int leftDepth = leftRes.size();
                int rightDepth = rightRes.size();
                if (leftDepth > rightDepth) {
                    for (int i = 0; i < leftDepth - rightDepth; i++) {
                        list1.add(leftRes.get(i));
                    }
                    for (int i = 0; i < rightDepth; i++) {
                        leftRes.get(leftDepth - rightDepth + i).addAll(rightRes.get(i));
                        list1.add(leftRes.get(leftDepth - rightDepth + i));
                    }
                    list1.add(list);
                    return list1;
                } else if (leftDepth < rightDepth) {
                    for (int i = 0; i < rightDepth - leftDepth; i++) {
                        list1.add(rightRes.get(i));
                    }
                    for (int i = 0; i < leftDepth; i++) {
                        leftRes.get(i).addAll(rightRes.get(rightDepth - leftDepth + i));
                        list1.add(leftRes.get(i));
                    }
                    list1.add(list);
                    return list1;
                } else {
                    for (int i = 0; i < leftDepth; i++) {
                        leftRes.get(i).addAll(rightRes.get(i));
                        list1.add(leftRes.get(i));
                    }
                    list1.add(list);
                    return list1;
                }
            }
        }
    }
}
