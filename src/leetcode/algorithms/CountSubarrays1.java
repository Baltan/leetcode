package leetcode.algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: 2962. Count Subarrays Where Max Element Appears at Least K Times
 *
 * @author Baltan
 * @date 2023/12/12 21:17
 */
public class CountSubarrays1 {
    public static void main(String[] args) {
        System.out.println(countSubarrays(new int[]{1, 3, 2, 3, 3}, 2));
        System.out.println(countSubarrays(new int[]{1, 4, 2, 1}, 3));
    }

    public static long countSubarrays(int[] nums, int k) {
        long result = 0L;
        /**
         * 数组nums中的最大值
         */
        int max = Integer.MIN_VALUE;
        /**
         * 依次保存数组nums中每个元素max的索引
         */
        List<Integer> indexes = new ArrayList<>();
        int index = 0;

        for (int num : nums) {
            max = Math.max(max, num);
        }

        for (int num : nums) {
            if (num == max) {
                indexes.add(index);
            }
            index++;
        }
        /**
         * 假设子数组中的第一个元素max在数组nums中的索引为indexes[i]，则子数组的最后一个元素max在nums中的索引至少为indexes[i+k-1]才能
         * 保证子数组中至少有k个元素max。所以每个子数组向前可以延长[0,indexes[i]-indexes[i-1]]个元素，向后可以延长
         * [0,nums.length-index[i+k-1]]个元素
         */
        for (int i = 0; i + k - 1 < indexes.size(); i++) {
            result += (long) (i == 0 ? indexes.get(i) + 1 : indexes.get(i) - indexes.get(i - 1)) * (nums.length - indexes.get(i + k - 1));
        }
        return result;
    }
}
