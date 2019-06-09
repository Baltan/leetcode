package leetcode.algorithms;

import java.util.*;

/**
 * Description: 218. The Skyline Problem
 *
 * @author Baltan
 * @date 2019-06-09 11:46
 */
public class GetSkyline {
    public static void main(String[] args) {
        int[][] buildings1 = {{2, 9, 10}, {3, 7, 15}, {5, 12, 12}, {15, 20, 10}, {19, 24, 8}};
        System.out.println(getSkyline(buildings1));

        int[][] buildings2 = {{0, 2147483647, 2147483647}};
        System.out.println(getSkyline(buildings2));
    }

    public static List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> result = new LinkedList<>();

        if (buildings.length == 0) {
            return result;
        }

        Map<Integer, Integer> map = new HashMap<>();
        int leftmost = Integer.MAX_VALUE;
        int rightmost = Integer.MIN_VALUE;

        for (int[] building : buildings) {
            int left = building[0];
            int right = building[1];
            int height = building[2];
            leftmost = Math.min(leftmost, left);
            rightmost = Math.max(rightmost, right);

            for (int i = left; i <= right; i++) {
                map.put(i, Math.max(map.getOrDefault(i, 0), height));
            }
        }

        result.add(Arrays.asList(leftmost, map.get(leftmost)));

        for (int i = leftmost + 1; i <= rightmost; i++) {
            int height1 = map.getOrDefault(i - 1, 0);
            int height2 = map.getOrDefault(i, 0);

            if (height1 < height2) {
                result.add(Arrays.asList(i, height2));
            } else if (height1 > height2) {
                result.add(Arrays.asList(i - 1, height2));
            }
        }

        result.add(Arrays.asList(rightmost, 0));
        return result;
    }
}
