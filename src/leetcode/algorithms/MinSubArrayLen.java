package leetcode.algorithms;

/**
 * Description: 209. Minimum Size Subarray Sum
 *
 * @author Baltan
 * @date 2019-06-06 20:29
 */
public class MinSubArrayLen {
    public static void main(String[] args) {
        System.out.println(minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
        System.out.println(minSubArrayLen(7, new int[]{2}));
        System.out.println(minSubArrayLen(7, new int[]{9}));
        System.out.println(minSubArrayLen(7, new int[]{2, 3, 3, 2, 1}));
        System.out.println(minSubArrayLen(7, new int[]{1, 1, 1, 1, 1, 1, 1}));
        System.out.println(minSubArrayLen(7, new int[]{1, 1, 1, 1, 2, 1, 1}));
    }

    public static int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int result = Integer.MAX_VALUE;
        /**
         * 子数组起始索引位置
         */
        int lo = 0;
        /**
         * 子数组结束索引位置
         */
        int hi = 0;
        int length = nums.length;
        /**
         * 子数组中所有元素的和
         */
        int sum = nums[0];
        /**
         * 双指针滑动窗口
         */
        while (hi <= length) {
            while (lo <= hi) {
                /**
                 * 如果当前子数组中所有元素的和不小于s，向右移动起始索引位置指针，缩小子数组的长度，减小子数组中所有元
                 * 素的和
                 */
                if (sum >= s) {
                    result = Math.min(result, hi - lo + 1);
                    sum -= nums[lo];
                    lo++;
                } else {
                    break;
                }
            }
            /**
             * 向右移动结束索引位置指针，增大子数组的长度，增加子数组中所有元素的和
             */
            hi++;
            /**
             * 结束索引没有超出数组的范围，才增加子数组中所有元素的和
             */
            if (hi < length) {
                sum += nums[hi];
            }
        }
        return result > length ? 0 : result;
    }
}
