package leetcode.algorithms;

import leetcode.entity.TreeNode;
import leetcode.util.BinaryTreeUtils;

import java.util.Objects;
import java.util.Stack;

/**
 * Description: 297. Serialize and Deserialize Binary Tree
 *
 * @author Baltan
 * @date 2019-06-18 09:11
 * @see Codec2
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
        /**
         * 查找字符串data中第二个"["的位置
         */
        int index = data.indexOf("[", 1);
        /**
         * 索引位置为0的字符是data中的第一个"["，第一个"["和第二个"["之间的部分是二叉树根节点的值
         */
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
            /**
             * 当stack中没有元素时，就找到了一棵子树序列化后的字符串
             */
            if (stack.isEmpty()) {
                root.left = deserialize(data.substring(index, i + 1));
                root.right = deserialize(data.substring(i + 1, length - 1));
                return root;
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root1 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{1, 2, 3, 4, 5}, 0);
        String str1 = serialize(root1);
        System.out.println(str1);

        TreeNode root11 = deserialize(str1);
        System.out.println(root11);

        System.out.println("----------------------------------------");

        TreeNode root2 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{-1, 0, 1}, 0);
        String str2 = serialize(root2);
        System.out.println(str2);

        TreeNode root21 = deserialize(str2);
        System.out.println(root21);
    }
}
