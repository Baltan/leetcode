package leetcode.algorithms;

/**
 * Description: 3095. Shortest Subarray With OR at Least K I
 *
 * @author Baltan
 * @date 2024/4/2 21:38
 * @see MinimumSubarrayLength
 */
public class MinimumSubarrayLength1 {
    public static void main(String[] args) {
        System.out.println(minimumSubarrayLength(new int[]{1, 2, 3}, 2));
        System.out.println(minimumSubarrayLength(new int[]{2, 1, 8}, 10));
        System.out.println(minimumSubarrayLength(new int[]{1, 2}, 0));
    }

    public static int minimumSubarrayLength(int[] nums, int k) {
        int result = Integer.MAX_VALUE;
        /**
         * 因为按位或运算有非严格递增的性质，所以可以按照子数组长度递增的顺序逐一枚举所有以数字nums[i]开头的子数组，直到子数组中所有数字按位
         * 或的值不小于k
         */
        for (int i = 0; i < nums.length; i++) {
            /**
             * 子数组中所有数字按位或的值
             */
            int or = 0;

            for (int j = i; j < nums.length; j++) {
                or |= nums[j];

                if (or >= k) {
                    result = Math.min(result, j - i + 1);
                }
            }
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }
}
