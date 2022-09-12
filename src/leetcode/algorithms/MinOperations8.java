package leetcode.algorithms;

import java.util.Arrays;

/**
 * Description: 1658. Minimum Operations to Reduce X to Zero
 *
 * @author Baltan
 * @date 2022/9/11 15:07
 */
public class MinOperations8 {
    public static void main(String[] args) {
        System.out.println(minOperations(
                new int[]{8828, 9581, 49, 9818, 9974, 9869, 9991, 10000, 10000, 10000, 9999, 9993, 9904, 8819,
                        1231, 6309}, 134365));
        System.out.println(minOperations(
                new int[]{8828, 9581, 49, 9818, 9974, 9869, 9991, 10000, 10000, 10000, 9999, 9993, 9904, 8819,
                        1231, 6309}, 125537));
        System.out.println(minOperations(
                new int[]{8828, 9581, 49, 9818, 9974, 9869, 9991, 10000, 10000, 10000, 9999, 9993, 9904, 8819,
                        1231, 6309}, 128056));
        System.out.println(minOperations(
                new int[]{8828, 9581, 49, 9818, 9974, 9869, 9991, 10000, 10000, 10000, 9999, 9993, 9904, 8819,
                        1231, 6309}, 124374));
        System.out.println(minOperations(new int[]{1, 1, 4, 2, 3}, 5));
        System.out.println(minOperations(new int[]{5, 6, 7, 8, 9}, 4));
        System.out.println(minOperations(new int[]{3, 2, 20, 1, 1, 3}, 10));
    }

    public static int minOperations(int[] nums, int x) {
        int result = Integer.MAX_VALUE;
        /**
         * 需要查找的连续子数组中所有元素的和
         */
        int sum = Arrays.stream(nums).sum() - x;

        if (sum == 0) {
            return nums.length;
        }
        int length = nums.length;
        /**
         * 滑动窗口第一个元素的索引位置
         */
        int lo = 0;
        /**
         * 滑动窗口最后一个元素的索引位置
         */
        int hi = 0;
        int currSum = nums[0];

        while (hi < length) {
            while (currSum > sum && lo < hi) {
                currSum -= nums[lo];
                lo++;
            }

            if (currSum == sum) {
                result = Math.min(result, length - (hi - lo + 1));
            }
            hi++;

            if (hi < length) {
                currSum += nums[hi];
            }
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }
}
