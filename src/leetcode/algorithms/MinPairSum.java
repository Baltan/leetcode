package leetcode.algorithms;

import java.util.Arrays;

/**
 * Description: 1877. Minimize Maximum Pair Sum in Array
 *
 * @author Baltan
 * @date 2022/5/2 14:36
 */
public class MinPairSum {
    public static void main(String[] args) {
        System.out.println(minPairSum(new int[]{3, 5, 2, 3}));
        System.out.println(minPairSum(new int[]{3, 5, 4, 2, 4, 6}));
    }

    public static int minPairSum(int[] nums) {
        int result = Integer.MIN_VALUE;
        Arrays.sort(nums);
        /**
         * 将排序后的nums首尾两两组合成数对
         */
        for (int i = 0; i < nums.length / 2; i++) {
            result = Math.max(result, nums[i] + nums[nums.length - 1 - i]);
        }
        return result;
    }
}
