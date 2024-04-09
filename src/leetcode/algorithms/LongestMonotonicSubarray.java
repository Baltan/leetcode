package leetcode.algorithms;

/**
 * Description: 3105. Longest Strictly Increasing or Strictly Decreasing Subarray
 *
 * @author baltan
 * @date 2024/4/9 17:21
 */
public class LongestMonotonicSubarray {
    public static void main(String[] args) {
        System.out.println(longestMonotonicSubarray(new int[]{1, 4, 3, 3, 2}));
        System.out.println(longestMonotonicSubarray(new int[]{3, 3, 3, 3}));
        System.out.println(longestMonotonicSubarray(new int[]{3, 2, 1}));
    }

    public static int longestMonotonicSubarray(int[] nums) {
        int result = 1;
        /**
         * 严格递增子数组的长度
         */
        int increasingLength = 1;
        /**
         * 严格递减子数组的长度
         */
        int decreasingLength = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                increasingLength++;
                /**
                 * 从元素nums[i]开始一个新的严格递减子数组
                 */
                decreasingLength = 1;
                result = Math.max(result, increasingLength);
            } else if (nums[i] < nums[i - 1]) {
                /**
                 * 从元素nums[i]开始一个新的严格递增子数组
                 */
                increasingLength = 1;
                decreasingLength++;
                result = Math.max(result, decreasingLength);
            } else {
                /**
                 * 从元素nums[i]开始一个新的严格递增子数组
                 */
                increasingLength = 1;
                /**
                 * 从元素nums[i]开始一个新的严格递减子数组
                 */
                decreasingLength = 1;
            }
        }
        return result;
    }
}
