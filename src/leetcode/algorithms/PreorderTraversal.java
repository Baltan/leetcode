package leetcode.algorithms;

import leetcode.entity.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Description: 144. Binary Tree Preorder Traversal
 *
 * @author Baltan
 * @date 2019-05-31 16:03
 */
public class PreorderTraversal {
    public static void main(String[] args) {
        TreeNode treeNode11 = new TreeNode(1);
        TreeNode treeNode12 = new TreeNode(2);
        TreeNode treeNode13 = new TreeNode(3);
        treeNode11.right = treeNode12;
        treeNode12.left = treeNode13;
        System.out.println(preorderTraversal(treeNode11));

        TreeNode treeNode21 = new TreeNode(1);
        System.out.println(preorderTraversal(treeNode21));

        TreeNode treeNode31 = null;
        System.out.println(preorderTraversal(treeNode31));
    }

    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        if (root == null) {
            return result;
        }

        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node.val);

            if (node.right != null) {
                stack.push(node.right);
            }

            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return result;
    }
}
