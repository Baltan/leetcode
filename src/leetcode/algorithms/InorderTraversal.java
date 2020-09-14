package leetcode.algorithms;

import leetcode.entity.TreeNode;
import leetcode.util.BinaryTreeUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: 94. Binary Tree Inorder Traversal
 *
 * @author Baltan
 * @date 2019-05-22 10:04
 * @see InorderTraversal1
 */
public class InorderTraversal {
    public static void main(String[] args) {
        TreeNode root1 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{1, null, 2, null, null, 3}, 0);
        System.out.println(inorderTraversal(root1));
    }

    /**
     * 递归算法
     *
     * @param root
     * @return
     */
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if (root != null) {
            result.addAll(inorderTraversal(root.left));
            result.add(root.val);
            result.addAll(inorderTraversal(root.right));
        }
        return result;
    }
}
