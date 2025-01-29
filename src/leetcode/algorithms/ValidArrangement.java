package leetcode.algorithms;

import leetcode.util.OutputUtils;

import java.util.*;

/**
 * Description: 2097. Valid Arrangement of Pairs
 *
 * @author Baltan
 * @date 2025/1/8 23:08
 */
public class ValidArrangement {
    public static void main(String[] args) {
        int[][] pairs1 = {{5, 1}, {4, 5}, {11, 9}, {9, 4}};
        OutputUtils.print2DIntegerArray(validArrangement(pairs1));
        System.out.println("-----------------------------------");
        int[][] pairs2 = {{1, 3}, {3, 2}, {2, 1}};
        OutputUtils.print2DIntegerArray(validArrangement(pairs2));
        System.out.println("-----------------------------------");
        int[][] pairs3 = {{1, 2}, {1, 3}, {2, 1}};
        OutputUtils.print2DIntegerArray(validArrangement(pairs3));
        System.out.println("-----------------------------------");
        int[][] pairs4 = {{8, 5}, {8, 7}, {0, 8}, {0, 5}, {7, 0}, {5, 0}, {0, 7}, {8, 0}, {7, 8}};
        OutputUtils.print2DIntegerArray(validArrangement(pairs4));
    }

    /**
     * 参考：<a href="https://leetcode.cn/problems/valid-arrangement-of-pairs/solutions/1264966/cpython3javago-you-xiang-tu-qiu-ou-la-lu-t6ez/"></a>
     * 参考：<a href="https://leetcode.cn/problems/valid-arrangement-of-pairs/solutions/1139485/zhuan-hua-wei-ou-la-lu-jing-wen-ti-tu-ji-aqmu/"></a>
     *
     * @param pairs
     * @return
     */
    public static int[][] validArrangement(int[][] pairs) {
        if (pairs.length == 1) {
            return pairs;
        }
        int[][] result = new int[pairs.length][2];
        int resultIndex = 0;
        /**
         * 将pairs[i]当做从节点pairs[i][0]到pairs[i][1]的一条有向边，则二维数组pairs可以转换为有向图graph
         * 节点i -> 有向图中与节点i相邻，可以直接从节点i到达的其他节点集合
         */
        Map<Integer, Deque<Integer>> graph = new HashMap<>();
        /**
         * 节点i -> 有向图中节点i的入度
         */
        Map<Integer, Integer> indegreeMap = new HashMap<>();
        /**
         * 欧拉通路的起点
         */
        int start = pairs[0][0];
        /**
         * 逆序保存欧拉通路中的所有节点
         */
        List<Integer> path = new ArrayList<>();
        /**
         * 构建有向图，并计算图中每个节点的入度
         */
        for (int[] pair : pairs) {
            indegreeMap.merge(pair[1], 1, Integer::sum);
            graph.computeIfAbsent(pair[0], k -> new ArrayDeque<>()).offerFirst(pair[1]);
        }
        /**
         * 查找欧拉通路的起点
         */
        for (Map.Entry<Integer, Deque<Integer>> entry : graph.entrySet()) {
            int num = entry.getKey();
            int outdegree = entry.getValue().size();
            int indegree = indegreeMap.getOrDefault(num, 0);
            /**
             * 已知有向图中一定存在欧拉通路，如果有向图中存在某个节点的出度比入度大1，则这个节点就是欧拉通路的起点，否则，有向图中任意一个节
             * 点作为起点都能构成一条欧拉回路
             */
            if (outdegree - indegree == 1) {
                start = num;
                break;
            }
        }
        dfs(path, start, graph);
        /**
         * 还原欧拉回路
         */
        for (int i = path.size() - 1; i > 0; i--) {
            result[resultIndex++] = new int[]{path.get(i), path.get(i - 1)};
        }
        return result;
    }

    /**
     * Hierholzer算法计算欧拉通路
     *
     * @param path
     * @param start
     * @param graph
     */
    public static void dfs(List<Integer> path, int start, Map<Integer, Deque<Integer>> graph) {
        Deque<Integer> next = graph.get(start);

        while (next != null && !next.isEmpty()) {
            dfs(path, next.pollLast(), graph);
        }
        path.add(start);
    }
}
