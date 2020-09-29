package leetcode.algorithms;

import leetcode.entity.TreeNode;
import leetcode.util.BinaryTreeUtils;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Description: 145. Binary Tree Postorder Traversal
 *
 * @author Baltan
 * @date 2020-09-29 08:45
 */
public class PostorderTraversal {
    public static void main(String[] args) {
        TreeNode root1 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{1, null, 2, null, null, 3}, 0);
        System.out.println(postorderTraversal(root1));
    }

    /**
     * 参考：
     * <a href="https://leetcode-cn.com/problems/binary-tree-postorder-traversal/solution/die-dai-jie-fa-shi-jian-fu-za-du-onkong-jian-fu-za/"></a>
     *
     * @param root
     * @return
     */
    public static List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> result = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();

        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                stack.push(root);
                result.addFirst(root.val);
                root = root.right;
            } else {
                root = stack.pop();
                root = root.left;
            }
        }
        return result;
    }
}
