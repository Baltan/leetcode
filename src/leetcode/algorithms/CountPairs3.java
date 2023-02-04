package leetcode.algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: 2316. Count Unreachable Pairs of Nodes in an Undirected Graph
 *
 * @author Baltan
 * @date 2023/1/19 10:23
 */
public class CountPairs3 {
    public static void main(String[] args) {
        System.out.println(countPairs(3, new int[][]{{0, 1}, {0, 2}, {1, 2}}));
        System.out.println(countPairs(7, new int[][]{{0, 2}, {0, 5}, {2, 4}, {1, 6}, {5, 4}}));
    }

    /**
     * 当前遍历到的连通分量的节点数
     */
    private static int nodeCount;

    public static long countPairs(int n, int[][] edges) {
        long result = 0L;
        /**
         * graphs[i]为和节点i直接相连的节点的列表
         */
        List<Integer>[] graphs = new List[n];
        /**
         * isVisited[i]表示节点i已访问过
         */
        boolean[] isVisited = new boolean[n];
        /**
         * 已累计的连通分量的节点数
         */
        long totalNodeCount = 0L;

        for (int i = 0; i < n; i++) {
            graphs[i] = new ArrayList<>();
        }
        /**
         * 构建图
         */
        for (int[] edge : edges) {
            int x = edge[0];
            int y = edge[1];
            graphs[x].add(y);
            graphs[y].add(x);
        }

        for (int i = 0; i < n; i++) {
            /**
             * 初始化当前连通分量的节点数为0
             */
            nodeCount = 0;
            dfs(i, graphs, isVisited);

            if (nodeCount != 0) {
                /**
                 * 不同的连通分量中的节点都是无法相互到达的，当前连通分量的节点和之前已累计的节点都属于不同的连通分量
                 */
                result += nodeCount * totalNodeCount;
                totalNodeCount += nodeCount;
            }
        }
        return result;
    }

    /**
     * 从from开始深度优先搜索无向图，累计当前连通分量中节点的个数
     *
     * @param from
     * @param graphs
     * @param isVisited
     */
    public static void dfs(int from, List<Integer>[] graphs, boolean[] isVisited) {
        if (isVisited[from]) {
            return;
        }
        nodeCount++;
        isVisited[from] = true;

        for (int to : graphs[from]) {
            dfs(to, graphs, isVisited);
        }
    }
}
