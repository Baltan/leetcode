package leetcode.algorithms;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: 560. Subarray Sum Equals K
 *
 * @author Baltan
 * @date 2019-09-13 14:14
 * @see MaxNonOverlapping
 */
public class SubarraySum {
    public static void main(String[] args) {
        int[] nums1 = {1, 1, 1};
        System.out.println(subarraySum(nums1, 2));

        int[] nums2 = {3, 4, 7, 2, -3, 1, 4, 2};
        System.out.println(subarraySum(nums2, 7));
    }

    public static int subarraySum(int[] nums, int k) {
        int result = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0;
        /**
         * 依次计算数组的前缀和，并用map保存每一个前缀和出现的次数，当前前缀和sum若比目标和k多difference，
         * 则结果加上之前前缀和difference出现的次数即可
         */
        for (int num : nums) {
            sum += num;
            int difference = sum - k;
            result += map.getOrDefault(difference, 0);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return result;
    }
}
