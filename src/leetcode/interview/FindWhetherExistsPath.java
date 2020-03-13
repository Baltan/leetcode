package leetcode.interview;

import java.util.*;

/**
 * Description: 面试题 04.01. 节点间通路
 *
 * @author Baltan
 * @date 2020-03-13 16:22
 */
public class FindWhetherExistsPath {
    public static void main(String[] args) {
        int[][] graph1 = {{0, 1}, {0, 2}, {1, 2}, {1, 2}};
        System.out.println(findWhetherExistsPath(3, graph1, 0, 2));

        int[][] graph2 = {{0, 1}, {0, 2}, {0, 4}, {0, 4}, {0, 1}, {1, 3}, {1, 4}, {1, 3}, {2, 3}, {3, 4}};
        System.out.println(findWhetherExistsPath(5, graph2, 0, 4));

        int[][] graph3 =
                {{0, 1}, {1, 2}, {1, 3}, {1, 10}, {1, 11}, {1, 4}, {2, 4}, {2, 6}, {2, 9}, {2, 10}, {2, 4},
                        {2, 5}, {2, 10}, {3, 7}, {3, 7}, {4, 5}, {4, 11}, {4, 11}, {4, 10}, {5, 7}, {5, 10},
                        {6, 8}, {7, 11}, {8, 10}};
        System.out.println(findWhetherExistsPath(12, graph3, 2, 3));
    }

    public static boolean findWhetherExistsPath(int n, int[][] graph, int start, int target) {
        /**
         * 节点x -> 和节点x直接相连的所有节点的集合
         */
        Map<Integer, Set<Integer>> pathMap = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);

        for (int[] path : graph) {
            int from = path[0];
            int to = path[1];
            pathMap.putIfAbsent(from, new HashSet<>());
            pathMap.get(from).add(to);
        }
        /**
         * 从起点start开始进行广度优先搜索，直到到达target或无路可走为止
         */
        while (!queue.isEmpty()) {
            int from = queue.poll();

            if (from == target) {
                return true;
            }
            /**
             * 和from节点直接相连的所有节点的集合
             */
            Set<Integer> set = pathMap.get(from);
            /**
             * 为了避免又走回from的情况，将左右from到达其他节点的路径删除
             */
            pathMap.remove(from);

            if (set != null) {
                for (int to : set) {
                    queue.offer(to);
                    /**
                     * 为了避免走回头路，如果存在to到from的路径，将这条路径删除
                     */
                    if (pathMap.containsKey(to)) {
                        pathMap.get(to).remove(from);
                    }
                }
            }
        }
        return false;
    }
}
