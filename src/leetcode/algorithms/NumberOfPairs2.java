package leetcode.algorithms;

import java.util.*;

/**
 * Description: 3027. Find the Number of Ways to Place People II
 *
 * @author Baltan
 * @date 2024/2/8 22:53
 * @see NumberOfPairs1
 */
public class NumberOfPairs2 {
    public static void main(String[] args) {
        System.out.println(numberOfPairs(new int[][]{{3, 5}, {3, 4}, {0, 5}}));
        System.out.println(numberOfPairs(new int[][]{{1, 6}, {0, 9}, {0, 3}}));
        System.out.println(numberOfPairs(new int[][]{{0, 5}, {6, 1}, {4, 5}}));
        System.out.println(numberOfPairs(new int[][]{{1, 1}, {2, 2}, {3, 3}}));
        System.out.println(numberOfPairs(new int[][]{{6, 2}, {4, 4}, {2, 6}}));
        System.out.println(numberOfPairs(new int[][]{{3, 1}, {1, 3}, {1, 1}}));

    }

    public static int numberOfPairs(int[][] points) {
        int result = 0;
        /**
         * 将所有点按照y坐标降序排列，y坐标相等时则按照x坐标升序排列
         */
        Arrays.sort(points, (x, y) -> x[1] == y[1] ? x[0] - y[0] : y[1] - x[1]);
        /**
         * 保存所有可能的y坐标
         */
        List<Integer> yList = new ArrayList<>();
        int prevY = Integer.MAX_VALUE;
        int yIndex = 0;

        for (int[] point : points) {
            if (point[1] < prevY) {
                yList.add(point[1]);
                prevY = point[1];
            }
        }
        /**
         * 假设Alice所在位置为points[i]
         */
        for (int i = 0; i < points.length; i++) {
            /**
             * Bob允许所在位置的最大x坐标
             */
            int maxX = Integer.MAX_VALUE;
            /**
             * 判断Bob能否在Alice的正右方
             */
            if (i + 1 < points.length && points[i][1] == points[i + 1][1]) {
                maxX = points[i + 1][0];
                result++;
            }
            /**
             * 计算所有y坐标小于points[i]的点中y坐标的最大值yList[yIndex]
             */
            while (yIndex < yList.size() && yList.get(yIndex) >= points[i][1]) {
                yIndex++;
            }
            /**
             * 判断Bob能否在y坐标为yList[j]的某个点上
             */
            for (int j = yIndex; j < yList.size(); j++) {
                /**
                 * 点集points中y坐标为yList[j]的第一个点的索引
                 */
                int lo = binarySearchFirst(points, yList.get(j));
                /**
                 * 点集points中y坐标为yList[j]的最后一个点的索引
                 */
                int hi = binarySearchLast(points, yList.get(j));
                /**
                 * 点集points中y坐标为yList[j]，且x坐标大于等于points[i][0]的第一个点的索引
                 */
                int index = binarySearch(points, lo, hi, points[i][0]);
                /**
                 * 只有当点points[index]的x坐标位于[points[i][0],maxX)范围内时，Bob可以安排在这个点的位置
                 */
                if (points[index][0] >= points[i][0] && points[index][0] < maxX) {
                    result++;
                    maxX = points[index][0];
                }
            }
        }
        return result;
    }

    /**
     * 在所有y坐标为y的点中二分查找x坐标大于等于x的第一个点的索引
     *
     * @param points
     * @param lo
     * @param hi
     * @param x
     * @return
     */
    public static int binarySearch(int[][] points, int lo, int hi, int x) {
        while (lo < hi) {
            int mid = (lo + hi) / 2;

            if (points[mid][0] < x) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

    /**
     * 在所有点points中二分查找y坐标为y且x坐标最小的点的索引
     *
     * @param points
     * @param y
     * @return
     */
    public static int binarySearchFirst(int[][] points, int y) {
        int lo = 0;
        int hi = points.length - 1;

        while (lo < hi) {
            int mid = (lo + hi) / 2;

            if (points[mid][1] > y) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

    /**
     * 在所有点points中二分查找y坐标为y且x坐标最大的点的索引
     *
     * @param points
     * @param y
     * @return
     */
    public static int binarySearchLast(int[][] points, int y) {
        int lo = 0;
        int hi = points.length - 1;

        while (lo < hi) {
            int mid = (lo + hi + 1) / 2;

            if (points[mid][1] < y) {
                hi = mid - 1;
            } else {
                lo = mid;
            }
        }
        return lo;
    }
}
