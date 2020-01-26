package leetcode.algorithms;

import java.util.*;

/**
 * Description: 310. Minimum Height Trees
 *
 * @author Baltan
 * @date 2020-01-25 12:35
 */
public class FindMinHeightTrees {
    public static void main(String[] args) {
        int[][] edges1 = {{1, 0}, {1, 2}, {1, 3}};
        System.out.println(findMinHeightTrees(4, edges1));

        int[][] edges2 = {{0, 3}, {1, 3}, {2, 3}, {4, 3}, {5, 4}};
        System.out.println(findMinHeightTrees(6, edges2));

        int[][] edges3 = {{0, 1}};
        System.out.println(findMinHeightTrees(2, edges3));
    }

    public static List<Integer> findMinHeightTrees(int n, int[][] edges) {
        Map<Integer, List<Integer>> edgeMap = new HashMap<>((int) Math.ceil(n / 0.75));
        Map<Integer, List<Integer>> heightMap = new HashMap<>();
        int minHeight = n;

        for (int i = 0; i < n; i++) {
            edgeMap.put(i, new LinkedList<>());
        }

        for (int[] edge : edges) {
            edgeMap.get(edge[0]).add(edge[1]);
            edgeMap.get(edge[1]).add(edge[0]);
        }

        for (int i = 0; i < n; i++) {
            boolean[] book = new boolean[n];
            Queue<Integer> queue = new LinkedList<>();
            int height = 0;
            queue.offer(i);

            while (!queue.isEmpty()) {
                int size = queue.size();
                height++;

                for (int j = 0; j < size; j++) {
                    int value = queue.poll();
                    book[value] = true;

                    for (int k : edgeMap.get(value)) {
                        if (!book[k]) {
                            queue.offer(k);
                        }
                    }
                }
            }

            heightMap.putIfAbsent(height, new LinkedList<>());
            heightMap.get(height).add(i);
            minHeight = Math.min(minHeight, height);
        }
        return heightMap.get(minHeight);
    }
}
