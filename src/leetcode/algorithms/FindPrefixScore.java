package leetcode.algorithms;

import leetcode.util.OutputUtils;

/**
 * Description: 2640. Find the Score of All Prefixes of an Array
 *
 * @author Baltan
 * @date 2023/4/16 12:44
 */
public class FindPrefixScore {
    public static void main(String[] args) {
        OutputUtils.print1DLongArray(findPrefixScore(new int[]{2, 3, 7, 5, 10}));
        OutputUtils.print1DLongArray(findPrefixScore(new int[]{1, 1, 2, 4, 8, 16}));
    }

    public static long[] findPrefixScore(int[] nums) {
        long[] result = new long[nums.length];
        /**
         * 数组nums前缀子数组中的最大值
         */
        int max = nums[0];
        result[0] = nums[0] + max;

        for (int i = 1; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            result[i] = result[i - 1] + nums[i] + max;
        }
        return result;
    }
}
