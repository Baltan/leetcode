package leetcode.algorithms;

import leetcode.util.OutputUtils;

import java.util.Arrays;

/**
 * Description: 3685. Subsequence Sum After Capping Elements
 *
 * @author Baltan
 * @date 2025/11/2 17:46
 */
public class SubsequenceSumAfterCapping {
    public static void main(String[] args) {
        OutputUtils.print1DBooleanArray(subsequenceSumAfterCapping(new int[]{11, 14, 2, 5, 10, 8, 11, 4, 2, 7, 8, 4, 10, 5, 11}, 3));
        OutputUtils.print1DBooleanArray(subsequenceSumAfterCapping(new int[]{3, 3, 5, 6, 2, 5}, 23));
        OutputUtils.print1DBooleanArray(subsequenceSumAfterCapping(new int[]{1, 1}, 1));
        OutputUtils.print1DBooleanArray(subsequenceSumAfterCapping(new int[]{11, 12, 2, 8, 4, 19, 10, 10, 14, 20, 17, 10, 2, 13, 20, 15, 20, 9, 13, 16}, 6));
        OutputUtils.print1DBooleanArray(subsequenceSumAfterCapping(new int[]{1}, 1));
        OutputUtils.print1DBooleanArray(subsequenceSumAfterCapping(new int[]{4, 3, 2, 4}, 5));
        OutputUtils.print1DBooleanArray(subsequenceSumAfterCapping(new int[]{1, 2, 3, 4, 5}, 3));
    }

    public static boolean[] subsequenceSumAfterCapping(int[] nums, int k) {
        Arrays.sort(nums);
        int length = nums.length;
        boolean[] result = new boolean[length];
        int leftCount = length;
        int max = nums[length - 1];
        int[] counts = new int[max + 1];
        int value = 0;
        int maxSum = max * length;
        int currentMaxSum = 0;
        boolean[] dp = new boolean[maxSum + 1];
        dp[0] = true;

        for (int num : nums) {
            counts[num]++;
        }

        for (int i = 1; i <= length; i++) {
            if (i > max) {
                result[i - 1] = result[i - 2];
                continue;
            }

            while (value <= i) {
                leftCount -= counts[value];

                for (int sum = currentMaxSum; sum >= 0; sum--) {
                    if (!dp[sum]) {
                        continue;
                    }

                    if ((k - sum) % i == 0 && (k - sum) / i <= leftCount && (k - sum) / i >= 0) {
                        result[i - 1] = true;
                    }

                    for (int count = counts[value]; count >= 1; count--) {
                        int newSum = sum + value * count;
                        dp[newSum] = true;

                        if ((k - newSum) % i == 0 && (k - newSum) / i <= leftCount && (k - newSum) / i >= 0) {
                            result[i - 1] = true;
                        }
                    }
                }
                currentMaxSum += value * counts[value];
                value++;
            }
        }
        return result;
    }
}
