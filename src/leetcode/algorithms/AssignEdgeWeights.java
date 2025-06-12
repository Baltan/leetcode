package leetcode.algorithms;

import java.util.*;

/**
 * Description: 3558. Number of Ways to Assign Edge Weights I
 *
 * @author baltan
 * @date 2025/6/11 16:12
 */
public class AssignEdgeWeights {
    public static void main(String[] args) {
        System.out.println(assignEdgeWeights(new int[][]{{2, 3}, {1, 2}, {5, 6}, {2, 4}, {6, 7}, {3, 5}}));
        System.out.println(assignEdgeWeights(new int[][]{{1, 4}, {1, 2}, {1, 3}, {3, 5}}));
        System.out.println(assignEdgeWeights(new int[][]{{1, 2}, {2, 3}, {3, 4}}));
        System.out.println(assignEdgeWeights(new int[][]{{1, 2}}));
        System.out.println(assignEdgeWeights(new int[][]{{1, 2}, {1, 3}, {3, 4}, {3, 5}}));
    }

    public static int assignEdgeWeights(int[][] edges) {
        long result = 0L;
        int mod = 1000000007;
        int n = edges.length + 1;
        int depth = -1;
        Queue<Integer> queue = new LinkedList<>();
        boolean[] isVisited = new boolean[n + 1];
        List<Integer>[] graph = new List[n + 1];
        Arrays.setAll(graph, i -> new ArrayList<>());
        queue.offer(1);
        isVisited[1] = true;

        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        while (!queue.isEmpty()) {
            depth++;
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                for (int next : graph[queue.poll()]) {
                    if (!isVisited[next]) {
                        queue.offer(next);
                        isVisited[next] = true;
                    }
                }
            }
        }
        long[][] combinations = new long[depth + 1][depth + 1];

        for (int i = 0; i < combinations.length; i++) {
            combinations[i][0] = 1;

            for (int j = 1; j <= i; j++) {
                combinations[i][j] = (combinations[i - 1][j - 1] + combinations[i - 1][j]) % mod;
            }
        }

        for (int i = 1; i <= depth; i += 2) {
            result = (result + combinations[depth][i]) % mod;
        }
        return (int) result % mod;
    }
}
