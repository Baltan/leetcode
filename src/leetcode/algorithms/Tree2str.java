package leetcode.algorithms;

import leetcode.entity.TreeNode;

/**
 * Description: 606. Construct String from Binary Tree
 *
 * @author Baltan
 * @date 2018/8/1 16:37
 */
public class Tree2str {
    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        root1.left = node1;
        root1.right = node2;
        TreeNode node3 = new TreeNode(4);
        node1.left = node3;
        System.out.println(tree2str(root1));

        TreeNode root2 = new TreeNode(1);
        TreeNode node4 = new TreeNode(2);
        TreeNode node5 = new TreeNode(3);
        root2.left = node4;
        root2.right = node5;
        TreeNode node6 = new TreeNode(4);
        node4.right = node6;
        System.out.println(tree2str(root2));
    }

    public static String tree2str(TreeNode t) {
        if (t == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(t.val);

        if (t.left != null) {
            if (t.left.left == null && t.left.right == null) {
                sb.append("(").append(t.left.val).append(")");
            } else {
                sb.append("(").append(tree2str(t.left)).append(")");
            }
        } else {
            if (t.right != null) {
                sb.append("()");
            }
        }
        if (t.right != null) {
            if (t.right.left == null && t.right.right == null) {
                sb.append("(").append(t.right.val).append(")");
            } else {
                sb.append("(").append(tree2str(t.right)).append(")");
            }
        }
        return sb.toString();
    }
}
