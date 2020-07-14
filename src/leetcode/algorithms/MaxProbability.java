package leetcode.algorithms;

import java.util.*;

/**
 * Description: 1514. Path with Maximum Probability
 *
 * @author Baltan
 * @date 2020-07-12 23:16
 */
public class MaxProbability {
    public static void main(String[] args) {
        int[][] edges1 = {{0, 1}, {1, 2}, {0, 2}};
        double[] succProb1 = {0.5, 0.5, 0.2};
        System.out.println(maxProbability(3, edges1, succProb1, 0, 2));

        int[][] edges2 = {{0, 1}, {1, 2}, {0, 2}};
        double[] succProb2 = {0.5, 0.5, 0.3};
        System.out.println(maxProbability(3, edges2, succProb2, 0, 2));

        int[][] edges3 = {{0, 1}};
        double[] succProb3 = {0.5};
        System.out.println(maxProbability(3, edges3, succProb3, 0, 2));

        int[][] edges4 = {{193, 229}, {133, 212}, {224, 465}};
        double[] succProb4 = {0.91, 0.78, 0.64};
        System.out.println(maxProbability(500, edges4, succProb4, 4, 364));
    }

    public static double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        double result = 0;
        /**
         * 起点 -> {终点 -> 起点到达终点的概率}
         */
        Map<Integer, Map<Integer, Double>> map = new HashMap<>();
        /**
         * 已经到达过的节点
         */
        Queue<Integer> queue = new LinkedList<>();
        /**
         * 节点 -> start节点到达该节点的最大概率
         */
        Map<Integer, Double> isVisited = new HashMap<>();
        queue.offer(start);
        isVisited.put(start, 1.0);

        for (int i = 0; i < edges.length; i++) {
            int x = edges[i][0];
            int y = edges[i][1];
            map.putIfAbsent(x, new HashMap<>());
            map.get(x).put(y, succProb[i]);
            map.putIfAbsent(y, new HashMap<>());
            map.get(y).put(x, succProb[i]);
        }

        while (!queue.isEmpty()) {
            int from = queue.poll();
            /**
             * 到达from节点的概率
             */
            double possibility = isVisited.get(from);
            /**
             * 如果from节点就是end节点，则找到一条从start节点到达end节点的路径，更新result
             */
            if (from == end) {
                result = Math.max(result, possibility);
            }
            /**
             * 如果from节点不能到达任何节点，继续判断下一个已经到达过的节点
             */
            if (!map.containsKey(from)) {
                continue;
            }

            for (Map.Entry<Integer, Double> entry : map.get(from).entrySet()) {
                int to = entry.getKey();
                /**
                 * 从from节点到达to节点的概率
                 */
                double pathPossibility = entry.getValue();
                /**
                 * 如果还未到达过to节点，或者当前到达to节点的概率更大，才将to节点加入queue，并更新start节点到达to
                 * 节点的最大概率
                 */
                if (!isVisited.containsKey(to) || possibility * pathPossibility > isVisited.get(to)) {
                    queue.offer(to);
                    isVisited.put(to, possibility * pathPossibility);
                }
            }
        }
        return result;
    }
}
