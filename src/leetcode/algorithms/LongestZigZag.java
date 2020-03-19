package leetcode.algorithms;

import leetcode.entity.TreeNode;
import leetcode.util.BinaryTreeUtils;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * Description: 1372. Longest ZigZag Path in a Binary Tree
 *
 * @author Baltan
 * @date 2020-03-19 10:50
 */
public class LongestZigZag {
    public static void main(String[] args) {
        TreeNode root1 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{1, null, 1, null, null, 1, 1, null,
                null, null, null, null, null, 1, 1, null, null, null, null, null, null, null, null, null,
                null, null, null, null, 1, null, null, null, null, null, null, null, null, null, null, null,
                null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
                null, null, null, 1, null, null, null, null}, 0);
        System.out.println(longestZigZag(root1));

        TreeNode root2 =
                BinaryTreeUtils.arrayToBinaryTree(new Integer[]{1, 1, 1, null, 1, null, null, null, null, 1
                        , 1, null, null, null, null, null, null, null, null, null, 1, null, null, null,
                        null,
                        null, null, null, null, null, null}, 0);
        System.out.println(longestZigZag(root2));

        TreeNode root3 =
                BinaryTreeUtils.arrayToBinaryTree(new Integer[]{1}, 0);
        System.out.println(longestZigZag(root3));
    }

    public static int longestZigZag(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int result = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        /**
         * 当node作为从上向下的交错路径最后一个左节点时路径的最大长度
         */
        Map<TreeNode, Integer> leftMap = new HashMap<>();
        /**
         * 当node作为从上向下的交错路径最后一个右节点时路径的最大长度
         */
        Map<TreeNode, Integer> rightMap = new HashMap<>();
        queue.offer(root);
        leftMap.put(root, 0);
        rightMap.put(root, 0);

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                if (node.left != null) {
                    queue.offer(node.left);
                    /**
                     * 对于当前左子节点，如果它的父节点是某条交错路径最后一个右节点，则以这个左子节点结尾
                     * 的交错路径长度会加1；
                     * <pre>
                     *       ○
                     *        \
                     *         ○
                     *        /
                     *      ○
                     * </pre>
                     * 否则以这个左子节点结尾的交错路径长度为1
                     * <pre>
                     *       ○
                     *      /
                     *    ○
                     *   /
                     * ○
                     * </pre>
                     */
                    if (rightMap.containsKey(node)) {
                        int length = rightMap.get(node) + 1;
                        result = Math.max(result, length);
                        leftMap.put(node.left, length);
                    } else {
                        result = Math.max(result, 1);
                        leftMap.put(node.left, 1);
                    }
                }

                if (node.right != null) {
                    queue.offer(node.right);
                    /**
                     * 对于当前右子节点，如果它的父节点是某条交错路径最后一个左节点，则以这个右子节点结尾
                     * 的交错路径长度会加1；
                     * <pre>
                     *       ○
                     *      /
                     *    ○
                     *     \
                     *      ○
                     * </pre>
                     * 否则以这个右子节点结尾的交错路径长度为1
                     * <pre>
                     *       ○
                     *        \
                     *         ○
                     *          \
                     *           ○
                     * </pre>
                     */
                    if (leftMap.containsKey(node)) {
                        int length = leftMap.get(node) + 1;
                        result = Math.max(result, length);
                        rightMap.put(node.right, length);
                    } else {
                        result = Math.max(result, 1);
                        rightMap.put(node.right, 1);
                    }
                }
            }
        }
        return result;
    }
}
