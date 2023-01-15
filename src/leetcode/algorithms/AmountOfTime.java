package leetcode.algorithms;

import leetcode.entity.TreeNode;
import leetcode.util.BinaryTreeUtils;

import java.util.*;

/**
 * Description: 2385. Amount of Time for Binary Tree to Be Infected
 *
 * @author Baltan
 * @date 2023/1/1 12:32
 */
public class AmountOfTime {
    public static void main(String[] args) {
        TreeNode root1 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{1, 5, 3, null, 4, 10, 6, null, null, 9, 2}, 0);
        System.out.println(amountOfTime(root1, 3));

        TreeNode root2 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{1}, 0);
        System.out.println(amountOfTime(root2, 1));

        TreeNode root3 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{1, 5, 3, null, 4, 10, 6, null, null, 9, 2}, 0);
        System.out.println(amountOfTime(root3, 6));

        TreeNode root4 = BinaryTreeUtils.arrayToBinaryTree(new Integer[]{1, null, 2, null, null, 3, 4, null, null, null, null, null, 5}, 0);
        System.out.println(amountOfTime(root4, 4));
    }

    public static int amountOfTime(TreeNode root, int start) {
        /**
         * 没有任何其他节点可以被感染
         */
        if (root.left == null && root.right == null) {
            return 0;
        }
        int result = -1;
        /**
         * 节点i -> 可以被节点i直接感染的节点列表
         */
        Map<Integer, List<Integer>> paths = new HashMap<>();
        /**
         * 已被感染的节点
         */
        Set<Integer> isVisited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        /**
         * 从值为start的节点开始感染
         */
        queue.offer(start);
        isVisited.add(start);
        getPaths(root, paths);
        /**
         * 广度优先搜索逐层向外感染
         */
        while (!queue.isEmpty()) {
            result++;
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int from = queue.poll();
                /**
                 * 可以被from节点直接感染的节点列表
                 */
                List<Integer> toList = paths.get(from);

                for (int to : toList) {
                    if (!isVisited.contains(to)) {
                        queue.offer(to);
                        isVisited.add(to);
                    }
                }
            }
        }
        return result;
    }

    /**
     * 查找每个节点可以直接感染的其他节点
     *
     * @param root
     * @param paths
     */
    public static void getPaths(TreeNode root, Map<Integer, List<Integer>> paths) {
        if (root == null) {
            return;
        }
        /**
         * 从root节点向左子树感染
         */
        if (root.left != null) {
            List<Integer> fromRoot = paths.computeIfAbsent(root.val, x -> new ArrayList<>());
            fromRoot.add(root.left.val);
            getPaths(root.left, paths);

            List<Integer> fromLeft = paths.computeIfAbsent(root.left.val, x -> new ArrayList<>());
            fromLeft.add(root.val);
        }
        /**
         * 从root节点向右子树感染
         */
        if (root.right != null) {
            List<Integer> fromRoot = paths.computeIfAbsent(root.val, x -> new ArrayList<>());
            fromRoot.add(root.right.val);
            getPaths(root.right, paths);

            List<Integer> fromRight = paths.computeIfAbsent(root.right.val, x -> new ArrayList<>());
            fromRight.add(root.val);
        }
    }
}
