package leetcode.algorithms;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Description: 2492. Minimum Score of a Path Between Two Cities
 *
 * @author Baltan
 * @date 2022/12/5 10:32
 */
public class MinScore {
    public static void main(String[] args) {
        int[][] roads1 = {{1, 2, 9}, {2, 3, 6}, {2, 4, 5}, {1, 4, 7}};
        System.out.println(minScore(4, roads1));

        int[][] roads2 = {{1, 2, 2}, {1, 3, 4}, {3, 4, 7}};
        System.out.println(minScore(4, roads2));

        int[][] roads3 = {{18, 20, 9207}, {14, 12, 1024}, {11, 9, 3056}, {8, 19, 416}, {3, 18, 5898}, {17, 3, 6779}, {13, 15, 3539}, {15, 11, 1451}, {19, 2, 3805}, {9, 8, 2238}, {1, 16, 618}, {16, 14, 55}, {17, 7, 6903}, {12, 13, 1559}, {2, 17, 3693}};
        System.out.println(minScore(20, roads3));
    }

    private static int result;

    public static int minScore(int n, int[][] roads) {
        result = Integer.MAX_VALUE;
        /**
         * 已经访问过的城市
         */
        Set<Integer> isVisited = new HashSet<>();
        /**
         * 城市i -> {城市j -> 城市i和城市j之间道路的距离}
         */
        Map<Integer, Map<Integer, Integer>> roadMap = new HashMap<>();
        /**
         * 汇总两城市之间的道路
         */
        for (int[] road : roads) {
            int x = road[0];
            int y = road[1];
            int distance = road[2];
            Map<Integer, Integer> fromXMap = roadMap.computeIfAbsent(x, i -> new HashMap<>());
            fromXMap.put(y, distance);
            Map<Integer, Integer> fromYMap = roadMap.computeIfAbsent(y, i -> new HashMap<>());
            fromYMap.put(x, distance);
        }
        dfs(1, roadMap, isVisited);
        return result;
    }

    /**
     * 深度优先搜索，从城市x去往相邻城市
     *
     * @param x
     * @param roadMap
     * @param isVisited
     */
    public static void dfs(int x, Map<Integer, Map<Integer, Integer>> roadMap, Set<Integer> isVisited) {
        Map<Integer, Integer> fromXMap = roadMap.get(x);
        isVisited.add(x);

        for (Map.Entry<Integer, Integer> entry : fromXMap.entrySet()) {
            int y = entry.getKey();
            int distance = entry.getValue();
            result = Math.min(result, distance);
            /**
             * 已经访问过的城市不要重复访问，避免死循环
             */
            if (!isVisited.contains(y)) {
                dfs(y, roadMap, isVisited);
            }
        }
    }
}
