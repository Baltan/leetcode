package leetcode.algorithms;

import leetcode.entity.TreeNode;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

/**
 * Description: 449. Serialize and Deserialize BST
 *
 * @author Baltan
 * @date 2019-10-14 08:55
 * @see Codec1
 */
public class Codec3 {
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
            return "";
        }

        StringBuilder builder = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                if (node != null) {
                    builder.append(node.val);
                    TreeNode left = node.left;
                    TreeNode right = node.right;

                    if (left != null) {
                        builder.append("l");
                        queue.offer(left);
                    }

                    if (right != null) {
                        builder.append("r");
                        queue.offer(right);
                    }

                    builder.append("*");
                }
            }
        }
        return builder.substring(0, builder.length() - 1);
    }

    /**
     * Decodes your encoded data to tree.
     */
    public static TreeNode deserialize(String data) {
        if (Objects.equals(data, "")) {
            return null;
        }
        String[] values = data.split("\\*");
        int length = values.length;
        int index = 1;
        TreeNode root = new TreeNode(getValue(values[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<String> markQueue = new LinkedList<>();
        queue.offer(root);
        markQueue.offer(getMark(values[0]));

        while (index < length) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                String mark = markQueue.poll();

                if (mark.contains("l")) {
                    TreeNode left = new TreeNode(getValue(values[index]));
                    String leftMark = getMark(values[index]);
                    node.left = left;
                    queue.offer(left);
                    markQueue.offer(leftMark);
                    index++;
                }

                if (mark.contains("r")) {
                    TreeNode right = new TreeNode(getValue(values[index]));
                    String rightMark = getMark(values[index]);
                    node.right = right;
                    queue.offer(right);
                    markQueue.offer(rightMark);
                    index++;
                }
            }
        }
        return root;
    }

    public static int getValue(String str) {
        StringBuilder builder = new StringBuilder();

        for (char c : str.toCharArray()) {
            if (c >= '0' && c <= '9') {
                builder.append(c);
            }
        }
        return Integer.valueOf(builder.toString());
    }

    public static String getMark(String str) {
        StringBuilder builder = new StringBuilder();

        for (char c : str.toCharArray()) {
            if (c < '0' || c > '9') {
                builder.append(c);
            }
        }
        return builder.toString();
    }
}
