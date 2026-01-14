package leetcode.algorithms;

import java.util.Arrays;

/**
 * Description: 3727. Maximum Alternating Sum of Squares
 *
 * @author baltan
 * @date 2026/1/13 17:48
 */
public class MaxAlternatingSum1 {
    public static void main(String[] args) {
        System.out.println(maxAlternatingSum(new int[]{1, 2, 3}));
        System.out.println(maxAlternatingSum(new int[]{1, -1, 2, -2, 3, -3}));
    }

    public static long maxAlternatingSum(int[] nums) {
        long result = 0L;

        for (int i = 0; i < nums.length; i++) {
            nums[i] *= nums[i];
        }
        Arrays.sort(nums);
        /**
         * 将数组nums中元素的平方值最小的nums.length/2项作为新数组的负项
         */
        for (int i = 0; i < nums.length / 2; i++) {
            result -= nums[i];
        }
        /**
         * 将数组nums中元素的平方值最大的nums.length-nums.length/2项作为新数组的正项
         */
        for (int i = nums.length / 2; i < nums.length; i++) {
            result += nums[i];
        }
        return result;
    }
}
