package leetcode.algorithms;

import java.util.*;

/**
 * Description: 1443. Minimum Time to Collect All Apples in a Tree
 *
 * @author Baltan
 * @date 2020-05-12 22:34
 */
public class MinTime {
    public static void main(String[] args) {
        int[][] edges1 = {{0, 1}, {0, 2}, {1, 4}, {1, 5}, {2, 3}, {2, 6}};
        List<Boolean> hasApple1 = Arrays.asList(false, false, true, false, true, true, false);
        System.out.println(minTime(7, edges1, hasApple1));

        int[][] edges2 = {{0, 1}, {0, 2}, {1, 4}, {1, 5}, {2, 3}, {2, 6}};
        List<Boolean> hasApple2 = Arrays.asList(false, false, true, false, false, true, false);
        System.out.println(minTime(7, edges2, hasApple2));

        int[][] edges3 = {{0, 1}, {0, 2}, {1, 4}, {1, 5}, {2, 3}, {2, 6}};
        List<Boolean> hasApple3 = Arrays.asList(false, false, false, false, false, false, false);
        System.out.println(minTime(7, edges3, hasApple3));
    }

    public static int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        int result = 0;
        /**
         * to节点 -> from节点，因为根据题意，edges.length==n-1，说明每个节点都只能通过一条路径访问
         */
        Map<Integer, Integer> pathMap = new HashMap<>();
        /**
         * 已经经过过的节点
         */
        Set<Integer> isVisited = new HashSet<>();

        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            pathMap.put(to, from);
        }

        for (int i = 0; i < n; i++) {
            /**
             * 对于有苹果的节点沿路径向根节点查找，直到找到根节点或找到已经经过过的节点
             */
            if (hasApple.get(i)) {
                int to = i;

                while (!isVisited.contains(to) && to != 0) {
                    /**
                     * 前一个节点
                     */
                    int from = pathMap.get(to);
                    isVisited.add(to);
                    to = from;
                    /**
                     * 这段路径因为要来回折返两次，所以加2
                     */
                    result += 2;
                }
            }
        }
        return result;
    }
}
