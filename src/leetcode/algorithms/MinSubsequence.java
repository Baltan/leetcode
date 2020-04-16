package leetcode.algorithms;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Description: 1403. Minimum Subsequence in Non-Increasing Order
 *
 * @author Baltan
 * @date 2020-04-16 20:40
 */
public class MinSubsequence {
    public static void main(String[] args) {
        System.out.println(minSubsequence(new int[]{4, 3, 10, 9, 8}));
        System.out.println(minSubsequence(new int[]{4, 4, 7, 6, 7}));
        System.out.println(minSubsequence(new int[]{6}));
    }

    public static List<Integer> minSubsequence(int[] nums) {
        List<Integer> result = new LinkedList<>();
        /**
         * 数组nums中所有数字的和
         */
        int sum = 0;
        /**
         * 最小子序列的和
         */
        int currentSum = 0;

        for (int num : nums) {
            sum += num;
        }

        Arrays.sort(nums);
        /**
         * 将数组中的数从大到小逐一加入到最小子序列中，直到子序列的元素之和严格大于未包含在该子序列中
         * 的各元素之和
         */
        for (int i = nums.length - 1; i >= 0; i--) {
            currentSum += nums[i];
            result.add(nums[i]);

            if (currentSum > sum - currentSum) {
                break;
            }
        }
        return result;
    }
}
