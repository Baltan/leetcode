package leetcode.algorithms;

/**
 * Description: 3392. Count Subarrays of Length Three With a Condition
 *
 * @author Baltan
 * @date 2024/12/23 23:38
 */
public class CountSubarrays3 {
    public static void main(String[] args) {
        System.out.println(countSubarrays(new int[]{1, 2, 1, 4, 1}));
        System.out.println(countSubarrays(new int[]{1, 1, 1}));
    }

    public static int countSubarrays(int[] nums) {
        int result = 0;
        /**
         * 枚举所有长度为3的子数组
         */
        for (int i = 0; i <= nums.length - 3; i++) {
            if (nums[i] * 2 + nums[i + 2] * 2 == nums[i + 1]) {
                result++;
            }
        }
        return result;
    }
}
