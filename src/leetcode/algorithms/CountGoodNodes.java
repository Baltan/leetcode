package leetcode.algorithms;

import java.util.*;

/**
 * Description: 3249. Count the Number of Good Nodes
 *
 * @author baltan
 * @date 2024/8/12 14:41
 */
public class CountGoodNodes {
    public static void main(String[] args) {
        System.out.println(countGoodNodes(new int[][]{{0, 1}, {0, 2}, {1, 3}, {1, 4}, {2, 5}, {2, 6}}));
        System.out.println(countGoodNodes(new int[][]{{0, 1}, {1, 2}, {2, 3}, {3, 4}, {0, 5}, {1, 6}, {2, 7}, {3, 8}}));
        System.out.println(countGoodNodes(new int[][]{{0, 1}, {1, 2}, {1, 3}, {1, 4}, {0, 5}, {5, 6}, {6, 7}, {7, 8}, {0, 9}, {9, 10}, {9, 12}, {10, 11}}));
    }

    private static int result;

    public static int countGoodNodes(int[][] edges) {
        result = 0;
        /**
         * counts[i]表示以节点i为根节点的多叉树中的节点数量
         */
        int[] counts = new int[edges.length + 1];
        /**
         * graph[i]表示与节点i相邻的所有节点
         */
        List<Integer>[] graph = new List[edges.length + 1];
        Arrays.setAll(graph, i -> new ArrayList<>());
        /**
         * 构建图
         */
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        dfs(0, -1, graph, counts);
        return result;
    }

    /**
     * 递归计算以每个节点作为根节点的多叉树中的节点数量
     *
     * @param node
     * @param parent
     * @param graph
     * @param counts
     */
    public static void dfs(int node, int parent, List<Integer>[] graph, int[] counts) {
        /**
         * 节点node的各个子树的节点数量
         */
        Set<Integer> countSet = new HashSet<>();
        /**
         * 现将节点node本身计数
         */
        counts[node]++;

        for (int child : graph[node]) {
            /**
             * 排除节点node的父节点
             */
            if (child == parent) {
                continue;
            }
            dfs(child, node, graph, counts);
            /**
             * 节点node的所有子树中的节点总数
             */
            counts[node] += counts[child];
            countSet.add(counts[child]);
        }
        /**
         * 如果countSet为空集合，说明节点node是叶子节点，也是一个好节点
         */
        if (countSet.isEmpty() || countSet.size() == 1) {
            result++;
        }
    }
}
