package leetcode.algorithms;

import java.util.List;

/**
 * Description: 3364. Minimum Positive Sum Subarray
 *
 * @author Baltan
 * @date 2024/12/2 22:59
 */
public class MinimumSumSubarray {
    public static void main(String[] args) {
        System.out.println(minimumSumSubarray(List.of(-11, -7, -19), 3, 3));
        System.out.println(minimumSumSubarray(List.of(4, -10), 1, 1));
        System.out.println(minimumSumSubarray(List.of(3, -2, 1, 4), 2, 3));
        System.out.println(minimumSumSubarray(List.of(-2, 2, -3, 1), 2, 3));
        System.out.println(minimumSumSubarray(List.of(1, 2, 3, 4), 2, 4));
    }

    public static int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int result = Integer.MAX_VALUE;

        for (int i = 0; i < nums.size(); i++) {
            int sum = 0;
            /**
             * 枚举子数组nums[i……j]
             */
            for (int j = i; j < nums.size() && j - i + 1 <= r; j++) {
                sum += nums.get(j);
                /**
                 * 当子数组的长度不小于l，且子数组中元素之和大于0时符合要求
                 */
                if (j - i + 1 >= l && sum > 0) {
                    result = Math.min(result, sum);
                }
            }
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }
}
