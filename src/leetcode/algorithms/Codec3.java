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
        boolean flag = true;
        queue.offer(root);

        while (!queue.isEmpty() && flag) {
            int size = queue.size();
            flag = false;

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                if (node == null) {
                    builder.append(" ").append("*");
                    queue.offer(null);
                    queue.offer(null);
                } else {
                    flag = true;
                    builder.append(node.val).append("*");
                    queue.offer(node.left);
                    queue.offer(node.right);
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
        TreeNode root = new TreeNode(Integer.valueOf(values[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (index < length) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                if (node == null) {
                    index += 2;
                    queue.offer(null);
                    queue.offer(null);
                } else {
                    String leftValue = values[index++];
                    String rightValue = values[index++];
                    TreeNode left;
                    TreeNode right;

                    if (Objects.equals(leftValue, " ")) {
                        left = null;
                    } else {
                        left = new TreeNode(Integer.valueOf(leftValue));
                    }

                    if (Objects.equals(rightValue, " ")) {
                        right = null;
                    } else {
                        right = new TreeNode(Integer.valueOf(rightValue));
                    }

                    node.left = left;
                    node.right = right;
                    queue.offer(left);
                    queue.offer(right);
                }
            }
        }
        return root;
    }
}
