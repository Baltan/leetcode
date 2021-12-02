package leetcode.algorithms;

/**
 * Description: 2016. Maximum Difference Between Increasing Elements
 *
 * @author Baltan
 * @date 2021/12/2 09:19
 */
public class MaximumDifference {
    public static void main(String[] args) {
        System.out.println(maximumDifference(new int[]{7, 1, 5, 4}));
        System.out.println(maximumDifference(new int[]{9, 4, 3, 2}));
        System.out.println(maximumDifference(new int[]{1, 5, 2, 10}));
    }

    public static int maximumDifference(int[] nums) {
        int result = -1;
        /**
         * 遍历到nums[i]为止，nums[i]之前的最小值
         */
        int min = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > min) {
                result = Math.max(nums[i] - min, result);
            }
            /**
             * 更新到nums[i]为止的最小值
             */
            min = Math.min(nums[i], min);
        }
        return result;
    }
}
