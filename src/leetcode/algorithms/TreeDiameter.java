package leetcode.algorithms;

import java.util.*;

/**
 * Description: 1245. Tree Diameter
 *
 * @author Baltan
 * @date 2019-11-04 09:07
 */
public class TreeDiameter {
    public static void main(String[] args) {
        int[][] edges1 = {{0, 1}, {0, 2}};
        System.out.println(treeDiameter(edges1));

        int[][] edges2 = {{0, 1}, {1, 2}, {2, 3}, {1, 4}, {4, 5}};
        System.out.println(treeDiameter(edges2));
    }

    public static int treeDiameter(int[][] edges) {
        if (edges.length == 0) {
            return 0;
        }

        int result = 0;
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int[] edge : edges) {
            map.putIfAbsent(edge[0], new LinkedList<>());
            map.get(edge[0]).add(edge[1]);
            map.putIfAbsent(edge[1], new LinkedList<>());
            map.get(edge[1]).add(edge[0]);
        }

        for (int start : map.keySet()) {
            int length = 0;
            Queue<int[]> queue = new LinkedList<>();
            List<Integer> nodeList = map.get(start);

            for (int node : nodeList) {
                queue.offer(new int[]{start, node});
            }

            while (!queue.isEmpty()) {
                length++;
                int size = queue.size();

                for (int i = 0; i < size; i++) {
                    int[] edge = queue.poll();
                    int from = edge[0];
                    int to = edge[1];
                    List<Integer> nextNodes = map.get(to);

                    for (int node : nextNodes) {
                        if (node == from) {
                            continue;
                        }
                        queue.offer(new int[]{to, node});
                    }
                }
            }
            result = Math.max(result, length);
        }
        return result;
    }
}
