package leetcode.algorithms;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: 1546. Maximum Number of Non-Overlapping Subarrays With Sum Equals Target
 *
 * @author Baltan
 * @date 2020-08-18 23:09
 * @see SubarraySum
 */
public class MaxNonOverlapping {
    public static void main(String[] args) {
        System.out.println(maxNonOverlapping(new int[]{1, 1, 1, 1, 1}, 2));
        System.out.println(maxNonOverlapping(new int[]{-1, 3, 5, 1, 4, 2, -9}, 6));
        System.out.println(maxNonOverlapping(new int[]{-2, 6, 6, 3, 5, 4, 1, 2, 8}, 10));
        System.out.println(maxNonOverlapping(new int[]{0, 0, 0}, 0));
    }

    public static int maxNonOverlapping(int[] nums, int target) {
        int length = nums.length;
        /**
         * dp[i]表示数组nums的前i个数构成的子数组中和为target的最大数目不重叠非空子数组数目
         */
        int[] dp = new int[length + 1];
        /**
         * 前缀和i -> 最近一次前缀和为i的索引位置
         */
        Map<Integer, Integer> prefixSumMap = new HashMap<>();
        /**
         * 前缀和
         */
        int prefixSum = 0;
        prefixSumMap.put(0, -1);

        for (int i = 0; i < length; i++) {
            prefixSum += nums[i];
            dp[i + 1] = dp[i];
            /**
             * 如果之前存在某个索引x处的前缀和为prefixSum-target，则索引[x+1,i]构成的子数组和为target，此时
             * 索引[0,x]构成的子数组中和为target的最大数目不重叠非空子数组数目为dp[x+1]
             */
            if (prefixSumMap.containsKey(prefixSum - target)) {
                dp[i + 1] = Math.max(dp[i + 1], dp[prefixSumMap.get(prefixSum - target) + 1] + 1);
            }
            /**
             * 更新最近一次前缀和为prefixSum的索引位置为当前位置i
             */
            prefixSumMap.put(prefixSum, i);
        }
        return dp[length];
    }
}
