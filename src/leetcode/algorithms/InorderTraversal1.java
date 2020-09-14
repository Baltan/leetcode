package leetcode.algorithms;

import leetcode.entity.TreeNode;
import leetcode.util.BinaryTreeUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Description: 94. Binary Tree Inorder Traversal
 *
 * @author Baltan
 * @date 2019-05-22 10:04
 * @see InorderTraversal
 */
public class InorderTraversal1 {
    public static void main(String[] args) {
        TreeNode root1 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{1, null, 2, null, null, 3}, 0);
        System.out.println(inorderTraversal(root1));
    }

    /**
     * 迭代算法
     *
     * @param root
     * @return
     */
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                result.add(root.val);
                root = root.right;
            }
        }
        return result;
    }
}
