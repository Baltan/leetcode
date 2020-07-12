package leetcode.algorithms;

import java.util.Arrays;

/**
 * Description: 1508. Range Sum of Sorted Subarray Sums
 *
 * @author Baltan
 * @date 2020-07-12 15:47
 */
public class RangeSum {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 4};
        System.out.println(rangeSum(nums1, 4, 1, 5));

        int[] nums2 = {1, 2, 3, 4};
        System.out.println(rangeSum(nums2, 4, 3, 4));

        int[] nums3 = {1, 2, 3, 4};
        System.out.println(rangeSum(nums3, 4, 1, 10));
    }

    public static int rangeSum(int[] nums, int n, int left, int right) {
        long result = 0L;
        int mod = 1000000007;
        /**
         * 数组nums的前缀和
         */
        int[] prefixSum = new int[n + 1];
        /**
         * 保存数组nums的所有子数组的和
         */
        int[] sums = new int[n * (n + 1) / 2];
        int index = 0;

        for (int i = 1; i <= n; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                sums[index++] = prefixSum[i] - prefixSum[j];
            }
        }
        /**
         * 将所有子数组的和升序排列
         */
        Arrays.sort(sums);

        for (int i = left - 1; i < right; i++) {
            result += sums[i];
        }
        return (int) (result % mod);
    }
}
