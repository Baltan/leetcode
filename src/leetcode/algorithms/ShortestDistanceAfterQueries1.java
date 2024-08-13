package leetcode.algorithms;

import leetcode.util.OutputUtils;

/**
 * Description: 3244. Shortest Distance After Road Addition Queries II
 *
 * @author baltan
 * @date 2024/8/12 09:42
 * @see ShortestDistanceAfterQueries
 */
public class ShortestDistanceAfterQueries1 {
    public static void main(String[] args) {
        OutputUtils.print1DIntegerArray(shortestDistanceAfterQueries(12, new int[][]{{4, 7}, {8, 10}, {0, 7}}));
        OutputUtils.print1DIntegerArray(shortestDistanceAfterQueries(6, new int[][]{{2, 4}, {0, 2}}));
        OutputUtils.print1DIntegerArray(shortestDistanceAfterQueries(6, new int[][]{{1, 3}, {3, 5}}));
        OutputUtils.print1DIntegerArray(shortestDistanceAfterQueries(5, new int[][]{{2, 4}, {0, 2}, {0, 4}}));
        OutputUtils.print1DIntegerArray(shortestDistanceAfterQueries(4, new int[][]{{0, 3}, {0, 2}}));
    }

    public static int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        int[] result = new int[queries.length];
        boolean[] ignore = new boolean[n];

        for (int i = 0; i < queries.length; i++) {
            for (int j = queries[i][0] + 1; j < queries[i][1]; j++) {
                if (!ignore[j]) {
                    ignore[j] = true;
                    n--;
                }
            }
            result[i] = n - 1;
        }
        return result;
    }
}
