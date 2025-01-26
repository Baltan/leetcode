package leetcode.algorithms;

import java.util.Arrays;

/**
 * Description: 3428. Maximum and Minimum Sums of at Most Size K Subsequences
 *
 * @author baltan
 * @date 2025/1/24 12:15
 */
public class MinMaxSums {
    public static void main(String[] args) {
        System.out.println(minMaxSums(new int[]{1, 2, 3}, 2));
        System.out.println(minMaxSums(new int[]{5, 0, 6}, 1));
        System.out.println(minMaxSums(new int[]{1, 1, 1}, 2));
    }

    public static int minMaxSums(int[] nums, int k) {
        long result = 0L;
        int mod = 1000000007;
        /**
         * combinations[i][j]表示从i个中选择j个的方法数
         */
        long[][] combinations = new long[nums.length][k];
        /**
         * 参考：<a href="https://leetcode.cn/problems/maximum-and-minimum-sums-of-at-most-size-k-subsequences/solutions/3051549/gong-xian-fa-zu-he-shu-xue-pythonjavacgo-0jod/"></a>
         * <em>由于我们只关心子序列中的最值，所以元素顺序不影响答案，可以先把数组排序</em>
         */
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            combinations[i][0] = 1L;

            for (int j = 1; j <= Math.min(i, k - 1); j++) {
                /**
                 * 根据组合公式，C(i,j)=C(i-1,j-1)+C(i-1,j)
                 */
                combinations[i][j] = (combinations[i - 1][j - 1] + combinations[i - 1][j]) % mod;
            }
        }
        /**
         * 计算nums[i]作为子序列中最大值的情况。当nums[i]为子序列中的最大值时，之前不大于nums[i]的i个数字中可以选择[0,Math.min(i,k-1)]
         * 个数字
         */
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j <= Math.min(i, k - 1); j++) {
                result = (result + combinations[i][j] * nums[i]) % mod;
            }
        }
        /**
         * 计算nums[i]作为子序列中最小值的情况。当nums[i]为子序列中的最小值时，之前不小于nums[i]的length-1-i个数字中可以选择
         * [0,Math.min(length-1-i,k-1)]个数字
         */
        for (int i = nums.length - 1; i >= 0; i--) {
            for (int j = 0; j <= Math.min(nums.length - 1 - i, k - 1); j++) {
                result = (result + combinations[nums.length - 1 - i][j] * nums[i]) % mod;
            }
        }
        return (int) result;
    }
}