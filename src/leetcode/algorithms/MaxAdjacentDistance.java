package leetcode.algorithms;

/**
 * Description: 3423. Maximum Difference Between Adjacent Elements in a Circular Array
 *
 * @author Baltan
 * @date 2025/1/22 23:37
 */
public class MaxAdjacentDistance {
    public static void main(String[] args) {
        System.out.println(maxAdjacentDistance(new int[]{1, 2, 4}));
        System.out.println(maxAdjacentDistance(new int[]{-5, -10, -5}));
    }

    public static int maxAdjacentDistance(int[] nums) {
        int result = Math.abs(nums[0] - nums[nums.length - 1]);

        for (int i = 1; i < nums.length; i++) {
            result = Math.max(result, Math.abs(nums[i] - nums[i - 1]));
        }
        return result;
    }
}
