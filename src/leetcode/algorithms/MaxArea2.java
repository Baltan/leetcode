package leetcode.algorithms;

import java.util.*;

/**
 * Description: 3588. Find Maximum Area of a Triangle
 *
 * @author baltan
 * @date 2025/7/14 14:56
 */
public class MaxArea2 {
    public static void main(String[] args) {
        System.out.println(maxArea(new int[][]{{2, 9}, {2, 6}, {2, 5}}));
        System.out.println(maxArea(new int[][]{{1, 1}, {1, 2}, {3, 2}, {3, 3}}));
        System.out.println(maxArea(new int[][]{{1, 1}, {2, 2}, {3, 3}}));
    }

    public static long maxArea(int[][] coords) {
        long result = -1;
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        int maxY = Integer.MIN_VALUE;

        for (int[] coord : coords) {
            minX = Math.min(minX, coord[0]);
            maxX = Math.max(maxX, coord[0]);
            minY = Math.min(minY, coord[1]);
            maxY = Math.max(maxY, coord[1]);
        }
        List<Integer>[] xList = new List[maxX + 1];
        List<Integer>[] yList = new List[maxY + 1];
        Arrays.setAll(xList, i -> new ArrayList<>());
        Arrays.setAll(yList, i -> new ArrayList<>());

        for (int[] coord : coords) {
            xList[coord[0]].add(coord[1]);
            yList[coord[1]].add(coord[0]);
        }

        for (int i = 0; i < xList.length; i++) {
            if (!xList[i].isEmpty()) {
                Collections.sort(xList[i]);

                if (!Objects.equals(xList[i].getFirst(), xList[i].getLast())) {
                    long area = (long) (xList[i].getLast() - xList[i].getFirst()) * Math.max(i - minX, maxX - i);

                    if (area > 0) {
                        result = Math.max(result, area);
                    }
                }
            }
        }

        for (int i = 0; i < yList.length; i++) {
            if (!yList[i].isEmpty()) {
                Collections.sort(yList[i]);

                if (!Objects.equals(yList[i].getFirst(), yList[i].getLast())) {
                    long area = (long) (yList[i].getLast() - yList[i].getFirst()) * Math.max(i - minY, maxY - i);

                    if (area > 0) {
                        result = Math.max(result, area);
                    }
                }
            }
        }
        return result;
    }
}
