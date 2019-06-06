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
        int lo = 0;
        int hi = 0;
        int length = nums.length;
        int sum = nums[0];

        while (hi <= length) {
            while (lo <= hi) {
                if (sum >= s) {
                    result = Math.min(result, hi - lo + 1);
                    sum -= nums[lo];
                    lo++;
                } else {
                    break;
                }
            }
            hi++;
            if (hi < length) {
                sum += nums[hi];
            }
        }
        return result > length ? 0 : result;
    }
}
