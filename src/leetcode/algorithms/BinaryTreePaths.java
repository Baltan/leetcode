package leetcode.algorithms;

import leetcode.entity.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: 257. Binary Tree Paths
 *
 * @author Baltan
 * @date 2018/8/8 09:33
 */
public class BinaryTreePaths {
    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(5);
        root1.left = node1;
        root1.right = node2;
        node1.right = node3;
        System.out.println(binaryTreePaths(root1));

        TreeNode root2 = null;
        System.out.println(binaryTreePaths(root2));

        TreeNode root3 = new TreeNode(1);
        System.out.println(binaryTreePaths(root3));
    }

    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        if (root.left == null && root.right == null) {
            res.add(String.valueOf(root.val));
            return res;
        } else if (root.left == null && root.right != null) {
            List<String> list = binaryTreePaths(root.right);
            for (String str : list) {
                StringBuilder sb = new StringBuilder().append(root.val).append("->").append(str);
                res.add(sb.toString());
            }
        } else if (root.left != null && root.right == null) {
            List<String> list = binaryTreePaths(root.left);
            for (String str : list) {
                StringBuilder sb = new StringBuilder().append(root.val).append("->").append(str);
                res.add(sb.toString());
            }
        } else {
            List<String> list1 = binaryTreePaths(root.left);
            List<String> list2 = binaryTreePaths(root.right);
            for (String str : list1) {
                StringBuilder sb = new StringBuilder().append(root.val).append("->").append(str);
                res.add(sb.toString());
            }
            for (String str : list2) {
                StringBuilder sb = new StringBuilder().append(root.val).append("->").append(str);
                res.add(sb.toString());
            }
        }
        return res;
    }
}
