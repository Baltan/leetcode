package leetcode.algorithms;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: 673. Number of Longest Increasing Subsequence
 *
 * @author Baltan
 * @date 2020-02-12 15:08
 */
public class FindNumberOfLIS {
    public static void main(String[] args) {
        System.out.println(findNumberOfLIS(new int[]{1, 3, 5, 4, 7}));
        System.out.println(findNumberOfLIS(new int[]{2, 2, 2, 2, 2}));
        System.out.println(findNumberOfLIS(new int[]{1, 2, 3, 1, 2, 3}));
        System.out.println(findNumberOfLIS(
                new int[]{1, 2, 4, 6, 7, 2, 7, 9, 3, 1, 2, 7, 9, 3, 1, 5, 7, 8, 7, 3, 1, 1, 3, 5, 7, 9, 7, 5,
                        3, 2, 2, 5, 0, 8, 9, 9, 6, 4, 3, 2, 1, 1, 3, 4}));
        System.out.println(findNumberOfLIS(new int[]{}));
        System.out.println(findNumberOfLIS(new int[]{1}));
    }

    public static int findNumberOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int length = nums.length;
        /**
         * dp[i]表示以nums[i]作为最后一个元素的最长递增子序列的长度
         */
        int[] dp = new int[length];
        dp[0] = 1;
        /**
         * lisCount[i]表示以nums[i]作为最后一个元素的最长递增子序列的个数
         */
        int[] lisCount = new int[length];
        lisCount[0] = 1;
        /**
         * map保存长度为key的递增子序列的个数
         */
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 1);
        /**
         * 最长递增子序列的长度
         */
        int lisLength = 1;

        for (int i = 1; i < length; i++) {
            /**
             * 以当前元素作为最后一个元素的最长递增子序列的长度
             */
            int currentLisLength = 1;
            /**
             * 以当前元素作为最后一个元素的最长递增子序列的个数
             */
            int currentLisCount = 1;

            for (int j = i - 1; j >= 0; j--) {
                /**
                 * 只有当前元素大于之前的某个元素时，才有可能构成更长的递增子序列
                 */
                if (nums[i] > nums[j]) {
                    /**
                     * 如果dp[j]>=currentLisLength，在以nums[j]结尾的最长递增子序列后追加
                     * nums[i]可以得到更长的长度为dp[j]+1的最长递增子序列，并且有lisCount[j]
                     * 种长度为dp[j]+1的最长递增子序列；如果dp[j]+1=currentLisLength，在以
                     * nums[j]结尾的最长递增子序列后追加nums[i]可以得到长度为currentLisLength
                     * 的另外lisCount[j]个最长递增子序列
                     */
                    if (dp[j] >= currentLisLength) {
                        /**
                         * 更新以当前元素作为最后一个元素的最长递增子序列的长度
                         */
                        currentLisLength = dp[j] + 1;
                        currentLisCount = lisCount[j];
                    } else if (dp[j] + 1 == currentLisLength) {
                        currentLisCount += lisCount[j];
                    }
                }
            }
            dp[i] = currentLisLength;
            lisCount[i] = currentLisCount;
            /**
             * 最长递增子序列的长度
             */
            lisLength = Math.max(lisLength, currentLisLength);
            /**
             * 记录长度为currentLisLength的递增子序列的个数
             */
            map.put(currentLisLength, map.getOrDefault(currentLisLength, 0) + currentLisCount);
        }
        return map.get(lisLength);
    }
}
