package leetcode.algorithms;

import leetcode.entity.TreeNode;

import java.util.Objects;
import java.util.Stack;

/**
 * Description: 297. Serialize and Deserialize Binary Tree
 *
 * @author Baltan
 * @date 2019-06-18 09:11
 */
public class Codec1 {
    /**
     * Encodes a tree to a single string.
     *
     * @param root
     * @return
     */
    public static String serialize(TreeNode root) {
        if (root == null) {
            return "[]";
        }
        return "[" + root.val + serialize(root.left) + serialize(root.right) + "]";
    }

    /**
     * Decodes your encoded data to tree.
     *
     * @param data
     * @return
     */
    public static TreeNode deserialize(String data) {
        if (data == null || !data.startsWith("[") || !data.endsWith("]") || Objects.equals(data, "[]")) {
            return null;
        }
        int index = data.indexOf("[", 1);
        TreeNode root = new TreeNode(Integer.valueOf(data.substring(1, index)));
        int length = data.length();
        Stack<Character> stack = new Stack<>();

        for (int i = 1; ; i++) {
            char c = data.charAt(i);
            if (c != '[' && c != ']') {
                continue;
            } else if (c == '[') {
                stack.push(c);
            } else if (c == ']') {
                stack.pop();
            }

            if (stack.isEmpty()) {
                root.left = deserialize(data.substring(index, i + 1));
                root.right = deserialize(data.substring(i + 1, length - 1));
                return root;
            }
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode11 = new TreeNode(1);
        TreeNode treeNode12 = new TreeNode(2);
        TreeNode treeNode13 = new TreeNode(3);
        TreeNode treeNode14 = new TreeNode(4);
        TreeNode treeNode15 = new TreeNode(5);
        treeNode11.left = treeNode12;
        treeNode11.right = treeNode13;
        treeNode13.left = treeNode14;
        treeNode13.right = treeNode15;
        String str1 = serialize(treeNode11);
        System.out.println(str1);

        TreeNode root1 = deserialize(str1);
        System.out.println(root1);

        System.out.println("----------------------------------------");

        TreeNode treeNode21 = new TreeNode(-1);
        TreeNode treeNode22 = new TreeNode(0);
        TreeNode treeNode23 = new TreeNode(1);
        treeNode21.left = treeNode22;
        treeNode21.right = treeNode23;
        String str2 = serialize(treeNode21);
        System.out.println(str2);

        TreeNode root2 = deserialize(str2);
        System.out.println(root2);
    }
}
