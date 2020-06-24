package leetcode.algorithms;

import java.util.Arrays;

/**
 * Description: 16. 3Sum Closest
 *
 * @author Baltan
 * @date 2018/8/29 10:45
 */
public class ThreeSumClosest {
    public static void main(String[] args) {
        System.out.println(threeSumClosest(new int[]{-1, 2, 1, -4}, 1));
        System.out.println(threeSumClosest(new int[]{1, 1, 1, 0}, -100));
    }

    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int length = nums.length;
        /**
         * 三数之和与target的最小差值
         */
        int minDiff = Integer.MAX_VALUE;
        int result = target;
        /**
         * 先固定第一个数nums[i]，双指针查找剩余的两个数，使得剩余两数的和尽可能接近target-nums[i]
         */
        for (int i = 0; i < length - 2; i++) {
            int lo = i + 1;
            int hi = length - 1;
            /**
             * 双指针
             */
            while (lo < hi) {
                int sum = nums[i] + nums[lo] + nums[hi];
                int diff = Math.abs(sum - target);

                if (diff < minDiff) {
                    minDiff = diff;
                    result = sum;
                }

                if (sum < target) {
                    lo++;
                } else if (sum > target) {
                    hi--;
                } else {
                    return result;
                }
            }
        }
        return result;
    }
}
