package leetcode.algorithms;

import leetcode.entity.TreeNode;
import leetcode.util.BinaryTreeUtils;

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
        TreeNode root1 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{1, null, 2, null, null, 3}, 0);
        System.out.println(preorderTraversal(root1));

        TreeNode root2 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{1}, 0);
        System.out.println(preorderTraversal(root2));

        TreeNode root3 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{}, 0);
        System.out.println(preorderTraversal(root3));
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
