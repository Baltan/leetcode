package leetcode.algorithms;

/**
 * Description: 2760. Longest Even Odd Subarray With Threshold
 *
 * @author Baltan
 * @date 2023/7/4 23:35
 */
public class LongestAlternatingSubarray {
    public static void main(String[] args) {
        System.out.println(longestAlternatingSubarray(new int[]{4, 10, 3}, 10));
        System.out.println(longestAlternatingSubarray(new int[]{3, 2, 5, 4}, 5));
        System.out.println(longestAlternatingSubarray(new int[]{1, 2}, 2));
        System.out.println(longestAlternatingSubarray(new int[]{2, 3, 4, 5}, 4));
    }

    public static int longestAlternatingSubarray(int[] nums, int threshold) {
        int result = 0;
        /**
         * 当前子数组的长度
         */
        int currentLength = 0;
        /**
         * 当前是否正在计算一个符合题意的子数组的长度
         */
        boolean flag = false;
        /**
         * 接下去需要找到的元素是否为偶数
         */
        boolean isEven = true;

        for (int num : nums) {
            /**
             * 当前元素num可以延长子数组的长度
             */
            if (flag && (isEven == (num % 2 == 0)) && num <= threshold) {
                currentLength++;
                isEven = !isEven;
                result = Math.max(result, currentLength);
                /**
                 * 当前元素num不能延长子数组的长度，但是可以重新开始计算一个子数组且元素num为该子数组的第一个元素
                 */
            } else if (num % 2 == 0 && num <= threshold) {
                flag = true;
                currentLength = 1;
                isEven = false;
                result = Math.max(result, currentLength);
                /**
                 * 当前元素num不能延长子数组的长度，需要在后续元素中重新开始计算一个符合题意的子数组
                 */
            } else {
                flag = false;
                currentLength = 0;
                isEven = true;
            }
        }
        return result;
    }
}
