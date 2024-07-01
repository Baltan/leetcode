package leetcode.algorithms;

import java.util.Arrays;

/**
 * Description: 3194. Minimum Average of Smallest and Largest Elements
 *
 * @author baltan
 * @date 2024/6/29 13:23
 */
public class MinimumAverage {
    public static void main(String[] args) {
        System.out.println(minimumAverage(new int[]{7, 8, 3, 4, 15, 13, 4, 1}));
        System.out.println(minimumAverage(new int[]{1, 9, 8, 3, 10, 5}));
        System.out.println(minimumAverage(new int[]{1, 2, 3, 7, 8, 9}));
    }

    public static double minimumAverage(int[] nums) {
        double result = Double.POSITIVE_INFINITY;
        int lo = 0;
        int hi = nums.length - 1;
        Arrays.sort(nums);
        /**
         * 将升序排列后的数组nums首尾数字两两配对求平均数
         */
        while (lo < hi) {
            result = Math.min(result, (nums[lo++] + nums[hi--]) / 2.0);
        }
        return result;
    }
}
