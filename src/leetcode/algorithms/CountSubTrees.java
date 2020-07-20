package leetcode.algorithms;

import leetcode.util.OutputUtils;

import java.util.*;

/**
 * Description: 1519. Number of Nodes in the Sub-Tree With the Same Label
 *
 * @author Baltan
 * @date 2020-07-19 22:20
 */
public class CountSubTrees {
    public static void main(String[] args) {
        int[][] edges1 = {{0, 1}, {0, 2}, {1, 4}, {1, 5}, {2, 3}, {2, 6}};
        OutputUtils.print1DIntegerArray(countSubTrees(7, edges1, "abaedcd"));

        int[][] edges2 = {{0, 1}, {1, 2}, {0, 3}};
        OutputUtils.print1DIntegerArray(countSubTrees(4, edges2, "bbbb"));

        int[][] edges3 = {{0, 1}, {0, 2}, {1, 3}, {0, 4}};
        OutputUtils.print1DIntegerArray(countSubTrees(5, edges3, "aabab"));

        int[][] edges4 = {{0, 1}, {0, 2}, {1, 3}, {3, 4}, {4, 5}};
        OutputUtils.print1DIntegerArray(countSubTrees(6, edges4, "cbabaa"));

        int[][] edges5 = {{0, 1}, {1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}};
        OutputUtils.print1DIntegerArray(countSubTrees(7, edges5, "aaabaaa"));

        int[][] edges6 = {{0, 2}, {0, 3}, {1, 2}};
        OutputUtils.print1DIntegerArray(countSubTrees(4, edges6, "aeed"));
    }

    public static int[] countSubTrees(int n, int[][] edges, String labels) {
        int[] result = new int[n];
        char[] charArray = labels.toCharArray();
        Map<Integer, Set<Integer>> pathMap = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);

        for (int[] edge : edges) {
            pathMap.putIfAbsent(edge[0], new HashSet<>());
            pathMap.get(edge[0]).add(edge[1]);
            pathMap.putIfAbsent(edge[1], new HashSet<>());
            pathMap.get(edge[1]).add(edge[0]);
        }

        while (!queue.isEmpty()) {
            int value = queue.poll();
            Set<Integer> children = pathMap.get(value);

            if (Objects.nonNull(children)) {
                for (int child : children) {
                    pathMap.get(child).remove(value);
                    queue.offer(child);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            int count = 0;
            char c = charArray[i];
            Queue<Integer> queue1 = new LinkedList<>();
            queue1.offer(i);

            while (!queue1.isEmpty()) {
                int num = queue1.poll();

                if (charArray[num] == c) {
                    count++;
                }

                if (pathMap.containsKey(num)) {
                    for (int value : pathMap.get(num)) {
                        queue1.offer(value);
                    }
                }
            }
            result[i] = count;
        }
        return result;
    }
}
