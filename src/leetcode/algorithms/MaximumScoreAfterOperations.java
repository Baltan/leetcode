package leetcode.algorithms;

import java.util.*;

/**
 * Description: 2925. Maximum Score After Applying Operations on a Tree
 *
 * @author Baltan
 * @date 2023/11/8 22:07
 */
public class MaximumScoreAfterOperations {
    public static void main(String[] args) {
        int[][] edges1 = {{0, 1}, {0, 2}, {0, 3}, {2, 4}, {4, 5}};
        int[] values1 = {5, 2, 5, 2, 1, 1};
        System.out.println(maximumScoreAfterOperations(edges1, values1));

        int[][] edges2 = {{0, 1}, {0, 2}, {1, 3}, {1, 4}, {2, 5}, {2, 6}};
        int[] values2 = {20, 10, 9, 7, 4, 3, 5};
        System.out.println(maximumScoreAfterOperations(edges2, values2));
    }

    public static long maximumScoreAfterOperations(int[][] edges, int[] values) {
        /**
         * 所有节点值的和
         */
        long sum = 0L;
        int nodes = values.length;
        /**
         * neighborsArray[i]表示与节点i直接相连的所有节点的集合
         */
        Set<Integer>[] neighborsArray = new Set[nodes];
        Arrays.setAll(neighborsArray, x -> new HashSet<>());

        for (int value : values) {
            sum += value;
        }

        for (int[] edge : edges) {
            neighborsArray[edge[0]].add(edge[1]);
            neighborsArray[edge[1]].add(edge[0]);
        }
        /**
         * 所有节点值之和扣除以节点root为根节点的健康树中所有节点值之和的最小值
         */
        return sum - help(values, neighborsArray, 0);
    }

    /**
     * 计算以节点root为根节点的健康树中所有节点值之和的最小值
     *
     * @param values
     * @param neighborsArray
     * @param root
     * @return
     */
    public static long help(int[] values, Set<Integer>[] neighborsArray, int root) {
        /**
         * 这棵树只有一个根节点root，必须选择当前节点
         */
        if (neighborsArray[root].isEmpty()) {
            return values[root];
        }
        long sum = 0L;
        /**
         * 如果不选择根节点root，则必须保证root的所有子树都是健康的，对所有健康的子树进行递归计算求和
         */
        for (int neighbor : neighborsArray[root]) {
            /**
             * 删除父节点，只保留节点neighbor的子节点
             */
            neighborsArray[neighbor].remove(root);
            sum += help(values, neighborsArray, neighbor);
        }
        return Math.min(values[root], sum);
    }
}
