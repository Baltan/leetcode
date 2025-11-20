package leetcode.algorithms;

/**
 * Description: 3708. Longest Fibonacci Subarray
 *
 * @author baltan
 * @date 2025/11/18 10:26
 */
public class LongestSubarray3 {
    public static void main(String[] args) {
        System.out.println(longestSubarray(new int[]{1, 1, 1, 1, 2, 3, 5, 1}));
        System.out.println(longestSubarray(new int[]{5, 2, 7, 9, 16}));
        System.out.println(longestSubarray(new int[]{1000000000, 1000000000, 1000000000}));
    }

    public static int longestSubarray(int[] nums) {
        int result = 0;
        /**
         * 当前斐波那契子数组的长度，初始子数组为nums[0……1]
         */
        int length = 2;

        for (int i = 2; i < nums.length; i++) {
            if (nums[i] == nums[i - 1] + nums[i - 2]) {
                length++;
            } else {
                /**
                 * 将nums[i-1……i]作为一个新的斐波那契子数组的前两个元素
                 */
                length = 2;
            }
            result = Math.max(result, length);
        }
        return result;
    }
}
