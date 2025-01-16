package leetcode.algorithms;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Description: 3413. Maximum Coins From K Consecutive Bags
 *
 * @author Baltan
 * @date 2025/1/16 22:54
 */
public class MaximumCoins {
    public static void main(String[] args) {
        System.out.println(maximumCoins(new int[][]{{8, 10, 1}, {1, 3, 2}, {5, 6, 4}}, 4));
        System.out.println(maximumCoins(new int[][]{{1, 10, 3}}, 2));
    }

    public static long maximumCoins(int[][] coins, int k) {
        long result = Long.MIN_VALUE;
        /**
         * 将所有区间按照起点升序排列
         */
        Arrays.sort(coins, Comparator.comparingInt(x -> x[0]));
        int length = coins.length;
        /**
         * sums[i]表示升序排列后，区间coins[i]中所有袋子中硬币的总数
         */
        long[] sums = new long[length];
        /**
         * 数组sums的前缀和数组
         */
        long[] prefixSums = new long[length + 1];

        for (int i = 0; i < length; i++) {
            sums[i] = (long) (coins[i][1] - coins[i][0] + 1) * coins[i][2];
            prefixSums[i + 1] = prefixSums[i] + sums[i];
        }
        /**
         * 根据贪心思想，为了使得k个连续的袋子中硬币的总数尽可能多，这k个袋子中的第一个袋子应该在某个区间的第一个袋子处，或者这k个袋子中的最
         * 后一个袋子应该在某个区间的最后一个袋子处。计算第一种情况，假设这k个袋子中的第一个袋子在索引coins[i][0]处，则最后一个袋子在索引
         * end处
         */
        for (int i = 0; i < length; i++) {
            int[] coin = coins[i];
            int start = coin[0];
            int end = start + k - 1;
            int lo = i;
            int hi = length - 1;
            /**
             * 二分查找第一个袋子的索引不大于end的最右侧的区间，这个区间右侧的其他区间中都不可能包含索引为[coins[i][0],end]的这k个袋子
             */
            while (lo < hi) {
                int mid = (lo + hi + 1) / 2;

                if (coins[mid][0] <= end) {
                    lo = mid;
                } else {
                    hi = mid - 1;
                }
            }
            /**
             * 二分查找到的区间为coins[lo]，如果该区间中最后一个袋子的索引仍不大于end，则说明索引为coins[i……lo]这些区间中的所有袋子都包
             * 含在k个袋子中；否则coins[i……lo-1]这些区间中的所有袋子都包含在k个袋子中，另外区间coins[lo]中索引为[coins[lo][0],end]的
             * 这部分袋子也包含在k个袋子中
             */
            if (coins[lo][1] <= end) {
                result = Math.max(result, prefixSums[lo + 1] - prefixSums[i]);
            } else {
                result = Math.max(result, prefixSums[lo] - prefixSums[i] + (long) (end - coins[lo][0] + 1) * coins[lo][2]);
            }
        }
        /**
         * 计算第二种情况，假设这k个袋子中的最后一个袋子在索引coins[i][1]处，则第一个袋子在索引start处
         */
        for (int i = length - 1; i >= 0; i--) {
            int[] coin = coins[i];
            int end = coin[1];
            int start = end - k + 1;
            int lo = 0;
            int hi = i;
            /**
             * 二分查找最后一个袋子的索引不小于start的最左侧的区间，这个区间左侧的其他区间中都不可能包含索引为[start,coins[i][1]]的这k个
             * 袋子
             */
            while (lo < hi) {
                int mid = (lo + hi) / 2;

                if (coins[mid][1] >= start) {
                    hi = mid;
                } else {
                    lo = mid + 1;
                }
            }
            /**
             * 二分查找到的区间为coins[lo]，如果该区间中第一个袋子的索引仍不小于start，则说明索引为coins[lo……i]这些区间中的所有袋子都包
             * 含在k个袋子中；否则coins[lo+1……i]这些区间中的所有袋子都包含在k个袋子中，另外区间coins[lo]中索引为[start,coins[lo][1]]
             * 的这部分袋子也包含在k个袋子中
             */
            if (coins[lo][0] >= start) {
                result = Math.max(result, prefixSums[i + 1] - prefixSums[lo]);
            } else {
                result = Math.max(result, prefixSums[i + 1] - prefixSums[lo + 1] + (long) (coins[lo][1] - start + 1) * coins[lo][2]);
            }
        }
        return result;
    }
}
