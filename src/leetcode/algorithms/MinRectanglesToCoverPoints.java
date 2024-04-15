package leetcode.algorithms;

import java.util.TreeSet;

/**
 * Description: 3111. Minimum Rectangles to Cover Points
 *
 * @author baltan
 * @date 2024/4/15 16:00
 */
public class MinRectanglesToCoverPoints {
    public static void main(String[] args) {
        System.out.println(minRectanglesToCoverPoints(new int[][]{{2, 1}, {1, 0}, {1, 4}, {1, 8}, {3, 5}, {4, 6}}, 1));
        System.out.println(minRectanglesToCoverPoints(new int[][]{{0, 0}, {1, 1}, {2, 2}, {3, 3}, {4, 4}, {5, 5}, {6, 6}}, 2));
        System.out.println(minRectanglesToCoverPoints(new int[][]{{2, 3}, {1, 2}}, 0));
    }

    public static int minRectanglesToCoverPoints(int[][] points, int w) {
        int result = 0;
        /**
         * 去重升序保存数组points中所有点的x坐标值
         */
        TreeSet<Integer> xSet = new TreeSet<>();
        Integer x = Integer.MIN_VALUE;

        for (int[] point : points) {
            xSet.add(point[0]);
        }
        /**
         * 只要存在x坐标大于x的点，覆盖一个矩形，使得矩形的左边x坐标为x，右边x坐标为x+w
         */
        while ((x = xSet.higher(x)) != null) {
            result++;
            x += w;
        }
        return result;
    }
}
