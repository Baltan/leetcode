package leetcode.algorithms;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: 2461. Maximum Sum of Distinct Subarrays With Length K
 *
 * @author Baltan
 * @date 2022/11/25 09:28
 */
public class MaximumSubarraySum {
    public static void main(String[] args) {
        System.out.println(maximumSubarraySum(new int[]{1, 5, 4, 2, 9, 9, 9}, 3));
        System.out.println(maximumSubarraySum(new int[]{4, 4, 4}, 3));
    }

    public static long maximumSubarraySum(int[] nums, int k) {
        long result = 0L;
        int length = nums.length;
        /**
         * 窗口中所有数字的和
         */
        long sum = 0L;
        /**
         * i -> 窗口中数字i出现的次数
         */
        Map<Integer, Integer> countMap = new HashMap<>();

        for (int i = 0; i < length; i++) {
            /**
             * 窗口向右移动的过程中，需要将之前窗口中的第一个元素移出窗口
             */
            if (i >= k) {
                int removalNum = nums[i - k];
                sum -= removalNum;
                int count = countMap.get(removalNum);

                if (count > 1) {
                    countMap.put(removalNum, count - 1);
                } else {
                    countMap.remove(removalNum);
                }
            }
            /**
             * 窗口向右移动，进入窗口的新数字
             */
            countMap.put(nums[i], countMap.getOrDefault(nums[i], 0) + 1);
            sum += nums[i];

            if (countMap.size() == k) {
                result = Math.max(result, sum);
            }
        }
        return result;
    }
}
