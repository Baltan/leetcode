package leetcode.algorithms;

import java.util.*;

/**
 * Description: 1971. Find if Path Exists in Graph
 *
 * @author Baltan
 * @date 2022/1/27 09:05
 */
public class ValidPath {
    public static void main(String[] args) {
        int[][] edges1 = {{0, 1}, {1, 2}, {2, 0}};
        System.out.println(validPath(3, edges1, 0, 2));

        int[][] edges2 = {{0, 1}, {0, 2}, {3, 5}, {5, 4}, {4, 3}};
        System.out.println(validPath(6, edges2, 0, 5));
    }

    public static boolean validPath(int n, int[][] edges, int source, int destination) {
        if (source == destination) {
            return true;
        }
        /**
         * i -> 顶点i可以直接相连的点集合
         */
        Map<Integer, Boolean> isVisited = new HashMap<>();
        /**
         * i -> 顶点i是否被访问过
         */
        Map<Integer, Set<Integer>> paths = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(source);
        isVisited.put(source, true);
        /**
         * 计算各个顶点直接相连的点集合
         */
        for (int[] edge : edges) {
            int x = edge[0];
            int y = edge[1];
            Set<Integer> fromX = paths.computeIfAbsent(x, i -> new HashSet<>());
            fromX.add(y);
            Set<Integer> fromY = paths.computeIfAbsent(y, i -> new HashSet<>());
            fromY.add(x);
        }

        while (!queue.isEmpty()) {
            /**
             * 当前所在的顶点
             */
            int curr = queue.poll();
            /**
             * 当前所在顶点直接相连的点集合
             */
            Set<Integer> nextSet = paths.getOrDefault(curr, new HashSet<>());

            for (Integer next : nextSet) {
                /**
                 * 从当前所在顶点可以到达destination，直接返回true
                 */
                if (next == destination) {
                    return true;
                }
                /**
                 * 当前所在顶点可以直接相连的点如果还没有被访问过，继续访问这些点
                 */
                if (!isVisited.getOrDefault(next, false)) {
                    queue.offer(next);
                    isVisited.put(next, true);
                }
            }
        }
        return false;
    }
}
