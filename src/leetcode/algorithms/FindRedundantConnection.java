package leetcode.algorithms;

import leetcode.util.OutputUtils;

import java.util.*;

/**
 * Description: 684. Redundant Connection
 *
 * @author Baltan
 * @date 2020-02-13 11:48
 */
public class FindRedundantConnection {
    /**
     * 从init出发查找是否存在一个包含init的环
     */
    public static int init;
    /**
     * 是否在无向图中找到环
     */
    public static boolean flag;
    /**
     * 环上的所有元素
     */
    public static Set<Integer> set;

    public static void main(String[] args) {
        int[][] edges1 = {{1, 2}, {1, 3}, {2, 3}};
        OutputUtils.print1DIntegerArray(findRedundantConnection(edges1));

        int[][] edges2 = {{1, 2}, {2, 3}, {3, 4}, {1, 4}, {1, 5}};
        OutputUtils.print1DIntegerArray(findRedundantConnection(edges2));

        int[][] edges3 = {{2, 7}, {7, 8}, {3, 6}, {2, 5}, {6, 8}, {4, 8}, {2, 8}, {1, 8}, {7, 10}, {3, 9}};
        OutputUtils.print1DIntegerArray(findRedundantConnection(edges3));
    }

    public static int[] findRedundantConnection(int[][] edges) {
        flag = false;
        set = new HashSet<>();
        Map<Integer, Set<Integer>> edgeMap = new HashMap<>();

        for (int[] edge : edges) {
            int x = edge[0];
            int y = edge[1];
            edgeMap.putIfAbsent(x, new HashSet<>());
            edgeMap.putIfAbsent(y, new HashSet<>());
            edgeMap.get(x).add(y);
            edgeMap.get(y).add(x);
        }

        for (int start : edgeMap.keySet()) {
            init = start;
            Set<Integer> loopValues = new HashSet<>();
            /**
             * 在搜索的过程中，标记已经访问过的元素
             */
            Set<Integer> isVisited = new HashSet<>();
            /**
             * 假设start在环上，先将start加入loopValues
             */
            loopValues.add(start);
            dfs(edgeMap, loopValues, start, isVisited);
            /**
             * 如果set不为空说明找到了一个环，从edges的最后向前遍历，将第一个找到的环上的边删除
             * 即可
             */
            if (!set.isEmpty()) {
                for (int i = edges.length - 1; i >= 0; i--) {
                    int[] edge = edges[i];

                    if (set.contains(edge[0]) && set.contains(edge[1])) {
                        return edge;
                    }
                }
            }
        }
        return null;
    }

    /**
     * 深度优先搜索，查到是否存在一个包含start的环
     *
     * @param edgeMap
     * @param loopValues
     * @param start
     * @param isVisited
     */
    public static void dfs(Map<Integer, Set<Integer>> edgeMap, Set<Integer> loopValues, int start,
                           Set<Integer> isVisited) {
        /**
         * 和start直接相连构成边的所有的值
         */
        Set<Integer> connectedValues = new HashSet<>(edgeMap.get(start));
        isVisited.add(start);

        for (int connectedValue : connectedValues) {
            /**
             * 如果已经找到了一个环就不用再继续搜索了
             */
            if (flag) {
                break;
            }
            /**
             * 从start出发下一个值和最初的起点init一样，说明已经找到环了
             */
            if (connectedValue == init) {
                flag = true;
                set = new HashSet<>(loopValues);
                return;
            }

            if (isVisited.contains(connectedValue)) {
                continue;
            }
            /**
             * 因为是从start走到connectedValue的，将start移除，避免再从connectedValue走回
             * start
             */
            edgeMap.get(connectedValue).remove(start);
            /**
             * 假设connectedValue在环上，先将connectedValue加入loopValues
             */
            loopValues.add(connectedValue);
            dfs(edgeMap, loopValues, connectedValue, isVisited);
            /**
             * 沿着connectedValue走没有找到环，将connectedValue从loopValues移除
             */
            loopValues.remove(connectedValue);
            /**
             * 还原edgeMap
             */
            edgeMap.get(connectedValue).add(start);
        }
    }
}
