package leetcode.algorithms;

import java.util.Arrays;

/**
 * Description: 2971. Find Polygon With the Largest Perimeter
 *
 * @author Baltan
 * @date 2023/12/24 19:45
 */
public class LargestPerimeter11 {
    public static void main(String[] args) {
        System.out.println(largestPerimeter(new int[]{5, 5, 5}));
        System.out.println(largestPerimeter(new int[]{1, 12, 1, 2, 5, 50, 3}));
        System.out.println(largestPerimeter(new int[]{5, 5, 50}));
    }

    public static long largestPerimeter(int[] nums) {
        /**
         * 数组nums中所有边长之和
         */
        long sum = 0L;
        Arrays.sort(nums);

        for (int num : nums) {
            sum += num;
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            /**
             * 此时只剩余两条边，无法构成一个多边形
             */
            if (i == 1) {
                return -1L;
            }
            /**
             * 判断剩余所有边中的最长边nums[i]是否小于其余边的长度之和
             */
            if (sum - nums[i] > nums[i]) {
                return sum;
            }
            sum -= nums[i];
        }
        return -1;
    }
}
