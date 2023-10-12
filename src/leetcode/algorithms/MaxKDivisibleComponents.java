package leetcode.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description: 2872. Maximum Number of K-Divisible Components
 *
 * @author Baltan
 * @date 2023/10/10 21:59
 * 参考：<a href="https://leetcode.cn/problems/maximum-number-of-k-divisible-components/solutions/2464687/pan-duan-zi-shu-dian-quan-he-shi-fou-wei-uvsg/"></a>
 */
public class MaxKDivisibleComponents {
    public static void main(String[] args) {
        int[][] edges1 = {{0, 2}, {1, 2}, {1, 3}, {2, 4}};
        int[] values1 = {1, 8, 1, 4, 4};
        System.out.println(maxKDivisibleComponents(5, edges1, values1, 6));

        int[][] edges2 = {{0, 1}, {0, 2}, {1, 3}, {1, 4}, {2, 5}, {2, 6}};
        int[] values2 = {3, 0, 6, 1, 5, 2, 1};
        System.out.println(maxKDivisibleComponents(7, edges2, values2, 3));
    }

    private static int result;

    public static int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        result = 0;
        /**
         * sums[i]表示节点i的所有后代节点值的和
         */
        long[] sums = new long[n];
        /**
         * graph[i]表示与节点i相邻的所有节点
         */
        List<Integer>[] graph = new List[n];
        Arrays.setAll(graph, x -> new ArrayList<>());

        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        getSum(0, -1, graph, values, sums, k);
        return result;
    }

    /**
     * 计算以节点node作为根节点的子树中所有节点值的和
     *
     * @param node
     * @param from
     * @param graph
     * @param values
     * @param sums
     * @param k
     */
    public static void getSum(int node, int from, List<Integer>[] graph, int[] values, long[] sums, int k) {
        sums[node] += values[node];

        for (int neighbor : graph[node]) {
            /**
             * 节点neighbor为节点node的父节点，不在以根节点为node的子树中，跳过
             */
            if (neighbor == from) {
                continue;
            }
            /**
             * 递归计算以节点neighbor作为根节点的子树中所有节点值的和
             */
            getSum(neighbor, node, graph, values, sums, k);
            sums[node] += sums[neighbor];
        }
        /**
         * 如果以节点node作为根节点的子树中所有节点值的和为k的倍数，说明当前子树可以独立成为一个连通块
         */
        if (sums[node] % k == 0) {
            result++;
        }
    }
}
