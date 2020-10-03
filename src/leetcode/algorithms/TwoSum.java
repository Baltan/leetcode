package leetcode.algorithms;

import leetcode.util.OutputUtils;

import java.awt.*;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Description: 1. Two Sum
 *
 * @author Baltan
 * @date 2017/11/7 11:29
 */

public class TwoSum {
    public static void main(String[] args) {
        OutputUtils.print1DIntegerArray(twoSum(new int[]{2, 7, 11, 15}, 9));
    }

    public static int[] twoSum(int[] nums, int target) {
        int length = nums.length;
        Point[] points = new Point[length];

        for (int i = 0; i < length; i++) {
            points[i] = new Point(nums[i], i);
        }

        Arrays.sort(points, Comparator.comparingInt(p -> p.x));
        int lo = 0;
        int hi = length - 1;

        while (lo < hi) {
            if (points[lo].x + points[hi].x == target) {
                return new int[]{points[lo].y, points[hi].y};
            } else if (points[lo].x + points[hi].x < target) {
                lo++;
            } else if (points[lo].x + points[hi].x > target) {
                hi--;
            }
        }
        return new int[]{};
    }
}
