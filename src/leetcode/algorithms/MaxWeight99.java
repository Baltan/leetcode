package leetcode.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description: 3543. Maximum Weighted K-Edge Path
 *
 * @author Baltan
 * @date 2025/6/1 22:57
 */
public class MaxWeight99 {
    public static void main(String[] args) {
        System.out.println(maxWeight(3, new int[][]{{0, 1, 1}, {1, 2, 2}}, 2, 4));
        System.out.println(maxWeight(3, new int[][]{{0, 1, 2}, {0, 2, 3}}, 1, 3));
        System.out.println(maxWeight(3, new int[][]{{0, 1, 6}, {1, 2, 8}}, 1, 6));
    }

    private static int result;

    public static int maxWeight(int n, int[][] edges, int k, int t) {
        /**
         * 初始化假设不存在满足条件的路径
         */
        result = -1;
        /**
         * graph[i]保存所有以节点i为起点的边
         */
        List<int[]>[] graph = new List[n];
        /**
         * isVisited[i][j][l]表示到达节点i的路径中刚好包含j条边，路径上边权值之和为l的情况是否已被计算过
         */
        boolean[][][] isVisited = new boolean[n][k + 1][t + 1];
        Arrays.setAll(graph, i -> new ArrayList<>());
        /**
         * 构建图
         */
        for (int[] edge : edges) {
            graph[edge[0]].add(edge);
        }
        /**
         * 以每个节点作为路径起点，分别计算是否存在满足条件的路径
         */
        for (int i = 0; i < n; i++) {
            dfs(graph, isVisited, i, 0, 0, k, t);
        }
        return result;
    }

    /**
     * 深度优先搜索计算满足条件的路径
     *
     * @param graph
     * @param isVisited
     * @param node      当前节点
     * @param edgeCount 到达当前节点的路径上边的数量
     * @param weightSum 到达当前节点的路径上边权值之和
     * @param k
     * @param t
     */
    public static void dfs(List<int[]>[] graph, boolean[][][] isVisited, int node, int edgeCount, int weightSum, int k, int t) {
        /**
         * 如果到达节点node的路径上边的数量大于k或者边权值之和不小于t，则当前路径一定不满足条件。如果到达节点node的路径中刚好包含edgeCount
         * 条边，路径上边权值之和为weightSum的情况是否已被计算过，也不需要再继续向下计算路径
         */
        if (weightSum >= t || edgeCount > k || isVisited[node][edgeCount][weightSum]) {
            return;
        }
        isVisited[node][edgeCount][weightSum] = true;

        if (edgeCount == k) {
            result = Math.max(result, weightSum);
            return;
        }
        /**
         * 从节点node继续延长路径
         */
        for (int[] edge : graph[node]) {
            dfs(graph, isVisited, edge[1], edgeCount + 1, weightSum + edge[2], k, t);
        }
    }
}
