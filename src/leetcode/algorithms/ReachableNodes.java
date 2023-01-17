package leetcode.algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: 2368. Reachable Nodes With Restrictions
 *
 * @author Baltan
 * @date 2023/1/11 16:36
 */
public class ReachableNodes {
    public static void main(String[] args) {
        int n1 = 7;
        int[][] edges1 = {{0, 1}, {1, 2}, {3, 1}, {4, 0}, {0, 5}, {5, 6}};
        int[] restricted1 = {4, 5};
        System.out.println(reachableNodes(n1, edges1, restricted1));

        int n2 = 7;
        int[][] edges2 = {{0, 1}, {0, 2}, {0, 5}, {0, 4}, {3, 2}, {6, 5}};
        int[] restricted2 = {4, 2, 1};
        System.out.println(reachableNodes(n2, edges2, restricted2));
    }

    private static int result;

    public static int reachableNodes(int n, int[][] edges, int[] restricted) {
        result = 0;
        /**
         * paths[i]表示和节点i直接连通的节点列表
         */
        List<Integer>[] paths = new List[n];
        /**
         * isVisited[i]表示节点i是否访问过
         */
        boolean[] isVisited = new boolean[n];
        /**
         * isRestricted[i]表示节点i是否是受限节点
         */
        boolean[] isRestricted = new boolean[n];

        for (int i = 0; i < n; i++) {
            paths[i] = new ArrayList<>();
        }

        for (int i : restricted) {
            isRestricted[i] = true;
        }

        for (int[] edge : edges) {
            int x = edge[0];
            int y = edge[1];
            paths[x].add(y);
            paths[y].add(x);
        }
        dfs(paths, 0, isVisited, isRestricted);
        return result;
    }

    /**
     * 从节点from开始访问
     *
     * @param paths
     * @param from
     * @param isVisited
     * @param isRestricted
     */
    public static void dfs(List<Integer>[] paths, int from, boolean[] isVisited, boolean[] isRestricted) {
        /**
         * 节点from已经访问过或者为受限节点
         */
        if (isVisited[from] || isRestricted[from]) {
            return;
        }
        isVisited[from] = true;
        result++;

        for (int to : paths[from]) {
            dfs(paths, to, isVisited, isRestricted);
        }
    }
}
