package leetcode.algorithms;

import leetcode.util.OutputUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: 3532. Path Existence Queries in a Graph I
 *
 * @author baltan
 * @date 2025/5/14 09:01
 */
public class PathExistenceQueries {
    public static void main(String[] args) {
        int[] nums1 = {1, 3};
        int[][] queries1 = {{0, 0}, {0, 1}};
        OutputUtils.print1DBooleanArray(pathExistenceQueries(2, nums1, 1, queries1));

        int[] nums2 = {2, 5, 6, 8};
        int[][] queries2 = {{0, 1}, {0, 2}, {1, 3}, {2, 3}};
        OutputUtils.print1DBooleanArray(pathExistenceQueries(4, nums2, 2, queries2));
    }

    public static boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        boolean[] result = new boolean[queries.length];
        /**
         * 按递增顺序保存各个连通图
         */
        List<List<Integer>> graphs = new ArrayList<>();
        /**
         * 按递增顺序保存当前连通图中的节点
         */
        List<Integer> graph = new ArrayList<>();
        graph.add(0);

        for (int i = 1; i < n; i++) {
            if (nums[i] - nums[i - 1] <= maxDiff) {
                graph.add(i);
            } else {
                graphs.add(graph);
                /**
                 * 当前节点不在前一个连通图中，新建一个新的连通图
                 */
                graph = new ArrayList<>();
                graph.add(i);
            }
        }
        graphs.add(graph);

        for (int i = 0; i < queries.length; i++) {
            result[i] = binarySearch(graphs, queries[i][0]) == binarySearch(graphs, queries[i][1]);
        }
        return result;
    }

    /**
     * 二分查找节点node所在连通图的索引
     *
     * @param graphs
     * @param node
     * @return
     */
    public static int binarySearch(List<List<Integer>> graphs, int node) {
        int lo = 0;
        int hi = graphs.size() - 1;

        while (lo < hi) {
            int mid = (lo + hi + 1) / 2;

            if (graphs.get(mid).get(0) > node) {
                hi = mid - 1;
            } else {
                lo = mid;
            }
        }
        return lo;
    }
}
