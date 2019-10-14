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
     * <pre>
     * 序列化规则为：
     * 1、只序列化不为null的节点；
     * 2、每个节点的序列化字符串为节点值+该节点左右子树的情况，如果左子树不为null，就标记"l"，如果右子树不为null，
     *    就标记"r"；
     * 3、节点之间的序列化字符串用"*"分隔。
     *
     * 例如：如下二叉树的序列化字符串为"1lr*2*3lr*4*5"
     *          1
     *        /  \
     *      2     3
     *          /  \
     *        4     5
     * </pre>
     */
    public static String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }

        StringBuilder builder = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        /**
         * 逐层处理二叉树的节点
         */
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                if (node != null) {
                    builder.append(node.val);
                    TreeNode left = node.left;
                    TreeNode right = node.right;

                    if (left != null) {
                        /**
                         * 如果左子树不为null，就标记"l"
                         */
                        builder.append("l");
                        /**
                         * 将左子树加入queue，处理二叉树下一层节点时再序列化左子树
                         */
                        queue.offer(left);
                    }

                    if (right != null) {
                        /**
                         * 如果右子树不为null，就标记"r"
                         */
                        builder.append("r");
                        /**
                         * 将右子树加入queue，处理二叉树下一层节点时再序列化右子树
                         */
                        queue.offer(right);
                    }
                    /**
                     * 用"*"分隔节点之间的序列化字符串
                     */
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
        /**
         * 节点序列化字符串数组
         */
        String[] values = data.split("\\*");
        int length = values.length;
        /**
         * 当前要处理的节点序列化字符串的索引
         */
        int index = 1;
        TreeNode root = new TreeNode(getValue(values[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<String> markQueue = new LinkedList<>();
        queue.offer(root);
        markQueue.offer(getMark(values[0]));
        /**
         * 逐层处理二叉树的节点
         */
        while (index < length) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                String mark = markQueue.poll();
                /**
                 * 如果当前节点的标记包含"l"，说明该节点左子树不为null
                 */
                if (mark.contains("l")) {
                    TreeNode left = new TreeNode(getValue(values[index]));
                    /**
                     * 当前节点左子树的标记
                     */
                    String leftMark = getMark(values[index]);
                    node.left = left;
                    /**
                     * 将左子树和左子树的序列化字符串标记加入queue和markQueue，处理二叉树下一层节点时再反序列化左子树
                     */
                    queue.offer(left);
                    markQueue.offer(leftMark);
                    index++;
                }
                /**
                 * 如果当前节点的标记包含"r"，说明该节点右子树不为null
                 */
                if (mark.contains("r")) {
                    TreeNode right = new TreeNode(getValue(values[index]));
                    /**
                     * 当前节点右子树的标记
                     */
                    String rightMark = getMark(values[index]);
                    node.right = right;
                    /**
                     * 将右子树和右子树的序列化字符串标记加入queue和markQueue，处理二叉树下一层节点时再反序列化右子树
                     */
                    queue.offer(right);
                    markQueue.offer(rightMark);
                    index++;
                }
            }
        }
        return root;
    }

    /**
     * 将某个节点的序列化字符串截取值的部分，例如："1lr"截取获得"1"
     */
    public static int getValue(String str) {
        StringBuilder builder = new StringBuilder();

        for (char c : str.toCharArray()) {
            if (c >= '0' && c <= '9') {
                builder.append(c);
            }
        }
        return Integer.valueOf(builder.toString());
    }

    /**
     * 将某个节点的序列化字符串截取表示左右子树的部分，例如："1lr"截取获得"lr"
     */
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
