package leetcode.algorithms;

import leetcode.util.OutputUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: 689. Maximum Sum of 3 Non-Overlapping Subarrays
 *
 * @author Baltan
 * @date 2025/1/31 15:54
 */
public class MaxSumOfThreeSubarrays {
    public static void main(String[] args) {
        OutputUtils.print1DIntegerArray(maxSumOfThreeSubarrays(new int[]{1, 2, 1, 2, 6, 7, 5, 1}, 2));
        OutputUtils.print1DIntegerArray(maxSumOfThreeSubarrays(new int[]{1, 2, 1, 2, 1, 2, 1, 2, 1}, 2));
    }

    public static int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        /**
         * 数组nums的前缀和数组
         */
        long[] prefixSums = new long[nums.length + 1];

        for (int i = 0; i < nums.length; i++) {
            prefixSums[i + 1] = prefixSums[i] + nums[i];
        }
        /**
         * dp[i][j]表示前缀子数组nums[0……i]中，选择j个长度为k、互不重叠、全部数字之和最大的子数组，最优方案的状态
         */
        Subarray[][] dp = new Subarray[nums.length][4];
        /**
         * 如果前缀子数组nums[0……i]中只需要包含1个长度为k的子数组，则前缀子数组的长度至少为k，此时长度为k的子数组只能为nums[0……k-1]，被
         * 选择的子数组的全部数字之和为prefixSums[k]-prefixSums[0]
         */
        dp[k - 1][1] = new Subarray(new ArrayList<>(List.of(k - 1)), prefixSums[k] - prefixSums[0]);
        /**
         * 如果前缀子数组nums[0……i]中需要包含2个长度为k、互不重叠的子数组，则前缀子数组的长度至少为2k，此时长度为k的子数组只能为
         * nums[0……k-1]和nums[k……2k-1]，被选择的子数组的全部数字之和为prefixSums[2k]-prefixSums[0]
         */
        dp[2 * k - 1][2] = new Subarray(new ArrayList<>(List.of(k - 1, 2 * k - 1)), prefixSums[2 * k] - prefixSums[0]);
        /**
         * 如果前缀子数组nums[0……i]中需要包含3个长度为k、互不重叠的子数组，则前缀子数组的长度至少为3k，此时长度为k的子数组只能为
         * nums[0……k-1]、nums[k……2k-1]和nums[2k……3k-1]，被选择的子数组的全部数字之和为prefixSums[3k]-prefixSums[0]
         */
        dp[3 * k - 1][3] = new Subarray(new ArrayList<>(List.of(k - 1, 2 * k - 1, 3 * k - 1)), prefixSums[3 * k] - prefixSums[0]);

        for (int i = k; i < nums.length; i++) {
            /**
             * 如果从前缀子数组nums[0……i]中选择1个长度为k、全部数字之和最大的子数组，最优方案至少不逊于从前缀子数组nums[0……i-1]中选择1个
             * 长度为k、全部数字之和最大的子数组的最优方案
             */
            dp[i][1] = new Subarray(dp[i - 1][1]);
            /**
             * 考虑长度为k的子数组为[i-k+1,i-k+2,……,i]时的情况，此时全部数字之和为prefixSums[i+1]-prefixSums[i+1-k]，判断是否优于
             * 从前缀子数组nums[0……i-1]中选择1个长度为k、全部数字之和最大的子数组的最优方案
             */
            long sum = prefixSums[i + 1] - prefixSums[i + 1 - k];

            if (sum > dp[i][1].sum) {
                dp[i][1] = new Subarray(new ArrayList<>(List.of(i)), sum);
            }
        }

        for (int i = 2 * k; i < nums.length; i++) {
            /**
             * 如果从前缀子数组nums[0……i]中选择2个长度为k、互不重叠、全部数字之和最大的子数组，最优方案至少不逊于从前缀子数组nums[0……i-1]
             * 中选择2个长度为k、互不重叠、全部数字之和最大的子数组的最优方案
             */
            dp[i][2] = new Subarray(dp[i - 1][2]);
            /**
             * 考虑第2个长度为k的子数组为[i-k+1,i-k+2,……,i]时的情况，此时第一个长度为k的子数组只能从前缀子数组nums[0……i-k]中选择，全部
             * 数字之和的最大值为prefixSums[i+1]-prefixSums[i+1-k]+dp[i-k][1].sum，判断是否优于从前缀子数组nums[0……i-1]中选择2个
             * 长度为k、互不重叠、全部数字之和最大的子数组的最优方案
             */
            long sum = prefixSums[i + 1] - prefixSums[i + 1 - k] + dp[i - k][1].sum;

            if (sum > dp[i][2].sum) {
                List<Integer> ends = new ArrayList<>(dp[i - k][1].ends);
                ends.add(i);
                dp[i][2] = new Subarray(ends, sum);
            }
        }

        for (int i = 3 * k; i < nums.length; i++) {
            /**
             * 如果从前缀子数组nums[0……i]中选择3个长度为k、互不重叠、全部数字之和最大的子数组，最优方案至少不逊于从前缀子数组nums[0……i-1]
             * 中选择3个长度为k、互不重叠、全部数字之和最大的子数组的最优方案
             */
            dp[i][3] = new Subarray(dp[i - 1][3]);
            long sum = prefixSums[i + 1] - prefixSums[i + 1 - k] + dp[i - k][2].sum;
            /**
             * 考虑第3个长度为k的子数组为[i-k+1,i-k+2,……,i]时的情况，此时前两个长度为k的子数组只能从前缀子数组nums[0……i-k]中选择，全部
             * 数字之和的最大值为prefixSums[i+1]-prefixSums[i+1-k]+dp[i-k][2].sum，判断是否优于从前缀子数组nums[0……i-1]中选择3个
             * 长度为k、互不重叠、全部数字之和最大的子数组的最优方案
             */
            if (sum > dp[i][3].sum) {
                List<Integer> ends = new ArrayList<>(dp[i - k][2].ends);
                ends.add(i);
                dp[i][3] = new Subarray(ends, sum);
            }
        }
        /**
         * dp[length-1][3]即为从数组nums中选择3个长度为k、互不重叠、全部数字之和最大的子数组的最优方案，根据被选择的3个子数组各自最后一个
         * 元素在原数组nums中的索引值，推算出它们各自第一个元素在原数组nums中的索引值
         */
        return dp[nums.length - 1][3].ends.stream().mapToInt(i -> i - k + 1).toArray();
    }

    /**
     * Subarray表示从数组nums的指定前缀子数组中选择若干个长度为k、互不重叠、全部数字之和最大的子数组，最优方案的状态
     */
    public static class Subarray {
        /**
         * 若干个长度为k的子数组中，各个子数组的最后一个元素在原数组nums中的索引值
         */
        private final List<Integer> ends;
        /**
         * 被选择的若干个长度为k的子数组的全部数字之和
         */
        private final long sum;

        public Subarray(List<Integer> ends, long sum) {
            this.ends = ends;
            this.sum = sum;
        }

        public Subarray(Subarray subarray) {
            this.ends = new ArrayList<>(subarray.ends);
            this.sum = subarray.sum;
        }
    }
}
