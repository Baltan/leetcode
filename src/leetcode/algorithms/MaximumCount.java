package leetcode.algorithms;

/**
 * Description: 2529. Maximum Count of Positive Integer and Negative Integer
 *
 * @author Baltan
 * @date 2023/2/2 13:57
 */
public class MaximumCount {
    public static void main(String[] args) {
        System.out.println(maximumCount(new int[]{-2, -1, -1, 1, 2, 3}));
        System.out.println(maximumCount(new int[]{-3, -2, -1, 0, 0, 1, 2}));
        System.out.println(maximumCount(new int[]{5, 20, 66, 1314}));
    }

    public static int maximumCount(int[] nums) {
        int length = nums.length;
        int lastNegativeIndex = getLastNegativeIndex(nums, length);
        int firstPositiveIndex = getFirstPositiveIndex(nums, length);
        return Math.max(length - firstPositiveIndex, lastNegativeIndex + 1);
    }

    /**
     * 查找数组nums中第一个正数的索引
     *
     * @param nums
     * @param length
     * @return
     */
    public static int getFirstPositiveIndex(int[] nums, int length) {
        /**
         * 说明数组nums中所有数字都是非正数
         */
        if (nums[length - 1] <= 0) {
            return length;
        }
        int lo = 0;
        int hi = length - 1;
        /**
         * 二分查找数组nums中第一个正数的索引
         */
        while (lo < hi) {
            int mid = (lo + hi) / 2;

            if (nums[mid] <= 0) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

    /**
     * 查找数组nums中最后一个负数的索引
     *
     * @param nums
     * @param length
     * @return
     */
    public static int getLastNegativeIndex(int[] nums, int length) {
        /**
         * 说明数组nums中所有数字都是非负数
         */
        if (nums[0] >= 0) {
            return -1;
        }
        int lo = 0;
        int hi = length - 1;
        /**
         * 二分查找数组nums中最后一个负数的索引
         */
        while (lo < hi) {
            int mid = (lo + hi + 1) / 2;

            if (nums[mid] >= 0) {
                hi = mid - 1;
            } else {
                lo = mid;
            }
        }
        return lo;
    }
}
