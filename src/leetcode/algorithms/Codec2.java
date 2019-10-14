package leetcode.algorithms;

import leetcode.entity.TreeNode;

import java.util.Objects;
import java.util.Stack;

/**
 * Description: 449. Serialize and Deserialize BST
 *
 * @author Baltan
 * @date 2019-10-14 08:55
 * @see Codec1
 */
public class Codec2 {
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

    /**
     * Encodes a tree to a single string.
     */
    public static String serialize(TreeNode root) {
        if (root == null) {
            return "[]";
        }
        return "[" + root.val + serialize(root.left) + serialize(root.right) + "]";
    }

    /**
     * Decodes your encoded data to tree.
     */
    public static TreeNode deserialize(String data) {
        if (data == null || !data.startsWith("[") || !data.endsWith("]") || Objects.equals(data, "[]")) {
            return null;
        }
        /**
         * 查找字符串中的第2个"["（第1个"["为字符串的第1个字符）
         */
        int index = data.indexOf("[", 1);
        /**
         * 确定第一个数字，即根节点的值
         */
        TreeNode root = new TreeNode(Integer.valueOf(data.substring(1, index)));
        int length = data.length();
        Stack<Character> stack = new Stack<>();
        /**
         * 确定根节点左子树序列化后的字符串和右节点序列化后的字符串
         */
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
}
