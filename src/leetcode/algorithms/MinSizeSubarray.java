package leetcode.algorithms;

/**
 * Description: 2875. Minimum Size Subarray in Infinite Array
 *
 * @author baltan
 * @date 2023/10/8 10:39
 */
public class MinSizeSubarray {
    public static void main(String[] args) {
        System.out.println(minSizeSubarray(new int[]{2, 1, 5, 7, 7, 1, 6, 3}, 39));
        System.out.println(minSizeSubarray(new int[]{1, 2, 3}, 5));
        System.out.println(minSizeSubarray(new int[]{1, 1, 1, 2, 3}, 4));
        System.out.println(minSizeSubarray(new int[]{2, 4, 6, 8}, 3));
    }

    public static int minSizeSubarray(int[] nums, int target) {
        int result = Integer.MAX_VALUE;
        int length = nums.length;
        /**
         * 数组nums中所有元素的和
         */
        long sum = 0L;

        for (int num : nums) {
            sum += num;
        }
        /**
         * 目标子数组中至少包含copies个完整的数组nums
         */
        long copies = target / sum;
        /**
         * 目标子数组中还需要有连续若干个元素的和为diff
         */
        long diff = target - copies * sum;
        int count = (int) (copies * length);

        if (diff == 0L) {
            return count;
        }
        /**
         * 将两个数组nums拼接在一起
         */
        int[] newNums = new int[length * 2];
        System.arraycopy(nums, 0, newNums, 0, length);
        System.arraycopy(nums, 0, newNums, length, length);
        int lo = 0;
        int hi = 0;
        /**
         * 窗口中所有数字的和
         */
        int windowSum = newNums[0];

        while (true) {
            if (windowSum <= diff) {
                if (windowSum == diff) {
                    result = Math.min(result, hi - lo + 1 + count);
                }

                if (hi + 1 < newNums.length) {
                    /**
                     * 放大窗口，增加元素newNums[hi+1]
                     */
                    windowSum += newNums[++hi];
                } else {
                    break;
                }
            } else {
                /**
                 * 缩小窗口，移除元素newNums[lo]
                 */
                windowSum -= newNums[lo++];
            }
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }
}
