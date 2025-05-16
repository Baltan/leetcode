package leetcode.algorithms;

import leetcode.util.OutputUtils;

import java.util.Arrays;

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
        int[] parents = new int[n];
        int[] heights = new int[n];
        Arrays.setAll(parents, i -> i);
        Arrays.fill(heights, 1);

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] <= maxDiff) {
                if (heights[i] <= heights[i - 1]) {
                    parents[i] = i - 1;
                    heights[i - 1] = Math.max(heights[i - 1], heights[i] + 1);
                } else {
                    parents[i - 1] = i;
                }
            }
        }

        for (int i = 0; i < queries.length; i++) {
            result[i] = !union(parents, queries[i][0], queries[i][1]);
        }
        return result;
    }

    public static int getRoot(int[] parents, int x) {
        while (x != parents[x]) {
            x = parents[x];
        }
        return x;
    }

    public static boolean union(int[] parents, int x, int y) {
        int xRoot = getRoot(parents, x);
        int yRoot = getRoot(parents, y);
        return xRoot != yRoot;
    }
}
