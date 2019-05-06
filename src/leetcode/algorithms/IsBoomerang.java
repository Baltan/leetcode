package leetcode.algorithms;

import java.util.Arrays;

/**
 * Description: Valid Boomerang
 *
 * @author Baltan
 * @date 2019-05-06 08:59
 */
public class IsBoomerang {
    public static void main(String[] args) {
        int[][] points1 = {{1, 1}, {2, 3}, {3, 2}};
        System.out.println(isBoomerang(points1));

        int[][] points2 = {{1, 1}, {2, 2}, {3, 3}};
        System.out.println(isBoomerang(points2));

        int[][] points3 = {{1, 1}, {2, 2}, {1, 1}};
        System.out.println(isBoomerang(points3));

        int[][] points4 = {{1, 1}, {2, 2}, {0, 0}};
        System.out.println(isBoomerang(points4));

        int[][] points5 = {{1, 1}, {1, 2}, {1, 3}};
        System.out.println(isBoomerang(points5));

        int[][] points6 = {{1, 1}, {1, 2}, {2, 3}};
        System.out.println(isBoomerang(points6));

        int[][] points7 = {{1, 1}, {1, 2}, {2, 3}};
        System.out.println(isBoomerang(points7));
    }

    public static boolean isBoomerang(int[][] points) {
        int[] p1 = points[0];
        int[] p2 = points[1];
        int[] p3 = points[2];

        if (Arrays.equals(p1, p2) || Arrays.equals(p1, p3) || Arrays.equals(p2, p3)) {
            return false;
        }

        if (p2[0] == p1[0] && p3[0] == p2[0]) {
            return false;
        }

        if (p2[0] == p1[0] && p3[0] != p2[0]) {
            return true;
        }

        if (p2[0] != p1[0] && p3[0] == p2[0]) {
            return true;
        }

        return (p2[1] - p1[1]) * 1.0 / (p2[0] - p1[0]) != (p3[1] - p2[1]) * 1.0 / (p3[0] - p2[0]);
    }
}
