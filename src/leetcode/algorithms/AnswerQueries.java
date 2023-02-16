package leetcode.algorithms;

import leetcode.util.OutputUtils;

import java.util.Arrays;

/**
 * Description: 2389. Longest Subsequence With Limited Sum
 *
 * @author Baltan
 * @date 2023/2/12 14:09
 */
public class AnswerQueries {
    public static void main(String[] args) {
        OutputUtils.print1DIntegerArray(answerQueries(new int[]{4, 5, 2, 1}, new int[]{3, 10, 21}));
        OutputUtils.print1DIntegerArray(answerQueries(new int[]{2, 3, 4, 5}, new int[]{1}));
    }

    public static int[] answerQueries(int[] nums, int[] queries) {
        int[] result = new int[queries.length];
        Arrays.sort(nums);
        /**
         * 得到数组nums的前缀和，其中计算后得到的nums[i]等于原来的nums[0]+nums[1]+……+nums[i]
         */
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }

        for (int i = 0; i < queries.length; i++) {
            /**
             * 原始数组nums中所有数字都大于queries[i]，不存在符合题意的子序列
             */
            if (nums[0] > queries[i]) {
                result[i] = 0;
                continue;
            }
            int lo = 0;
            int hi = nums.length - 1;
            /**
             * 子序列的起始索引为0，二分查找子序列的结束索引
             */
            while (lo < hi) {
                int mid = (lo + hi + 1) / 2;

                if (nums[mid] > queries[i]) {
                    hi = mid - 1;
                } else {
                    lo = mid;
                }
            }
            result[i] = lo + 1;
        }
        return result;
    }
}
